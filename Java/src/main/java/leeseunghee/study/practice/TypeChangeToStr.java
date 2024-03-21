package leeseunghee.study.practice;

public class TypeChangeToStr {

    public static void main(String[] args) {

        // int -> String
        int i = 1234;
        String is1 = String.valueOf(i);
        String is2 = Integer.toString(i);

        System.out.println(is1.getClass());
        System.out.println(is2.getClass());

        // float -> String
        float f = 3.14F;
        String fs1 = String.valueOf(f);
        String fs2 = Float.toString(f);

        System.out.println(fs1.getClass());
        System.out.println(fs2.getClass());

        // double -> String
        double d = 3.14;
        String ds1 = String.valueOf(d);
        String ds2 = Double.toString(d);

        System.out.println(ds1.getClass());
        System.out.println(ds2.getClass());
    }
}
