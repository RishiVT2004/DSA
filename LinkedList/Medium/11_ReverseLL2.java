Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node to simplify edge cases (e.g., when reversing starts at head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // If head is null or no reversal is needed, return the original list
        if (head == null || left == right) return head;
        
        // `trackNode` will point to the node just before the `left` position
        ListNode trackNode = dummy;

        // Move `trackNode` (left-1) times to reach the node before `left`
        for (int i = 1; i < left; i++) {
            trackNode = trackNode.next;
        }

        // `currNode` is the first node in the sublist to be reversed
        ListNode currNode = trackNode.next;
        ListNode prevNode = null;
        ListNode nextNode = null;

        // Reverse nodes from position `left` to `right`
        for (int i = left; i <= right; i++) {
            nextNode = currNode.next; // Store the next node
            currNode.next = prevNode; // Reverse the current node's pointer
            prevNode = currNode;      // Move prevNode one step ahead
            currNode = nextNode;      // Move currNode one step ahead
        }

        // Connect the reversed sublist back to the main list
        trackNode.next.next = currNode; // Connect the tail of the reversed segment to the next unreversed node
        trackNode.next = prevNode;      // Connect `trackNode` to the new head of the reversed segment

        return dummy.next; // Return the modified list, skipping the dummy node
    }
}

time -> O(N)
space -> O(1)
