import java.util.Scanner;

public class swea_2070 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a - b;

            System.out.print("#" + test_case + " ");
            if (result > 0) {
                System.out.println(">");
            } else if (result < 0) {
                System.out.println("<");
            } else {
                System.out.println("=");
            }
        }
    }

}
