import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int result;
	static int[] numArr;
	static String str;
	static String[] strArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		str = sc.nextLine();
		strArr = str.split("-");
		numArr = new int[strArr.length];

		int idx = 0;

		for (String s : strArr) {
			int[] sNum =  Arrays.stream(s.split("\\+"))
				.mapToInt(Integer::parseInt)
				.toArray();

			for (int num : sNum) {
				numArr[idx] += num;
			}

			idx++;
		}

        result += numArr[0];

		for (int i = 1; i < numArr.length; i++) {
			result -= numArr[i];
		}

		System.out.println(result);
	}
}
