import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    int[] dy = {-1, 1, 0, 0};
	int[] dx = {0, 0, -1, 1};
	boolean[][] visited;
    
	public int solution(int[][] maps) {
		int r = maps.length;
		int c = maps[0].length;
		visited = new boolean[r][c];

		return bfs(0, 0, r, c, maps, visited);
	}

	private int bfs(int y, int x, int r, int c, int[][] maps, boolean[][] visited) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(y, x, 1));
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.y == r - 1 && node.x == c - 1) {
				return node.count;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + node.y;
				int nx = dx[i] + node.x;

				if (ny >= r || ny < 0 || nx >= c || nx < 0 || visited[ny][nx] || maps[ny][nx] == 0) {
					continue;
				}

				visited[ny][nx] = true;
				queue.add(new Node(ny, nx, node.count + 1));
			}
		}

		return -1;
	}

	class Node {
		int y;
		int x;
		int count;

		public Node(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}
