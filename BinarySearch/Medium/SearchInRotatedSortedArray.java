import java.util.ArrayList;
public class Solution {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        
        // O(n) soln [Linear Search]
        
        for(int i = 0 ; i<n ; i++){
            if(arr.get(i) == k){
                return i;
            }
        }
        return -1;
        

        

        // my solution(did not passed al test cases)

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr.get(mid) == k){
                return mid;
            }
            if(arr.get(mid) > k){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return -1;

      
        // final soln O(logn)
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr.get(mid) == k){
                return mid;
            }
            // check if you are in left sorted array or right
            // left portion
            if(arr.get(low) <= arr.get(mid)){
                // if target is not in range of left sorted array
                if(k > arr.get(mid) || k < arr.get(low)){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }// right portion
            else{
                // if target is not in range of left sorted array
                if(k < arr.get(mid) || k > arr.get(high)){
                    high = mid - 1;
                }else{
                    low = mid +1;
                }
            }
        }
        return -1;
    }
}
