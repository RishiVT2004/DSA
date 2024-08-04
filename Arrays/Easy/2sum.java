class Solution {
    public int[] twoSum(int[] nums, int target) { // int[] -> returns array of integer

        /*
        // 1. Initial approach   
        for(int i = 0;i < nums.length ;i++){
            for(int j = 1;j <nums.length ;j++){
                if(nums[i] + nums[j] == target && i!=j){
                    int[]res = {i,j};
                    return res;
                }
            }
        }
        return null;

        Code run 
        Issue -> VEry high time complexity 
        Soln -> remove i!=j , by using j = i+1 in loops && use return new[] int {i,j} 

        // 2. Improved code -:
           for(int i = 0;i < nums.length ;i++){
            for(int j = i+1;j <nums.length ;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        Space -> O(n)
        Time -> O(n2)

        //Optimal Soln (HashMap)

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int complement = target - nums[i]; 
            // nums[i] + complement = target , need to return {complement,nums[i]}
            if(map.containsKey(complement)){
                return new int[]{map.get(complement) , i}; 
                // map.get(complement) ==> returns index in map
            }
            map.put(nums[i] , i); // put num[i] in ith index of map
        }
        return null;

        Time -> O(n);
        Space -> O(n);

        */
    }
}
