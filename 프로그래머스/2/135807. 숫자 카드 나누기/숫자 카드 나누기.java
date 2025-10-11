import java.util.*;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        int n = arrayA.length;
        
        boolean validA = true;
        boolean validB = true;
        
        for (int i = 0; i < n; i++) {
            if (arrayB[i] % gcdA == 0) {
                validA = false;
            }
            
            if (arrayA[i] % gcdB == 0) {
                validB = false;
            }
        }
        
        int result = 0;
        
        if (validA) {
            result = Math.max(result, gcdA);
        }
        
        if (validB) {
            result = Math.max(result, gcdB);
        }
        
        return result;
    }
    
    private int gcd(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}
