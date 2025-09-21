import java.util.*;

class Solution {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        char[][] chMaps = new char[n][m];
        for (int i = 0; i < n; i++) {
            chMaps[i] = maps[i].toCharArray();
        }

        Miro start = find(maps, 'S', n, m);
        Miro lever = find(maps, 'L', n, m);
        Miro end   = find(maps, 'E', n, m);
        
        // 존재하지 않으면 -1
        if (start == null || lever == null || end == null) {
            return -1;
        }
        
        // 출발점 -> 레버
        int toLever = bfs(start, lever, chMaps, n, m);
        if (toLever == -1) return -1;
        
        // 레버 -> 출구
        int toExit = bfs(lever, end, chMaps, n, m);
        if (toExit == -1) return -1;
                        
        return toLever + toExit;
    }
    
    private int bfs(Miro start, Miro target, char[][] maps, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<Miro> queue = new LinkedList<>();
        queue.add(new Miro(start.r, start.c, 0));
        visited[start.r][start.c] = true;
        
        while (!queue.isEmpty()) {
            Miro curr = queue.poll();
            
            if (curr.r == target.r && curr.c == target.c) {
                return curr.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 'X') continue;

                visited[nr][nc] = true;
                queue.add(new Miro(nr, nc, curr.dist + 1));
            }
        }
        
        return -1;
    }
    
    private Miro find(String[] maps, char ch, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == ch) {
                    return new Miro(i, j, 0);
                }
            }
        }
        
        return null;
    }
    
    class Miro {
        int r, c, dist;
        
        Miro(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
