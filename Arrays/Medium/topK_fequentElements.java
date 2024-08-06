// asked by amazon
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        int n = nums.length

        if(n==1){
            return new int[]{nums[0]};
        }
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0;i<n;i++){  
            if(!map.containsKey(i)){
                map.put(i,1);
            } 
            int j = map.get(i)++;
            map.put(i,j);
        }
        */
        /*
         I was able to figure out what the question was about , about usage of hashmaps and i inserted the varues wrt to keys of hashmap , but i was unable to figure out how to extract the top k frequent elements from the hashmap



         Way to solve the question -> Type of Bucket Sort 

         // Brute Force technique 

         ** Using a HashTable that stores each number and its frequency , then iterate over the frequency to find k most frequent numbers
        // issue ; [1,1,2,2,3] & k = 2 in this case we need to iterate over the array multiple time to get the same ans -> ans = [1,2]
        both 1 & 2 occur for same amount of time 

        // soln -: create a bucket arraylist of size n+1 where each index of the bucket array represents the frequency of the num occuring  , iterate over the map , eg : [1,1,2,2,3] where 1 & 2 occur 2 time and 4 occurs once , hence in the freq array(size = 5) -: 
        0 -: 0
        1 -: 3
        2 -: 1,2
        3,4,5 -: 0

        we found out that 1,2 occurs twice and 3 occurs once , as k = 2, our final ans must be -> [1,2,3] 
        */

        List <Integer>[] bucket = new List[nums.length + 1]; // create a List of Arrays called buckets 
        Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        
         // populating HashMap
        for(int n :nums){
            freqMap.put(n,freqMap.getOrDefault(n,0) + 1); // insert value of n in nth index + 1, if null set default = 0 , then +1;
        }

        // iterating and populating buckets

        for(int key : freqMap.keySet()){ // returns all keys
            int freq = freqMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>(); // initalizing new arraylist in freq index 
            }
            bucket[freq].add(key);
        }
        
        int[] res = new int[k]; // resultant array 
        int count = 0; // keeps track of k

        for(int position = bucket.length - 1 ; position >= 0  && count < k ; position--){
            if(bucket[position] != null){ // if bucket index is not null 
                for(int i : bucket[position]){ // select the integers in the bucket[position]
                    res[count++] = i; // res[0] = int ; then inc count by 1 to 1 , untill count <k;then break 
                }
            }
        }
        return res;

        // alt soln using priority queue but havent studied it 

        /*
            time = O(N)
            space = O(N)
        */
    }
}
