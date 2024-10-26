Problem statement
You are given two arrays 'A' and 'B' of size 'N' and 'M' respectively. Both these arrays are sorted in non-decreasing order. You have to find the intersection of these two arrays.

Intersection of two arrays is an array that consists of all the common elements occurring in both arrays.

Note :
1. The length of each array is greater than zero.
2. Both the arrays are sorted in non-decreasing order.
3. The output should be in the order of elements that occur in the original arrays.
4. If there is no intersection present then return an empty array.


import java.util.* ;
import java.io.*; 
import java.util.Arrays;
import java.util.Collections;
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		// Write Your Code Here.
		ArrayList<Integer> intersection = new ArrayList<>();
		int i = 0, j = 0; // Initialize two pointers

        while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j)) {
                i++; // Move pointer in arr1 forward
            } else if (arr1.get(i) > arr2.get(j)) {
                j++; // Move pointer in arr2 forward
            } else {
                // Common element found
                intersection.add(arr1.get(i));
                i++;
                j++;
            }
        }
		return intersection;
	}
}
