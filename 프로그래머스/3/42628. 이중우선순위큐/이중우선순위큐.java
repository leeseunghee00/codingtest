import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (String operation : operations) {
            char calc = operation.split(" ")[0].charAt(0);
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            if (calc == 'I') {
                queue.offer(num);
            } else {
                // 큐가 비어있지 않을 경우 -> 1: 최댓값 삭제, -1: 최솟값 삭제
                if (!queue.isEmpty()) {
                    if (num == 1) {
                        int max = Collections.max(queue);
                        queue.remove(max);
                    } else {
                        int out = queue.poll();
                    }
                }
            }
        }
        
        if (queue.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{Collections.max(queue), queue.peek()};
    }
}