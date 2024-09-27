public class Solution{
    static class Stack {
            private int[] stack;
            private int top;
            private int capacity;

        Stack(int capacity) {
            // Declaring an Empty Stack.
            this.capacity = capacity;
            this.stack = new int[capacity];
            this.top = -1;
        }

        public void push(int num) {
            // Write your code here.
            if(isFull() == 1){
                // Stack is full, do nothing
                return;
            }
            stack[++top] = num;
        }
        public int pop() {
            // Write your code here.
            if (isEmpty() == 1) {
                return -1;
            }
            return stack[top--];
        }
        public int top() {
            // Write your code here.
            if(isEmpty() == 1){
               return -1;
            }
            return stack[top];
        }
        public int isEmpty() {
            // Write your code here.
            return top == -1 ? 1 : 0;

        }
        public int isFull() {
            // Write your code here.
            return top == capacity - 1 ? 1 : 0;
        }
    }
}
