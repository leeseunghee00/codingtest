import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {
        
        StringBuilder stream = new StringBuilder();
        
        // 진수 변환
        int num = 0;
        
        while (stream.length() < t * m) {
            stream.append(toBase(num, n));
            num++;
        }
        
        // 튜브 차례의 t개 문자열
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            result.append(stream.charAt(p - 1 + i * m));
        }
        
        return result.toString();
    }
    
    private String toBase(int num, int base) {

        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            int d = num % base;
            
            if (d < 10) {
                sb.append((char) ('0' + d));
            } else {
                sb.append((char) ('A' + (d - 10)));
            }
            
            num /= base;
        }
        
        return sb.reverse().toString();
    }
}
