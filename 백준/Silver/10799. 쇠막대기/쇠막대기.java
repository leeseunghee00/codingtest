import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	static int result;
	static Stack<Integer> stack = new Stack<>();
	static List<Parentheses> laser = new ArrayList<>();
	static List<Parentheses> block = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(i);
			} else {
				Integer start = stack.pop();

				if (start == null) {
					break;
				}

				if (start + 1 == i) {
					laser.add(new Parentheses(start, i));
				} else {
					block.add(new Parentheses(start, i));
				}
			}
		}

		for (int i = 0; i < block.size(); i++) {
			Parentheses blockLoc = block.get(i);
			int count = 0;

			for (int j = 0; j < laser.size(); j++) {
				Parentheses laserLoc = laser.get(j);

				if (blockLoc.start < laserLoc.start && blockLoc.end > laserLoc.end) {
					count++;
				}
			}

			result += (count + 1);
		}

		System.out.println(result);
	}

	static class Parentheses {
		int start;
		int end;

		Parentheses(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
