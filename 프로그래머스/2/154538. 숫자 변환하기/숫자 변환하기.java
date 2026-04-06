import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.offer(new int[]{x, 0});
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int now = curr[0];
            int count = curr[1];
            
            if (now == y) {
                return count;
            }
            
            int[] next = {now + n, now * 2, now * 3};
            
            for (int nx : next) {
                if (nx <= y && !visited[nx]) {
                    visited[nx] = true;
                    queue.offer(new int[]{nx, count + 1});
                }
            }
        }
        
        return -1;
    }
}
