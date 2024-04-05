package leeseunghee.study.backjoon;

import java.util.Scanner;

public class boj_2018 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int start_idx = 1, end_idx = 1;
        int count = 1, sum = 1;

        while (end_idx != N) {

            if (sum == N) {
                count++; end_idx++;
                sum = sum + end_idx;
            } else if (sum > N) {
                sum = sum - start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum = sum + end_idx;
            }
        }

        System.out.println(count);
    }
}
