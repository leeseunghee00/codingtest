class Solution {
    
    int[] dp;
    
    public int solution(int n) {

        dp = new int[n + 1];
        
        return fibonacci(n);
    }
    
    private int fibonacci(int n) {
        if (n == 1 || n == 2) {
            dp[n] = 1;
            return dp[n];
        }
        
        if (dp[n] != 0) {
            return dp[n];
        }
        
        dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
        
        return dp[n];
    }
}