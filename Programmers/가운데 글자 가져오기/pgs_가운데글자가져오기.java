public class pgs_가운데글자가져오기 {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "qwer";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    private static String solution (String s) {

        String answer = "";
        int length = s.length();

        if (length % 2 == 0) {
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        } else {
            answer = s.substring(length / 2, length / 2 + 1);
        }

        return answer;
    }
}
