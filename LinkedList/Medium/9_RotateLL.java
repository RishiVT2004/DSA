You are given a linked list having ‘n’ nodes and an integer ‘k’.

You have to rotate the linked list to the right by ‘k’ positions .
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

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
 };

 *****************************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.

        if(head == null) return head;
        Node currHead = head;
        int size = 1;
        while(currHead.next != null){
            currHead = currHead.next;
            size++;
        }
        
        k %= size;
        if(size == 1 || k == 0) return head; // no need to rotate 

        currHead.next = head; // initialting circular LL

        Node newTail = head; // tracks where new head will begin

        for(int i = 1 ;i <= size - k - 1 ; i++){
            newTail = newTail.next;
        }

        /*
            k = 2,size = 5
            k = k%size = 3
            size - k = 3
            no of rotation = size - k - 1 (2)
            [1->2->3->4->5->1] // circular LL
            head = 1 , tail = 1
            after 2 rotation tail = 3, new head will begin at tail.next = 4(newHead)
            tail.next = null -> [4->5->1->2->3->null]
        */

        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
