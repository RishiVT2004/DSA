You are given an array ‘Arr’ of size ‘N’ consisting of positive integers.
Your task is to make a doubly linked list from the array and return the head of the linked list.
Here, the head of the doubly linked list is the first element of the array, and the tail of the doubly linked list is the last element.
Note:
A doubly linked list is one in which it is possible to access the next and the previous nodes from a node in the linked list (if they exist).

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

     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 };
 *****************************************************************/
  
public class Solution
{
    public static Node constructDLL(int []arr) {
        // Write your code here
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1;i<arr.length ; i++){
            Node nextNode = new Node(arr[i],null,curr);
            curr.next = nextNode;
            curr = nextNode;
        }
        return head;
    }
}
