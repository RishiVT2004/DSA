# Binary Search

## Using an example 

array = [3,6,1,2,4,5];
target = 1

public static int search(int []nums, int target) {
        // Write your code here.

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
