// soln 1 -: 3 pointers 
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>(); // initializing hashset of type List<Integers>
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]); // initializing temp with ArrayList of i,j.k
                        temp.sort(null); //sorts the list using the natural order of its elements. The null argument here indicates that no custom Comparator is provided,  
                        set.add(temp);
                    }
                }
            }    
        }
        List<List<Integer>> res = new ArrayList<>(set); // moves value of set -> convert it to a List<List<int>> and returns it 
        return res;
    }
}
*/
 //issue -> Time = O(n3*log(m)) -> [m-> no. of unoque triplets] very large , needs to be reduced 

 // Better Soln(Hashing)

 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>(); // O(n)
        int n = nums.length;
        for(int i = 0;i<n;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j = i+1 ; j<n; j++){
                int third = -(nums[i] + nums[j]);
                if(set2.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i] , nums[j] , third);
                    temp.sort(null);//O(m)
                    set.add(temp);
                }else{
                    set2.add(nums[j]);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set); // O(m)
        return res;

        /*
           1. First, we will declare a set data structure as we want unique triplets.
           2. Then we will use the first loop(say i) that will run from 0 to n-1.
           3. Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
            4. Before the second loop, we will declare another HashSet to store the array elements as we intend to search  for the third element using this HashSet.
            5. Inside the second loop, we will calculate the value of the third element i.e. -(arr[i]+arr[j]).
            6. If the third element exists in the HashSet, we will sort these 3 values i.e. arr[i], arr[j], and the third element, and insert it in the set data structure declared in step 1.
            7. After that, we will insert the j-th element i.e. arr[j] in the HashSet as we only want to insert those array elements that are in between indices i and j.
            8. Finally, we will return a list of triplets stored in the set data structure.
        */

    /*
    issue with code -:
    Time = O(n2.log(m)) -> m -> no of unique triplets 
    Space = O(n) + O(2m)
    Large time and reletively large space also 
    */
    }
}

// Optimal Solution

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       int n = nums.length;
       Arrays.sort(nums);

       for(int i = 0;i<n;i++){
        if(i!=0 && nums[i] == nums[i-1]){
            continue;
        }
        int j = i+1;
        int k = n-1;
        while(j < k){
            int sum = nums[i] + nums[j] + nums[k];
            if(sum < 0){
                j++;
            }else if(sum > 0){
                k--;
            }else{
                List<Integer> temp = Arrays.asList(nums[i] , nums[j], nums[k]); 
                res.add(temp);
                j++;
                k--;
                while(j<k && nums[j] == nums[j-1]){
                    j++;
                }
                while(j<k && nums[k] == nums[k+1]){
                    k--;
                }
            }
        }
    } 
    return res;   
    }
    /*
    time -> O(nlogn) + O(n.n) => O(nlogn) // sort + O(n2)//for + while
    space -> O(number of unique triplets ) => O(1)

    1. First, we will sort the entire array.
    2. We will use a loop(say i) that will run from 0 to n-1. This i will represent the fixed pointer.  3. In each iteration, this value will be fixed for all different values of the rest of the 2 pointers. 4. Inside the loop, we will first check if the current and the previous element is the same and if it is we will do nothing and continue to the next value of i.
   5. After that, there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.
    6. Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
    7.If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
    8. If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
    9. If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
    Finally, we will have a list of unique triplets.
    */
}
