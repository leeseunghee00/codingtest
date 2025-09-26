import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        
        Set<String> jewel = new HashSet<>(Arrays.asList(gems));
        int total = jewel.size();
        
        Map<String, Integer> count = new HashMap<>();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while (true) {
            if (count.size() == total) {
                if (right - left < minLen) {
                    minLen = right - left;
                    ansLeft = left + 1;
                    ansRight = right;
                }
                
                count.put(gems[left], count.get(gems[left]) - 1);
                
                if (count.get(gems[left]) == 0) {
                    count.remove(gems[left]);
                }
                
                left++;
            } else {
                if (right == gems.length) {
                    break;
                }
                
                count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }
        
        return new int[]{ansLeft, ansRight};
    }
}
