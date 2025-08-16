import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        int count = 0;
        
        for (int scv : scoville) {
            pqueue.offer(scv);
        }
        
        while (pqueue.size() > 1 && pqueue.peek() < K) {
            int first = pqueue.poll();
            int second = pqueue.poll();
            int newScovile = first + (second * 2);
            
            pqueue.offer(newScovile);
            count++;
        }
        
        return pqueue.peek() >= K ? count : -1;
    }
}