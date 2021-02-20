package hu.meiit.haladojava.calculator;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args )
    {
        String result="-";
        try {

            String expressionFromStandardInput =IO.getExpressionFromStandardInput();
            String[] parts= Function.parse(expressionFromStandardInput);
            IO.assertExpression(parts);
            Expression expression = Function.getAsExpression(parts);
            result=Function.executeExpression(expression);
            IO.outTostOutpot(result);

        }catch (Exception ex){
            IO.outTostOutpot(result);
        }

    }
}
