import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int in, out, total, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			out = Integer.parseInt(st.nextToken());
			in = Integer.parseInt(st.nextToken());

			total = total - out + in;
			max = Math.max(total, max);
		}

		System.out.println(max);
	}
}