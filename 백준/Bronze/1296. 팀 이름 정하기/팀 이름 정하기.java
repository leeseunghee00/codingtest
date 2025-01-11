import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, yL, yO, yV, yE, max;
	static String yeondu, result;
	static List<String> teams = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		yeondu = br.readLine();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			teams.add(br.readLine());
		}

		// 연두 LOVE Count
		for (int i = 0; i < yeondu.length(); i++) {
			switch (yeondu.charAt(i)) {
				case 'L': yL++; break;
				case 'O': yO++; break;
				case 'V': yV++; break;
				case 'E': yE++; break;
			}
		}

		teams.sort(String::compareTo);

		for (int i = 0; i < N; i++) {
			String team = teams.get(i);
			int tL = 0, tO = 0, tV = 0, tE = 0;

			// 팀 LOVE Count + 연두 LOVE Count
			for (int j = 0; j < team.length(); j++) {
				switch (team.charAt(j)) {
					case 'L': tL++; break;
					case 'O': tO++; break;
					case 'V': tV++; break;
					case 'E': tE++; break;
					default: break;
				}
			}

			int L = yL + tL;
			int O = yO + tO;
			int V = yV + tV;
			int E = yE + tE;

			int probability  = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
			if (max < probability) {
				max = probability;
				result = team;
			}
		}

		if (result == null) {
			result = teams.get(0);
		}

		System.out.println(result);
	}
}
