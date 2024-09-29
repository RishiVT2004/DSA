# Stack

## Some key points to know about Stacks

1.Stack is a linear data structure based on <b>LIFO(Last In First Out) principle </b> in which the insertion of a new element and removal of an 
existing element takes place at the same end represented as the top of the stack.<br>

2. We can access the elements only on the top of the stack.<br>

3. <b>Types of Stack Data Structure:</b>
    a.] <b>Fixed Size Stack</b> : As the name suggests, a fixed size stack has a fixed size and cannot grow or shrink dynamically. 
    b.] <b>Dynamic Size Stack</b> : A dynamic size stack can grow or shrink dynamically. When the stack is full, it automatically increases its size to accommodate ]
        the new element, and when the stack is empty, it decreases its size . 
        This type of stack is implemented using a linked list, as it allows for easy resizing of the stack.<br>

<hr>

## Basic Operations on Stack Data Structure:

In order to make manipulations in a stack, there are certain operations provided to us.

push() to insert an element into the stack
pop() to remove an element from the stack
top() Returns the top element of the stack.
isEmpty() returns true if stack is empty else false.
isFull() returns true if the stack is full else false.

<hr>

## Stack Implementation Using Arrays/ArrayList


    public class Stack{

    private int[] stack;
    private int top;
    private int size;

    public Stack(int size){
      this.size = size;
      stack = new int[size];
      top = -1;
      System.out.println("Stack of size : "+size+" created ");
    }  
  
    boolean isEmpty(){
    return top == -1;
    }
  
    boolean isFull(){
    return top == size-1;
    }
  
    void push(int num){
    if(isFull()){
       System.out.println("Stack Overflow");
    }
    stack[++top] = num; // we increment the value of top by 1 (top = top + 1) and the new value is inserted at top position .
    }

    int pop() {
    if (isEmpty()) {
        System.out.println("Stack Underflow");
      }
      int val = stack[top--];
      return val;
    }

    int top(){
    if(!isEmpty()){
      return stack[top];
    }
    System.out.println("Empty Stack");
    return -1;
    }

    void displayStack(){
    System.out.println("Stack Display :");
    for(int i = stack.length-1;i>=0;i--){
      System.out.println(" "+stack[i]);
    }
    }
  
  
    public static void main(String[] args) {
      Stack S = new Stack(4);
      S.push(10);
      S.push(20);
      S.push(30);
      S.push(40);

    System.out.println("Popped Element : "+S.pop());
    System.out.println("Top / Peek element : "+S.top());

    S.displayStack();
    }
    }

## Stack using Linked-Lists

    /****************************************************************

     Following is the class structure of the Node class:

     static class Node
     {
         int data;
         Node next;
         Node() {
             this.data = 0;
             this.next = null;
         }
         Node(int data){
             this.data = data;
             this.next = null;
         }
         Node(int data, Node next){
         this.data = data;
         this.next = next;
         }
     };


     *****************************************************************/
    public class Solution {
        static class Stack {
         
        private Node head;
        private int size;

        Stack()
        {
             
            head = null;
            size = 0;
           
        }

        int getSize()
        {
            //Write your code here
            return size;
        }

        boolean isEmpty()
        {
             
            return head == null;
        }

        void push(int data)
        {
            
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        void pop()
        {
             
            if(!isEmpty()){
                head = head.next;
                size--;
            }
        }

        int getTop()
        {
               
            if(isEmpty()) return -1;
            return head.data;
        }
    }
    }
