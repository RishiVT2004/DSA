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

    public static int maxAreaContainer(ArrayList<Integer> arr) {
		// Write your code here.
		int n = arr.size();
		int l = 0;
		int r = n-1;

		if(arr.size() == 0) return 0;
		if(arr.size() == 1) return arr.get(0);

		int MaxVolume = 0;
		while(l < r){
			int currVolume = (Math.min(arr.get(l),arr.get(r)))*(r-l);
			MaxVolume = Math.max(MaxVolume , currVolume);

			if(arr.get(l) < arr.get(r)){ //  you move the left pointer (l++) to potentially find a taller line that might trap more water with the right line (height[r]).
				l++;
			}else{
				r--; // else case 
			}
 		}

		return MaxVolume;
	}
}
