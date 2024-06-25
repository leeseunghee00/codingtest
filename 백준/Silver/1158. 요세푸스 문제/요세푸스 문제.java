import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N, K, idx;
	static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}

		System.out.print("<");

		while (arr.size() > 1){
			idx = (idx + K - 1) % arr.size();
			System.out.print(arr.remove(idx) + ", ");
		}

		System.out.println(arr.remove(0) + ">");
	}
}
