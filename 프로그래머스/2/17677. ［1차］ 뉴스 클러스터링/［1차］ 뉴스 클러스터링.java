import java.util.*;

class Solution {

    public int solution(String str1, String str2) {
        
        Map<String, Integer> str1Map = toMap(str1);
        Map<String, Integer> str2Map = toMap(str2);
        
        // 교집합
        int inner = 0;
        
        for (String e : str1Map.keySet()) {
            if (str2Map.containsKey(e)) {
                inner += Math.min(str1Map.get(e), str2Map.get(e));
            }
        }
        
        // 합집합
        int union = 0;
        Set<String> set = new HashSet<>(str1Map.keySet());
        set.addAll(str2Map.keySet());
        
        for (String key : set) {
            union += Math.max(str1Map.getOrDefault(key, 0), str2Map.getOrDefault(key, 0));
        }
        
        // 유사도 계산
        if (union == 0) {
            return 65536;
        }
        
        int result = (int) Math.floor((double) inner / union * 65536);
        
        return result;
    }
    
    private Map<String, Integer> toMap(String str) {

        Map<String, Integer> map = new HashMap<>();
        str = str.toUpperCase();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);
            
            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                String element = "" + ch1 + ch2;
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        
        return map;
    }
}
