Problem statement : 
  
Given a singly linked list of 'N' nodes. The objective is to determine the middle node of a singly linked list. 
However, if the list has an even number of nodes, we return the second middle node.


   initial soln : 
  public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        Node fast = head;
        Node slow = head;

        Node currHead = head;
        int count = 0;
        while(currHead != null){
            count++;
            currHead = currHead.next;
        }

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(count%2 == 0){
            return slow.next;
        }
        
        return slow;
    }
}

issue : some unnecessary conditions (counting,etc)

  better code : 

public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        Node fast = head;
        Node slow = head;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
