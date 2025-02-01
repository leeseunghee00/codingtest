import java.util.*;

class Solution {
    
    boolean[] primeArr = new boolean[1000_0001];

    public int solution(String numbers) {
        String[] arr = numbers.split("");
		Set<Integer> setArr = new HashSet<>();
		int result = 0;

		// 소수 배열 T/F 채우기
		createPrime();

		// 모든 경우의 수를 저장 단, Set 으로 중복 제거
		boolean[] visited = new boolean[arr.length];
		permutation(arr, visited, "", setArr);

		// 소수인지 확인 후 카운트
		for (Integer num : setArr) {
			if (num > 1 && primeArr[num]) {
				result++;
			}
		}

		return result;
	}

	private void permutation(String[] arr, boolean[] visited, String str, Set<Integer> setArr) {
		if (!str.equals("")) {
			setArr.add(Integer.parseInt(str));
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(arr, visited, str + arr[i], setArr);
				visited[i] = false;
			}
		}
	}

	private void createPrime() {
		// 일의 자리 예외만 true 로 미리 처리
		primeArr[2] = primeArr[3] = primeArr[5] = primeArr[7] = true;

		// 나머지 소수 판정
		for (int i = 10; i <= 100_0000; i++) {
			primeArr[i] = isPrime(i);
		}
	}

	private boolean isPrime(int num) {
		int sq = (int) Math.sqrt(num);

		for (int i = 2; i <= sq; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}