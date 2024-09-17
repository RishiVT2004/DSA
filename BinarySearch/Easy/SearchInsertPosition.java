class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int res = n; // if target is greater than any other no in array it goes to the last position

        while(low <= high){
            int mid = (high+low)/2;

            if(nums[mid] >= target){
                res = mid;
                high = mid-1; // helps to track lower bound if target is not present
            }else{
                low = mid+1;
            }
        }
        return res;
    }
}
