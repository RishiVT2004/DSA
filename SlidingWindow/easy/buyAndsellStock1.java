// Array Question 

class Solution {
    public int maxProfit(int[] prices) {
        // Two pointers approach (My first approach)
        /*
        int n = prices.length;
        int profit = 0;

        for(int i = 0 ; i<n-1 ; i++){
            for(int j = i+1 ; j < n ; j++){
                int diff = prices[j] - prices[i];
                profit = Math.max(profit,diff);
            }
        }   

        if(profit <= 0) return 0;

        return profit;

       
        */
        //answer -> true 
        //issue -> O(n2) time , failed in large test cases...

        // Optimal Solution -> Sliding Window Approach at O(n) time 

       class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int right = 1;

        int currProfit = 0;
        int maxProfit = 0;

        while(right < n){
            if(prices[left] < prices[right]){
                currProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit,currProfit);
            }else{
                left = right; 
                /* using leftPointer = rightPointer; allows you to "jump" leftPointer directly to rightPointer, which is essential to reset 
                the potential buying point to the latest low price when a new lower price is encountered. This approach optimally captures the potential 
                for maximum profit.*/
            }
            right++;
        }

        if(maxProfit <= 0) return 0;

        return maxProfit;
    }
}
// description 

/*
when high pointer < n :
    if prices at low pointer < high pointer:
        current Profit = high.value - low.value
        maximum Profit = max(current Profit , maximum Profit)
    else :
        make low pointer equal to high
    increase high pointer continiously ...

return maxProfit;             
*/


// ArrayList Question - Code Studio

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
      /*
       // Two pointers approach (My first approach)
       
        int n = prices.size();
        int profit = 0;
        
        for(int i = 0 ; i<n-1 ; i++){
            for(int j = i+1 ; i < n ; j++){
                int diff = prices.get(j) - prices.get(i);
                profit = Math.max(profit,diff);
            }
        }

        if(profit <=0){
            return 0;
        }

        return profit;
      */

       //answer -> true 
        //issue -> O(n2) time , failed in large test cases...

        // Optimal Solution -> Sliding Window Approach at O(n) time

      int n = prices.size();
        int low = 0;
        int high = 1;

        int currProfit = 0;
        int maxProfit = 0;


        while(high < n){
            if(prices.get(low) < prices.get(high)){
                currProfit = prices.get(high) - prices.get(low);
                maxProfit = Math.max(maxProfit, currProfit);
            }else{
                low = high;
            }
            high++;
        }

        return maxProfit;

      //O(n) space and O(1) time 
    }
}
