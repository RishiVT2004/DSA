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

 *****************************************************************/


public class Solution
{
    public static int searchInLinkedList(Node head, int k)
    {
        // Write Your Code Here.
        
        Node CurrentHead = head;
        while(CurrentHead != null){
            if(CurrentHead.data == k){
               return 1;
            }
            CurrentHead = CurrentHead.next;
        }
        return 0;
    }
}
