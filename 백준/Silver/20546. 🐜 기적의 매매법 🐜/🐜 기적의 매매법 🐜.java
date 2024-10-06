import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cash, junhyeon, sungmin;
	static int[] stockNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cash = Integer.parseInt(br.readLine());
		stockNum = new int[14];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			stockNum[i] = Integer.parseInt(st.nextToken());
		}

		junhyeon = bnp(cash);
		sungmin = timing(cash);

		if (junhyeon > sungmin) {
			System.out.println("BNP");
		} else if (junhyeon < sungmin) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}

	private static int bnp(int myCash) {
		int buyStock = 0;
		int idx = 0;

		while (idx < 14) {
			if (myCash / stockNum[idx] >= 1) {
				buyStock += myCash / stockNum[idx];
				myCash %= stockNum[idx];
			}

			idx++;
		}

		return (myCash + buyStock * stockNum[13]);
	}

	private static int timing(int myCash) {
		int buyStock = 0;
		int upCnt = 0;
		int dropCnt = 0;

		for (int i = 1; i < 14; i++) {
			if (stockNum[i] > stockNum[i - 1]) {
				upCnt++;
				dropCnt = 0;
			} else if (stockNum[i] < stockNum[i - 1]) {
				dropCnt++;
				upCnt = 0;
			} else {
				upCnt = 0;
				dropCnt = 0;
			}

			// 3일 연속 가격 상승일 경우 -> 전량 매도
			if (upCnt >= 3 && buyStock > 0) {
				myCash += buyStock * stockNum[i];
				buyStock = 0;
				upCnt = 0;
			}

			// 3일 연속 가격 하락일 경우 -> 전량 매수
			if (dropCnt >= 3 && myCash >= stockNum[i]) {
				buyStock += myCash / stockNum[i];
				myCash %= stockNum[i];
			}
		}

		return (myCash + buyStock * stockNum[13]);
	}
}
