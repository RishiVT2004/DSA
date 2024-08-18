// Given an integer array nums, find the subarray with the largest sum, and return its sum.

class Solution {
    public int maxSubArray(int[] arr) {

    /* 
    // Initial soln (My approach) -> invalid / logic error  
        int n = arr.length;
        int res = 0;
		int temp = 0;

        if(n==1){
            return arr[0];
        }


		for(int i = 0;i<n-1;i++){
			int j = i+1;
			temp = arr[i];
			temp += arr[j];
            j++;
			res = Math.max(res,temp);
		}
		return res;
        */

        // Brute force soln -: in O(N2) time 

       /*
        int n = arr.length;
        int res = 0;
        if(n==1){
            return arr[0];
        }
		for(int i = 0;i<n;i++){
			int sum = 0; // when i increses reset sum = 0;
			for(int j = i; j < n ; j++){
				sum += arr[j];
				res = Math.max(res,sum);
			}
		}
		return res;
        */

      //Optimal Soln -> Kadane's Algorithm O(N) time 

      // do not carry sum if sum < 0 as it will decrese the sum anyways 
		int res = 0;
		int sum = 0;
		int n = arr.length;

		for(int i = 0;i<n;i++){
			sum += arr[i];

			if(sum > res){
				res = sum;
			}
			
			if(sum < 0){
				sum = 0;
			}
		}

		// if sub array sum < 0 -> return 0; (if given in question)
		if(res < 0){
			return 0;
		}

		return res;

      /*
      //follow up question -> print any sub array with max sum 
		int res = 0;
		int sum = 0;
		int n = arr.length;

		int startOfSubarray = 0;
		int ansStart = 0;
		int ansEnd = 0

		for(int i = 0;i<n;i++){
			sum += arr[i];

			
			if(sum < 0){
				sum = 0;
				startOfSubarray = i;
			}

			if(sum > res){
				res = sum;
				ansStart = startOfSubarray;
				ansEnd = i;
			}
			
		}

		// if sub array sum < 0 -> return 0; (if given in question)
		if(res < 0){
			return 0;
		}

		// to print the max-subarray 

		for(int i = ansStart ; i<ansEnd ; i++){
			System.out.print("[" + arr[i] +"]");
		}

		return res;
      */
    }
}
