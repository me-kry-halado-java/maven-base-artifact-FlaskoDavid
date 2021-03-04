package hu.meiit.haladojava.calculator;

public class Executor {
    public double add(int operand1, int operand2){
        return operand1+operand2;
    }
    public double sub(int operand1, int operand2){
        return operand1-operand2;
    }
    public double mult(int operand1, int operand2){
        return operand1*operand2;
    }
    public double div(int operand1, int operand2) throws Exception{
        Double ret=null;
        if (operand2==0){
            throw new ArithmeticException(" no dividing with null number");
        }
        ret = (double)operand1/(double)operand2;

        return ret;
    }
}
