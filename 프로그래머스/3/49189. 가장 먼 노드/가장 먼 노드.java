import java.util.*;

class Solution {

    List<List<Integer>> nodes = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        
        for (int[] eg : edge) {
            int v = eg[0] - 1;
            int w = eg[1] - 1;
            
            nodes.get(v).add(w);
            nodes.get(w).add(v);
        }
        
        int[] distance = bfs(n, edge);
        int result = 0;
        int maxDist = Arrays.stream(distance).max().getAsInt();
        
        for (int d : distance) {
            if (d == maxDist) {
                result++;
            }
        }

        return result;   
    }
    
    private int[] bfs(int n, int[][] edge) {
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        distance[0] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : nodes.get(curr)) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    queue.add(next);
                }
            }
        }
        
        return distance;
    }
}