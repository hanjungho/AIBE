package Devcos.AIBE.study_250224;

import java.util.Arrays;

public class Solution02 {

    public static void main(String[] args) {
        String[] setList = {
                "Hello!",
                "Hi there.",
                "Good day.",
                "Thank you.",
                "See you.",
                "Take care.",
                "All right.",
                "No problem.",
                "You're welcome.",
                "Have fun!"
        };
        System.out.println("setList = " + setList);
        System.out.println("Arrays.toString(setList) = " + Arrays.toString(setList));

        String[] setList2 = setList;
        setList2[6] += " haha!!!!";

        System.out.println("setList2 = " + Arrays.toString(setList2));
        System.out.println("setList = " + Arrays.toString(setList));

        String[] setList3 = new String[setList.length];
        for (int i = 0; i < setList3.length; i++) {
            setList3[i] = setList[i];
        }
        setList3[6] += " haha!!!!";
        System.out.println("setList = " + Arrays.toString(setList));
        System.out.println("setList3 = " + Arrays.toString(setList3));
        System.out.println("System.identityHashCode(setList) = " + System.identityHashCode(setList));
        System.out.println("System.identityHashCode(setList2) = " + System.identityHashCode(setList2));
        System.out.println("System.identityHashCode(setList3) = " + System.identityHashCode(setList3));

        String[] setList4 = new String[setList.length];
        System.arraycopy(setList, 0, setList4, 0, setList4.length);
        System.out.println("setList4 = " + Arrays.toString(setList4));

        String[][] matrix = {
                {"Hi", "Hello", "Hey"},
                {"Yes", "No", "OK"},
                {"Thanks", "Sorry", "Bye"},
                {"Good", "Bad", "Cool"},
                {"Wow", "Great", "Nice"},
                {"One", "Two", "Three"},
                {"Up", "Down", "Left"},
                {"Right", "Here", "There"},
                {"Now", "Later", "Soon"},
                {"Please", "Maybe", "Never"}
        };
        System.out.println("Arrays.toString(matrix) = " + Arrays.toString(matrix));
        System.out.println("Arrays.deepToString(matrix) = " + Arrays.deepToString(matrix));

        // 얕은 복사
        String[][] matrix2 = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix2.length; i++) {
            matrix2[i] = matrix[i];
        }
        matrix2[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix2 = " + Arrays.deepToString(matrix2));

        // 얕은 복사
        String[][] matrix3 = new String[matrix.length][matrix[0].length];
        System.arraycopy(matrix, 0, matrix3, 0, matrix3.length);
        System.out.println("matrix3 = " + Arrays.deepToString(matrix3));
        matrix3[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix2 = " + Arrays.deepToString(matrix3));

        // 깊은 복사
        String[][] matrix4 = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix4.length; i++) {
            for (int j = 0; j < matrix4[0].length; j++) {
                matrix4[i][j] = matrix[i][j];
            }
        }
        matrix4[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix4 = " + Arrays.deepToString(matrix4));

        // 깊은 복사
        String[][] matrix5 = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix5.length; i++) {
            System.arraycopy(matrix[i], 0, matrix5[i], 0, matrix5[0].length);
        }
        matrix5[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix5 = " + Arrays.deepToString(matrix5));

        // 깊은 복사
        String[][] matrix6 = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix6.length; i++) {
            matrix6[i] = matrix[i].clone();
        }
        matrix6[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix6 = " + Arrays.deepToString(matrix6));

        // 얕은 복사
        String[][] matrix7 = new String[matrix.length][matrix[0].length];
        matrix7 = matrix.clone();
        matrix7[3][1] += " haha!!!";
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix7 = " + Arrays.deepToString(matrix7));
    }
}
