import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int idx;
	static String str;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		str = sc.nextLine();

		while (idx != str.length()) {
			char ch = str.charAt(idx);

			if (ch == ' ') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				
				System.out.print(" ");
				idx++;
				
				continue;
			}

			if (ch == '<') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				
				while (ch != '>') {
					System.out.print(ch);
					ch = str.charAt(++idx);
				}
				
				System.out.print(ch);
				idx++;
				
				continue;
			}

			stack.push(ch);
			idx++;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
