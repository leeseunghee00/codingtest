import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
    
        int[] result = new int[2];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int count = bfs(i, j, m, n, picture);
                    result[0]++;
                    result[1] = Math.max(count, result[1]);
                }
            }
        }
        
        return result;
    }   
    
    private int bfs(int r, int c, int m, int n, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        
        visited[r][c] = true;
        queue.offer(new int[]{r, c});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            count++;
            
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= m || nc >= n 
                    || visited[nr][nc] || picture[nr][nc] == 0) {
                    continue;
                }
                
                if (picture[r][c] == picture[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return count;
    }
}