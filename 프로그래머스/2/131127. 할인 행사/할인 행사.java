import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        int count = 0;
        Map<String, Integer> wants = new HashMap<>(); 
        
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        for (int d = 0; d <= discount.length - 10; d++) {
            boolean flag = true;
            Map<String, Integer> tmpWants = new HashMap<>(wants);
            
            for (int i = d; i < d + 10; i++) {
                if (tmpWants.containsKey(discount[i])) {
                    if (tmpWants.get(discount[i]) != 0) {
                        tmpWants.put(discount[i], tmpWants.getOrDefault(discount[i], 0) - 1);
                    }
                }
            }
            
            for (int val : tmpWants.values()) {
                if (val != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                count++;
            }
        }
        
        return count;
    }
}