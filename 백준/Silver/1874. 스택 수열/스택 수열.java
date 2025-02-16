import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int N;
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int num = 1;
		boolean isPossible = true;

		for (int i = 0; i < N; i++) {
			int target = arr[i];

			while (num <= target) {
				stack.push(num++);
				sb.append("+").append("\n");
			}

			if (stack.peek() == target) {
				stack.pop();
				sb.append("-").append("\n");
			} else {
				isPossible = false;
				break;
			}
		}

		if (isPossible) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
