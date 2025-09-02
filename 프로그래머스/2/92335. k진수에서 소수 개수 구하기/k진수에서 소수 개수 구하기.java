import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        
        int count = 0;
        String convert = convertToBaseK(n, k);
        String[] str = convert.split("0");

        for(String s : str) {
            if (s.isEmpty()) {
                continue;
            }
            
            long num = Long.parseLong(s);
            count += isPrime(num) ? 1 : 0;
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private String convertToBaseK(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}