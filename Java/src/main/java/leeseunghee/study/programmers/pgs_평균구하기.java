package leeseunghee.study.programmers;

public class pgs_평균구하기 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        System.out.println(solution(arr));
    }

    private static double solution(int[] arr) {

        double answer = 0;
        int sum = 0;

        for (int k : arr) {
            sum += k;
        }

        answer = (double) sum / arr.length;

        return answer;
    }
}
