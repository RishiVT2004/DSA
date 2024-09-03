//Application of Lower Bound

public class Solution {
    public static int searchInsert(int [] arr, int x){
        // Write your code here.
               // we basically need to find the lower bound for the target 
        // lowest mid for which arr[mid] >= index

        int n = arr.length;
        int low = 0;
        int high = n-1;
        int res = n;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] >= x){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}
