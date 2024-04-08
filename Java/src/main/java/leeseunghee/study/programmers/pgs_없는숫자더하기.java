package leeseunghee.study.programmers;

import java.util.Arrays;

public class pgs_없는숫자더하기 {

    public static void main(String[] args) {

        int[] numbers = {1 ,2, 3, 4, 6, 7, 8, 0};

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {

        return 45 - Arrays.stream(numbers).sum();
    }
}
