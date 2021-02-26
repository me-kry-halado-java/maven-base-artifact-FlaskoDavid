package hu.meiit.haladojava.calculator;

import java.util.ArrayList;

public class Function {
    private static final String errorResponse="-";
    public static String[] parse(String expression){
        if(expression.contains(" ")){
            return expression.split(" ");
        }
        char sub;
        ArrayList<String> express=new ArrayList<String>();
        String[]other;
        String[] retvalue=new String[3];
        int index=0;
        if (expression.contains("+")){
            index=expression.indexOf("+");
        }else if(expression.contains("-")){
            index=expression.indexOf("-");
        }else if(expression.contains("*")){
            index=expression.indexOf("*");
        }else if(expression.contains("/")){
            index=expression.indexOf("/");
        }
        sub=expression.charAt(index);

        other=expression.split("[+ - * /]");
        express.add(other[0]);
        express.add(String.valueOf(sub));
        express.add(other[1]);
        for (int i=0;i<express.size();i++){
            retvalue[i]=express.get(i);
        }
        return retvalue;
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
