package Devcos.AIBE.study_250220;

import java.util.Scanner;

public class Solution01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();
        System.out.println("안녕하세요 " + name + "님");
        scanner.close();
        System.out.println("끝");
    }
}
