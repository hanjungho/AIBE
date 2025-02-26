package Devcos.AIBE.study_250226;

public class Solution05 {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorialByIteration(5));
        System.out.println(factorial.factorialByRecursion(5));
    }
}


class Factorial {
    long factorialByIteration(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    long factorialByRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorialByRecursion(n - 1);
    }
}