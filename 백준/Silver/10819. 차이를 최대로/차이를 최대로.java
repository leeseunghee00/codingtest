import java.io.*;
import java.util.*;

public class Main {

    static int N, result = 0;
    static int[] arr;
    static boolean[] visited;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(result);
    }

    private static void perm(int depth) {

        if(depth == N) {
            int sum = 0;

            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }

            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < N; i++) {

            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];

                perm(depth + 1);

                visited[i] = false;
            }
        }
    }
}