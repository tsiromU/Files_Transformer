package com.progect_to_exam.third_semester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.objecthunter.exp4j.ExpressionBuilder;

public class LineCalculator {
    
    public static String evaluateExpressionsInString(String input) {
        String regex = "-?\\d+(\\.\\d+)?\\s*[-\\+\\*/]\\s*-?\\d+(\\.\\d+)?";
        String regexWithParenthesis = "\\(\\s*" + regex + "\\s*\\)";
        String regexForMulDiv = "-?\\d+(\\.\\d+)?\\s*[\\*/]\\s*-?\\d+(\\.\\d+)?";
        String regexForSumSub = "-?\\d+(\\.\\d+)?\\s*[\\+-]\\s*-?\\d+(\\.\\d+)?";
        

        Pattern pattern = Pattern.compile(regex);
        
        while(true){
            Matcher matcher = pattern.matcher(input);
            if(!matcher.find()){
                break;
            }
            String evaluatedString = evaluateExpressionsInStringByRegex(input, regexWithParenthesis);
            if(evaluatedString != ""){  
                input = evaluatedString;
                continue;
            }
            evaluatedString = evaluateExpressionsInStringByRegex(input, regexForMulDiv);
            if(evaluatedString != ""){
                input = evaluatedString;
                continue;
            }
            input = evaluateExpressionsInStringByRegex(input, regexForSumSub);
            // evaluatedString = evaluateExpressionsInStringByRegex(input, regexForSumSub);
            // if(evaluatedString != ""){
            //     input = evaluatedString;
            // }
        }
        return input;
    }

    private static String evaluateExpressionsInStringByRegex(String input, String regex){
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        if(matcher.find()){
            
            String value = matcher.group();
            String ans = String.valueOf(new ExpressionBuilder(value).build().evaluate());
            matcher.appendReplacement(result, ans);
            matcher.appendTail(result);
            return result.toString();
        }
        else {
            return "";
        }
    }
};

