package leeseunghee.study.swea;

import java.util.Scanner;

public class swea_2058 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String T = sc.next();

        long sum = 0;

        for (int i = 0; i < T.length(); i++) {
            sum +=T.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
