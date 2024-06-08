package parser;

import java.util.ArrayList;

public class Parser{
    private static final String[] FUNCTIONS = 
    {
        "nul",
        "srt",
        "crt",
        "sin",
        "cos",
        "tan",
        "sec",
        "csc",
        "cot",
        "log",
        "lan",
        /*
        "prm",
        "cmb",
        "asi",
        "acs",
        "atn",
        "ase",
        "acc",
        "act",
        */
    };
    private static final String[] MODES = 
    {
        "inv",
        "rad",
        "deg",
        "sci",
        "norm",
        "bin",
        "oct",
        "dec",
        "hex"
    };
    private String expression;
    private int[] contentArray = new int[4];
    private ArrayList<Integer> funcArray = new ArrayList<>();
    private ArrayList<Integer> funcIndices = new ArrayList<>();
    void details(){
        System.out.println(" expression: " + expression);
        System.out.println(" Content:");
        System.out.println(" numbers = " + contentArray[0]);
        System.out.println(" operators = " + contentArray[1]);
        System.out.println(" brackets = " + contentArray[2]);
        System.out.println(" points = " + contentArray[3]);
        System.out.println(" Functions:");
        for(int i = 0; i < funcArray.size(); i++){
            System.out.println(" " + (i + 1) + ". " + FUNCTIONS[funcArray.get(i)] + ": " + funcIndices.get(i));
        }
    }
    int countLeftBrackets(String expression){
        int counter = 0;
        for(int i = 0; i < expression.length(); i++)
        if(expression.charAt(i) == '(')counter++;
        return 0;
    }
    int countRightBrackets(String expression){
        int counter = 0;
        for(int i = 0; i < expression.length(); i++)
        if(expression.charAt(i) == ')')counter++;
        return 0;
    }
    int[] analyzeExpression(String expression){
        if(expression.isEmpty())return new int[]{-1, -1, -1, -1};
        int[] contentArray = {0, 0, 0, 0};
        /*
         * [0] - numbers of digits
         * [1] - numbers of operators
         * [2] - numbers of brackets (both left and right) (must be even)
         * [3] - numbers of points
         */
        for(int i = 0; i < expression.length(); i++){
            if
            (
                expression.charAt(i) == '0' || 
                expression.charAt(i) == '1' || 
                expression.charAt(i) == '2' ||
                expression.charAt(i) == '3' ||
                expression.charAt(i) == '4' ||
                expression.charAt(i) == '5' ||
                expression.charAt(i) == '6' ||
                expression.charAt(i) == '7' ||
                expression.charAt(i) == '8' ||
                expression.charAt(i) == '9'
            )
            contentArray[0]++;
            if
            (
                expression.charAt(i) == '+' || 
                expression.charAt(i) == '-' || 
                expression.charAt(i) == '/' ||
                expression.charAt(i) == '*' ||
                expression.charAt(i) == '%' ||
                expression.charAt(i) == '^'
            )
            contentArray[1]++;
            if(expression.charAt(i) == '(' || expression.charAt(i) == ')')contentArray[2]++;
            if(expression.charAt(i) == '.')contentArray[3]++;
        }
        return contentArray;
    }
    int getFunctionIndex(String func){
        if(func.isEmpty())return 0;
        for(int i = 0; i < FUNCTIONS.length; i++){
            if(func.equals(FUNCTIONS[i]))return i;
        }
        return -1;
    }
    ArrayList<Integer> getFunctions(String expression){
        ArrayList<Integer> functions = new ArrayList<>();
        int length = expression.length();
        int adder;
        for(int i = 0; i < length; i += adder){
            if(i + 3 > length - 1)break;
            adder = 1;
            boolean charop2 = false;
            String temp = expression.substring(i, i + 3);
            int index = getFunctionIndex(temp);
            if(index >= 0){
                functions.add(index);
                adder = 3;
            }
        }
        return functions;
    }
    ArrayList<Integer> getFuncIndex(String expression){
        ArrayList<Integer> indices = new ArrayList<>();
        int length = expression.length();
        int adder;
        for(int i = 0; i < length; i += adder){
            if(i + 3 > length - 1)break;
            adder = 1;
            boolean charop2 = false;
            String temp = expression.substring(i, i + 3);
            int index = getFunctionIndex(temp);
            if(index >= 0){
                indices.add(i);
                adder = 3;
            }
        }
        return indices;
    }
    Parser(String expression){
        this.expression = expression;
        contentArray = analyzeExpression(expression);
        funcArray = getFunctions(expression);
        funcIndices = getFuncIndex(expression);
    }
    Parser(){
        this("");
    }
}
class Output<T>{
    public static void main(String args[]){
        Parser parser = new Parser("sin(cos(tan(4*6*(sec(8)))))");
        parser.details();
    }
}