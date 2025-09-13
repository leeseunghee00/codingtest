import java.util.*;

class Solution {
    
    public String solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n  > 0) {
            int r = n % 3;
            n /= 3;
            
            if (r == 0) {
                r = 4;
                n--;
            }
            
            sb.insert(0, r);
        }
        
        return sb.toString();
    }
}