package hu.meiit.haladojava.calculator;

public class Function {
    private static final String errorResponse="-";
    public static String[] parse(String expression){

        return expression.split(" ");
    }
    public static Expression getAsExpression(String[] parts){
        return new Expression(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[2]),parts[1]);
    }

    public static String executeExpression(Expression expression){
        String result=errorResponse;
        Executor executor=new Executor();
        String valto=expression.getOperator();
        switch (valto){
            case "+": result = String.valueOf(executor.add(expression.getOperand1()
                    , expression.getOperand2()));
                break;
            case "-": result = String.valueOf(executor.sub(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
            case "*": result=String.valueOf(executor.mult(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
            case "/": result=String.valueOf(executor.div(expression.getOperand1()
                    ,expression.getOperand2()));
                break;
        }
        if (result==null) {
            result="-";}
        return result;
    }
}
