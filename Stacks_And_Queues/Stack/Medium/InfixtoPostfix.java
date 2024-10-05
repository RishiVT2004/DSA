You are given a string 'exp' which is a valid infix expression.

Convert the given infix expression to postfix expression.

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    // Function to return precedence of operators
    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    // Function to convert infix expression to postfix
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>(); // Stack for operators
        StringBuilder result = new StringBuilder(); // To store the postfix expression

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If the character is an operand, add it to the result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop and output from the stack until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from the stack
            }
            // If the character is an operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the operators left in the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
