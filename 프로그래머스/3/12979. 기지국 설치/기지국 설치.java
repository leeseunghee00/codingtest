import java.util.*;

class Solution {
    
    public int solution(int n, int[] stations, int w) {
        
        int cover = 2 * w + 1;  // 한 기지국이 커버하는 전파 길이
        int prevRight = 0;
        int count = 0;

        for (int s : stations) {
            long left = Math.max(1, (long)s - w);
            long right = Math.min(n, (long)s + w);
            
            long gap = (left - prevRight - 1);
            
            if (gap > 0) {
                count += ((gap + cover - 1) / cover);
            }
            
            prevRight = (int) right;
        }
        
        long tailGap = (n - prevRight);
        
        if (tailGap > 0) {
            count += ((tailGap + cover - 1) / cover);
        }
        
        return count;
    }
}
