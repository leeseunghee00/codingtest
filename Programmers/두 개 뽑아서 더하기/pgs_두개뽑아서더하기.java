import java.util.HashSet;
import java.util.Set;

public class pgs_두개뽑아서더하기 {

	public static void main(String[] args) {

		int[] numbers = {2, 1, 3, 4, 1};

		System.out.println(solution(numbers));
	}

	private static int[] solution(int[] numbers) {

		Set<Integer> answer = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				answer.add(numbers[i] + numbers[j]);
			}
		}

		return answer.stream()
			.sorted()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
