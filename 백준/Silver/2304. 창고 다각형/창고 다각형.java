import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, area;
	static List<Roof> store = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			store.add(new Roof(x, y));
		}

		// 정렬: x 오름차순
		store.sort(Comparator.comparingInt(g -> g.x));

		// 최고 기둥 찾기
		int highIdx = 0;

		for (int i = 0; i < N; i++) {
			if (store.get(i).y > store.get(highIdx).y) {
				highIdx = i;
			}
		}

		// 왼쪽 -> 최고 기둥
		Roof curr = store.get(0);

		for (int i = 1; i <= highIdx; i++) {
			Roof next = store.get(i);

			if (next.y >= curr.y) {
				area += (next.x - curr.x) * curr.y;
				curr = next;
			}
		}

		// 최고 기둥 <- 오른쪽
		curr = store.get(N - 1);

		for (int i = N - 2; i >= highIdx; i--) {
			Roof next = store.get(i);

			if (next.y >= curr.y) {
				area += (curr.x - next.x) * curr.y;
				curr = next;
			}
		}

		// 최고 기둥 더하기
		area += store.get(highIdx).y;

		System.out.println(area);
	}

	static class Roof {
		int x, y;

		public Roof(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
