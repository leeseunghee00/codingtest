import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] arr = new int[n * 2];
        
        for (int i = 0; i < n * 2; i++) {
            arr[i] = elements[i % n];
        }

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                
                for (int k = 0; k < length; k++) {
                    sum += arr[start + k];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }
}