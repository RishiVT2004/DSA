// Leetcode -> Using 2-D Arrays

public boolean searchMatrix(int[][] matrix, int target) {
       
       // brute force O(m.n) soln , not optimal
       
       /*
       int m = matrix.length;
       int n = matrix[0].length;

       for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(matrix[i][j] == target){
                return true;
            }
        }
       }
       return false;
       */

       //Optimal Solution O(log(m.n))

        /*
        imagine the matrix[][] as a 1-d matrix[] of size m.n
        then if we apply bin search in this hypothetical 1d matrix we get our ans in O(log(m.n))
        if target is at 4th index(i) in hypothetical 1D array and n = 2,  & m = 3
        index of equivalent in 2D matrix 
        i = 4 , col number = n = 2
        row => i/n => 4/2 = 2
        col => i%n => 4%3 = 1
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n - 1;

        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target) return true;

            if(matrix[row][col] > target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return false;
    }

// Code - 360 (Using 2-D ArrayList)

static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.

  /* O(M.N)
 int m = mat.size();
        int n = mat.get(0).size();

        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(mat.get(i).get(j) == target) return true;
            }
        }
       return false;
  */

  //O(log(M.N))
        int m = mat.size();
        int n = mat.get(0).size();

        int low = 0;
        int high = m*n-1;

        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/n;
            int col = mid%n;

            if(mat.get(row).get(col) == target) return true;

            if(mat.get(row).get(col) > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
       return false;
    }
