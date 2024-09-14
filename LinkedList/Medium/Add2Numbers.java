/*
 Problem statement

You are given two non-negative numbers 'num1' and 'num2' represented in the
form of linked lists.

The digits in the linked lists are stored in reverse order, i.e. starting from
least significant digit (LSD) to the most significant digit (MSD),
and each of their nodes contains a single digit.

Calculate the sum of the two numbers and return the head of the sum list.
Example :

Input:
'num1' : 1 -> 2 -> 3 -> NULL
'num2' : 4 -> 5 -> 6 -> NULL
Output: 5 -> 7 -> 9 -> NULL
*/

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode tail = dummy;

        LinkedListNode curr1 = head1;
        LinkedListNode curr2 = head2;

        int carry = 0;

        while(curr1 != null || curr2 != null){
            
            int x = 0;
            int y = 0;

            if(curr1 != null){
                x = curr1.data;
                curr1 = curr1.next;
            }

             if(curr2 != null){
                y = curr2.data;
                curr2 = curr2.next;
            }

            int currSum = carry + x + y;
            carry = currSum/10;

            tail.next = new LinkedListNode(currSum % 10);
            tail = tail.next;

        }

        if(carry > 0){
            tail.next = new LinkedListNode(carry);
        }

        return dummy.next;
    }
}


Time => O(N)
Space => O(1)


some mistakes i did -:

1. using && in while loop

2. not implementing int carry = 0; before while loop

3. not implementing tail.next properly & checking for 

i got the general idea and coded the soln perfectly (about 50 % ) on my own
then chatgpt

some important understandings -: 

1. The loop (while(curr1 != null || curr2 != null)) ensures that we continue
processing as long as there's at least one node left in either list.

2. The if (curr1 != null) and if (curr2 != null) checks ensure we don't try to 
access null nodes, and if one list is shorter, we treat the missing values as 0.

3. The if (carry > 0) after the loop ensures that any leftover carry is added as 
a new node after both lists are processed.
