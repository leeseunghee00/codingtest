import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, level, zeroCount;
	static Belt[] conveyor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		conveyor = new Belt[2 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int durability = Integer.parseInt(st.nextToken());
			conveyor[i] = new Belt(durability, false);
		}

		simulation();

		System.out.println(level);
	}

	/* 컨베이어 시뮬레이션 */
	private static void simulation() {

		while (true) {
			if (zeroCount >= K){
				return;
			}

			rotation();
			move();
			raise();

			level++;
		}
	}

	/* 컨베이어 회전 */
	private static void rotation() {
		Belt last = conveyor[2 * N - 1];

		for (int i = 2 * N - 1; i > 0; i--) {
			conveyor[i] = conveyor[i - 1];
		}

		conveyor[0] = last;

		// 내리는 위치 로봇 제거
		conveyor[N - 1].existOfRobot = false;
	}

	/* 로봇 이동 */
	private static void move() {
		for (int i = N - 2; i >= 0; i--) {
			// 로봇이 존재한다면,
			if (conveyor[i].existOfRobot) {
				// 다음 위치 내구도 >= 1 && 로봇 존재하지 않으면 -> 이동 & 내구도-1
				int next = i + 1;

				if (!conveyor[next].existOfRobot && conveyor[next].durability >= 1) {
					conveyor[i].existOfRobot = false;
					conveyor[next].existOfRobot = true;
					conveyor[next].durability -= 1;

					if (conveyor[next].durability == 0) {
						zeroCount++;
					}
				}
			}
		}

		// 내리는 위치 로봇 제거
		conveyor[N - 1].existOfRobot = false;
	}

	/* 로봇 올리기 */
	private static void raise() {
		if (conveyor[0].durability >= 1 && !conveyor[0].existOfRobot) {
			conveyor[0].durability -= 1;
			conveyor[0].existOfRobot = true;

			if (conveyor[0].durability == 0) {
				zeroCount++;
			}
		}
	}

	static class Belt {
		int durability;
		boolean existOfRobot;

		public Belt(int durability, boolean existOfRobot) {
			this.durability = durability;
			this.existOfRobot = existOfRobot;
		}
	}
}
