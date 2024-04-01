package leeseunghee.study.programmers;

public class pgs_최소직사각형 {

    static int width = 0;      //총 계산된 카드 너비
    static int height = 0;     //총 계산된 카드 높이
    static int answer = 0;

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    private static int solution(int[][] sizes) {

        // 1. 2차원 배열을 1차원 배열로 순회
        for (int[] card : sizes) {

            int cardWidth = card[0];    //n번 카드의 가로
            int cardHeight = card[1];   //n번 카드의 세로

            // 2. 카드의 가로세로 길이 중 최대값과 이전 카드 사이즈를 비교하여 최종 너비값 추출
            width = Math.max(width, Math.max(cardWidth, cardHeight));

            // 3. 카드의 가로세로 길이 중 최소값과 이전 카드 사이즈를 비교하여 최종 높이값 추출
            height = Math.max(height, Math.min(cardWidth, cardHeight));

        }

        answer = width * height;

        return answer;
    }
}
