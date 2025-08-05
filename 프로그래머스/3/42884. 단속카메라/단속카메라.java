import java.util.*;

// (-3, -5) (-5, -14) (-13, -18) (-15, -20)
class Solution {
    
    public int solution(int[][] routes) {

        int count = 0;
        int point = Integer.MIN_VALUE;

        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
         
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (point < start) {
                point = end;
                count++;
            }
        }

        return count;
    }
}