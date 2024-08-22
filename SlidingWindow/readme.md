## Types of pattern of question in Sliding Window Algorithm 

### 1. Constant Window 

### 2. Longest Subarray/Substring with or w/o conditions -:
       way to solve these -: 
       1. (brute force) : 
       -> generate all sub arrays/strings using 2 for loops and then check for the condition , 
          usually O(n2) time.
       
       2. (better approach) : to find sub arrays / sub strings
       -> start with a window size of 1 (with 2 pointers lets say l and r) , we will expand r and shrink l to keep check 
          on the size of the window. you need to check and update all other condition at all time , len of window => r-l+1
          whenever the window violates the condition , we try to shrink the window by increasing l counter and getting a window which satisfy the            condtion.
          Overall time (worst case) -> O(N + N) : 1 n is for the initial for / while loop , and the other one is for the interior while loop
          Overall space -> O(1) 

      3. (optimal solution) 
      -> O(N) soln : (to find length of sub - array)
          in better approach due to shrinking window by moving l counter using while loop , we get O(2N) , if we can optimize these we can 
          make the code as O(N) complexity .
          remove the inner while which checks for the condition and replace it with if .

### 3. Find number of sub arrays with given conditions(constant condition) -:
      To be solved by using pattern 2 
      eg : no . of sub arrays with sum = k -> hard to determine when to expand / shrink
      soln : 
      1. find no of sub arrays where sum <= k and sum <= k-1 , then substract them to find the soln;

 ### 4. Shortest Window with a given condition (pretty rare)

     take l,r -> if window is valid -> shrink l -> l+1 and check if the shrinked window is valid or not
     the smallest shrinked window is stored as the answers 

      
          
          
