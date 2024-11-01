
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        int n = s.length();
        int min = 1;
        int max = 0;

        int i = 0;
        int j = i+1;

        while(i<n-1){
            if(s.charAt(i) != s.charAt(j)){
                min++;
                max = Math.max(max,min);
                i++;
            }else{
                min = 1;
                max = Math.max(max,min);
                i++;
            }
            j++;
        }

        return max;

        // initial approach -> understood this is based on sliding window algorithm , but was unable to implementit 
        especially with strings which have multiple repeating substrings and considered that the chaaracters must  not be adjecently repreating 
        eg : abcabcac -> abc , abc are repeating sub-strings ; hence final ans must be 3...
        */

        //2nd Trial -:

        /*
        	Set<Integer> set = new HashSet<>();

		int n = s.length();
		int curr = 0;
		int max = 0;

		for(int i = 0;i<n;i++){
			if(!(set.contains(i))){
				curr++;
				set.add(i);
				max = Math.max(curr,max);
			}
			curr = 1;
			max = Math.max(curr,max);
		}
		return max;

        /* issue -> You reset curr to 1 on every iteration of the loop, even when you add the current index i to the set. 
        This means that for the string "xxxx", curr is effectively being incremented and then immediately reset, leading to an incorrect result.
        */

        // Optimal Soln -: 2 pointers (j-i -> repr length of curr substring)
 
       class Solution {
   	 public int lengthOfLongestSubstring(String s) {
        	int n = s.length();
        	int i = 0;
        	int j = 0;
        	int maxSubstring = 0;
        	HashSet<Character> set = new HashSet<>();

        	while(j < n){
            		if(!set.contains(s.charAt(j))){
                	set.add(s.charAt(j));
                	j++;
                	maxSubstring = Math.max(max,j-i);// j-i -> track len of curr longest substring
            	}else{
                	set.remove(s.charAt(i));
                	i++;
            	}
        	}
        	return maxSubstring;
    }
}
		// space , time -> O(n)
        /*

        Intuition -:

        1. Two Pointers (i and j): i is the start of the current substring, and j is the end of the current substring.
        2. Set Usage: The Set keeps track of the characters in the current substring.
        3. Adding Characters: If s.charAt(j) is not in the Set, add it and increment j.
        4. Removing Characters: If s.charAt(j) is already in the Set, remove s.charAt(i) and increment i until the duplicate character is removed.
        5. Max Length: max is updated based on the length of the current substring (i.e., j - i).

        why are we removing s.charAt(i) and not j at else condition ?? 
        
        Key Concepts:

    **Sliding Window Approach: The two pointers, i and j, represent the start and end of the current substring. The window slides through the string,  
    expanding and contracting as needed to maintain a substring with unique characters.

    ** Why Remove s.charAt(i)?
        1. When a duplicate character s.charAt(j) is found, it means that the substring starting at i up to j contains a repeated character.
        2. To fix this, we need to move the start of the substring (i) forward to remove the duplicate character from our current window. 
        This is done by removing s.charAt(i) from the set and incrementing i.
        3. We increment i until the duplicate character is no longer in the current window, allowing us to include s.charAt(j) without 
        violating the unique character rule.

    ** Why Not Remove s.charAt(j)?
        1. Removing s.charAt(j) would mean that we keep the current window the same size but lose information about the end of the substring. 
        This approach would miss the opportunity to expand the window and find longer substrings with unique characters.
        2.By removing s.charAt(i) instead, we are effectively shrinking the window from the left side, creating space to include the
        new character s.charAt(j) while still maintaining a valid window of unique characters.

        */
    }
}
