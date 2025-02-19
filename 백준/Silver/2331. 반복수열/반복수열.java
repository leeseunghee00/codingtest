import java.io.*;
import java.util.*;

public class Main {

    static int A, P;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list.add(A); // 처음 입력된 값 저장

        while (true) {
            int value = 0;
            char[] numCh = String.valueOf(A).toCharArray();

            for (char ch : numCh) {
                int num = ch - '0';
                value += (int) Math.pow(num, P);
            }

            if (list.contains(value)) {
                System.out.println(list.indexOf(value));
                break;
            }

            list.add(value);
            A = value;
        }
    }
}
