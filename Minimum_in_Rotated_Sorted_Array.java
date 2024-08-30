/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
*/public class Solution {
    public static int findMin(int []arr) {
       
     // O(N) solution 
        int n = arr.length;
        int min = arr[0];

        for(int i = 0; i<n ; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        return min;
    
  

    //O(logN) solution 

    int n = arr.length;
    int left = 0;
    int right = n-1; 
   
    int min = Integer.MAX_VALUE;

    while(left <= right){
        if(arr[left] < arr[right]){
            min = Math.min(min,arr[left]);
        }
        int mid = (left+right)/2;
        min = Math.min(min , arr[mid]);

        if(arr[mid] >= arr[left]){
            left = mid + 1;
        }else{
            right = mid -1;
        }
    }
    return min;
    }
}

/*
Main Loop (while(left <= right)):

The loop continues as long as the left pointer is less than or equal to the right pointer. This ensures the search space is not exhausted.

    Check if Subarray is Sorted (if (arr[left] < arr[right])):

        Condition: If the element at the left pointer is less than the element at the right pointer, this means the subarray between left and right is already sorted.
        Action: If the subarray is sorted, the smallest element in this subarray must be arr[left]. Therefore, update min to arr[left] and break out of the loop because we've found the minimum element.

    Calculate Midpoint (int mid = left + (right - left) / 2):

        Purpose: This calculates the midpoint of the current search range. The expression (right - left) / 2 finds the distance to the midpoint, and adding left gives the actual index of the midpoint.

    Update Minimum (min = Math.min(min, arr[mid])):

        Action: Compare the current minimum value (min) with the element at the mid index. Update min to be the smaller of the two.

    Determine Which Half to Search Next:

        Condition: if (arr[mid] >= arr[left])
            If the element at mid is greater than or equal to the element at left, this means the left half of the array (from left to mid) is sorted.
            Action: Since the minimum element cannot be in the sorted part, move the left pointer to mid + 1 to search in the right half.
    
        Else Condition (else):
            If the element at mid is less than the element at left, this means the right half of the array (from mid to right) is unsorted, and the minimum element must be in this half.
            Action: Move the right pointer to mid - 1 to search in the left half.
*/

/*
Logic Summary:

    Binary Search: The code uses a modified binary search to efficiently locate the minimum element 
    in a rotated sorted array.

    Sorted Subarray Check: By checking if the subarray is sorted, the code can immediately 
    identify the minimum element without further searching.

    Divide and Conquer: By adjusting left and right pointers based on whether the left or right 
    half is sorted, the code narrows down the search space, making the search faster.
*/
