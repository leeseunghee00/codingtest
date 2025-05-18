import java.util.*;

/*

코너가 생기는 경우
- 행/열 끝
- 행/열 역행

직진도로가 생기는 경우
- 코너가 아닌 경우

*/
class Solution {
    
    int[] dy = {-1, 1, 0, 0}; // 상하좌우
    int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        
        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        Queue<Load> queue = new LinkedList<>();
        
        // 시작 위치에서 가능한 방향 모두 탐색
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0;
            queue.add(new Load(0, 0, 0, i));
        }
        
        while(!queue.isEmpty()) {
           Load load = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = load.y + dy[d];
                int nx = load.x + dx[d];
                
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] == 1) {
                    continue;
                }
                
                int nextCost = load.cost + ((load.dir == d) ? 100 : 600);
                
                if (cost[ny][nx][d] > nextCost) {
                    cost[ny][nx][d] = nextCost;
                    queue.add(new Load(ny, nx, nextCost, d));
                }
            }
        }
        
        int min = Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
        
        return min;
    }
    
    class Load {
        int y;
        int x;
        int cost;
        int dir;
        
        Load(int y, int x, int cost, int dir) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir;
        }
        
    }
}