package leeseunghee.study.programmers;

public class MiniRectangle {

    int width = 0;      //총 계산된 카드 너비
    int height = 0;     //총 계산된 카드 높이
    int answer = 0;

    public int main(int[][] sizes) {

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
