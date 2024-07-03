import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		BigInteger moves = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
		System.out.println(moves);

		if (N <= 20) {
			hanoi(N, 1, 3, 2);
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static void hanoi(int n, int from, int to, int mid) throws IOException {
		if (n == 1) {
			bw.write(from + " " + to + "\n");
			return;
		}

		hanoi(n - 1, from, mid, to);
		bw.write(from + " " + to + "\n");
		hanoi(n - 1, mid, to, from);
	}
}
