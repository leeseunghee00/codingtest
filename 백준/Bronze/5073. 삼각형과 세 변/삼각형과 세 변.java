import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				return;
			}

			arr.add(a);
			arr.add(b);
			arr.add(c);

			arr.sort(Integer::compare);

			if (arr.get(0) + arr.get(1) <= arr.get(2)) {
				System.out.println("Invalid");
			} else if (arr.get(0).equals(arr.get(1)) && arr.get(1).equals(arr.get(2))) {
				System.out.println("Equilateral");
			} else if (arr.get(0).equals(arr.get(1)) || arr.get(1).equals(arr.get(2)) || arr.get(0).equals(arr.get(2))) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}
	}
}
