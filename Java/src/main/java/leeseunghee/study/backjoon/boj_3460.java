package leeseunghee.study.backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_3460 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        // T 만큼 돌리기
        while(T-- > 0) {
            ArrayList<Integer> binary = new ArrayList<>();
            int n = scanner.nextInt();

            // 이진수 구하기
            while(n != 0){
                binary.add(n % 2);
                n = n / 2;
            }

            // 1 위치 출력
            int loc = 0;

            while(loc < binary.size()) {
                if (binary.get(loc) == 1) {
                    System.out.print(loc + " ");
                }
                loc++;
            }
        }
    }
}
