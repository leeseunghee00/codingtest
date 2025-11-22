import java.util.*;

class Solution {
    
    int count;
    
    public int solution(int n) {
        nqueen(n, 0, new ArrayList<>());
        
        return count;
    }
    
    private void nqueen(int n, int row, List<Integer> list) {
        // 1. 모든 행에 퀸을 다 놓았다면 -> +1
        if (row == n) {
            count++;
            return;
        }
        
        // 2. 현재 rowl의 각 col에서 퀸 시도
        for (int col = 0; col < n; col++) {
            if (isAvailable(col, list)) {
                // 현재 위치에 퀸 배치
                list.add(col);
                // 다음 행으로 이동
                nqueen(n, row + 1, list);
                // 백트래킹: 방금 둔 퀸 제거
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isAvailable(int col, List<Integer> list) {
        int row = list.size();
        
        for (int i = 0; i < row; i++) {
            int prevCol = list.get(i);
            
            // 1) 같은 열
            // 2) 대각선 (열 차이 == 행 차이)
            if (col == prevCol || Math.abs(col - prevCol) == row - i) {
                return false;
            }
        }
        
        return true;
    }
}