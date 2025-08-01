import java.util.*;

class Solution {

    public int[] solution(int[] sequence, int k) {
        
        int left = 0, right = 0;
        int sum = sequence[0];
        int[] answer = {0, Integer.MAX_VALUE};
        
        while (right < sequence.length) {

            if (sum == k) {
                if ((right - left) < (answer[1] - answer[0])) {
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}
