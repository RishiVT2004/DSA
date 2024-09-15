Problem statement
You are given a linked list containing 'n' nodes, where every node in the linked list contains two pointers:
(1) ‘next’ which points to the next node in the list
(2) ‘random’ which points to a random node in the list or 'null'.

Your task is to create a 'deep copy' of the given linked list and return its head.

Note:
A 'deep copy' of a linked list means we do not copy the references of the nodes of the original linked list, 
rather for each node in the original linked list, a new node is created.

  import java.util.HashMap;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node random;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.random = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.random = null;
     }
     Node(int data, Node next, Node random)
     {
         this.data = data;
         this.next = next;
         this.random = random;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node cloneLL(Node head) {
        // Write your code here.
        HashMap <Node , Node> copyMap = new HashMap<>();
        Node curr = head;
        copyMap.put(null , null); // if curr.next = null -> put null in the copy list 
       
        // 1st pass     
        while(curr!= null){
            Node copyNode = new Node(curr.data);
            copyMap.put(curr , copyNode);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copyNode = copyMap.get(curr);
            copyNode.next = copyMap.get(curr.next);
            copyNode.random = copyMap.get(curr.random);
            curr = curr.next;
        }

        // return head of copied list
        return copyMap.get(head);
    }
}

Explanation:
Initialization: A HashMap (copyMap) is used to store the mapping from the original 
nodes to their copied counterparts.

First Pass: Iterates through the original list to create copies of all nodes and 
store these copies in the map.

Second Pass: Iterates through the list again to set the next and random pointers of
the copied nodes using the map.

Return: The head of the newly cloned list is returned.
