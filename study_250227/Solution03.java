package Devcos.AIBE.study_250227;

import java.util.Random;

public class Solution03 {

    public static void main(String[] args) throws Exception {
        Solution03 sol = new Solution03();
        try {
            Random random = new Random();
            int min = random.nextInt(50);
            int max = random.nextInt(50) + min;
            System.out.println("오늘 행운의 숫자는 " + sol.getLuckyNumber(min, max));
        } catch (MaxLimitException e) {
            System.out.println("최대값을 초과했습니다.");
        } catch (MinLimitException e) {
            System.out.println("최소값을 초과했습니다.");
        } catch (Exception e) {
            System.out.println("Exception occurred");
        } finally {
            System.out.println("Finally block executed");
        }
    }

    int getLuckyNumber(int minLimit, int maxLimit) throws Exception {
        int luckyNumber = new Random().nextInt(100);


        if (luckyNumber > maxLimit) {
//            throw new Exception("Lucky number is too big");
            throw new MaxLimitException("Lucky number is too big");
        }

        if (luckyNumber < minLimit) {
//            throw new Exception("Lucky number is too small");
            throw new MinLimitException("Lucky number is too small");
        }

        return luckyNumber;
    }

    static class MaxLimitException extends Exception {
        public MaxLimitException(String message) {
            super(message);
        }
    }

    static class MinLimitException extends Exception {
        public MinLimitException(String message) {
            super(message);
        }
    }


}
