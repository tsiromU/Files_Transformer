package com.progect_to_exam.third_semester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineCalculatorTest {

    @Test
    public void BasicTest1()
    {
        String inputString    = "2+4";
        String expectedResult = "6.0";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void basicTest2()
    {
        String StringWithoutAnyExpressions = "urireur";
        String inputString    = StringWithoutAnyExpressions;
        String expectedResult = StringWithoutAnyExpressions;
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void basicTest3()
    {
        String inputString    = "the summ of 3 and 5 is 3+ 5(for sure)";
        String expectedResult = "the summ of 3 and 5 is 8.0(for sure)";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void highPriorityOperationsTest1()
    {
        String inputString    = "2 +4* 8";
        String expectedResult = "34.0";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void highPriorityOperationsTest2()
    {
        String inputString    = "*something important*2 +4* 8(not really)";
        String expectedResult = "*something important*34.0(not really)";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void highPriorityOperationsTest3()
    {
        String inputString    = "*something important*2 *4 -  8(not really)";
        String expectedResult = "*something important*0.0(not really)";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void highPriorityOperationsTest4()
    {
        String inputString    = "2 *4 /  8";
        String expectedResult = "1.0";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void parenthesisTest1()
    {
        String inputString    = "Lorem Ipsum(2+4*3 +3)*8 Lorem Ipsum";
        String expectedResult = "Lorem Ipsum136.0 Lorem Ipsum";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void parenthesisTest2()
    {
        String inputString    = "Lorem Ipsum(2+4*3 +3)*((8 -3)-7) Lorem Ipsum";
        String expectedResult = "Lorem Ipsum-34.0 Lorem Ipsum";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }

    @Test
    public void moreThanOneExpressionInInputTest()
    {
        String inputString    = "before taxes: 200+100; after taxes: (200+100)*0.85.";
        String expectedResult = "before taxes: 300.0; after taxes: 255.0.";
        assertEquals(LineCalculator.evaluateExpressionsInString(inputString), expectedResult);
    }
}
