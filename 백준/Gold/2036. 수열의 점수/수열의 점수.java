import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N;
	static boolean hasZero;
	static long result;
	static List<Integer> posList = new ArrayList<>();
	static List<Integer> negList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0) {
				posList.add(num);
			} else if (num < 0) {
				negList.add(num);
			} else {
				hasZero = true;
			}
		}

		posList.sort((o1, o2) -> o2 - o1);
		negList.sort((o1, o2) -> o1 - o2);
        
        if (negList.size() % 2 != 0) {
			if (!hasZero) {
				result += negList.get(negList.size() - 1);
			}
		}

		for (int i = 0; i < negList.size() - 1; i += 2) {
			result += ((long) negList.get(i) * negList.get(i + 1));
		}

        for (int i = 0; i < posList.size() - 1; i += 2) {
			if (posList.get(i) == 1 || posList.get(i + 1) == 1) {
				result += ((long) posList.get(i) + posList.get(i + 1));
			} else {
				result += ((long) posList.get(i) * posList.get(i + 1));
			}
		}

		if (posList.size() % 2 != 0) {
			result += ((long) posList.get(posList.size() - 1));
		}

		System.out.println(result);
	}
}
