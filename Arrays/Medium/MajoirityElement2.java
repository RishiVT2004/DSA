You are given an array/list 'ARR' of integers of length ‘N’. 
You are supposed to find all the elements that occur strictly more than floor(N/3) times in the given array/list.

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int n = arr.size();
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 0) return list;
        if(n == 1){
            list.add(arr.get(0));
            return list;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        int target = n/3;

        for(int nums : map.keySet()){
            if(map.get(nums) > target){
                list.add(nums);
            }
        }

        return list;
    }
}
