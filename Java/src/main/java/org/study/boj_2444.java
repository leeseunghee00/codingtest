package org.study;

import java.util.Scanner;

public class boj_2444 {
    public static void main(String[] args) {
        // 1 ~ 2*n-1 ~ 1 로 출력

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int blank = n - 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= blank; j++) {
                System.out.print(" ");
            }

            for(int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
            blank--;
        }

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= blank; j++) {
                System.out.print(" ");
            }

            for(int k = 2 * i - 1; k >= 1; k--){
                System.out.print("*");
            }

            System.out.println();
            blank++;
        }
    }
}
