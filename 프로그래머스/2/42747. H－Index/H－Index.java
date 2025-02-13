import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
		int size = citations.length;

		Arrays.sort(citations);

		for (int i = 0; i < size; i++) {
			int h = size - i;
			if (h <= citations[i]) {
				hIndex = h;
                break;
			}
		}

		return hIndex;
	}
}