package hu.meiit.haladojava.calculator;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String errorResponse="-";
    private static String[] parse(String expression){
        String[] returnvalue = expression.split(" ");
        return returnvalue;
    }
    private static String getExpressionFromStandardInput(){
        System.out.println("kerem az adatokat");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression;
    }

    private static void assertExpression(String[] parts) throws Exception {
        if (parts.length != 3) {
            throw new RuntimeException("wrong input");
        }
    }
    private static Expression getAsExpression(String[] parts){
        return new Expression(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),parts[2]);
    }

    private static String executeExpression(Expression expression){
        String result=errorResponse;
        Executor executor=new Executor();
        if (expression.getOperator().equals("+")){
            result = String.valueOf(executor.add(expression.getOperand1()
                    , expression.getOperand2()));
        }else if (expression.getOperator().equals("-")){
            result = String.valueOf(executor.sub(expression.getOperand1()
                    ,expression.getOperand2()));
        }
        return result;
    }
    public static void main( String[] args )
    {
        String result=" ";
        try {

            String expressionFromStandardInput =getExpressionFromStandardInput();
            String[] parts= parse(getExpressionFromStandardInput());
            assertExpression(parts);
            Expression expression = getAsExpression(parts);
            result=executeExpression(expression);


        }catch (Exception ex){}
        System.out.println(result);
    }
}
