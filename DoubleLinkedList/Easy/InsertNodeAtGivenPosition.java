You are given a Doubly linked list, where every node in the linked list contains two pointers ‘next’ and ‘prev’
which point to the next node and previous node in the list respectively. All nodes have some positive integer value 
associated with them. Your task is to insert an integer value ‘VAL’ in the linked list at a given position ‘K’.

Note:
The position given will always be less than or equal to the length of the linked list.
Assume that the Indexing for the linked list starts from 0.

  import java.util.* ;
import java.io.*; 

/************************************************************

 Following is the linkedList class structure:

 class Node<T> {
 T data;
 Node<T> next,prev;

 public Node(T data) {
 this.data = data;
 }
 }

 ************************************************************/

public class Solution {

    static Node insert(int k, int val, Node head) {
        // Write your code here.

        // inserting at head , newNode ;
        if(k == 0){
            Node newHead = new Node(val);
            newHead.next = head;
            if(head!=null){
                head.prev = newHead;
            }
            return newHead;
        }

        Node currNode = head;
        Node newNode = new Node(val); // creating new node 
        int counter = 0;

        // shifting currNode to k-1 th position
        while(currNode!=null && counter < k){
            if(counter == k-1) break;
            counter++;
            currNode = currNode.next;
        }

        if(currNode == null) return null;

        // adjusting values of next and prev of newNode
        newNode.next = currNode.next;
        newNode.prev = currNode;

        // adjusting values of currNode.next and currNode.next.prev to newNode 
        if(currNode.next != null){
            currNode.next.prev = newNode;
        }
        currNode.next = newNode;

        return head;
    }
}
