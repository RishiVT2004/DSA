/*
Question

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
eg : 
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
*/

class Solution {
    public int characterReplacement(String str, int k) {

      // initial soln -:
        // AABABBA

/*

        int start = 0;
        int pointer = start+1;
        int max = 0;

        char[] S = str.toCharArray();
        int n = S.length;

        while(pointer < n){
            if(S[pointer --] == S[pointer++] && S[pointer]!=S[pointer--]
            && S[pointer] != S[pointer++]){
                k--;
                S[pointer] = S[pointer--];
                max = Math.max(max,pointer++ - start);
            }
            if(k==0) break;
            pointer++;
        }

        return max;

        issue -> improper logic 
    */
    // Optimal Solution -> O(N) time and O(1) space 
        int maxLen = 0;
        int maxFreq = 0;
        int start = 0;
        int end = 0;
        int n = str.length();

        char[] counter = new char[26];

        for(end = 0;end<n;end++){
            counter[str.charAt(end) - 'A']++;

            maxFreq = Math.max(maxFreq  ,counter[str.charAt(end) - 'A']);

            int lenOfWindow = end-start+1;

            if(lenOfWindow - maxFreq <= k){ // valid window 
                maxLen = Math.max(maxLen,lenOfWindow);
            }else{
                counter[str.charAt(start) - 'A']--;
                start++;
            }   
        }

        return maxLen;
    }
}

/*
Explanation of code

Terminologies -:

1. start,end -> represents 2 pointers , which helps to create a window 
2. char [] counter = new char[26] -> a character array of size 26 , which helps is to keep count of freq all characters in the string 
(indexes of counter represent character and value of indexes represents freq of the index character)  
3. maxFreq -> maximum frequency of the most common occuring character within the window 
4. lenOfWindow -> distance covered b/w the 2 pointers
5. maxLen -> maximum length of a valid window which includes .
6. k -> no. of allowed changes of characters 

Explanation -:
1. Initiate start,end,maxFreq,maxLen = 0 and initialize a character array counter (with size 26); char [] counter = new char[26]
2. run a loop where pointer 'end' runs from index 0 to n-1 
3. increse the counter at every index the end pointer crosses by , counter[str.charAt(end) - 'A']++; (counter = [0,0,0,....]
eg : 'ABAB' -> when end is at index 0 , counter[str.charAt(0) - 'A']++ => counter['A' - 'A']++ => counter[0]++ -> [{1},0,0,...] => maxFreq = 1
4. Calculate current max freq of the characters in the {current sliding window} => maxFreq = Math.max(maxFreq,counter[s.charAt(end) - 'A']
eg : 'ABAB' when end is at index 1 -> counter = [{1,1},0,0] & maxFreq = 1 -> maxFreq = Math.max(1,counter[str.charAt(1) - 'A']) -> max(1,1) -> 1
5. Length of curr window = end pointer - start pointer + 1 
6. Condition for valid window  -> if(Length of Current Window - max Frequency > k(allowed changes of characters) -> the window is valid else not.
7. For a valid Window -> update maxLength = Math.max(maxLength,Length of Current Window);
8. For Invalid Window -> decrese the value of counter at index str.charAt(start) - 'A' , in order to increse the pointer of start from index 0 to 
the next index -: counter[str.charAt(start) - 'A']-- -> start++;
9.return MaximumLength which is length of longest substring containing the same letter you can get after performing the above operations k times.

*/
