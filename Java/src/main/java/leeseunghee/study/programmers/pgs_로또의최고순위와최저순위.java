package leeseunghee.study.programmers;

public class pgs_로또의최고순위와최저순위 {

    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(solution(lottos, win_nums));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int zero_count = 0;
        int win_count = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero_count++;
            }
        }

        for (int lotto : lottos) {
            for (int win : win_nums) {
                if (lotto == win) {
                    win_count++;
                    break;
                }
            }
        }

        answer[0] = result(zero_count + win_count);
        answer[1] = result(win_count);

        return answer;
    }

    private static int result(int num) {
        return switch (num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
