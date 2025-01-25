import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

		for (String[] clo : clothes) {
			String type = clo[1];
			int num = map.get(type) != null ? map.get(type) + 1 : 1;

			map.put(type, num);
		}

		for (String type : map.keySet()) {
			answer *= (map.get(type) + 1);
		}

		return answer - 1;
    }
}