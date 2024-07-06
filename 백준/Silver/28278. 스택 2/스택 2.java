import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int order = sc.nextInt();

			switch (order) {
				case 1:
					stack.push(sc.nextInt());
					break;
				case 2:
					sb.append(!stack.empty() ? stack.pop() : -1).append('\n');
					break;
				case 3:
					sb.append(stack.size()).append('\n');
					break;
				case 4:
					sb.append(stack.empty() ? 1 : 0).append('\n');
					break;
				case 5:
					sb.append(!stack.empty() ? stack.peek() : -1).append('\n');
					break;
			}
		}

		System.out.println(sb);
	}
}
