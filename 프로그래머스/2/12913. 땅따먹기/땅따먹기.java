class Solution {
    
    int solution(int[][] land) {
        
        int size = land.length;
        
        for (int r = 1; r < size; r++) {
            land[r][0] += Math.max(land[r - 1][1], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][1] += Math.max(land[r - 1][0], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][2] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][3]));
            land[r][3] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][2]));            
        }
        
        int result = Math.max(Math.max(land[size - 1][0], land[size - 1][1]), 
                              Math.max(land[size - 1][2], land[size - 1][3]));

        return result;
    }
}