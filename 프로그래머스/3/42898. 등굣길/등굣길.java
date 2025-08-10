import java.util.*;

class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {    
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        boolean[][] water = new boolean[n][m];
        for (int[] p : puddles) {
            water[p[1] - 1][p[0] - 1] = true;
        }
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (water[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                
                if (y > 0) {
                    dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
                }
                
                if (x > 0) {
                    dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}