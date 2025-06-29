import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static List<Country> countries = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int id = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int sliver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			countries.add(new Country(id, gold, sliver, bronze));
		}

		countries.sort((c1, c2) -> {
			if (c1.gold != c2.gold) {
				return c2.gold - c1.gold;
			}

			if (c1.sliver != c2.sliver) {
				return c2.sliver - c1.sliver;
			}

			return c2.broonze - c1.broonze;
		});

		int rank = 1;
		int sameRank = 1;
		int[] prev = new int[3];

		Map<Integer, Integer> rankMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			Country country = countries.get(i);

			if (i == 0) {
				rankMap.put(country.id, 1);
				prev[0] = country.gold;
				prev[1] = country.sliver;
				prev[2] = country.broonze;
			} else {
				Country prevCountry = countries.get(i - 1);

				if (country.gold == prevCountry.gold && country.sliver == prevCountry.sliver && country.broonze == prevCountry.broonze) {
					rankMap.put(country.id, rank);
					sameRank++;
				} else {
					rank += sameRank;
					sameRank = 1;
					rankMap.put(country.id, rank);
				}
			}
		}

		System.out.println(rankMap.get(k));
	}

	static class Country {
		int id;
		int gold, sliver, broonze;

		public Country(int id, int gold, int sliver, int broonze) {
			this.id = id;
			this.gold = gold;
			this.sliver = sliver;
			this.broonze = broonze;
		}
	}
}
