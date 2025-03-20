import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int P;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		P = Integer.parseInt(br.readLine());

		while (P-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] line = new int[20];
			int testcase = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 20; i++) {
				line[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;

			for (int i = 1; i < 20; i++) {
				int currNum = line[i];
				int j = i - 1;

				while (j >=0 && line[j] > currNum) {
					line[j + 1] = line[j];
					j--;
					count++;
				}

				line[j + 1] = currNum;
			}

			System.out.println(testcase + " " + count);
		}
	}
}
