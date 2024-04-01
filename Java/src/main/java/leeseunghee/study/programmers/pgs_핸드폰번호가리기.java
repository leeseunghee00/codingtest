package leeseunghee.study.programmers;

public class pgs_핸드폰번호가리기 {

    public static void main(String[] args) {

        System.out.println(solution("01033334444"));
    }

    private static String solution(String phone_number) {

        String answer = "";

        String blind = phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*");
        String number = phone_number
                .substring(phone_number.length() - 4, phone_number.length());

        answer = blind + number;

        return answer;
    }
}
