Problem statement

You are given a Singly Linked List of integers. Return true if it has a cycle, else return false.

A cycle occurs when a node's next points back to a previous node in the list.

import java.util.Currency;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }
467
 *****************************************************************/

public class Solution {

    public static boolean detectCycle(Node head) {
        //Your code goes here

        if(head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
    
}

 ** O(N) time and O(1) space

    ** This Question is An Application of Floyd's Cycle Detection Algorithm(or known as Hare's Algorithm)

    issue with the code -: 

    1. i was initailly trying to traverse till the end of linkedlist and if end.next != null then
    return false, but this is wrong as in case of loop , it will enter an infinite loop ans
    next points to a previous element

    2. after learning the current code initially i wrote while(fast != null && fast.next != null) as
    while(fast != null || fast.next != null) , but this is not vaid as -:
    && ensures the loop runs only when both fast and fast.next are valid(not null), preventing errors.
