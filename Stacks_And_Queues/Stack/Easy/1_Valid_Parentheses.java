
import java.util.Stack;

public class Solution {
    public static boolean isValidParenthesis(String s) {
        // Write your code here.
        Stack <Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket, check for matching opening bracket
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;  // No matching opening bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;  // Mismatched pair
                }
            }
        }
        
        // At the end, stack should be empty for a balanced string
        return stack.isEmpty();
    }
}
