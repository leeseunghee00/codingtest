import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int approve = nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			Integer value = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
			map.put(nums[i], value + 1);
		}

		int count = map.size();

		return count < approve ? count : approve;
    }
}