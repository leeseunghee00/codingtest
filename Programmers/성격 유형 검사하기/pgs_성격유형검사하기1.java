import java.util.HashMap;

/**
 * 풀이 1
 */
public class pgs_성격유형검사하기1 {

    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {

        String answer = "";
        HashMap<Character, Integer> map  = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4)
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            else
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
        }

        answer += map.get('R') >= map.get('T') ? "R" : "T";
        answer += map.get('C') >= map.get('F') ? "C" : "F";
        answer += map.get('J') >= map.get('M') ? "J" : "M";
        answer += map.get('A') >= map.get('N') ? "A" : "N";

        return answer;
    }
}
