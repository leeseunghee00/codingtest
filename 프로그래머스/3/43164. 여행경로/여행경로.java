import java.util.*;

class Solution {
    
    List<String> result = new ArrayList();
    Map<String, List<String>> airports = new HashMap<>();

    public String[] solution(String[][] tickets) {
        
        for (String[] t : tickets) {
            airports
                .computeIfAbsent(t[0], k -> new ArrayList<>())
                .add(t[1]);
        }
        
        for (List<String> in : airports.values()) {
            Collections.sort(in);
        }
                        
        dfs("ICN");
        
        return result.toArray(new String[0]);
    }
    
    private void dfs(String out) {
        List<String> in = airports.get(out);

        while (in != null && !in.isEmpty()) {
            String next = in.remove(0);
            dfs(next);
        }
            
        result.add(0, out);
    }
}