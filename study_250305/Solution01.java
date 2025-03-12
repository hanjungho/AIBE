package Devcos.AIBE.study_250305;

import java.util.logging.Logger;

public class Solution01 {
    public static void main(String[] args) {
        ICalculator calculator = new Calculator();
        Logger logger = Logger.getLogger("calculator");
        logger.info("%d".formatted(calculator.add(1, 2)));
        logger.info("%d".formatted(calculator.subtract(1, 2)));

        ICalculatorLambda calculatorLambda = (a, b) -> a * b;
        logger.info("%d".formatted(calculatorLambda.run(1, 2)));
        ICalculatorLambda calculatorLambda2 = Calculator::pythagorean;
        logger.info("%d".formatted(calculatorLambda2.run(3, 4)));
    }
}

@FunctionalInterface
interface ICalculatorLambda {
    int run(int a, int b);
}

class Calculator implements ICalculator {

    public static int pythagorean(int a, int b) {
        return (int) Math.sqrt(a * a + b * b);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}

interface ICalculator {
    int add(int a, int b);
    int subtract(int a, int b);
}