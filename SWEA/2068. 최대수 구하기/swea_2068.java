import java.util.Scanner;

public class swea_2068 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int max_num = 0;
            int[] numbers = new int[10];

            for (int i = 0; i < 10; i++) {
                numbers[i] = sc.nextInt();
            }

            for (int j = 0; j < 10; j++) {
                max_num = Math.max(max_num, numbers[j]);
            }

            System.out.println("#" + test_case + " " + max_num);
        }
    }
}
