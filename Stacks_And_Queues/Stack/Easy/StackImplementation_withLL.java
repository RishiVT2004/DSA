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
