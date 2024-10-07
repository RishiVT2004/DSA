import java.util.Stack;

public class Solution {
    public static String postToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            
            if (Character.isLetter(ch)) {
                stack.push(Character.toString(ch));
            } 
           
            else {
            
                String operand2 = stack.pop(); // 2nd operand appears first then first operand 
                String operand1 = stack.pop();

                String result = "(" + operand1 + ch + operand2 + ")";
                stack.push(result);
            }
        }
      
        return stack.pop();
    }
}
