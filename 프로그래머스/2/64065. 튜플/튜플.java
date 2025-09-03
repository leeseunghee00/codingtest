import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("\\},\\{");
        
        List<List<Integer>> tuples = new ArrayList<>();
        
        for (String part : parts) {
            List<Integer> tuple = new ArrayList<>();
            
            for (String num : part.split(",")) {
                tuple.add(Integer.parseInt(num));
            }
            
            tuples.add(tuple);
        }
        
        tuples.sort(Comparator.comparingInt(List::size));
        
        List<Integer> set = new ArrayList<>();
        
        for (List<Integer> tuple : tuples) {
            for (int num : tuple) {
                if (!set.contains(num)) {
                    set.add(num);
                }
            }
        }
        
        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }
    
}
