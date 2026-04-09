import java.util.*;

class Solution {

    int[] dist;
    List<List<Delivery>> deliveryList = new LinkedList<>();
        
    public int solution(int N, int[][] road, int K) {
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i <= N; i++) {
            deliveryList.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int to = r[0], from = r[1], cost = r[2];
            
            deliveryList.get(to).add(new Delivery(from, cost));
            deliveryList.get(from).add(new Delivery(to, cost));
        }
        
        int result = order(N, K);
        
        return result;
    }
    
    private int order(int N, int K) {
        PriorityQueue<Delivery> pqueue = new PriorityQueue<>((Comparator.comparingInt(d -> d.cost)));
        
        pqueue.offer(new Delivery(1, 0));
        dist[1] = 0;
        
        while (!pqueue.isEmpty()) {
            Delivery curr = pqueue.poll();

            if (curr.cost > dist[curr.from]) {
                continue;
            }
            
            for (Delivery next : deliveryList.get(curr.from)) {
                if (curr.cost + next.cost < dist[next.from]) {
                    dist[next.from] = curr.cost + next.cost;
                    pqueue.offer(new Delivery(next.from, dist[next.from]));
                }
            }
        }
        
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        
        return count;
    }
    
    class Delivery {
        int from, cost;
        
        Delivery(int from, int cost) {
            this.from = from;
            this.cost = cost;
        }
    }
}