package com.dzcode.springboot.masterclass.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyMathTest {

    MyMath myMath = new MyMath();

    @Test
    void calculateSumTest() {
        int[] numbers = {1,2,3};
        MyMath myMath = new MyMath();
        int result = myMath.calculateSum(numbers);
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    void calculateSumTest_ThreeMemberArray() {
        assertEquals(6, myMath.calculateSum(new int[] {1,2,3}));
    }

    @Test
    void calculateSumTest_ZeroLenghtArray() {
        assertEquals(0, myMath.calculateSum(new int[] {}));
    }
}
