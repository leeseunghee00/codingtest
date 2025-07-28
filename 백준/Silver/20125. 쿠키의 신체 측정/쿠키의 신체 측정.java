import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 1. 머리 위치 찾기
		int headY = 0, headX = 0;
		boolean found = false;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == '*') {
					headY = y;
					headX = x;
					found = true;
					break;
				}
			}
			if (found) break;
		}

		// 2. 심장 위치 = 머리 바로 아래
		int heartY = headY + 1;
		int heartX = headX;

		sb.append(heartY + 1).append(" ").append(heartX + 1).append("\n");

		// 3. 왼쪽 팔 길이
		int leftArm = 0;
		for (int x = heartX - 1; x >= 0; x--) {
			if (map[heartY][x] == '*') leftArm++;
			else break;
		}
		sb.append(leftArm).append(" ");

		// 4. 오른쪽 팔 길이
		int rightArm = 0;
		for (int x = heartX + 1; x < N; x++) {
			if (map[heartY][x] == '*') rightArm++;
			else break;
		}
		sb.append(rightArm).append(" ");

		// 5. 허리 길이
		int waist = 0;
		int waistEndY = heartY;
		for (int y = heartY + 1; y < N; y++) {
			if (map[y][heartX] == '*') {
				waist++;
				waistEndY = y;
			} else break;
		}
		sb.append(waist).append(" ");

		// 6. 왼쪽 다리 길이
		int leftLeg = 0;
		for (int y = waistEndY + 1; y < N; y++) {
			if (map[y][heartX - 1] == '*') leftLeg++;
			else break;
		}
		sb.append(leftLeg).append(" ");

		// 7. 오른쪽 다리 길이
		int rightLeg = 0;
		for (int y = waistEndY + 1; y < N; y++) {
			if (map[y][heartX + 1] == '*') rightLeg++;
			else break;
		}
		sb.append(rightLeg);

		// 8. 출력
		System.out.println(sb.toString());
	}
}
