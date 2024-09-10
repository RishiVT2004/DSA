/*
Problem statement

You are given a Singly Linked List of integers and a reference to the node to be deleted. Every node of the Linked List has a unique value written on it. Your task is to delete that node from the linked list.

A singly linked list is a linear data structure in which we can traverse only in one direction i.e. from Head to Tail. It consists of several nodes where each node contains some data and a reference to the next node.

Note:

• The reference to the head of the linked list is not given.
• The node to be deleted is not a tail node.
• The value of each node in the Linked List is unique.
• It is guaranteed that the node to be deleted is present in the linked list.
*/

import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
         if (node == null || node.next == null) {
            return;
        }

       node.data = node.next.data;
       node.next = node.next.next;
	}
}
