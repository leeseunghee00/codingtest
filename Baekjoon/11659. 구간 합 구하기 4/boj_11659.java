import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];

        st = new StringTokenizer(br.readLine());    //엔터역할; 개행 없애기 위함

        // 구간 합 생성
        for (int i = 1; i <= n; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int z = 0; z < m; z++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }
    }
}
