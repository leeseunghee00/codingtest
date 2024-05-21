public class pgs_짝수와홀수 {

    public static void main(String[] args) {

        System.out.println(solution(3));
    }

    private static String solution(int num) {

        return num % 2 == 0 ? "Even" : "Odd";
    }
}
