import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<Integer, Integer> aMap = new HashMap<>();
    static Map<Integer, Integer> bMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            primeFactorization(num, aMap);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            primeFactorization(num, bMap);
        }

        boolean flag = false;
        long result = 1L;

        for (Integer prime : aMap.keySet()) {
            if (bMap.containsKey(prime)) {
                int minCount = Math.min(aMap.get(prime), bMap.get(prime));
                for (int i = 0; i < minCount; i++) {
                    result *= prime;

                    if (result >= 1_000_000_000) {
                        result %= 1_000_000_000;
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            System.out.printf("%09d", result);
        } else {
            System.out.println(result);
        }
    }

    // 소인수분해하여 소인수와 개수를 저장하는 함수
    private static void primeFactorization(int num, Map<Integer, Integer> map) {
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }
        if (num > 1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
}
