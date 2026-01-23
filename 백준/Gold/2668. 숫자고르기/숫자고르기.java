import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] done;	// 노드 판별 완료됐는지
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		done = new boolean[N + 1];

		// arr 초기화 (값 입력 및 삽입)
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// dfs
		for (int i = 1; i <= N; i++) {
			if (!done[i]) {
				dfs(i);
			}
		}

		// 오름차순 정렬
		List<Integer> result = new ArrayList<>(set);
		Collections.sort(result);

		// 출력
		System.out.println(result.size());

		for (int num : result) {
			System.out.println(num);
		}
	}

	private static void dfs(int curr) {
		visited[curr] = true;
		int next = arr[curr];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!done[next]) {
				int x = next;
				set.add(x);

				while (arr[x] != next) {
					x = arr[x];
					set.add(x);
				}
			}
		}

		done[curr] = true;
		visited[curr] = false;
	}
}
