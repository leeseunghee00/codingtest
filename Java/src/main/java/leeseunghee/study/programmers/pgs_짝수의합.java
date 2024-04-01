package leeseunghee.study.programmers;

public class pgs_짝수의합 {

    public static void main(String[] args) {

        System.out.println(solution(1000));
    }

    private static int solution(int n) {

        int answer = 0;

        for (int i = 2; i <= n; i += 2) {
            answer += i;
        }

        return answer;
    }
}
