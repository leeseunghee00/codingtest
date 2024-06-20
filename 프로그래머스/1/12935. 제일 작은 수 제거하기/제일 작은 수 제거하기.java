import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] arr) {
		ArrayList<Integer> newArr = new ArrayList<>();
		int min = Arrays.stream(arr).min().getAsInt();

        if (arr.length <= 1) {
			newArr.add(-1);
			return newArr;
		}
        
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != min) {
				newArr.add(arr[i]);
			}
		}
		
		return newArr;
    }
}