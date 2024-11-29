class Solution {
    public int[] twoSum(int[] nums, int target) { // int[] -> returns array of integer

        /*
        // 1. Initial approach   
        `int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(nums[i] + nums[j] == target && i != j){
                    int a[] = new int[]{i,j};
                    return a;
                }
            }
        }
        return new int[]{};
       
        Space -> O(n)
        Time -> O(n2)

        //Optimal Soln (HashMap)

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                int complement = target - nums[i];
                if(map.containsKey(complement)){
                    return new int[]{i,map.get(complement)}; // serarch for complement of num[i] in map
                }
                map.put(nums[i],i);
            }
            return new int[]{};
        }
    }

        Time -> O(n);
        Space -> O(n);

        */
    }
}
