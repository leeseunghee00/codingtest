import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.toArray(String[]::new);
		
		Arrays.sort(strArr, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));

		StringBuilder sb = new StringBuilder();
		for (String num : strArr) {
			sb.append(num);
		}
		
		if (sb.toString().charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
    }
}