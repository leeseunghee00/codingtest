import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
		int idx = 0;

		for (int[] command : commands) {
			int start = command[0];
			int end = command[1];
			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = start - 1; i < end; i++) {
				arr.add(array[i]);
			}

			Collections.sort(arr);
			result[idx] = arr.get(command[2] - 1);
			idx++;

		}

		return result;
	}
}