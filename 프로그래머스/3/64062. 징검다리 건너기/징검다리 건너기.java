class Solution {

    public int solution(int[] stones, int k) {
        
        int result = 0;
        int left = 1, right = 200000000;
        
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canCross(int[] stones, int k, int people) {
        int jump = 0;
        
        for (int stone : stones) {
            if (stone - people < 0) {
                jump++;
                
                if (jump >= k) {
                    return false;
                }
            } else {
                jump = 0;
            }
        }
        
        return true;
    }
}