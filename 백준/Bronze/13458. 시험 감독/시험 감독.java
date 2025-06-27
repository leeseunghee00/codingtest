import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, chief, assistant;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(num);
		}

		st = new StringTokenizer(br.readLine());
		chief = Integer.parseInt(st.nextToken());
		assistant = Integer.parseInt(st.nextToken());

		long count = 0;

		for (int num : arr){
			num -= chief;
			count++;

			if (num > 0) {
				count += (num + assistant - 1) / assistant;
			}
		}

		System.out.println(count);
	}
}
