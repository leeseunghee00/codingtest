package org.study;

import java.util.Scanner;

public class boj_5598 {
    public static void main(String... args) {
        // D E F G H I J K L M N O P Q R S T U V W X Y Z A B C 를
        // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 로 변환

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z'){
                ch = (char) (((ch - 'A' + 23) % 26) + 'A');
            }

            result.append(ch);
        }

        System.out.println(result);
    }
}
