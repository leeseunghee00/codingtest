import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, P;
	static int[] curr = new int[4];
	static int[] need = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		String dna = br.readLine();
		for (int i = 0; i < P; i++) {
			add(dna.charAt(i));
		}

		// 입력: 최소 개수
 		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			need[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		if (isOk()) {
			result++;
		}

		// 슬라이딩
		for (int i = P; i < S; i++) {
			add(dna.charAt(i));
			remove(dna.charAt(i - P));

			if (isOk()) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static int idx(char ch) {
		switch (ch) {
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default : return -1;
		}
	}

	// 슬라이딩 윈도우
	private static void add(char ch) {
		curr[idx(ch)]++;
	}

	private static void remove(char ch) {
		curr[idx(ch)]--;
	}

	private static boolean isOk() {
		for (int i = 0; i < 4; i++) {
			if (curr[i] < need[i]) {
				return false;
			}
		}

		return true;
	}
}
