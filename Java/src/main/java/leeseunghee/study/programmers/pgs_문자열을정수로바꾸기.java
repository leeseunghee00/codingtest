package leeseunghee.study.programmers;

public class pgs_문자열을정수로바꾸기 {

    public static void main(String[] args) {

        System.out.println(solution("1234"));
        System.out.println(solution("-1234"));
    }

    private static int solution(String s) {

        return Integer.valueOf(s);
    }
}
