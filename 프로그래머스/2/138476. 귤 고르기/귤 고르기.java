import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        for (int c : counts) {
            if (sum >= k) {
                break;
            }
            
            sum += c;
            count++;
        }
        
        return count;
    }
}