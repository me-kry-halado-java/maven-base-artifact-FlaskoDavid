package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class IO {

    public static String getExpressionFromStandardInput(){

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
    public static void assertExpression(String[] parts) throws Exception {
        if (parts.length != 3) {
            throw new RuntimeException("wrong input");
        }
    }

    public static void outTostOutpot (String result){
        System.out.println(result);
    }

}
