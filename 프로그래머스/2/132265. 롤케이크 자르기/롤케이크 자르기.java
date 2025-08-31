import java.util.*;

class Solution {

    public int solution(int[] topping) {
        
        int size = topping.length, result = 0;
        
        if (size % 2 != 0) {
            return 0;
        }
        
        int[] left = new int[size];
        int[] right = new int[size];
        Set<Integer> typeCount = new HashSet<>();
        
        // left
        for (int i = 0; i < size; i++) {
            typeCount.add(topping[i]);
            left[i] = typeCount.size();
        }
        
        // right
        typeCount.clear();
        for (int i = size - 1; i >= 0; i--) {
            typeCount.add(topping[i]);
            right[i] = typeCount.size();
        }
        
        // left vs right
        for (int i = 0; i < size - 1; i++) {
            if (left[i] == right[i + 1]) {
                result += 1;
            }
        }

        
        return result;
    }
}