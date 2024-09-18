You are given a doubly-linked list of size 'N', consisting of positive integers. Now your task is to reverse it and 
return the head of the modified list.
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        Node currNode = head;
        Node prevNode = null;

        while(currNode != null){
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;
            currNode = currNode.prev;
        }

        return prevNode.prev;
    }
}

O(N) time, O(1) space
  
Key Learnings 
1. as we are reversing prev and next links of each nodes, if we want to move to next node we have to call the prev method
  and vice versa
2. We return prevNode.prev( next node after prev Node) as when our currNode hits null and terminates traversal , the 
  PrevNode is 2 nodes behind , and the new head must be the last Node of the reversed LinkedList (aka PrevNode.prev).
