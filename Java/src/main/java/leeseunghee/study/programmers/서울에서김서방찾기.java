package leeseunghee.study.programmers;

public class 서울에서김서방찾기 {

    public static void main(String[] args) {

        String[] seoul = {"Jane,", "Kim"};
        System.out.println(solution(seoul));
    }

    private static String solution(String[] seoul) {
        String answer = "";

        for (int x = 0; x < seoul.length; x++) {
            if (seoul[x].equals("Kim")) {
                answer = "김서방은 " + x + "에 있다";
            }
        }

        return answer;
    }
}
