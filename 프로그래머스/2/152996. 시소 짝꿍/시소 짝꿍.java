import java.util.*;

class Solution {

    public long solution(int[] weights) {
        
        Map<Integer, Long> couples = new HashMap<>();
        long result = 0L;
        
        Arrays.sort(weights);
        
        for (int w : weights) {
            result += couples.getOrDefault(w, 0L);
            
            // 2:3
            if (w % 3 ==0) {
                int num =  (w  * 2) / 3;
                result += couples.getOrDefault(num, 0L);
            }
            
            // 1:2
            if (w % 2 == 0) {
                int num = w / 2;
                result += couples.getOrDefault(num, 0L);
            }
            
            // 3:4
            if (w % 4 == 0) {
                int num = (w * 3) / 4;
                result += couples.getOrDefault(num, 0L);
            }
            
            couples.put(w, couples.getOrDefault(w, 0L) + 1);
        }
                
        return result;
    }
}