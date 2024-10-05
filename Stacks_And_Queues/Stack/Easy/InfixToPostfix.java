import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    private static int precedence(char ch){
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '^') return 3;
        return -1;
    }

    private static boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') return true;
        return false;
    }
    public static String infixToPostfix(String exp) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for()
        

    }
}
