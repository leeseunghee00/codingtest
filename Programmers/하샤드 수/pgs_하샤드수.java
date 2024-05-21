public class pgs_하샤드수 {

    public static void main(String[] args) {

        System.out.println(solution(10));
    }

    private static boolean solution(int x) {

        String s = String.valueOf(x);
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return x % sum == 0;
    }
}
