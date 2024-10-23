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

2. Correct Approach 

  class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = temp.length;
        int[] ans = new int[n];


        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}


Explanation:
Stack: We use the stack to store indices of days where we haven't found a warmer temperature yet.
  
Main loop: For each day i, we check if today's temperature is higher than the temperature of the day at the index stored at the top of the stack.
If it is, we pop the stack and calculate how many days it took for a warmer temperature.
  
Default answer array: Any day that doesn't have a future warmer day keeps its value as 0.
(Since Java initializes arrays with 0 by default, all values in ans start as 0)


  temp = [70,72,74,70,80]
** res  = [1,1,2,1,0] ** 
stack= [4]

for(i = 0;i<n;i++){
	while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
		int index = stack.pop(); 
    // index -> for index 'index' we have found a temp which is greater that temp[index]
		// index = 0 , 1 , 3 , 2
		// i = 1 , 2 , 4 , 4
		int nextHighDay = i - index;
		res[index] = nextHighDay;
	}
	stack.push(i);
}
