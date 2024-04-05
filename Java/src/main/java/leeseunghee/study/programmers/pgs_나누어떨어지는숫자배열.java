package leeseunghee.study.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class pgs_나누어떨어지는숫자배열 {

    public static void main(String[] args) {

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        System.out.println(solution(arr, divisor));
    }

    private static int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (int k : arr) {
            if (k % divisor == 0) {
                temp.add(k);
            }
        }

        if (temp.isEmpty()) {
            temp.add(-1);
        } else {
            Collections.sort(temp);
        }

        int[] answer = new int[temp.size()];

        for (int i = 0 ; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
