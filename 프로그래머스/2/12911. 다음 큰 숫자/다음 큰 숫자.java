import java.util.*;

class Solution {
    
    static final int MAX_INDEX = 1_000_000;
    
    public int solution(int n) {

        int oneCountOfN = count(n);
        int next = n + 1;
        
        while (next != MAX_INDEX) {
            if (count(next) == oneCountOfN) {
                return next;
            }
            
            next++;
        }
        
        return 0;
    }
    
    private int count(int num) {
        String binary = Integer.toBinaryString(num);
        int count = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            count += (binary.charAt(i) == '1') ? 1 : 0;
        }
        
        return count;
    }
}