class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        // Inital logic 
        int sum = 0;
        int n = piles.length;
        for(int i = 0 ; i<n ; i++){
            sum += piles[i];
        }
        int k = 0;
        while(k < Integer.MAX_VALUE){
            if(k*h >= sum){
                break;
            }else{
                k++;
                continue;
            }
        }
        return k;
        */

        /*
        Missed Logic (on my part) -> Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of      bananas and eats k bananas from that pile. 

        eg : pile has 3 bananas and k = 2 banana / hr , in first hour she will eat 2 banana , and second hour she will eat the remaining 1 banana.

        we need to return the min integer k such that koko can eat all the bananas within h hours 

        max possible walur for k = max(piles[i]) , range for k = [1,2,....,max(piles[i]])
        
        time taken to eat pile[i] banana while eating k banana/hr = Math.ceil(pile[i] / k)

        total time < h

        Complexity -> O(NLogM)

        Explanation -: 
        */

       int low = 0;
       int high = Integer.MAX_VALUE;
       while(low < high){
        int mid = (low+high)/2;
        if(canEatInTime(piles,h,mid)){
            high = mid;
        }else{
            low = mid + 1;
        }
       }
       return low;
    }
    public boolean canEatInTime(int[] piles , int h , int mid){
      int time = 0;
      int res = 0;
      for(int p : piles){
        time += Math.ceil((double) p / (double) mid);
        if(time > h){
            break;
        }
      }
      return time<=h;
    }
}
