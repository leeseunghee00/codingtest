public class pgs_x만큼간격이있는n개의숫자 {

    public static void main(String[] args) {

        System.out.println(solution(2, 5));
    }

    private static long[] solution(long x, int n) {

        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x * (i + 1);
        }

        return answer;
    }
}
