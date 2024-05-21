import java.util.Arrays;

public class pgs_k번째수 {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array, commands));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;

        for (int i = 0; i < commands.length; i++) {
            int k = 0;

            int[] list = new int[commands[i][1] - commands[i][0] + 1];

            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                list[k++] = array[j - 1];
            }

            Arrays.sort(list);  //오름차순

            answer[n++] = list[commands[i][2] - 1];
        }

        return answer;
    }
}
