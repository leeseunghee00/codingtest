import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new char[N][];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 영역 분할
		quadTree(0, 0, N);

		// 출력
		System.out.println(sb);
	}

	private static void quadTree(int y, int x, int size) {
		int sum = 0;

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				sum += arr[i][j] - '0';
			}
		}

		if (sum == 0 || sum == (size * size)) {	// 0 또는 1 로 채워져 있는 경우
			sb.append(sum / (size * size));
			return;
		} else {	// 그렇지 않다면, 영역 분할
			sb.append("(");
			
			int newSize = size /= 2;

			quadTree(y, x, newSize);
			quadTree(y, x + newSize, newSize);
			quadTree(y + newSize, x, newSize);
			quadTree(y + newSize, x + newSize, newSize);

			sb.append(")");
		}
	}
}
