import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			char[] chArr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;

			for (int i = 0; i < chArr.length; i++) {
				if (chArr[i] == '(') {
					stack.push(chArr[i]);
				} else {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}

			if (stack.isEmpty() && flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}

