import java.util.* ;
import java.awt.HeadlessException;
import java.io.*; 

/************************************************************

 Following is the linkedList class structure:

 class Node<T> {
 T data;
 Node<T> next;

 public Node(T data) {
 this.data = data;
 }
 }

 ************************************************************/

public class Solution {

    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.
        
        Node newNode = new Node(val); // node to be inserted
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node temp = head;
        int count = 0;

        // run loop untill temp reaches position -> pos -1;      
        while(temp != null && count < pos-1){
            temp = temp.next;
            count++;
        }

        // now that temp is at position : pos -1 th node 

        if(temp != null){ // if at position pos - 1 , temp is not null 
            newNode.next = temp.next; // point newNode.next to temp.next (towards required position)
            temp.next = newNode;
        }
        return head;
    }
}


// why we use pos-1

/*
If you want to insert at pos = 3:

    Using count < pos - 1:
        The loop will stop when count == 2 (i.e., pos - 1).
        At this point, temp is at the node with index 2, and you can insert the new node at position 3 by adjusting the next pointers.

    Using count <= pos - 1:
        The loop will stop when count == 3, meaning temp will now point to the node at position 3 instead of 2.
        In this case, you’ve gone one node too far, and you won't be able to properly insert the new node at position 3.
*/
