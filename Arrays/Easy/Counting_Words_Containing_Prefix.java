You are given an array of strings words and a string pref.
Return the number of strings in words that contain pref as a prefix.
A prefix of a string s is any leading contiguous substring of s.

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words){
            if(word.startsWith(pref)){ // check if word[i] starts with pref
                count++;
            }
        }
        return count;
    }
}
