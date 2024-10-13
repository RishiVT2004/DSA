Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

  class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c); // if key value is < 0 , remove it immediately, surplus of key 
            }
        }
        return map.isEmpty();
    }
}
