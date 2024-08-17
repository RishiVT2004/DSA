class Solution {
    public int trap(int[] height) {
        
        int res = 0;
        int n = height.length;
        int leftPointer = 0;
        int rightPointer = n-1;

        int leftMaxValue = height[leftPointer];
        int rightMaxValue = height[rightPointer];

        while(leftPointer<rightPointer){

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
                leftMaxValue = Math.max(leftMaxValue,height[leftPointer]);
                res += leftMaxValue - height[leftPointer];
            }else{
                rightPointer--;
                rightMaxValue = Math.max(rightMaxValue,height[rightPointer]);
                res += rightMaxValue - height[rightPointer];
            }
        }

        return res;
    }
}

// Time -> O(n)
// Space -> O(1)
