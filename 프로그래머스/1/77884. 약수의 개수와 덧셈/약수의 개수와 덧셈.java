class Solution {
    public int solution(int left, int right) {
        int result = 0;

		for (int i = left; i <= right; i++) {
			double sqrt = Math.sqrt(i);
			int count = 0;

			for (int k = 1; k <= sqrt; k++) {
				if (i % k == 0) {
					count++;

					if (i != k && i / k != k) {
						count++;
					}
				}
			}

			if (count % 2 == 0) {
				result += i;
			} else {
				result -= i;
			}
		}

		return result;
    }
}