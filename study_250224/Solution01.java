package Devcos.AIBE.study_250224;

import java.util.Arrays;

public class Solution01 {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("hello = " + hello);
        String newHello = new String(hello);
        System.out.println("newHello = " + newHello);
        System.out.println("(hello == newHello) = " + (hello == newHello));
        System.out.println("System.identityHashCode(hello) = " + System.identityHashCode(hello));
        System.out.println("System.identityHashCode(newHello) = " + System.identityHashCode(newHello));
        System.out.println("hello.equals(newHello) = " + hello.equals(newHello));

        long startTime = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1_000_000;i++) {
            sb.append((i + 1) * 3);
        }
//        String result = sb.toString();
//        System.out.println("result = " + result);
        System.out.println("수행시간 = " + (System.currentTimeMillis() - startTime));
//        StringBuffer sb = new StringBuffer();
        startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1_000_000;i++) {
//            sb.append((i + 1) * 3);
            builder.append((i + 1) * 3);
        }
//        String result = sb.toString();
//        System.out.println("result = " + result);
        System.out.println("수행시간 = " + (System.currentTimeMillis() - startTime));

        String sample = "가나다라마바사아자차카타파하";

        System.out.println("sample.length() = " + sample.length());
        System.out.println("sample.substring(0, 3) = " + sample.substring(0, 3));

        String eng = "abcdefg";
        System.out.println("eng.toUpperCase() = " + eng.toUpperCase());
        System.out.println("eng.toLowerCase() = " + eng.toLowerCase());

        String eng2 = "I'm so tired";
        System.out.println("eng2.split(\" \") = " + eng2.split(" "));
        System.out.println("eng2.split(\" \") = " + Arrays.toString(eng2.split(" ")));

        System.out.println("eng2.toLowerCase().replaceAll(\"tired\", \"happy\") = " + eng2.toLowerCase().replaceAll("tired", "happy"));
        System.out.println(eng2.toLowerCase().replaceAll("tired", "happy").replaceAll("'m so", "'m not"));

        String triple = """
                {
                    "name" : "jungho",
                    "work" : "program developer"
                }
                """;
        System.out.println(triple);
    }
}
