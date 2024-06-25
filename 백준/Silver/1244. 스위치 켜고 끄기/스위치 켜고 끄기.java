import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, stuCnt, gender, number;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		stuCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < stuCnt; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			switch (gender) {
				case 1 : male(); break;
				case 2 : female(); break;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
            
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	private static void male() {
		for (int i = number - 1; i < N; i += number) {
			arr[i] = change(arr[i]);
		}
	}

	private static void female() {
		int left = number - 2;
		int right = number;

		while (left >= 0 && right < N && arr[left] == arr[right]) {
			left--;
			right++;
		}

		for (int i = left + 1; i < right; i++) {
			arr[i] = change(arr[i]);
		}
	}

	private static int change(int current) {
		return (current == 1) ? 0 : 1;
	}
}
