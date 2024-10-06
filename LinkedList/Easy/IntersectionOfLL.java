Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.
a] Approach 1 -: O(N) space , O(N) time

  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode currHead1 = headA;
        while(currHead1 != null){
            set.add(currHead1);
            currHead1 = currHead1.next;
        }

        ListNode currHead2 = headB;
        ListNode res = null;
        while(currHead2 != null){
            if(set.contains(currHead2)){
                res = currHead2;
                break;
            }
            currHead2 = currHead2.next;
        }
        return res;
    }
}                           

b] 
  i> Approach 2 -: O(1) space , O(N) time & returning node 

  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode Pointer1 = headA;
        ListNode Pointer2 = headB;

        while(Pointer1 != Pointer2){
            if(Pointer1 == null){
                Pointer1 = headB;
            }else{
                Pointer1 = Pointer1.next;
            }

            if(Pointer2 == null){
                Pointer2 = headA;
            }else{
                Pointer2 = Pointer2.next;
            }
        }
        return Pointer1;
    }
}

if(Pointer1 == null){
      Pointer1 = headB;
}
if(Pointer2 == null){
    Pointer2 = headA;
}


This line ensures that when a pointer reaches the end of its list, it switches to the head of the other list. 
This allows both pointers to traverse the same number of nodes overall, ensuring they either meet at the intersection point or reach null 
simultaneously if there is no intersection.


>ii : Returning Value (int)

public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        Node Pointer1 = firstHead;
        Node Pointer2 = secondHead;
 
        if(firstHead == null || secondHead == null) return firstHead.data;


        while(Pointer1 != Pointer2){
            if(Pointer1 == null){
                Pointer1 = secondHead;
            }else{
                Pointer1 = Pointer1.next;
            }

            if(Pointer2 == null){
                Pointer2 = firstHead;
            }else{
                Pointer2 = Pointer2.next;
            }
        }

        return Pointer1.data;
    }











