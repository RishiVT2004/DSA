// case -> O(N) and w/o using '/' operator;
class Solution {
    public int[] productExceptSelf(int[] nums) {
      /*
      // Brute force method -: Using O(n2)
      
      int[] ans = new int[nums.length];
      int n = nums.length;

      for(int i = 0;i<nums.length;i++){
        int count = 1;
        for(int j = 0 ; j<nums.length; j++){
            if(i == j){
                continue; // pass or ignore this case 
            }
            count *= nums[j]; 
        }
        ans[i] = count;
      }
      return ans;

      // issue time limit excedding 

    //  2.Using Division opeartor 

      int n = nums.length;
      int [] ans = new int[n];
      int count = 1;

      for(int i = 0; i<n;i++){
        count *= i;
      }

      for(int i = 0; i<n;i++){
        ans[i] = count / nums[i];
      }
      return ans;

      // O(n)
      // issue , when nums[i] == 0 ; div by 0 is impossible 

      */

        //3. Optimal Soln -: Using prefix and suffix arrays 
     
        /*
            eg arr = [1,2,3,4,5]
             make 2 arr prefix and suffix of same length , prefix iterates from 0->n-1 while suffix iterates from n-1 -> 0;
        while iterating through both arrays we will update the values of array by finding product of all element before the current value of i (in prefix array) , and after the current value if i(in suffix arr)

        arr = [1,2,3,4,5]
        pre = [1,1,2,6,24]
        suf = [120,60,20,5,1]

     resulting array res[n] will be the product of pre[n] * suf[n];

     hence solved ;   
*/
    int n = nums.length;
    int []res = new int[n];
    int []pre = new int[n];
    int []suf = new int[n];

    pre[0] = 1;
    suf[n-1] = 1;

    //pre
    for(int i = 1 ; i<n ;i++){
        pre[i] = pre[i-1] * nums[i-1];
    }

    //post 
    for(int i = n-2 ; i>=0 ; i--){
        suf[i] = suf[i+1]*nums[i+1];
    }

    for(int i = 0; i<n; i++){
        res[i] = pre[i]*suf[i];
    }
    return res;

    // O(n) time and O(n) space
  }
}
