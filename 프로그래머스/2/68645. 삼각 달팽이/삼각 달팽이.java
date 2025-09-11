import java.util.*;

class Solution {
    
    // 방향: 아래, 오른쪽, 위 대각선
    int[] dy = {1, 0, -1};
    int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {

        int[][] arr = new int[n][n];
        int maxNum = (n * (n + 1)) / 2;
        int x = 0, y = 0, d = 0, num = 1;
        
        while (num <= maxNum) {
            arr[y][x] = num;
            num++;
        
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            
            y = ny;
            x = nx;
        }
        
        int[] result = new int[maxNum];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[idx] = arr[i][j];
                idx++;
            }
        }
        
        return result;
    }
}
