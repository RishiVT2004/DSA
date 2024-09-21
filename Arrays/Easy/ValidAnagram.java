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
    class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] CharCount = new int[26];

        for(int i = 0;i<s.length();i++){
            CharCount[s.charAt(i) - 'a']++;
            CharCount[t.charAt(i) - 'a']--;
        }

        for(int values : CharCount){
            if(values != 0) return false;
        }
        return true;
    }
}
        return true;
        Space => O(n)
        Time => O(n)
        */

      

    }
}
