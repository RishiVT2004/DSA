Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        if(head == null) return null;
        ListNode currHead = head;
        
        // calculate size;
        while(currHead != null){
            size++;
            currHead = currHead.next;
        } 

        if(size == 1 || k == 1) return head;

        // create a dummy node and tail as its reference
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode tail = dummy;

        // when size >= k
        while(size >= k){
            ListNode startLL = tail.next; // start of LL group to be reversed
            ListNode endLL = startLL; // end of LL group to be reversed

            for(int i = 1;i<k;i++){ // make endLL reach  kth position 
                endLL = endLL.next;
            }

            ListNode nextStart = endLL.next; // start of next LL group(to be reversed) is next element of curr end

            reverseLL(startLL,endLL); // reverse the LL from currStart to currEnd

            tail.next = endLL; // Connect the reversed group to the previous part of the list
            startLL.next = nextStart; // start of next LL will be will be after the start of curr reversed list;
        
            tail = startLL; // move tail to 1 node prev of the start of new group of LinkedList 

            size -= k; // reduce size by k 
        }

        return dummy.next;
        
    }
    public void reverseLL(ListNode start,ListNode end){
        ListNode prevNode = null;
        ListNode currNode = start;
        ListNode nextNode = null;

        while(prevNode != end){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
    }
}

Time = O(N) {for traversing the LL} + O(N) {reversing k groups , no of reversals => n/k} => O(N)
Space = O(1)

why we dont check for left out LL nodes

The loop only processes groups of k nodes. When fewer than k nodes remain, the loop exits, 
leaving the remaining nodes unchanged and naturally linked to the last reversed group.
