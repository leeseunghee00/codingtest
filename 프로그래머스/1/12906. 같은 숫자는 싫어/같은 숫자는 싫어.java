import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
		List<Integer> answer = new ArrayList<>();

		int value = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != value) {
				answer.add(arr[i]);
				value = arr[i];
			}
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();

    }
}