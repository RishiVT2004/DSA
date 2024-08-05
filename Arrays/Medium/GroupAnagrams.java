// amazon , meta question

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     
        // I was able to deduce that this is a hashmap based question , but could not figure out how to proceed next

            // hashmap with string (sorted ver of strings present in string array),list of string(when sorted -> gives same string as the key string )

        Map <String , List<String>> M = new HashMap<String , List<String>>();
        if(strs.length == 0){
            return new ArrayList<>();
        }

        for(String S : strs){
            char [] ch = S.toCharArray(); //** iterate over strings in array of string , eg : eat 
            Arrays.sort(ch); // ch = ['e' , 'a' ,'t']
            String keyString = String.valueOf(ch); // *** convert ch to key string values 

            if(!(M.containsKey(keyString))){
                M.put(keyString,new ArrayList<>());
            }

            M.get(keyString).add(S); // if map has key string , get its val and insert the curr value of string(of string array) 
//in it
        }

        return new ArrayList<>(M.values());
    }

    // n : avg size of strings in string array
    // m : length of string array
    // Time -> O(m*nlogn)
    // Space -> O(n);

