import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		count = (int)(Math.pow(2, N) - 1);
		sb.append(count).append("\n");

		hanoi(N, 1, 2, 3);

		System.out.println(sb);
	}

	private static void hanoi(int idx, int start, int mid, int end) {
		if (idx == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}

		hanoi(idx - 1, start, end, mid);
		hanoi(1, start, mid, end);
		hanoi(idx - 1, mid, start, end);
	}
}
