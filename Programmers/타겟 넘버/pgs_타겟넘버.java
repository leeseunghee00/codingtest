public class pgs_타겟넘버 {
    static int[] numbers;
    static int target;
    static int answer = 0;

    public static void main(String[] args) {

        numbers = new int[]{1, 1, 1, 1, 1};
        target = 3;

        System.out.println(solution(numbers, target));
    }

    private static void dfs(final int index, final int sum) {
        // 1. 탈출 조건
        if (index == numbers.length){
            if (sum == target) answer++;

            return;
        }

        // 2. 수행 동작 (수행동작을 먼저 구현 후 탈출 조건을 구현하는 것이 순서)
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    private static int solution(int[] numbers, int target) {

        answer = 0;

        dfs(0, 0);

        return answer;
    }
}
