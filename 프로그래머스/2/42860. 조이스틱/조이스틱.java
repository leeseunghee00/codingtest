import java.util.*;

class Solution {
    
    int size, result;
        
    public int solution(String name) {
        
        size = name.length();
        
        // 알파벳 변경 비용
        for (char ch : name.toCharArray()) {
            result += Math.min(ch - 'A', 'Z' - ch + 1);
        }
       
        // 커서 이동 비용
        int move = size - 1;
        
        for (int i = 0; i < size; i++) {
            int next = i + 1;
            
            // 연속된 A 구간 찾기
            while (next < size && name.charAt(next) == 'A') {
                next++;
            }
            
            // 오른쪽 vs 왼쪽부터 접근
            move = Math.min(move, i * 2 + size - next);
            move = Math.min(move, (size - next) * 2 + i);
        }
        
        return result + move;
    }
}