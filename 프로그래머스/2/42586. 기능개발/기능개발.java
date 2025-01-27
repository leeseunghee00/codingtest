import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		int count = 0, maxDays = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i <  progresses.length; i++) {
			int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

			// 새로운 배포 시작
			if (i == 0 || days > maxDays) {
				if (count > 0) {
					result.add(count);
				}

				maxDays = days;
				count = 1;
			} else {
				count++;
			}
		}

		result.add(count);

		return result.stream().mapToInt(i -> i).toArray();
    }
}