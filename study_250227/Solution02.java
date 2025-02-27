package Devcos.AIBE.study_250227;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution02 {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        File file = new File("src/Devcos/AIBE/study_250227/number.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                System.out.println(n);
            }
//            int n = scanner.nextInt();
//            System.out.println(n);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred");
        } finally {
            System.out.println("Finally block executed");
            try {
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextInt()) { // 문서에 처리할 수 있는 정수 있는지
                int n = sc.nextInt();
                System.out.println(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
