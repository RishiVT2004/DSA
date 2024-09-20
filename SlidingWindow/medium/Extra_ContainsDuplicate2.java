Given an array 'arr' of 'N' integers and an integer 'K'. The array 'arr' may contain duplicate integers. 
Return "true" if the array contains any duplicate element within the 'K' distance from each other, otherwise, return "false".

  // Sliding Window + HasshSet Approach;
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean checkDuplicate(int[] arr, int n, int k) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(set.contains(arr[i])) return true;
            set.add(arr[i]);
            if(i>=k){
                set.remove(arr[i-k]);
            }
        }
        return false;
       
    }
}

1. The set keeps track of the elements in the current sliding window of size K.
2. For each element in the array, we check if it is already in the set (i.e., if it appeared within the last K elements). 
   If yes, return true since we found a duplicate within distance K.
3. We then add the current element to the set.
4. If the window size exceeds K, we remove the element that is more than K distance away (i.e., arr[i - k]).
