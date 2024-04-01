package leeseunghee.study.programmers;

public class pgs_콜라츠추측 {

    public static void main(String[] args) {

        System.out.println(solution(6));
        System.out.println(solution(626331));
    }

    private static int solution(long num) {

        int answer = 0;

        while (num != 1) {

            if (num % 2 == 0)
                num /= 2;
            else
                num = (num * 3) + 1;

            answer++;

            if (answer >= 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}

