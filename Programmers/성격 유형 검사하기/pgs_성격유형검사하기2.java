import java.util.HashMap;

/**
 * 풀이 2
 */
public class pgs_성격유형검사하기2 {

    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {

        String answer = "";
        char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> map = new HashMap<>();

        // 유형별 점수 초기화
        for (char[] t : type) {
            map.put(t[0], 0);
            map.put(t[1], 0);
        }

        // 점수 저장
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4)
                map.put(survey[i].charAt(0), score[choices[i]] + map.get(survey[i].charAt(0)));
            else
                map.put(survey[i].charAt(1), score[choices[i]] + map.get(survey[i].charAt(1)));
        }

        // 점수 비교 후 유형 추가
        for (char[] t : type) {
            answer += map.get(t[0]) >= map.get(t[1]) ? t[0] : t[1];
        }

        return answer;
    }
}
