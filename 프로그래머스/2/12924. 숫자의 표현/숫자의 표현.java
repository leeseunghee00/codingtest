import java.util.*;

class Solution {
    
    public int solution(int n) {
        int left = 1, right = 1, sum = 1;
        int count = 0;
        
        while (left <= n) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                count++;
                sum -= left;
                left++;
            }
        }
        
        return count;
    }
}