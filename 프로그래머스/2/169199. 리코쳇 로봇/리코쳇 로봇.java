import java.util.*;

class Solution {

    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        
        int n = board.length, m = board[0].length();
        char[][] arr = new char[n][m];
        
        // 시작, 목표 위치점
        int[] start = new int[2];
        int[] goal = new int[2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);
                arr[i][j] = ch;
                
                if (ch == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        // 경로 탐색
        return bfs(start, goal, arr);
    }
    
    private int bfs(int[] start, int[] goal, char[][] arr) {
        
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0], x = curr[1], move = curr[2];
            
            if (y == goal[0] && x == goal[1]) {
                return move;
            }
            
            for (int d = 0; d < 4; d++) {
                int[] p = slide(y, x, d, arr);
                int ny = p[0], nx = p[1];
                
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, move + 1});
                }
            }
        }
        
        return -1;
    }
    
    // 장애물 or 경계 전까지 한 방향으로만 이동
    private int[] slide(int y, int x, int dir, char[][] arr) {
        int n = arr.length, m = arr[0].length;
        int ny = y, nx = x;
        
        while (true) {
            int ty = ny + dy[dir];
            int tx = nx + dx[dir];
            
            if (ty < 0 || tx < 0 || ty >= n || tx >= m || arr[ty][tx] == 'D') {
                break;
            }
            
            ny = ty;
            nx = tx;
        }
        
        return new int[]{ny, nx};
    }
}