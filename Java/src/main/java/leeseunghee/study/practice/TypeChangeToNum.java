package leeseunghee.study.practice;

public class TypeChangeToNum {

    public static void main(String[] args) {

        String sNum = "1234";

        // String -> int
        int i1 = Integer.parseInt(sNum);
        int i2 = Integer.valueOf(sNum);

        // String -> float
        float f1 = Float.valueOf(sNum);

        // String -> double
        double d1 = Double.valueOf(sNum);

        // String -> short
        short s1 = Short.valueOf(sNum);

        // String -> long
        long l1 = Long.valueOf(sNum);
    }
}
