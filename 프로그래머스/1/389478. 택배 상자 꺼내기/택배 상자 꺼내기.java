import java.util.*;

class Solution {

    public int solution(int n, int w, int num) {
        
        int count = 0;
        int numR = 0, numC = 0;
        int m = (n + w - 1) / w;
        
        int[][] arr = new int[m][w];
        int box = 1;
        boolean flag = false;
        
        // arr 채우기        
        for (int i = 0; i < m; i++) {            
            if (i % 2 == 0){
                for (int j = 0; j < w; j++) {                                        
                    arr[i][j] = box;

                    if (box == num) {
                        numR = i;
                        numC = j;
                    }
                    
                    if (box == n) {
                        flag = true;
                        break;
                    }

                    box++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    arr[i][j] = box;

                    if (box == num) {
                        numR = i;
                        numC = j;
                    }
                    
                    if (box == n) {
                        flag = true;
                        break;
                    }
                    
                    box++;
                }
            }
            
            if (flag) {
                break;
            }
        }
        
        // 꺼내야 하는 상자 개수 세기
        if (numR == m - 1) {
            return 1;
        }
        
        for (int r = m - 1; r >= numR; r--) {
            if (arr[r][numC] != 0) {
                count++;
            }
        }
        
        return count;
    }
}
