public class pgs_정수제곱근판별 {

    public static void main(String[] args) {

        System.out.println(solution(121));
    }

    private static long solution(long n) {

        long answer = 0;

        if (Math.sqrt(n) % 1 == 0) {
            answer = (long)((Math.sqrt(n) + 1) * (Math.sqrt(n) + 1));
        } else {
            answer = -1;
        }

        return answer;
    }
}
