package leeseunghee.study.backjoon;

import java.util.Scanner;

/**
 * DFS
 */
public class boj_1182 {

    static int n;
    static int s;
    static int[] arr;
    static int count = 0;

    private static void dfs(int index, int total) {
        // 1. 탈출 조건
        if (index == n) {
            if (total == s) {
                count++;
            }
            return ;
        }

        // 2. 수행 동작
        dfs(index+1, total);
        dfs(index+1, total+arr[index]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        s = scanner.nextInt();

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(0, 0);

        if (s==0)
            count--;

        System.out.println(count);
    }
}
