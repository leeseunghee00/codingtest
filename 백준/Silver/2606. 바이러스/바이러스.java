import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
	static int N, M, count;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> computer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N + 1];
		computer = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			computer.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 양방향 연결
			computer.get(a).add(b);
			computer.get(b).add(a);
		}

		dfs(1);
        
		System.out.println(count);
	}

	private static void dfs(int v) {
		visit[v] = true;

		for (int k = 0; k < computer.get(v).size(); k++) {
			int i = computer.get(v).get(k);

			if (!visit[i]) {
				count++;
				dfs(i);
			}
		}
	}
}
