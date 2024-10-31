class Solution {
    public boolean isPalindrome(String s) {

// 1. initial draft , solved completly by mylself , and checkef chatgpt for some java methods to convert to lower case and replace the non aplha num character by ""

        class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]" , ""); // takes O(N) space 
        
        int n = s.length();
        int left = 0;
        int right = s.length()-1;

        if(n == 0 || n == 1) return true; 

        while(left <= n/2){           
            if((s.charAt(left) == s.charAt(right))){
                left++;
                right--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}

      //space -> O(N)
      //Time -> O(N)

    //issue with the code 
    //1. usage of built in methods 
    //2. higher reletive time usage(13ms) in comparision to best case (1ms) -> can be ignored as Big O is optimal
        
     
    }
}
