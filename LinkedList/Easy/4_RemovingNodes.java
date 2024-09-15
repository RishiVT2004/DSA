/*

You are given a Singly Linked List of integers and an integer 'K'. 
Your task is to remove all such nodes from the linked list whose value is equal to 'K'.

A singly linked list is a linear data structure in which we can traverse only in one direction i.e., from Head to Tail.
It consists of several nodes where each node contains some data and a reference to the next node.
*/

import java.util.* ;
import java.io.*; 
/****************************************************************
    Following is the Linked List node structure

    class Node {
    public:
        int data;
        Node *next;
        Node(int data) {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/

public class Solution {
    public static Node removeNodes(Node head, int k) {
        // Write your code here.
        while(head != null && head.data == k){
            head = head.next;
        }

        Node currHead = head;

        while(currHead!= null && currHead.next != null){
            if(currHead.next.data == k){
                currHead.next = currHead.next.next;
            }else{
                currHead = currHead.next;
            }
        }
        return head;
    }
}
