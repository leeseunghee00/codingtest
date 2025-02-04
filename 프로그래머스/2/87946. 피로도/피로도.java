import java.util.Arrays;

class Solution {
    int result;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
		dfs(k, visited, dungeons, 0);
		return result;
	}

	private void dfs(int k, boolean[] visited, int[][] dungeons, int count) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				dfs(k - dungeons[i][1], visited, dungeons, count + 1);
				visited[i] = false;
			}
		}

		result = Math.max(count, result);
	}
}