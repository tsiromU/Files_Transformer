package com.progect_to_exam.third_semester;

public class App 
{
    public static void main( String[] args )
    {
        String input = "The price is ((100*3)+1+(1+1)*2+1*8+20 )/9/9 and 3+3 the 4+5 tax is 15.50+ 0.5.";
        
        String result = LineCalculator.evaluateExpressionsInString(input);
        System.out.println(result); 
    }
}
