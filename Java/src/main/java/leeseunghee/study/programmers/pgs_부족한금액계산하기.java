package leeseunghee.study.programmers;

public class pgs_부족한금액계산하기 {

    public static void main(String[] args) {

        System.out.println(solution(3, 20, 4));
    }

    private static long solution(int price, int money, int count) {

        long total = 0;

        for (int i = 1; i <= count; i++) {
            total += price * i;
        }

        if (money >= total) {
            return 0;
        }

        return total - money;
    }
}
