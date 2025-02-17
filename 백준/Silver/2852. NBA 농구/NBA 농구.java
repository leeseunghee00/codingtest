import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] teamScore = new int[3][2];    // 0: 시간 1: 이긴 횟수
	static List<NBAScore> nbaScores = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String time = st.nextToken();

			nbaScores.add(new NBAScore(team, time));
		}

		int winTeam = 0;
		int prevTime = 0;

		for (int i = 0; i < N; i++) {
			NBAScore nbaScore = nbaScores.get(i);

			teamScore[nbaScore.team][1]++;
			int[] ms = Arrays.stream(nbaScore.time.split(":")).mapToInt(Integer::parseInt).toArray();
			int time = (ms[0] * 60) + ms[1];

			if (winTeam != 0) {
				teamScore[winTeam][0] += (time - prevTime);
			}

			if (teamScore[1][1] > teamScore[2][1]) {
				winTeam = 1;
			} else if (teamScore[1][1] < teamScore[2][1]) {
				winTeam = 2;
			} else {
				winTeam = 0;
			}

			prevTime = time;
		}

		if (winTeam != 0) {
			teamScore[winTeam][0] += (2880 - prevTime);
		}

		for (int i = 1; i <= 2; i++) {
			int MM = teamScore[i][0] / 60;
			int SS = teamScore[i][0] % 60;

			sb.append(String.format("%02d:%02d", MM, SS)).append("\n");
		}

		System.out.println(sb);
	}

	static class NBAScore {
		int team;
		String time;

		public NBAScore(int team, String time) {
			this.team = team;
			this.time = time;
		}
	}
}
