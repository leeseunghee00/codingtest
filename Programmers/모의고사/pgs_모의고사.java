import java.util.Arrays;

public class pgs_모의고사 {

	private static final int[][] RULE = {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};

	public static void main(String[] args) {

		int[] answers = {1, 2, 3, 4, 5};

		System.out.println(solution(answers));
	}

	private static int[] solution(int[] answers) {

		int[] answer = new int[3];
		int[] collect = new int[RULE.length];
		int max = 0;

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < RULE.length; j++) {
				if (RULE[j][i % RULE[j].length] == answers[i]) {
					collect[j]++;
					max = Math.max(max, collect[j]);
				}
			}
		}

		for (int i = 0; i < collect.length; i++) {
			if (max == collect[i]) {
				answer[i] = i + 1;
			}
		}

		return Arrays.stream(answer)
			.filter(i -> i != 0)
			.toArray();
	}
}
