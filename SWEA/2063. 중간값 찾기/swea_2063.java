import java.util.Arrays;
import java.util.Scanner;

public class swea_2063 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] numbers = new long[T + 1];

        for (int i = 1; i <= T; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        long midNumber = numbers[T / 2 + 1];

        System.out.println(midNumber);
    }
}
