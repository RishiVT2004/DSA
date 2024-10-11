
You are given a sorted single linked list of size 'n'.
Remove all the duplicate nodes present in the linked list.

public class Solution {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        Node currHead = head;
        while(currHead != null && currHead.next != null){
            if(currHead.data == currHead.next.data){
                currHead.next = currHead.next.next;
            }else{
                currHead = currHead.next;
            }
        }
        return head;
    }
}
