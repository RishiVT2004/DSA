Design a data structure, which represents two stacks using only one array common for both stacks. The data structure should support the following operations:

push1(NUM) - Push ‘NUM’ into stack1.
push2(NUM) - Push ‘NUM’ into stack2.
pop1() - Pop out a top element from stack1 and return popped element, in case of underflow return -1.
pop2() - Pop out a top element from stack2 and return popped element, in case of underflow return -1.
There are 2 types of queries in the input

Type 1 - These queries correspond to Push operation.
Type 2 - These queries correspond to Pop operation.
Note:

1. You are given the size of the array.

2. You need to perform push and pop operations in such a way that we are able to push elements in the stack until there is some empty space available in the array.

3. While performing Push operations, do nothing in the situation of the overflow of the stack.

  import java.util.* ;
import java.io.*; 
import java.util.Stack;
public class TwoStack {
	int[] arr;
	int top1;
	int top2;
	int size;
	// Initialize TwoStack.
	public TwoStack(int s) {
		// Write your code here
		this.size = s;
		arr = new int[s];
		top1 = -1;
		top2 = s;
	}

	// Push in stack 1.
	public void push1(int num) {
		// Write your code here
		if(top1 < top2 - 1){
			top1++;
			arr[top1] = num;
		}
	}

	// Push in stack 2.
	public void push2(int num) {
		// Write your code here
		 if (top1 < top2 - 1) {
            top2--; 
            arr[top2] = num; 
        }
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
		// Write your code here
		if(top1 >= 0){
			int popped = arr[top1];
			top1--;
			return popped;
		}
		return -1;
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		// Write your code here
		if(top2 < size){
			int popped = arr[top2];
			top2++;
			return popped;
		}
		return -1;
	}

}
