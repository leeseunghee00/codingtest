import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {        
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        long total = sum1 + sum2;
        
        if (total % 2 != 0) {
            return -1;
        }
        
        long half = total / 2;
        
        if (isOverHalf(queue1, half) || isOverHalf(queue2, half)) {
            return -1;
        }
        
        List<Long> union = new ArrayList<>();
        
        for (int num : queue1) {
            union.add((long) num);
        }
        
        for (int num : queue2) {
            union.add((long) num);
        }
        
        int i = 0, j = queue1.length;
        int size = union.size();
        int moves = 0;
        
        while(i < size && j < size) {
            if (sum1 == sum2) {
                return moves;
            } 
            
            if (sum1 > sum2) {
                sum1 -= union.get(i);
                sum2 += union.get(i);
                i++;
            } else {
                sum1 += union.get(j);
                sum2 -= union.get(j);
                j++;
            }
            
            moves++;
        }
        
        return -1;
    }
    
    private long sum(int[] queue) {
        long sum = 0;
        
        for (int num : queue) {
            sum += num;
        }
        
        return sum;
    }
    
    private boolean isOverHalf(int[] queue, long half) {
        for(int num : queue) {
            if (num > half) {
                return true;
            }
        }
        
        return false;
    }
}
