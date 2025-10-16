import java.util.*;

class Solution {

    public int solution(int n, int[][] costs) {
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] c : costs) {
            graph.get(c[0]).add(new Node(c[1], c[2]));
            graph.get(c[1]).add(new Node(c[0], c[2]));
        }
   
        // 최소 비용 구하기
        int cost = 0, count = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pqueue.offer(new Node(0, 0));
        
        while (!pqueue.isEmpty() && count < n) {
            Node curr = pqueue.poll();
            
            if (visited[curr.u]) {
                continue;
            }
            
            visited[curr.u] = true;
            cost += curr.cost;
            count++;
            
            for (Node next : graph.get(curr.u)) {
                if (!visited[next.u]) {
                    pqueue.offer(next);
                }
            }
        }
        
        return cost;
    }
    
    class Node {
        int u, cost;
        
        Node(int u, int cost) {
            this.u = u;
            this.cost = cost;
        }
    }
}
