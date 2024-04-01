package leeseunghee.study.programmers;

import java.util.Scanner;

public class 수박수박수박수박수박수박수 {

    public static void main(String[] args) {

        System.out.println(solution(3));
    }

    private static String solution(int n) {
        String answer = "";
        int i = 1;

        while (n-- != 0) {
            if (i % 2 != 0) {   //홀수일 때
                answer += "수";
            } else {            //짝수일 때
                answer += "박";
            }

            i++;
        }

        return answer;
    }
}
