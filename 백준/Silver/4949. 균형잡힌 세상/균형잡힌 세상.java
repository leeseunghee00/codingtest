import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			Stack<Character> bracket = new Stack<>();

			if (str.equals(".")) {
				return;
			}

			boolean isBalanced = true;

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (ch == '(' || ch == '[' ) {
					bracket.push(ch);
				} else if (ch == ')' ) {
					if (bracket.isEmpty() || bracket.pop() != '(' ) {
						isBalanced = false;
						break;
					}
				} else if (ch == ']' ) {
					if (bracket.isEmpty() || bracket.pop() != '[') {
						isBalanced = false;
						break;
					}
				}
			}

			if (!bracket.isEmpty()) {
				isBalanced = false;
			}

			if (isBalanced) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
