package leeseunghee.study.programmers;

public class pgs_이상한문자만들기 {

    public static void main(String[] args) {

        String s = "try hello world";

        System.out.println(solution(s));
    }

    private static String solution(String s) {

        StringBuilder answer = new StringBuilder();
        String[] str = s.split(" ", -1);

        for (String word : str) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    answer.append(Character.toUpperCase(word.charAt(i)));
                } else {
                    answer.append(Character.toLowerCase(word.charAt(i)));
                }
            }

            if (!word.equals(str[str.length - 1])) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}
