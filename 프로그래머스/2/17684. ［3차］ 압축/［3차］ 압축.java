import java.util.*;

class Solution {

    public int[] solution(String msg) {
        Map<String, Integer> directory = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int num = 1;
        
        // directory 초기화
        for (int i = 0; i < 26; i++) {
            String alpha = String.valueOf((char)('A' + i));
            directory.put(alpha, num++);
        }
        
        int idx = 0;
        while (idx < msg.length()) {
            String curr = String.valueOf(msg.charAt(idx));
            int nextIdx = idx + 1;
            
            // curr + 다음 문자가 사전에 있으면 확장
            while (nextIdx <= msg.length() && 
                   directory.containsKey(msg.substring(idx, nextIdx))) {
                curr = msg.substring(idx, nextIdx);
                nextIdx++;
            }
            
            // 가장 긴 문자열 curr의 색인번호 출력
            list.add(directory.get(curr));
            
            // 새로운 문자열 등록
            if (nextIdx <= msg.length()) {
                directory.put(msg.substring(idx, nextIdx), num++);
            }
            
            // 인덱스 이동
            idx += curr.length();
        }
        
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
