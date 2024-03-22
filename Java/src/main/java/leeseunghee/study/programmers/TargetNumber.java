package leeseunghee.study.programmers;

public class TargetNumber {
    int[] numbers;
    int target;
    int answer = 0;

    void dfs(final int index, final int sum) {
        // 1. 탈출 조건
        if (index == numbers.length){
            if (sum == target) answer++;

            return;
        }

        // 2. 수행 동작 (수행동작을 먼저 구현 후 탈출 조건을 구현하는 것이 순서)
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(final int[] numbers, final int target) {

        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }
}
