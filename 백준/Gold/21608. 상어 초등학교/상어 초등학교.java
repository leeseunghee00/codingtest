import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] seat;
	static int[][] likes;
	static int[] order;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		seat = new int[N + 1][N + 1];
		likes = new int[N * N + 1][4];
		order = new int[N * N];

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			order[i] = num;

			for (int j = 0; j < 4; j++) {
				likes[num][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N * N; i++) {
			int num = order[i];
			placeStudent(num);
		}

		int result = getScore();

		System.out.println(result);
	}

	private static void placeStudent(int num) {
		int bestR = 1, bestC = 1, bestLike = -1, bestEmpty = -1;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (seat[r][c] != 0) {
					continue;
				}

				int emptyCnt = 0;
				int likeCnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr > N || nc > N || nr < 1 || nc < 1) {
						continue;
					}

					if (seat[nr][nc] == 0) {
						emptyCnt++;
					} else if (isLiked(num, seat[nr][nc])) {
						likeCnt++;
					}
				}

				// 1) 인접한 좋아요 수가 큰 곳
				if (likeCnt > bestLike) {
					bestLike = likeCnt;
					bestEmpty = emptyCnt;
					bestR = r;
					bestC = c;
				} else if (likeCnt == bestLike) {
					// 2) 인접한 좋아요 수가 같다면, 빈 칸 수가 많은 곳
					if (emptyCnt > bestEmpty) {
						bestEmpty = emptyCnt;
						bestR = r;
						bestC = c;
					}
					// 3) 빈 칸 수가 같다면, minR -> minC
					else if (emptyCnt == bestEmpty) {
						if (r < bestR || (r == bestR && c < bestC)) {
							bestR = r;
							bestC = c;
						}
					}
				}
			}
		}

		seat[bestR][bestC] = num;
	}

	private static boolean isLiked(int num, int other) {
		for (int i = 0; i < 4; i++) {
			if (likes[num][i] == other) {
				return true;
			}
		}

		return false;
	}

	private static int getScore() {
		int score = 0;
		int[] pow = {0, 1, 10, 100, 1000};

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int num = seat[r][c];
				int likeCnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr > N || nc > N || nr < 1 || nc < 1) {
						continue;
					}

					if (isLiked(num, seat[nr][nc])) {
						likeCnt++;
					}
				}

				score += pow[likeCnt];
			}
		}

		return score;
	}
}