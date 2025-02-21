package Devcos.AIBE.study_250221;

import java.util.Scanner;

public class Solution01 {
    /// Javadoc 주석
    /** Javadoc 주석 */
    // 주석
    /* 주석 */

    public static void main(String[] args) {
        int money = 0;
        System.out.println("money = " + money);
        Scanner scanner = new Scanner(System.in);
        try {
            money += scanner.nextInt();
            System.out.println("money = " + money);
        } catch (Exception e) {
            System.out.println("int 에는 그만큼 못 넣어요~~");
        }

        long bigMoney = 0;
        System.out.println("bigMoney = " + bigMoney);
        bigMoney += scanner.nextLong();
        System.out.println("bigMoney = " + bigMoney);

        double dollar = 0.0;
        System.out.println("dollar = " + dollar);
        dollar = scanner.nextDouble();
        System.out.println("dollar = " + dollar);

        double dollar1, dollar2;
        dollar1 = scanner.nextDouble();
        dollar2 = scanner.nextDouble();
        double dollarSum = dollar1 + dollar2;
        System.out.println("dollar1 = " + dollar1);
        System.out.println("dollar2 = " + dollar2);
        System.out.println("dollarSum = " + dollarSum);
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + c);
        System.out.println(c == 0.3);
        
        String guy1 = "chill guy";
        String guy2 = new String(guy1);
        System.out.println("guy1 = " + guy1);
        System.out.println("guy2 = " + guy2);
        System.out.println("guy1 == guy2 = " + guy1 == guy2);
        System.out.println("guy1.equals(guy2) = " + guy1.equals(guy2));

        int[] arr = new int[5];
        int[] arr2 = {1, 2, 3, 4, 5};
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] matrix2 = new int[2][2];
    }
}
