import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. initail approach
        /*
        HashSet<Character> H = new HashSet<Character>();
        for(int i = 0;i < s.length(); i++){
            H.add(s.charAt(i));
        }

        if(s.length() != t.length()){
            return false;
        }

        for(int j = 0;j<t.length() ;j++){
            if(!H.contains(t.charAt(j))){
                return false;
            }
        }
        
        return true;
        Problem -> in case with repetition of charecters it doent work , eg : s = aacc , t = cacc
        * missed the quantity of char parts 
        //SOLN -: 
        
       // 2. Using Built in method

         if(s.length() != t.length()){
            return false;
        }

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Arrays.sort(S);
        Arrays.sort(T);

        if(!Arrays.equals(S,T)){
            return false;
        }
        return true; 

        Time -> O(nlogn) // sort
        Space -> O(s+t)

        // Using char count array method
     if(s.length() != t.length()) return false;

       int[] CharCount = new int[26]; // make a char array of size 26 (26 char in alphabet);

       for(int i = 0;i<s.length();i++){
         
            CharCount[s.charAt(i) - 'a']++;
            CharCount[t.charAt(i) - 'a']--; // decreses the index count 
       }
         // if b is the char , 'b' - 'a' = 1 -> index 1 of array      charcount -> ++ -> value of index increrses with no of times charAt(i) is there 

       //  if index count of all indexes = 0 => s,t are anagrams 

        for(int value : CharCount){
            if(value != 0){
                return false;
            }
        }
        return true;
        Space => O(n)
        Time => O(n)
        */

      

    }
}
