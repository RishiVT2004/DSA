/*
 Problem statement

You are given two sorted linked lists. You have to merge them to produce a combined sorted linked list. You need to return the head of the final linked list.

Note:

The given linked lists may or may not be null.

For example:

If the first list is: 1 -> 4 -> 5 -> NULL and the second list is: 2 -> 3 -> 5 -> NULL

The final list would be: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> NULL


*/

import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        LinkedListNode<Integer> tail = dummy;

        LinkedListNode<Integer> curr1 = first;
        LinkedListNode<Integer> curr2 = second;

        while(curr1 != null && curr2!=null){

            if(curr1.data < curr2.data){
                tail.next = curr1;
                curr1 = curr1.next;
            }else{
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
        }

        if(curr1 != null){
            tail.next = curr1;
        }else if(curr2 != null){
            tail.next = curr2;
        }

        return dummy.next;
	}
}

time -> O(n + m)
space -> O(1)



Issues I ran into the code 


1. Function of dummy -: The dummy node is initialized with a placeholder value
 (in this case, 0), and its primary purpose is to simplify handling edge cases, such as 
 merging an empty list or the very first node insertion. It provides a convenient starting 
 point for the merged list.

2. why we return dummy.next 

Since dummy is just a placeholder node, the actual merged list starts at the node immediately
following dummy. Therefore, dummy.next points to the head of the merged list, which contains 
the meaningful data from the two input lists.

Returning dummy would include the placeholder node in the final result, which is not 
desirable since it was only used for simplifying the merging logic.

ex : 

first = [1, 3, 5]
second = [2, 4, 6]

dummy is initialized: dummy -> null

dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null (merged LL)

dummy.next is the actual head of the merged LL

3. tail = tail.next

tail = tail.next; was added after appending a node to the merged list. This moves the tail pointer 
forward so that it always points to the last node in the merged list.

tail.next -> points to next element 

