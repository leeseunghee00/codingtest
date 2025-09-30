import java.util.*;

class Solution {

    public int solution(String[][] book_time) {
        
        List<int[]> books = new ArrayList<>(book_time.length);
        
        for (String[] bt : book_time) {
            int start = toMinutes(bt[0]);
            int end = toMinutes(bt[1]) + 10;
            
            books.add(new int[]{start, end});
        }
        
        books.sort((b1, b2) -> {
            if (b1[0] == b2[0]) {
                return b1[1] - b2[1];
            }
            
            return b1[0] - b2[0];
        });
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        int room = 0;
        
        for (int[] b : books) {
            int start = b[0], end = b[1];
            
            while (!pqueue.isEmpty() && pqueue.peek() <= start) {
                pqueue.poll();
            }
            
            pqueue.offer(end);
            room = Math.max(room, pqueue.size());
        }
        
        return room;
    }
    
    private int toMinutes(String hhmm) {
        String[] minutes = hhmm.split(":");
        
        int h = Integer.parseInt(minutes[0]) * 60;
        int m = Integer.parseInt(minutes[1]);

        return h + m;
    }
}