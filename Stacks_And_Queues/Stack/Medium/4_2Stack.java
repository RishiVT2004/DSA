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
