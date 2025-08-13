import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for (int work : works) {
            pqueue.offer(work);
        }
        
        while (n > 0 && !pqueue.isEmpty()) {
            int work = pqueue.poll();

            if (work > 0) {
                pqueue.offer(work - 1);
            }
            
            n--;
        }
        
        if (pqueue.isEmpty()) {
            return 0;
        }
        
        for (int num : pqueue) {
            answer += (long) Math.pow(num, 2);
        }
        
        return answer;
    }
}
