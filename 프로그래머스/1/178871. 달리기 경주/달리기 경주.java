import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String player : callings) {
            int rank = map.get(player);
            
            if (rank > 0) {
                String front = players[rank - 1];
                
                players[rank - 1] = player;
                players[rank] = front;
                
                map.put(player, rank - 1);
                map.put(front, rank);
            }            
        }
        
        return players;
    }
}