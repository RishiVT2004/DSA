import java.util.ArrayList;
public class Solution {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        
        // O(n) soln [Linear Search]
        
        for(int i = 0 ; i<n ; i++){
            if(arr.get(i) == k){
                return i;
            }
        }
        return -1;
        

        

        // my solution(did not passed al test cases)

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr.get(mid) == k){
                return mid;
            }
            if(arr.get(mid) > k){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return -1;

      
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; // Get the length of the array
        int low = 0; // Initialize the left boundary
        int high = n - 1; // Initialize the right boundary

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index (prevents overflow)

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half of the array is sorted
            if (nums[low] <= nums[mid]) { 
                // Left half is sorted

                // Check if the target lies within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Search in the left half
                } else {
                    low = mid + 1; // Search in the right half
                }

            } else { 
                // Right half is sorted

                // Check if the target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
            }
        }

        // Target not found, return -1
        return -1;
    }
}
1. what if both condition of (nums[low] <= nums[mid]) and (nums[mid] < nums[high]) becomes true  : 

Even if both conditions are true, we don't take action on both at the same time. 
The first condition (nums[low] <= nums[mid]) will execute first, and we determine whether to search in the left or right half.

2.
🔹 Always search in the sorted half because it ensures efficient elimination of elements and maintains O(log n) complexity.
🔹 Identifying the sorted half prevents errors caused by searching in an unsorted section.
🔹 If you don't search in the sorted half, you might end up doing a linear search (O(n)) instead of binary search (O(log n)).

