import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> queue = new LinkedList<>();
        int time = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (queue.isEmpty()) {
                queue.offer(city);
                time += 5;
                continue;
            }
            
            if (queue.contains(city)) {
                queue.remove(city);
                queue.offer(city);
                time += 1;
            } else {
                if (queue.size() >= cacheSize) {
                    queue.poll();
                }
                
                queue.offer(city);
                time += 5;
            }
        }
        
        return time;
    }
}