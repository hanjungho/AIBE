package Devcos.AIBE.study_250220;

import java.util.Arrays;

public class Solution03 {

    public static void main(String[] args) {
        String text1 = "안녕하세요";
        System.out.println("text1 = " + text1);
        String text2 = "안녕하세요";
        System.out.println("text2 = " + text2);
        boolean isEqual = text1 == text2;
        System.out.println("isEqual = " + isEqual);
        String text3 = new String("안녕하세요");
        System.out.println("text3 = " + text3);
        boolean isEqual2 = text1 == text3;
        System.out.println("isEqual2 = " + isEqual2);
        System.out.println(System.identityHashCode(text1));
        System.out.println(System.identityHashCode(text2));
        System.out.println(System.identityHashCode(text3));
        System.out.println(text1.equals(text3));
        
        int[][] arr = {{1, 2}, {3, 4}};

        System.out.println("arr = " + arr);
        System.out.println("Arrays.deepToString(arr) = " + Arrays.deepToString(arr));

        int arr2[][] = {{1, 2}, {3, 4}};

        System.out.println("arr2 = " + arr2);

        String[] fruits = {"apple", "pear", "grapes"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

