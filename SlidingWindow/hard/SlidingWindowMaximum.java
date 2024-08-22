/*
Question -: 
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
eg : 
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
*/

// CodeStudio Solution (with ArrayList);

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{

		int n = nums.size();
		int l = 0;

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(l <= n-k){ // issue initially i took : l<n-k => but this case dosen't count the last case. 
						// so it must be l<= n-k;

			int r = k+l-1;
			int max = Integer.MIN_VALUE; // initially taken it as 0 , can be wrong in some cases 

			for(int i = l ; i<= r ; i++){ // initially i had taken range till i < r , but this excludes a case
				max = Math.max(max,nums.get(i));
			}

			list.add(max);
			l++;
		}

		return list;
	}
}

/*
time : O((n-k).k) -: k -> size of max window n-k -> range where l can go from 0
space : O(N)

*/

// Leetcode Solution (Using Arrays)

/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        int[] ans = new int[n-k+1]; // total num of max element with window size k => n-k+1 
        int l = 0;

        if(k==1){
            return nums;
        }

        while(l<=n-k){
            int r = k+l-1;
            int max = Integer.MIN_VALUE;

            for(int i = l ; i<=r ; i++){
                max = Math.max(max,nums[i]);
            }

            list.add(max);
            l++;
        }
        
        for(int i = 0 ; i<ans.length ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}

*/

/*
time -> O((n-k).k) 
space -> O(N) + O(n-k+1) creation of list and array

issue -> did not worked on large test cases 
this is beacuse 
eg : [1,2,3,4,5] k = 3
1st window - [1,2,3] => max = 3
2nd widow - [2,3,4] => max = 4

issue with the code -: in 2nd window we consider '2' even though it is clearly < thank curr max value (2).
*/

// Best Case SOLN O(N) -:

// Deque Algorithm (Monotonically Decereasing Queue) ... to be added after I have learnt queue


