/*
You have been given a singly Linked List in the form of 'L1' -> 'L2' -> 'L3' -> ... 'Ln'.
Your task is to rearrange the nodes of this list to make it in the form of 'L1' -> 'Ln' -> 'L2' -> 'Ln-1' and so on.
You are not allowed to alter the data of the nodes of the given linked list.
For example:

If the given linked list is 1 -> 2 -> 3 -> 4 -> 5 -> NULL.

Then rearrange it into 1 -> 5 -> 2 -> 4 -> 3 -> NULL. 


*/

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure
    
    class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	    }
   }

************************************************************/

public class Solution {
	public static Node rearrangeList(Node head)
	{
		// Write your code here.

		if(head == null || head.next == null){
			return head;
		}

		Node slow = head;
		Node fast = head;

		// finds middle of list
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		// second list starts from slow.next

		Node FirstPointer = head;
		Node SecondPointer = slow.next;
		slow.next = null; // cuts the list from middle
		
		Node previous = null;

		// Reverses 2nd list 
		while(SecondPointer != null){
			Node nextSecond = SecondPointer.next;
			SecondPointer.next = previous;
			previous = SecondPointer;
			SecondPointer = nextSecond; 
		}
		// previous pointer in the end would be at the last of the 2nd list , therefore its head 
		// head of first list = head;
		
		// Merging 2 lists

		SecondPointer = previous;

	
		while(SecondPointer != null){
			Node temp1 = FirstPointer.next;
			Node temp2 = SecondPointer.next;

			FirstPointer.next = SecondPointer;
			SecondPointer.next = temp1;

			FirstPointer = temp1;
			SecondPointer = temp2;
		}
		return head;
	}
}


issues -: 

1. how to split the list 
2. unable to move end pointer(in 2nd list) previously

soln -: 

1. using fast and slow pointer to determine where first list ends and 2nd begin
2. reversing the second list and then merging it 
3. cutting the list into two 
4. Head keeps track of the list 
