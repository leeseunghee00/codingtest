import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int[][] cogwheel = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				cogwheel[i][j] = line.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken());
			int way = Integer.parseInt(st.nextToken());

			start(wheel - 1, way);
		}

		// 점수 계산
		int score = getScore();

		System.out.println(score);
	}

	/* 톱니바퀴 회전 시뮬레이션 */
	private static void start(int idx, int way) {
		int base = cogwheel[idx][2];
		int[] dir = new int[4];
		dir[idx] = way;

		// 오른쪽 전파
		for (int i = idx + 1; i < 4; i++) {
			if (cogwheel[i][6] != base) {
				base = cogwheel[i][2];
				dir[i] = -dir[i - 1];
			} else {
				break;
			}
		}

		// 왼쪽 전파
		base = cogwheel[idx][6];

		for (int i = idx - 1; i >= 0; i--) {
			if (cogwheel[i][2] != base) {
				base = cogwheel[i][6];
				dir[i] = -dir[i + 1];
			} else {
				break;
			}
		}

		// 회전
		for (int i = 0; i < 4; i++) {
			if (dir[i] != 0) {
				rotate(i, dir[i]);
			}
		}
	}

	/* 톱니바퀴 회전 적용 */
	private static void rotate(int idx, int way) {
		int tmp;

		// 시계 방향
		if (way == 1) {
			tmp = cogwheel[idx][7];
			for (int i = 7; i > 0; i--) {
				cogwheel[idx][i] = cogwheel[idx][i - 1];
			}
			cogwheel[idx][0] = tmp;
		}
		// 반시계 방향
		else {
			tmp = cogwheel[idx][0];
			for (int i = 0; i < 7 ; i++) {
				cogwheel[idx][i] = cogwheel[idx][i + 1];
			}
			cogwheel[idx][7] = tmp;
		}
	}

	/* 톱니바퀴 점수 계산 */
	private static int getScore() {
		int score = 0;

		for (int i = 0; i < 4; i++) {
			if (cogwheel[i][0] == 1) {
				score += (int)Math.pow(2, i);
			}
		}

		return score;
	}
}