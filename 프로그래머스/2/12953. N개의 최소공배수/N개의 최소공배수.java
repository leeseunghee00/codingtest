import java.util.*;

class Solution {
    
    public int solution(int[] arr) {

        int result = 1;
        Map<Integer, Integer> total = new HashMap<>();
        
        for (int num : arr) {
            if (num == 1) {
                continue;
            }
            
            // 약수 구하기
            Map<Integer, Integer> divisor = new HashMap<>();
            int d = 2, tmp = num;
            
            while (d * d <= tmp) {
                while (tmp % d == 0) {
                    divisor.put(d, divisor.getOrDefault(d, 0) + 1);
                    tmp /= d;
                }
                
                d++;
            }
            
            if (tmp > 1) {
                divisor.put(tmp, divisor.getOrDefault(tmp, 0) + 1);
            }
            
            for (int key : divisor.keySet()) {
                int count = divisor.get(key);
                total.put(key, Math.max(total.getOrDefault(key, 0), count));
            }
        }
        
        for(int key : total.keySet()) {
            result *= Math.pow(key, total.get(key));
        }
        
        return result;
    }
}
