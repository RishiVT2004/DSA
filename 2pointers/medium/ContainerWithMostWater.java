// GOOGLE INTERVIEW QUESTION

class Solution {
    public int maxArea(int[] height) {
/*
// Initial Code -: intuition based(very complicated and unnecessary)
      int n = height.length;
	  HashSet<Integer> set = new HashSet<>();

	  for(int i = 0;i<n-1;i++){
		 for(int j = 1; j<n ; j++){
			int vol = Math.min(height[i] , height[j])*(j-1);
			if(set.contains(vol)){
				continue;
			}else{
				set.add(vol);
			}
		 }
	  }

	  Integer [] temp = set.toArray(new Integer[set.size()]);
	  int[] volArray = new int [temp.length];
	  for(int i = 0 ; i < volArray.length ; i++){
		  volArray[i] = temp[i];
	  }
	  int res = volArray[volArray.length - 1];
	  return res;
      */

      /*
		
	*/

    //BRUTE FORCE -> O(N2) time limit excedded 

    /*
        brute force approach O(n2)
		iterate over all possible vol of container 

	 int n = height.length; 	
	 int res = 0;
	 for(int i = 0;i<n-1;i++){
		 for(int j = i+1 ; j<n ; j++){
			 int vol = Math.min(height[i],height[j])*(j-i);
			 res = Math.max(res,vol);
		 }
	 }
	 return res;	
*/

// Optimal SOLN

// time -> O(N)
//Space -> O(1)

    int n = height.length;
		int l = 0;
		int r = n-1;
		
		int res = 0;
		while(l<r){
			int vol = Math.min(height[l],height[r])*(r-l);
			res = Math.max(res,vol);
			if(height[l] < height[r]){
				l++;
			}else{
				r--;
			}
		}

		return res;
    }
}