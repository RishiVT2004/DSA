Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
*** You must implement a solution with O(1) time complexity for each function.

class MinStack {
    // declaration
    private Stack<Integer> Stack;
    private Stack<Integer> Min;

    // initialization
    public MinStack() {
        Stack = new Stack<>();
        Min = new Stack<>();
    }
    
    public void push(int val) {
       
       // no size constraint(synamic stack)
        Stack.push(val);
        // if min is empty or val <= min.peek() 
        // to handle duplicate min 
        if(Min.isEmpty() || val <= Min.peek()){
            Min.push(val);
        }
    }
    
    public void pop() {
        // if top of min == top of stack -> pop min[top]
        int top = 0;
        if(!Stack.isEmpty()){
            top = Stack.peek();
            Stack.pop();
        }

        if(top == (Min.peek())){
            Min.pop();
        }
    }
    
    public int top() {
        return Stack.peek();
    }
    
    public int getMin() {
        return Min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
