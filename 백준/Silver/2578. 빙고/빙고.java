import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] bingo, checkBingo;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		bingo = new int[5][5];
		checkBingo = new int[5][5];
		visit = new boolean[5][5];

		// 빙고판 입력 받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 부르는 수 입력 받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				checkBingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int callCnt = 0;	// 사회자가 부르는 수 몇 번째인지 카운트

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				callCnt++;
				int num = checkBingo[i][j];

				// 빙고판에서 부른 수 찾기
				for (int k = 0; k < 5; k++) {
					for (int z = 0; z < 5; z++) {
						if (bingo[k][z] == num) {
							visit[k][z] = true;
						}
					}
				}

				// 빙고 확인 (가로, 세로 대각선)
				int bingoCnt = checkBingoCnt();

				// 빙고가 3개 이상일 경우 -> 종료
				if (bingoCnt >= 3) {
					System.out.println(callCnt);
					return;
				}
			}
		}
	}

	private static int checkBingoCnt() {
		int bingoCnt = 0;

		// 가로 확인
		for (int i = 0; i < 5; i++) {
			boolean rowBingo = true;

			for (int j = 0; j < 5; j++) {
				if (!visit[i][j]) {
					rowBingo = false;
					break;
				}
			}

			if (rowBingo) {
				bingoCnt++;
			}
		}

		// 세로 확인
		for (int i = 0; i < 5; i++) {
			boolean colBingo = true;

			for (int j = 0; j < 5; j++) {
				if (!visit[j][i]) {
					colBingo = false;
					break;
				}
			}

			if (colBingo) {
				bingoCnt++;
			}
		}

		// 대각선 확인 (좌상 -> 우하)
		boolean diagBingo1 = true;

		for (int i = 0; i < 5; i++) {
			if (!visit[i][i]) {
				diagBingo1 = false;
				break;
			}
		}

		if (diagBingo1) {
			bingoCnt++;
		}

		// 대각선 확인 (우상 -> 좌하)
		boolean diagBingo2 = true;

		for (int i = 0; i < 5; i++) {
			if (!visit[i][4 - i]) {
				diagBingo2 = false;
				break;
			}
		}

		if (diagBingo2) {
			bingoCnt++;
		}

		return bingoCnt;
	}
}
