public class pgs_콜라문제 {

    public static void main(String[] args) {

        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
    }

    private static int solution(int a, int b, int n) {

        int answer = 0;

        while (n >= a) {
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);
        }

        return answer;
    }
}
