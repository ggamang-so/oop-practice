package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
* 요구사항
• 간단한 사칙연산을 할 수 있다.
• 양수로만 계산할 수 있다.
• 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
* */
public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다. ")
    @Test
    void additionTest() {
        int result = Calculator.calculator(new PositiveNumber(10), "+", new PositiveNumber(10));
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("뺄셈 연산을 수행한다. ")
    @Test
    void subtractionTest() {
        int result = Calculator.calculator(new PositiveNumber(10), "-", new PositiveNumber(9));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사칙연산을 수행한다. ")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest() {
        int result = Calculator.calculator(new PositiveNumber(10), "-", new PositiveNumber(9));
        assertThat(result).isEqualTo(1);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

   /*  PositiveNumberTest 에서 먼저 걸리기 때문에 의미가 없는 TEST
   @DisplayName("나눗셈에서 0으로 나누면 Exception을 발생시킨다 ")
    @Test
    void calculatorExceptionTest() {
        assertThatCode(() -> Calculator.calculator(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }
*/
}
