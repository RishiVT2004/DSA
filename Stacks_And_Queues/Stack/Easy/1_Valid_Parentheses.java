import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char []ch = s.toCharArray();
        for(char c : ch){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')' || c == ']' || c == '}' ){
                if(stack.isEmpty()){
                    return false;
                }
                if((c == ')' && stack.peek() != '(') || 
                   (c == '}' && stack.peek() != '{') ||
                   (c == ']' && stack.peek() != '[')){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
