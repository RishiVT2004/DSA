import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String exp : tokens) {
            // Check if the token is a number (including negative numbers)
            try {
                // Attempt to parse the number
                int num = Integer.parseInt(exp);
                stack.push(num);
            } catch (NumberFormatException e) {
                // Ensure the stack has at least two operands for an operation
                if (stack.size() < 2) {
                    return -1; // Return -1 for error due to insufficient operands
                }

                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int res = 0;

                switch (exp) {
                    case "+":
                        res = operand1 + operand2;
                        break;
                    case "-":
                        res = operand1 - operand2;
                        break;
                    case "*":
                        res = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            return -1; // Return -1 for division by zero
                        }
                        res = operand1 / operand2;
                        break;
                    case "^":
                        res = (int) Math.pow(operand1, operand2);
                        break;
                    default:
                        return -1; // Return -1 for unknown operator
                }
                stack.push(res); // Push the result back to the stack
            }
        }

        // There should be exactly one result left in the stack if the input is valid
        if(stack.size() != 1) return -1;
        return stack.pop();
    }
}
