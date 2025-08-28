import java.util.*;

class Solution {

    public int[] solution(int[] numbers) {

        int n = numbers.length;
        int[] result = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        
        Arrays.fill(result, -1);
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && numbers[deque.peek()] < numbers[i]) {
                result[deque.pop()] = numbers[i];
            }
            deque.push(i);
        }
        
        return result;
    }
}
