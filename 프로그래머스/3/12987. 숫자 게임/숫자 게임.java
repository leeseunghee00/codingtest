import java.util.*;

class Solution {

    public int solution(int[] A, int[] B) {
        
        int size = A.length;
        int[] reverseA = new int[size];
        
        // A 내림차순
        Arrays.sort(A);
        
        for (int i = 0; i < size; i++) {
            reverseA[i] = A[size - i - 1];
        }
        
        // B 오름차순
        Arrays.sort(B);
        
        int left = 0, right = size - 1;
        int win = 0;
        
        for (int i = 0; i < size; i++) {
            if (B[i] > reverseA[left]) {
                left++;
                win++;
            } else if (B[i] > reverseA[right]) {
                right--;
                win++;
            } else {
                left++;
            }
        }
        
        return win;
    }
}
