package Devcos.AIBE.study_250227;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution04 {

    public static void main(String[] args) {
        File file = new File("src/Devcos/AIBE/study_250227/actor.txt");

        try {
            if (file.exists()) {
                System.out.println("파일 존재");
            } else {
                System.out.println("파일 존재하지 않음");
                if (file.createNewFile()) {
                    System.out.println("파일 생성 성공");
                } else {
                    System.out.println("파일 생성 실패");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception occurred");
        } finally {
            System.out.println("Finally block executed");
        }

        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(file)) {
            while (true) {
                System.out.println("배우 이름을 입력하세요 (그만 입력하려면 '그만'을 입력하세요)");
                String input = scanner.nextLine();
                if (input.equals("그만")) {
                    break;
                }
                writer.write("배우 이름: " + input + "\n");
            }
            System.out.println("파일 쓰기 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Y/N 입력 받기 (출력할지)
        System.out.println("파일을 출력하시겠습니까? (Y/N)");
        String input = scanner.nextLine();
        if (input.equals("Y")) {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("파일 출력 취소");
        }

        // Y/N 입력 받기 (삭제할지)
        System.out.println("파일을 삭제하시겠습니까? (Y/N)");
        input = scanner.nextLine();
        if (input.equals("Y")) {
            try {
                if (file.exists()) {
                    System.out.println("파일 존재");
                    if (file.delete()) {
                        System.out.println("파일 삭제 성공");
                    } else {
                        System.out.println("파일 삭제 실패");
                    }
                } else {
                    System.out.println("파일 존재하지 않음");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("파일 삭제 취소");
        }
    }
}
