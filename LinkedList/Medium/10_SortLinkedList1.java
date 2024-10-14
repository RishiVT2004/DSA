Using O(Nlogn) + O(2N) time and O(N) space 

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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int size = 1;

        if(head == null) return null;

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        for(int val : list){
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        
        ListNode res = dummy.next;

        return res;
    }
}
