import java.util.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> to = new HashMap<>();    // 신고한
        Map<String, Set<String>> from = new HashMap<>();  // 신고 당한
        Map<String, Integer> idx = new HashMap<>();       // id -> idx

        // map 초기화
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            
            to.put(id, new HashSet<>());
            from.put(id, new HashSet<>());
            idx.put(id, i);
        }

        // 신고한/신고당한 유저 추가
        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String target = parts[1];
                        
            to.get(reporter).add(target);
            from.get(target).add(reporter);
        }
        
        // 신고기록 반영
        Set<String> stop = new HashSet<>();
        
        for (String id : from.keySet()) {
            if (from.get(id).size() >= k) {
                stop.add(id);
            }
        }
        
        // 각 유저가 신고한 대상 중 정지된 사람 수
        int[] result = new int[id_list.length];
        
        for (String id : id_list) {
            int i = idx.get(id);
            int count = 0;
            
            for (String target : to.get(id)) {
                if (stop.contains(target)) {
                    count++;
                }
            }
            
            result[i] = count;
        }
        
        return result;
    }
}