Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i = 0;i<s.length();i++){
             if(s.charAt(i) == '#'){ 
                if(!stack1.isEmpty()) stack1.pop();
            }else{
                stack1.push(s.charAt(i));
            }
        }
        
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i) == '#'){ 
                if(!stack2.isEmpty())stack2.pop();
            }else{
                stack2.push(t.charAt(i));
            }
        }
       
        return stack1.equals(stack2);
    }
}
