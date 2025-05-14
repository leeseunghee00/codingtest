import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String A, B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken();
		B = st.nextToken();

		StringBuffer sf = new StringBuffer(A);
		int numA = Integer.parseInt(sf.reverse().toString());

		sf = new StringBuffer(B);
		int numB = Integer.parseInt(sf.reverse().toString());

		System.out.println(Math.max(numA, numB));
	}

}
