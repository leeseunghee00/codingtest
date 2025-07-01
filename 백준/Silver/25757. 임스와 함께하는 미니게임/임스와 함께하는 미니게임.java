import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static char game;
	static Set<String> players = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		game = st.nextToken().charAt(0);

		for (int i = 0; i < n; i++) {
			String player = br.readLine();
			players.add(player);
		}

		int size = players.size();

		switch (game) {
			case 'Y': {
				System.out.println(size);
				break;
			}
			case 'F': {
				System.out.println(size / 2);
				break;
			}
			case 'O': {
				System.out.println(size / 3);
				break;
			}
		}
	}
}
