import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalGenres = new HashMap<>();
		HashMap<String, List<Music>> playByGenre = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		// 1. 장르별 재생합
		for (int i = 0; i < genres.length; i++) {
			int value = totalGenres.getOrDefault(genres[i], 0);
			totalGenres.put(genres[i], value + plays[i]);

			playByGenre.putIfAbsent(genres[i], new ArrayList<>());
			playByGenre.get(genres[i]).add(new Music(i, plays[i]));
		}

		List<String> sortedGenres = new ArrayList<>(totalGenres.keySet());
		sortedGenres.sort((o1, o2) -> totalGenres.get(o2).compareTo(totalGenres.get(o1)));

		// 2. 장르내 재생순
		for (String genre : sortedGenres) {
			List<Music> musics = playByGenre.get(genre);

			musics.sort((o1, o2) -> o1.playCount != o2.playCount ? o2.playCount - o1.playCount: o1.idx - o2.idx);

			for (int i = 0; i < Math.min(2, musics.size()); i++) {
				result.add(musics.get(i).idx);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	class Music {
		int idx;
		int playCount;

		Music(int idx, int playCount) {
			this.idx = idx;
			this.playCount = playCount;
		}
	}
}