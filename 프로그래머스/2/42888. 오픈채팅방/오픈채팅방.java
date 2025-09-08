import java.util.*;

class Solution {
    
    private static final String[] PREFIX_INOUT = {"님이 들어왔습니다.", "님이 나갔습니다."};
    
    public String[] solution(String[] record) {
        
        Map<String, String> users = new HashMap<>();
        List<String[]> events = new ArrayList<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String uid = parts[1];

            if (cmd.equals("Enter")) {
                String name = parts[2];
                users.put(uid, name);
                events.add(new String[]{uid, cmd});
            } else if (cmd.equals("Leave")) {
                events.add(new String[]{uid, cmd});
            } else if (cmd.equals("Change")) {
                String name = parts[2];
                users.put(uid, name);
            }
        }
        
        String[] result = new String[events.size()];
        int i = 0;
        
        for (String[] e : events) {
            String cmd = e[1];
            String name = users.get(e[0]);
            
            if (cmd.equals("Enter")) {
                result[i] = name + PREFIX_INOUT[0];
            } else {
                result[i] = name + PREFIX_INOUT[1];
            }
            
            i++;
        }
        
        return result;
    }
}
