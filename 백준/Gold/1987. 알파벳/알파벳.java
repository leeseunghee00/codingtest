import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static char[][] str;
	static Set<Character> alpha = new HashSet<>();

	static int[] dr = {0, 1, 0, -1};	//오른쪽-아래-왼쪽-위
	static int[] dc = {1, 0, -1, 0};	//오른쪽-아래-왼쪽-위

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		str = new char[R][C];

		for (int i = 0; i < R; i++) {
			str[i] = br.readLine().toCharArray();
		}

		alpha.add(str[0][0]);
		move(0, 0);

		System.out.println(max);
	}

	private static void move(int r, int c) {

		max = Math.max(max, alpha.size());

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
				continue;
			}

			if (!alpha.contains(str[nr][nc])) {
				alpha.add(str[nr][nc]);
				move(nr, nc);
				alpha.remove(str[nr][nc]);
			}
		}
	}
}
