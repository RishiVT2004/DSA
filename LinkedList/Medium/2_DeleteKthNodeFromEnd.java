/*
Problem statement

You have been given a singly Linked List of 'N' nodes with integer data and an integer 'K'.
Your task is to remove the 'K'th node from the end of the given Linked List and return the head of the modified linked list.
Example:
Input : 1 -> 2 -> 3 -> 4 -> 'NULL'  and  'K' = 2
Output: 1 -> 2 -> 4 -> 'NULL'
Explanation:
After removing the second node from the end, the linked list become 1 -> 2 -> 4 -> 'NULL'.

*/

//Better Solution
public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        if(head == null || head.next == null) return null;

        Node temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }

        int res = count-K;
        // edge case , if K = N and we need to delete head
        if(K==count){
            return head.next;
        }

        temp = head;
        for(int i = 1;i<count-K;i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
       
    }
}

/*
we need to reach count - K th node(node before the deleted node)
 and rearrange next 2 nodes

 Time -> O(N) [worst case O(N) + O(N-k) => O(2N)]
*/

//Approach using Hare and Turtle Algorithm

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        if(head == null || head.next == null) return null;
        Node fast = head;
        Node slow = head;

        for(int i = 0;i<K;i++){ // O(K)
            fast = fast.next; // increase fast untill it reaches kth node 
        }
        
        if(fast == null) return head.next;

        while(fast.next != null){ // O(n-K)
            fast = fast.next;
            slow = slow.next;
        }

        Node nodeToBeDeleted = slow.next;
        slow.next = slow.next.next;

        return head;
    }
}

Time = O(k) + O(n-k) = O(n) [worst case];
Space = O(1)

  if (fast == null) return head.next; -:
  This condition checks if the fast pointer has reached null after moving K steps forward
  If fast is null, you return head.next. This effectively removes the head node from the 
  list by making the new head of the list the node that follows the original head.
