// neetcode 150 q1 

class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        int i = 0;
        while(i < nums.length - 1){
            for(int j = i+1 ; j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
            i++;
        }
        return false;

        my initial soln -> problem -> O(n2) time , O(1) space , not good for large array sets 

        ---------

        Optimal Soln (HashSets)

        HashSet <Integer> H = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(H.contains(nums[i])){
                return true;
            }
            H.add(nums[i]);
        }
        return false;

        Time -  O(n) , space - O(n)[hashset creation]

        * Alt method -> sort the array , duplicates comes to the initial elements of array , then use 2 pointer -> Time O(nlogn) , Space O(1)  
        */
       
    }
}
