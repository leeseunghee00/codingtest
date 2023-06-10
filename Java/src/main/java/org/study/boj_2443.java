package org.study;

import java.util.Scanner;

public class boj_2443 {
    public static void main(String[] args) {
        // 2*n-1, 2*n-3, 2*n-5, ...

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int blank = 0;

        for(int i = n; i >= 1; i--){

            // 1. 앞에 빈칸 띄우기
            for(int j = 1; j <= blank; j++) {
                System.out.print(" ");
            }

            // 2. 별 찍기
            for(int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // 3. 줄 바꿈
            blank++;
            System.out.println();
        }
    }
}
