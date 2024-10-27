import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] lamp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lamp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lamp[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int switchNum = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken());

			switch (switchNum) {
				case 1:
					lamp[l] = r;
					break;
				case 2:
					for (int j = l; j < r; j++) {
						lamp[j] = lamp[j] == 1 ? 0 : 1;
					}
					break;
				case 3:
					for (int j = l; j < r; j++) {
						lamp[j] = 0;
					}
					break;
				case 4:
					for (int j = l; j < r; j++) {
						lamp[j] = 1;
					}
					break;
			}
		}

		for (int i : lamp) {
			System.out.print(i + " ");
		}
	}
}
