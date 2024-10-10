You are given a string ‘S’ containing only the characters ‘)’ and ‘(‘. You need to find the length of the longest valid i.e. well-formed parentheses substring.

For example:
Let the given string be “(()())((”.

Here the valid parentheses substrings are: “()”, “()” and “(()())”. Out of these the longest valid string is “(()())” which has a length 6.

import java.util.Stack;

public class Solution {
    public static int longestValidParentheses(String s) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>(); // stores indexes of string 
        stack.push(-1); // Initialize stack with -1 to handle edge case like "()"
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i); // beginning of new valid substring 
                }else{
                    maxLen = Math.max(maxLen , i-stack.peek()); // maxLen -> length of pev max substring , i-stack.peek() length of current valid substring 
                }
            }
        }
        return maxLen;
       
    }
}
