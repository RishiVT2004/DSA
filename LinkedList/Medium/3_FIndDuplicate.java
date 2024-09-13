class Solution {
    public int findDuplicate(int[] nums) {

        /*
        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        There is only one repeated number in nums, return this repeated number.
        You must solve the problem without modifying the array nums and uses only constant extra space.
        */

        // Using HashSet -(O(N) time and O(N) space) -> did on my own 

        int n = nums.length;
        int ans = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0;i<n;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                ans = nums[i];
                break;
            }
        }
        return ans;

        

        // inorder to solve in O(1) space -: floyd hare and tortoise algo (makes it hard)

        /*
            nums = [1,3,4,2,2]
            let each ith bit point to nums[i] bit

            nums[i] points to nums[nums[i]]

            nums[0] -> 1 -> points to nums[1] aka 3
            nums[1] -> 3 -> points to nums[3] aka 2
            nums[2] -> 4 -> points to nums[4] aka 2
            nums[3] -> 2 -> points to nums[2] aka 4
            nums[4] -> 2 -> points to nums[2] aka 4

            no value will point to index 0 as  integers where each integer is in the range [1, n] inclusive.

            as multiple nodes point to 2 , 2 is ths start of the cycle 
        */

        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        // will intersect at a node which will be the part of a loop

        int slow2 = 0;
        int res = 0;

        // this loop will end when slow and slow2 intersect at the begenning of the loop , which will be the final answer 

        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2){
                res = slow;
                break;
            }
        }
        return res;
    }
}
