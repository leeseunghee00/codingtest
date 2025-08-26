import java.util.*;

class Solution {

    char[] open = {'(', '[', '{'};
    char[] close = {')', ']', '}'};
    
    public int solution(String s) {
        
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            deque.offer(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> openStack = new Stack<>();
            boolean isOk = true;
            
            StringBuilder sb = new StringBuilder();
            for (char c : deque) {
                sb.append(c);
            }
            String rotated = sb.toString();
            
            for (int j = 0; j < rotated.length(); j++) {
                char ch = rotated.charAt(j);
                
                if (ch == open[0] || ch == open[1] || ch == open[2]) {
                    openStack.push(ch);
                } else {
                    if (openStack.isEmpty()) {
                        isOk = false;
                        break;
                    }

                    char op = openStack.pop();
                    if (!isPair(op, ch)) {
                        isOk = false;
                        break;
                    }
                }
            }
            
            if (openStack.isEmpty() && isOk) {
                count++;
            }
            
            char ch = deque.pollFirst();
            deque.offerLast(ch);
        }
        
        return count;
    }
    
    private boolean isPair(char op, char cl) {
        if (op == open[0] && cl == close[0]) {
            return true;
        } 
        
        if (op == open[1] && cl == close[1]) {
            return true;
        }
        
        if (op == open[2] && cl == close[2]) {
            return true;
        }
        
        return false;
    }
}
