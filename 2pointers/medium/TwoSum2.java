
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        // brute force approach 

        int n = nums.length;
        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(nums[i] + nums[j] == target && i!=j){
                    return new int[]{i+1,j+1};
                }
            }
        }

        return new int[]{};

        // issue -> O(n2) time , needs to be lowered 
        */

        // Optimal Soln -> Binary search ( O(logN) time and O(1) space)
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] == target){
                return new int[]{i+1 , j+1};
            }
            else if(nums[i] + nums[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
      
    }
}
