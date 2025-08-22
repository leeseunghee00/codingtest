class Solution {
    
    public int solution(int n, int a, int b) {
        
        int count = 0;
        
        while (a != b) {
            a = change(a);
            b = change(b);
            count++;
        }

        return count;
    }
    
    private int change(int num) {
        int div = (num / 2);
        return (num % 2 == 0) ? div : div + 1;
    }
}