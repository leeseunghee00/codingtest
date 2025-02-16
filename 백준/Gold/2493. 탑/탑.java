import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] result;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		result = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int top = Integer.parseInt(st.nextToken());
			int idx = 0;

			while (!stack.isEmpty()) {
				if (stack.peek()[1] > top) {
					idx = stack.peek()[0];
					break;
				}
				stack.pop();
			}

			result[i] = idx;
			stack.push(new int[]{i + 1, top});
		}

		for (int i = 0 ; i < N; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
