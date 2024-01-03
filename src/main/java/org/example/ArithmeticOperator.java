package org.example;

import java.util.Arrays;

public enum ArithmeticOperator { //산술연산자
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String OPERATOR;


    ArithmeticOperator(String operator) {
        this.OPERATOR = operator;
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);//추상메서드


    public static int calculate(int operand1, String operator, int operand2) { //?? 다시 분석해보자
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.OPERATOR.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);

    }
}
