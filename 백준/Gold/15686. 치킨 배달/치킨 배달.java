import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static List<Location> houses, chickens, target;

	public static void main(String[] args) throws IOException {

		// 1. 입력받고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		houses = new ArrayList<>();
		chickens = new ArrayList<>();	// srcIdx
		target = new ArrayList<>();		// tgtIdx

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());

				if (num == 1) {
					houses.add(new Location(r, c));
				} else if (num == 2) {
					chickens.add(new Location(r, c));
				}
			}
		}

		min = Integer.MAX_VALUE;

		combination(0, 0);

		// 5. 최종 치킨거리 최솟값 min 출력
		System.out.println(min);

	}

	private static void combination(int srcIdx, int tgtIdx) {
		// 2. m만큼씩 치킨집 조합 리스트 생성해서 -> list
		if (tgtIdx == M) {
			int sum = 0;

			for (int i = 0; i < houses.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				Location house = houses.get(i);

				// 3. list.get(i) 해서 반환된 치킨집 m개를 기준으로 각 집마다 치킨 거리 구하기
				for (int j = 0; j < M; j++) {
					Location comb = target.get(j);
					// 4. 각 집마다 최솟값을 더해서 (-> sum), Math.min(minDist, sum)
					minDist = Math.min(minDist, Math.abs(house.r - comb.r) + Math.abs(house.c - comb.c));
				}

				sum += minDist;
			}

			min = Math.min(min, sum);

			return;
		}

		if (srcIdx == chickens.size()) {
			return;
		}

		// 선택
		target.add(chickens.get(srcIdx));
		combination(srcIdx + 1, tgtIdx + 1);

		// 비선택
		target.remove(chickens.get(srcIdx));
		combination(srcIdx + 1, tgtIdx);
	}

	static class Location {
		int r;
		int c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
