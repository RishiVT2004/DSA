class Solution {
    public int longestConsecutive(int[] nums) {

/*    
    // Initial Approach (by myself)

        int count = 1;
        int n = nums.length;
        int min = 0;
    if(n==0){
        return 0;
    }

    if(n==0){
        return 0;
    }

    Arrays.sort(nums);
    for(int i = 0 ; i<n-1 ; i++){
        if(nums[i] == nums[i+1] - 1){
            count++;
        }else{
            continue;
        }
    }
    return count;

    time -> O(nlogn)
    space -> O(n)
    all inital testcases passed 

    problems 
    1. Using built in methods (Arrays.sort())
    2. Unable to solve test case like [9,1,4,7,3,-1,0,5,8,-1,6] , where once sorted 
    nums = [-1,-1,0,1,3,4,5,6,7,8,9]
    where count = 3 at nums[3] , but unable to reset count = 1 at nums[4]
    3. time is O(nlogn) , while it is req to be O(n)
    */

     int count = 0;
      int n = nums.length ;
      Set<Integer> set = new HashSet<>();

      if(n==0) return 0;

      for(int i = 0 ; i<n ; i++){
        set.add(nums[i]);
      }

    // we can determine a number x is the start of a sequence if x+1 exise and x-1 dosent 
    
      for(int i : set){
        if(!set.contains(i-1)){
            int curr_count = 1;
            while(set.contains(i+1)){
                i+=1;
                curr_count += 1;
            }
            count = Math.max(count , curr_count);
        }
      }
        return count;

        // if a number x is in set and there is also x-1 then it cant be start of a sequence 
        // if !set.contains(x-1) => set current count = 1; => while set contains i+1 keep inc i and curr_count
        // return max(count , curr_count)

        // time -: O(n) , space -: O(n)
    }
}
