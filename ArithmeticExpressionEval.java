//345678901234567890123456789012345678901234567890123456789012345678901234567890012345678901234567890
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Evaluates an arithmetic expression passed as a string.
 *
 * @author Murphy (starter)
 * @version December 2024
 */
public class ArithmeticExpressionEval {
    
    /**
     * Takes arithmetic expression from user and evaluates it.
     */
    public static void testEvaluator() {
        System.out.println(evaluate("1+2*3"));
        System.out.println(evaluate("(1+2)*3"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String input = scanner.nextLine();
        while (!input.equals("")) {
            try {
                System.out.println(evaluate(input));
            } catch (NumberFormatException e) {
                System.out.println("Error: NumberFormatException");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: IllegalArgumentException");
            }
            System.out.println("Enter expression: ");
            input = scanner.nextLine();
        }
        System.out.println("Exited");
    }
    
    /**
     * Evaluates arithmetic expression by converting a String to an
     * expression tree and then converting to post-fix notation.  Prints results.
     * 
     * @param expression arithmetic expression as a String
     */
    public static double evaluate(String expression) {
        String[] arr = tokenize(expression);
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        if(!Applications.checkSyntax(expression)){
            throw new IllegalArgumentException("learn to type brochacho 💀");
        }
        
        int idx = 0;
        while (idx < arr.length) {
            
        }
    }

    /**
     * Tokenizes an arithmetic expression. Supports numbers, the operators + - * /,
     * and parentheses.
     * 
     * @param expression arithmetic expression as a String
     * @returns String array of tokens or null if unexpected characters
     */
    private static String[] tokenize(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            
            if (Character.isDigit(currChar) || currChar == '.') {
                numberBuffer.append(currChar);
            } else {
                if (numberBuffer.length() > 0) {
                    tokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }
                if ("+-*/()".indexOf(currChar) != -1) {
                    tokens.add("" + currChar);
                } else if (currChar == ' ') {
                    // do nothing if space
                } else { // unexpected character
                    return null;
                }
            }
        }

        if (numberBuffer.length() > 0) { // string ended with numbers
            tokens.add(numberBuffer.toString());
        }
  
        return tokens.toArray(new String[0]);
    }
    
    // Binary tree for representing an arithmetic expression
    // Subclasses for operators versus numbers
    private static class ExpressionTree implements Comparable<ExpressionTree> {

        // To work with MyRobustLinkedList
        public int compareTo(ExpressionTree other) { 
            return 0;
        }
    }
    
    private static class NumberNode extends ExpressionTree {
        private double number;
        
        private NumberNode(double number) {
            this.number = number;
        }

        private double getNumber() {
            return number;
        }
    }
    
    private static class OperatorNode extends ExpressionTree {
        private String operator;
        private int priority;
        private ExpressionTree leftTree;
        private ExpressionTree rightTree;
        
        private OperatorNode(String operator) {
            this.operator = operator;
            this.priority = -1;
            this.leftTree = null;
            this.rightTree = null;
        }

        private String getOperator() {
            return operator;
        }
        
        private int getPriority() {
            return priority;
        }
        
        private void setPriority(int priority) {
            this.priority = priority;
        }
        
        private void setLeftTree(ExpressionTree tree) {
            leftTree = tree;
        }
        
        private void setRightTree(ExpressionTree tree) {
            rightTree = tree;
        }
    }
}
