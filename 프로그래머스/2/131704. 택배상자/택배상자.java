import java.util.*;

class Solution {
    
    public int solution(int[] order) {
        
        Stack<Integer> container = new Stack<>();
        Stack<Integer> orders = new Stack<>();
        
        for (int i = order.length - 1; i >= 0; i--) {
            orders.push(order[i]);
        }
        
        int num = 1, result = 0;
        
        while (num <= order.length || !orders.isEmpty()) {
            int box = orders.peek();
                
            if (!container.isEmpty() && container.peek() == box) {
                container.pop();
                orders.pop();
                result++;
                                
                continue;
            }
            
            if (!container.isEmpty() && box < num) {
                break;
            }
            
            container.push(num);
            num++;
        }
        
        return result;
    }
}