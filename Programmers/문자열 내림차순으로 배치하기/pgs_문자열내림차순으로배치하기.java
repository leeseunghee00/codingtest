import java.util.Arrays;

public class pgs_문자열내림차순으로배치하기 {

    public static void main(String[] args) {

        System.out.println(solution("Zbcdefg"));
    }

    private static String solution(String s) {

        String answer = "";
        char[] str = s.toCharArray();

        Arrays.sort(str);

        answer = new StringBuilder(new String(str))
                .reverse()
                .toString();

        return answer;
    }
}
