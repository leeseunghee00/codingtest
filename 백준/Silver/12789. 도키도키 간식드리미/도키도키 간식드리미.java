import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] originLine;
	static Stack<Integer> waitingLine = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		originLine = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			originLine[i] = Integer.parseInt(st.nextToken());
		}

		int number = 1, idx = 0;
		boolean isNice = true;

		while (true) {

			if (idx == N) {
				if (!waitingLine.isEmpty()) {
					isNice = false;
				}
				break;
			}

			if (originLine[idx] != number) {
				waitingLine.push(originLine[idx]);
			} else {
				number++;
			}

			idx++;

			while (!waitingLine.isEmpty() && waitingLine.peek().equals(number)) {
				waitingLine.pop();
				number++;
			}
		}

		if (isNice) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
