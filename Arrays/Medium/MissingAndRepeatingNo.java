
You are given an array of size ‘N’. The elements of the array are in the range from 1 to ‘N’.

Ideally, the array should contain elements from 1 to ‘N’. But due to some miscalculations, there is a number R in the range [1, N] 
which appears in the array twice and another number M in the range [1, N] which is missing from the array.

Your task is to find the missing number (M) and the repeating number (R).

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1); // if num not in map set default val = 0, else inc val of key num
        }

        int x = 0;
        int y = 0;

        for(int i = 1;i<=n;i++){
            if(!map.containsKey(i)){
                x = i;
            }
            else if(map.get(i) > 1){
                y = i;
            }
        }

        return new int[]{x,y};
    }
}
