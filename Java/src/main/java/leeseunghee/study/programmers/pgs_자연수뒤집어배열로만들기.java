package leeseunghee.study.programmers;

import java.util.Arrays;

public class pgs_자연수뒤집어배열로만들기 {

    public static void main(String[] args) {

        System.out.println(solution(12345));
    }

    private static int[] solution(long n) {

        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[s.length() - 1 - i] = s.charAt(i) - '0';
        }

        return answer;
    }
}
