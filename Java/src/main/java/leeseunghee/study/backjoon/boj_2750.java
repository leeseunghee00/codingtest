package leeseunghee.study.backjoon;

import java.util.Scanner;

public class boj_2750 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArray = new int[N];

        for (int i = 0; i < N; i++) {
            numArray[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (numArray[i] > numArray[j]) {
                    int tmp = numArray[j];
                    numArray[j] = numArray[i];
                    numArray[i] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(numArray[i]);
        }
    }
}
