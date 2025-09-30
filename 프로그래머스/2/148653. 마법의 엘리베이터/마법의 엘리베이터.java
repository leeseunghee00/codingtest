import java.util.*;

class Solution {

    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
            int d = storey % 10;
            int next = (storey / 10) % 10;
            
            if (d < 5) {
                result += d;
            } else  if (d > 5) {
                result += (10 - d);
                storey += 10;
            } else {
                if (next >= 5) {
                    storey += 10;
                }
                
                result += 5;
            }
            
            storey /= 10;
        }
        
        return result;
    }
}
