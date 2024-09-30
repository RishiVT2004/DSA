Problem statement

You are given a singly linked list that may or may not contain a cycle. You are supposed to return the node
where the cycle begins, if a cycle exists, else return 'NULL'.

A cycle occurs when a node's next pointer returns to a previous node in the list.

public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        if(head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ // loop exists
                slow = head;
                while(slow != fast){ // checks where slow and fast intesect , aka start of loop
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
