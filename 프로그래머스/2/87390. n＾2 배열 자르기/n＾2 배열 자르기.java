import java.util.*;

class Solution {

    public int[] solution(int n, long left, long right) {
        
        int[] result = new int[(int)(right - left + 1)];
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            
            result[(int)(i - left)] = (int)(Math.max(row, col) + 1);
        }
        
        return result;
    }
}