import java.util.*;

class Solution {

    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        
        // key: 이름, value: 인덱스 로 사용 
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int[][] pair = new int[n][n]; // a -> b 에게 준 선물 횟수
        int[] point = new int[n];    // 선물 지수 (give - receive)
        
        // 선물 주고 받기
        for (String g : gifts) {
            String[] parts = g.split(" ");
            int a = map.get(parts[0]);
            int b = map.get(parts[1]);
            
            pair[a][b] += 1;
            point[a] += 1;  // 준 사람
            point[b] -= 1;  // 받은 사람
        }
        
        // 다음 선물 계산
        int[] next = new int[n];
       
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int ab = pair[a][b];
                int ba = pair[b][a];
                
                if (ab > ba) {
                    next[a]++;
                } else if (ab < ba) {
                    next[b]++;
                } else {
                    if (point[a] > point[b]) {
                        next[a]++;
                    } else if (point[a] < point[b]) {
                        next[b]++;
                    }
                }
            }
        }
        
        // 가장 큰 선물 수 찾기
        int result = 0;
        
        for (int v : next) {
            result = Math.max(v, result);
        }
        
        return result;
    }
    
    private int getPoint(Map<String, Integer> map) {
        int point = 0;
        
        for (int v : map.values()) {
            point += v;
        }
        
        return point;
    }
}
