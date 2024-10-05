Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

1. Push(num): Push the given number in the stack.
2. Pop: Remove and return the top element from the stack if present, else return -1.
3. Top: return the top element of the stack if present, else return -1.
4. getMin: Returns minimum element of the stack if present, else return -1.

import java.util.* ;
import java.io.*; 
import java.util.Stack; 

public class Solution {

    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        // Constructor
        MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num){
            stack.push(num);

            if(min.isEmpty() || num <= min.peek()){
                min.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {

            if(stack.isEmpty()) return -1;
            
            int top = stack.peek();
            if(!stack.isEmpty()){
                stack.pop();
            }

            if(top == min.peek()){
                min.pop();
            }
            return top;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stack.isEmpty()) return -1;

            return stack.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(min.isEmpty()) return -1;
            return min.peek();
        }
    }
}
