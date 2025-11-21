import java.util.*;
import java.io.*;

class Solution {

    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			int[] numArr = new int[100];
            
            // 배열에 숫자 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++)  {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            
			// 덤프 실행
            for (int d = 0; d < dump; d++) {
                // 최대, 최소 위치 구하기
                 int minIdx = 0, maxIdx = 0;
                
                for (int i = 0; i  < 100; i++) {
                    if (numArr[i] > numArr[maxIdx]) {
                        maxIdx = i;
                    } else if (numArr[i] < numArr[minIdx]) {
                    	minIdx = i;
                    }
                }
                
                if (numArr[maxIdx] - numArr[minIdx] <= 1) {
                    break;
                }
                
                numArr[minIdx]++;
                numArr[maxIdx]--;
            }
            
            // 최대, 최소 값 찾기
            int max = numArr[0], min = numArr[0];
            
            for (int i = 1; i < 100; i++) {
                if (max <  numArr[i]) {
                    max = numArr[i];
                } else if (min > numArr[i]) {
                	min =  numArr[i];
                }
            }
            
            // 출력
            int result = max - min;
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}