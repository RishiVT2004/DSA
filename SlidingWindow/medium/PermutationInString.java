
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
eg : s1 = 'ab' s2 = 'aoba' => true 
  : Input: s1 = "ab", s2 = "eidboaoo"
    Output: false

/*
          // initial solution
          
          Hashtable<Character,Integer> table1 = new Hashtable<Character,Integer>();
          for(char ch : str1){
          if(!table1.keys(ch)){
          table1.put(ch, 1);
          }
          table1.values(ch)++;
          }
          
          Hashtable<Character,Integer> table2 = new Hashtable<Character,Integer>();
          
          for(char ch : str2){
          if(!table2.keys(ch)){
          table2.put(ch, 1);
          }
          table2.values(ch)++;
          }
          
          for(char ch1 : str1 && char ch2 : str2){
          if(table2.keySet().contains(table1.key(ch1)) && table1.values(ch1) <=
          table2.values(ch2)){
          return true;
          }
          }
         
         return false;
*/

// Optimal Soln -: Sliding Window + Array tracking Frequency 

class Solution {
    public boolean checkInclusion(String str1, String str2) {
       
    
        int n = str1.length();
        int m = str2.length();

        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        if (n > m)
            return false;

        for (int i = 0; i < n; i++)
            counter1[str1.charAt(i) - 'a']++;

        for (int i = 0; i < m; i++) {
            counter2[str2.charAt(i) - 'a']++;
            if (i >= n)
                counter2[str2.charAt(i - n) - 'a']--;

            if (Arrays.equals(counter1, counter2))
            return true;

        }
        return false;

    }
}

// Time -> O(M) + O(N) => O(M);
// Space -> O(52) -> O(1)


// How the code works -:

/*
et's walk through how the algorithm works step by step with s1 = "ab" and s2 = "aoba".
Initialization:

    n = s1.length() = 2
    m = s2.length() = 4
    freq is initialized as an array of size 26 (for each letter in the alphabet) to store the frequency of characters in s1.
    freq2 is similarly initialized to store the frequency of characters in the current sliding window in s2.

Step 1: Populate freq with frequencies from s1

    For s1 = "ab":
        freq['a' - 'a']++ → freq[0]++ → freq[0] = 1 (since 'a' is at index 0 in freq)
        freq['b' - 'a']++ → freq[1]++ → freq[1] = 1 (since 'b' is at index 1 in freq)
    freq now looks like this:
    
    freq = [1, 1, 0, 0, ..., 0]  // only 'a' and 'b' have counts, others are 0
Let's walk through how the algorithm works step by step with s1 = "ab" and s2 = "aoba".
Initialization:

    n = s1.length() = 2
    m = s2.length() = 4
    freq is initialized as an array of size 26 (for each letter in the alphabet) to store the frequency of characters in s1.
    freq2 is similarly initialized to store the frequency of characters in the current sliding window in s2.

Step 1: Populate freq with frequencies from s1

    For s1 = "ab":
        freq['a' - 'a']++ → freq[0]++ → freq[0] = 1 (since 'a' is at index 0 in freq)
        freq['b' - 'a']++ → freq[1]++ → freq[1] = 1 (since 'b' is at index 1 in freq)
    freq now looks like this:

    sql

    freq = [1, 1, 0, 0, ..., 0]  // only 'a' and 'b' have counts, others are 0

Step 2: Slide through s2 using a sliding window of size n

We process each character in s2 and maintain a window of size n = 2:
i = 0, character = 'a'

    freq2['a' - 'a']++ → freq2[0]++ → freq2[0] = 1
    Since i < n, no character is removed from the window.
    freq2 after this step:

    freq2 = [1, 0, 0, 0, ..., 0]  // only 'a' has a count
    freq and freq2 are not equal.

i = 1, character = 'o'

    freq2['o' - 'a']++ → freq2[14]++ → freq2[14] = 1 (since 'o' is at index 14 in freq2)
    Since i < n, no character is removed from the window.
    freq2 after this step:
    
    freq2 = [1, 0, 0, 0, ..., 1, 0, 0]  // 'a' and 'o' have counts
    freq and freq2 are not equal.

    i = 2, character = 'b'

    freq2['b' - 'a']++ → freq2[1]++ → freq2[1] = 1
    Since i >= n, remove the character at position i - n = 0 (which is 'a'):
    req2['a' - 'a']-- → freq2[0]-- → freq2[0] = 0
        
    freq2 after this step:
    freq2 = [0, 1, 0, 0, ..., 1, 0, 0]  // 'b' and 'o' have counts
    freq and freq2 are not equal.

    i = 3, character = 'a'

    freq2['a' - 'a']++ → freq2[0]++ → freq2[0] = 1
    Since i >= n, remove the character at position i - n = 1 (which is 'o'):
    freq2['o' - 'a']-- → freq2[14]-- → freq2[14] = 0
    freq2 after this step:

    freq2 = [1, 1, 0, 0, ..., 0]  // 'a' and 'b' have counts

    Now, freq and freq2 are equal.

Conclusion:
At i = 3, the sliding window in s2 ("ba") matches the frequency of characters in s1 ("ab"). 
This means the algorithm will return true, indicating that an anagram of s1 is found in s2
*/
