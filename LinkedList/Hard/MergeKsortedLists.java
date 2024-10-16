Given 'k' sorted linked lists, each list is sorted in increasing order. You need to merge all these lists into one single sorted list. 
You need to return the head of the final linked list.

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/****************************************************
	Following is the Node class for the Singly Linked List

		class LinkedListNode<Integer> {
			int data;
			LinkedListNode<Integer> next;

			public LinkedListNode(int data) {
				this.data = data;
			}
		}

****************************************************/

public class Solution {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        // Write your code here.
		if(listArray.length == 0)return null;

		HashMap<Integer,Integer> map = new HashMap<>();

		for(int i = 0; i < listArray.length ; i++){
			LinkedListNode<Integer>currHead = listArray[i];
			while(currHead != null){
				map.put(currHead.data , map.getOrDefault(currHead.data , 0) + 1);
                currHead = currHead.next;
			}
		}
		LinkedListNode <Integer> dummy = new LinkedListNode<>(0);
		LinkedListNode <Integer> tail = dummy;

		ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet());
		Collections.sort(sortedKeys);

		for(int key : sortedKeys){
			int count = map.get(key);
			while(count != 0){
				tail.next = new LinkedListNode(key);
				tail = tail.next;
				count--;
			}
		}
		return dummy.next;
    }
}

***************
  
Time Complexity:

1. Building the frequency map: O(N), where N is the total number of nodes.
2. Sorting the keys: O(K log K), where K is the number of distinct keys (unique values in the merged lists).
3. Constructing the result list: O(N)

total => O(nlogk)
n -> no. of nodes , k -> no of distinct keys 

** Since the total number of nodes, N, can be larger than the number of unique keys, K, the overall complexity is:

O(N+KlogK)

But since K ? N (you can't have more unique keys than the total number of elements), in the worst case, O(N log K) becomes the overall complexity.

Space -> O(K) , creating sorted key arraylist 
