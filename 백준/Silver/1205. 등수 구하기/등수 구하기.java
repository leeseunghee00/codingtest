import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, P, score;
	static List<Integer> list = new ArrayList<>();

	 public static void main(String[] args) throws IOException {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());

		 N = Integer.parseInt(st.nextToken());
		 score = Integer.parseInt(st.nextToken());
		 P = Integer.parseInt(st.nextToken());

		 if (N == 0) {
			 System.out.println("1");
			 return;
		 }

		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < N; i++) {
			 int num = Integer.parseInt(st.nextToken());
			 list.add(num);
		 }


		 list.sort(Comparator.reverseOrder());

		 if (N == P && list.get(N - 1) >= score) {
			 System.out.println("-1");
			 return;
		 }

		 int rank = 1;
		 for (int s : list) {
			 if (s <= score) {
				 break;
			 }

			 rank++;
		 }

		 System.out.println(rank);
	}

}
