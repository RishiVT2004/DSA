
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

import java.util.ArrayList;
import java.util.List;

// returns all valid parenthesis
// we can add close parenthesis if and only if count(close) < count(open)
/*
n => pairs of parenthesis 
if len(res) == 2*n : return
if(close < open) : add "" + ) , close ++ 
if(open < max_len) : add "" + ( , open++
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }
    public void backtrack(List<String> result,String currString,int open,int close,int max_length){
        // to check len of valid parenthesis
        if(currString.length() == 2*max_length){
            result.add(currString);
            return;
        }
        // to check if open bracket can be added 
        if(open < max_length){
            backtrack(result,currString + "(",open+1,close,max_length);
        }
        // to check if closed bracket can be added 
        if(close < open){
            backtrack(result,currString + ")",open,close+1,max_length);
        }
    }
}

/*
* How Backtracking Enables All Combinations

1. The function explores all possible placements of parentheses by making recursive calls:
2. It first adds an open parenthesis if allowed.
3. It then adds a close parenthesis if allowed.

For example:
When the first ( is added, the function recursively explores adding another ( or a ).
If at some point adding a ) results in too many close parentheses, that path is abandoned.
This "backtracking" ensures all valid combinations are explored and invalid ones are discarded.
*/
