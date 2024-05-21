import java.util.*;

public class boj_2501 {
    public static void main(String[] args) {
        // n k 입력 받기
        // n = 자연수, k = 약수 중 k번째 작은 수

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // n 의 약수 구하기
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                arrayList.add(i);

                if (n / i != i) {
                    arrayList.add(n / i);
                }
            }
        }

        Collections.sort(arrayList);

        // 출력
        if (arrayList.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(arrayList.get(k-1));
        }
    }
}
