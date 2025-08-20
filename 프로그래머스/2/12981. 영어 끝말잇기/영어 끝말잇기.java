import java.util.*;

class Solution {
    
    public int[] solution(int n, String[] words) {
        
        int num = 1, turn = 1, count = 1;
        Set<String> usedWords = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {

            if (i == 0) {
                usedWords.add(words[i]);
                num++;
                count++;
                continue;
            }
            
            String prev = words[i - 1];
            String now = words[i];
            
            if (prev.charAt(prev.length() - 1) != now.charAt(0) 
                || usedWords.contains(now)) {
                return new int[]{num, turn};
            }
            
            if (count == n) {
                num = 1;
                count = 1;
                turn++;
                continue;
            }
            
            usedWords.add(words[i]);

            num++;
            count++;
        }
        
        return new int[]{0, 0};
    }
}