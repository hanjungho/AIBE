package Devcos.AIBE.study_250227;

import java.util.Random;

public class Solution01 {

    public static void main(String[] args) {
        try {
            int number = 10;
//            System.out.println(number / 0); // ArithmeticException
            System.out.println(throwRandom());
        }
//        catch (ArithmeticException e) {
//            System.out.println("ArithmeticException occurred");
//        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred");
        } finally {
            System.out.println("Finally block executed");
        }
    }

    static double throwRandom() {
        Random random = new Random();
        double result = random.nextDouble();
        try {
            if (result > 0.5) {
                int error = 1 / 0;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        } finally {
            if (result == -1) {
                result = 9999;
            } else {
                result *= 1_000_000;
            }
            return result;
        }
    }
}
