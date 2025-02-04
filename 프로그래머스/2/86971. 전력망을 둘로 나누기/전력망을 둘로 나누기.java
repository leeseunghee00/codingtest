import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] wire : wires) {
			int u = wire[0];
			int v = wire[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int[] wire : wires) {
			// 임의로 전선 끊어내기
			int u = wire[0];
			int v = wire[1];

			graph.get(u).remove(Integer.valueOf(v));
			graph.get(v).remove(Integer.valueOf(u));

			boolean[] visited = new boolean[n + 1];
			int count = dfs(u, visited);

			int diff = Math.abs(n - 2 * count);
			result = Math.min(diff, result);

			// 다시 전선 잇기
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		return result;
	}

	private int dfs(int node, boolean[] visited) {
		visited[node] = true;
		int count = 1;

		for (int next : graph.get(node)) {
			if (!visited[next]) {
				count += dfs(next, visited);
			}
		}

		return count;
	}
}