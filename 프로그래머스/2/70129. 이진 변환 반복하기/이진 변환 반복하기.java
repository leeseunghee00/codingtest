import java.util.*;

class Solution {

    public int[] solution(String s) {
        int[] result = new int[2];
        
        if (s.equals("1")) {
            return new int[]{0, 0};
        }
        
        while (true) {
            int one = 0, zero = 0;
            
            if (s.equals("1")) {
                break;
            }
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
            
            result[0]++;
            result[1] += zero;
            
            // 1 카운트 이진법 계산
            s = Integer.toBinaryString(one);
        }
        
        return result;
    }
}