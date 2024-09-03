# Binary Search

## Using an example 

nums = [3,6,1,2,4,5];

target = 1;


        int low = 0;
        int high = nums.length-1;


        while(low <= high){
           int mid = high+low/2;

           if(nums[mid] == target) return mid;

           if(nums[mid] > target){
               high = mid-1;
           }else{
               low = mid+1;
           } 
        }

        return -1;
    }
}

## Lower and Upper Bound 

### Conditions for lower and upper bound 
1. LOWER => Arr[index] >= x
2. UPPER => Arr[index] > x

### Lower Bound 

Problem statement

1. You are given an array 'arr' sorted in non-decreasing order and a number 'x'. You must return the index of the lower bound of 'x'.
2. For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'.If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here

        // lower bound => Min value (arr[index] >= x)

        int low = 0;
        int high = n-1;
        int ans = n; // set initial value of answer to the ;argest value 

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] < x){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid -1;
            }
        }
        return ans;
    }
}

### Upper Bound 

   public static int upperBound(int []arr, int x, int n){
        // Write your code here.

        int low = 0;
        int high = n-1;
        int ans = n; // set initial value of answer to the ;argest value 

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] > x){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

### Floor and Ceil Function 
1. Floor -> largest no in array such that arr[index] <= x
2. Ceil -> smallest no in array such that arr[index] >= x  , appl of lower bound.

