Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] 
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for 
which this is possible, keep answer[i] == 0 instead.
  
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]


1. initial (wrong) approach 
  class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = temp.length;

        for(int i = 0;i<n-1;i++){
            int count = i+1;
            while(count < n){
                if(temp[count] > temp[i]){
                    stack.push(count - i);
                    break;
                }else{
                    count++;
                }
            }
            stack.push(0);
        }
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int s = stack.pop();
            ans[n-1 - i] = s;
        }
        return ans;
    }
}

2. initial approach ii (write but uses O(N2) complexity)
	
public int[] dailyTemperatures(int[] temp) {
	int []arr = new int[temp.length];
        for(int i = 0;i<temp.length-1;i++){
            int count = 1;
            for(int j = i+1;j<temp.length;j++){
                if(temp[j]>temp[i]){
                    arr[i] = count;
                    break;
                }else{
                    count++;
                }
            }
        }
        return arr;
}


3. Correct Approach (O(N) time , O(N) space)

  class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int l = temp.length;
        Stack<Integer> stack = new Stack<>();
        int []arr = new int[l];
        for(int i = 0;i<l;i++){
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                int arr_index = stack.pop(); // remove index of temp , for whom we have found a warmer day
                int arr_value = i - arr_index; // value of resultant array
                // arr_value => index of day when we find warm temp(i) - index of curr day(stack.peek() / arr_index)
                arr[arr_index] = arr_value; // value of resultant array stored in respective index 
            }
            stack.push(i); // push index of curr temp 
        }
        // for all unfilled indexes java automatically fills 0 
        return arr;
    }
}


Explanation:
Stack: We use the stack to store indices of days where we haven't found a warmer temperature yet.
  
Main loop: For each day i, we check if today's temperature is higher than the temperature of the day at the index stored at the top of the stack.
If it is, we pop the stack and calculate how many days it took for a warmer temperature.
  
Default answer array: Any day that doesn't have a future warmer day keeps its value as 0.
(Since Java initializes arrays with 0 by default, all values in ans start as 0)
