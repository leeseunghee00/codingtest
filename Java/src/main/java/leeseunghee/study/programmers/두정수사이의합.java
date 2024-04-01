package leeseunghee.study.programmers;

public class 두정수사이의합 {

    public static void main(String[] args) {

        System.out.println(solution(3, 5));
    }

    private static long solution(int a, int b) {

        long answer = 0;

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }
}
