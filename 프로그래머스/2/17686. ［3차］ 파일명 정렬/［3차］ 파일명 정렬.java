import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        int size = files.length;
        Node[] nodes = new Node[size];
        
        for (int i = 0; i < size; i++) {
            nodes[i] = split(files[i], i);
        }
        
        Arrays.sort(nodes, (n1, n2) -> {
            int head = n1.headLower.compareTo(n2.headLower);
            
            if (head != 0) {
                return head;
            }
            
            if (n1.number != n2.number) {
                return n1.number - n2.number;
            }
            
            return n1.idx - n2.idx;
        });
        
        String[] result = new String[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = nodes[i].original;
        }
            
        return result;
    }
    
    private Node split(String file, int idx) {
        int i = 0, length = file.length();
        
        StringBuilder head = new StringBuilder();
        StringBuilder num = new StringBuilder();
        
        while (i < length && !Character.isDigit(file.charAt(i))) {
            head.append(file.charAt(i++));
        }
        
        int count = 0;
        while (i < length && Character.isDigit(file.charAt(i)) && count < 5) {
            num.append(file.charAt(i++));
        }
        
        int number = (num.length() == 0) ? 0 : Integer.parseInt(num.toString());
            
        return new Node(
            file,
            head.toString().toLowerCase(),
            number,
            idx
        );
    }
    
    static class Node {
        final String original;
        final String headLower;
        final int number;
        final int idx;
        
        Node(String original, String headLower, int number, int idx) {
            this.original = original;
            this.headLower = headLower;
            this.number = number;
            this.idx = idx;
        }
    }
}
