import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B, C, result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(modPow(A, B, C));
	}

	private static long modPow(long base, long exp, long mod) {
		if (exp == 0) {
			return 1;
		}

		long half = modPow(base, exp / 2, mod);
		long result = (half * half) % mod;

		if (exp % 2 == 1) {
			result = (result * base) % mod;
		}

		return result;
	}
}
