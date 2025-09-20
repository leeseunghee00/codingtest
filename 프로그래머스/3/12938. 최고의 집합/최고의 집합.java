import java.util.*;

class Solution {

    public int[] solution(int n, int s) {
        
        if (s < n) {
            return new int[] {-1};
        }

        int base = s / n;
        int r = s % n;

        int[] result = new int[n];
        Arrays.fill(result, base);

        for (int i = n - r; i < n; i++) {
            result[i] = base + 1;
        }
        
        return result;
    }
}
