import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, max;
	static char[] formula;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		formula = br.readLine().toCharArray();
        max = Integer.MIN_VALUE;

		dfs(1, formula[0] - '0');

		System.out.println(max);
	}

	private static void dfs(int idx, int curr) {
		if (idx >= formula.length) {
			max = Math.max(max, curr);
			return;
		}

		char op = formula[idx];
		int next = formula[idx + 1] - '0';

		// 괄호 없음
		int result1 = calculation(curr, op, next);
		dfs(idx + 2, result1);

		// 괄호 있음
		if (idx + 3 < N) {
			char nextOp = formula[idx + 2];
			int nextNext = formula[idx + 3] - '0';

			int bracket = calculation(next, nextOp, nextNext);
			int result2 = calculation(curr, op, bracket);

			dfs(idx + 4, result2);
		}
	}

	private static int calculation(int curr, char op, int next) {

		if (op == '*') {
			return curr * next;
		} else if (op == '+') {
			return curr + next;
		}

		return curr - next;
	}
}

