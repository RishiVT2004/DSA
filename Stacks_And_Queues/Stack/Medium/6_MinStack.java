Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

class MinStack {
    // declaration
    Stack<Integer> stack;
    Stack<Integer> minStack;

    // initialization
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}


problem faced -> 
1. val < minStack.peek() instead of val <= minStack.peek()
2. use stack.peek().equals(minStack.peek()) instead of stack.peek() == minStack.peek()
    as .equals() check value , while == checks object reference equality for non-primitive types like Integer, not their value equality.

    In some scenarios, two different Integer objects with the same value may not have the same reference, leading to incorrect behavior when using ==.
