// amazon question 
// each col and row mush have unique digit from 1-9 and each subbox should also follow thw same 
// correctly predicted usage of hashset , but could not follow through 
// set.add() -> returns false if number is already present in set , has false as a return value

class Solution {
    public boolean isValidSudoku(char[][] board) {
      
      // 3 method to check element in  sudoku
            /*
                // eg : char[2][3] = 1 ; 
                seen.add(curr + "seen in row " +i); number is present in row 2
                seen.add(curr + "seen in column " +j); number is present in column 3 
                seen.add(curr + "seen in sub matrix " + i/3 + j/3); number is present in sub martix
                2/3 , 3/3 => matrix [0,1]
                see.add(char[i][j]) => add char[i][j] , else return false 
            */

    Set<String> seen = new HashSet<>();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
   }
}
