public class pgs_카펫 {

	public static void main(String[] args) {

		int brown = 10;
		int yellow = 2;

		System.out.println(solution(brown, yellow));
	}

	private static int[] solution(int brown, int yellow) {

		int[] answer = new int[2];

		for (int i = 1; i <= Math.sqrt(yellow); i++) {
				if (yellow % i == 0) {
					if ((i + 2) * 2 + (yellow / i) * 2 == brown){
					answer[0] = (yellow / i) + 2;
					answer[1] = i + 2;
				}
			}
		}

		return answer;
	}
}
