import java.util.*;

class Solution {
    
    public int[] solution(int[] answers) {
        Supoja supoja1 = new Supoja(1, new int[]{1, 2, 3, 4, 5});
		Supoja supoja2 = new Supoja(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
		Supoja supoja3 = new Supoja(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

		List<Supoja> supojas = List.of(supoja1, supoja2, supoja3);
		List<int[]> grading = new ArrayList<>();	// 0: 수포자, 1: 점수
		List<Integer> result = new ArrayList<>();
		int max = 0;

		for (Supoja supoja : supojas) {
			int[] spjAns = supoja.answers;
			int correct = 0;

			for (int i = 0; i < answers.length; i++) {
				if (spjAns[i % spjAns.length] == answers[i]) {
					correct++;
				}
			}

			if (correct != 0) {
				grading.add(new int[]{supoja.idx, correct});
			}
		}

		for (int[] grade : grading) {
			max = Math.max(max, grade[1]);
		}

		for (int[] grade : grading) {
			if (grade[1] == max) {
				result.add(grade[0]);
			}
		}

		Collections.sort(result);

		return result.stream().mapToInt(i -> i).toArray();
	}

	class Supoja {
		int idx;
		int[] answers;

		Supoja(int idx, int[] answers) {
			this.idx = idx;
			this.answers = answers;
		}
	}
}