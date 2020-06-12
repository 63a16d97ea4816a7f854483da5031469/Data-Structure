
/*
 * 

https://leetcode.com/problems/valid-sudoku/

36. Valid Sudoku
Medium

1352

425

Add to List

Share
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

3 Apr. 2020 at 	//9.10pm - 10.00pm    10.45pm
 * 
 */







class Solution {
	//9.10pm - 10.00pm

	public boolean isValidSudoku(char[][] board) {
		int n = board.length;

		boolean[][] cubeNum = new boolean[10][10];

		for (int i = 0; i<board.length; i++) {

			boolean[] rowNum = new boolean[10];
			boolean[] colNum = new boolean[10];

			for (int j = 0; j<board[0].length; j++) {

				if (board[i][j] != '.') {
					int tmp = board[i][j] - '0';
					if (colNum[tmp]) {
						return false;
					}
					colNum[tmp] = true;
				}

				if (board[j][i] != '.') {
					int tmp = board[j][i] - '0';
					if (rowNum[tmp]) {
						return false;
					}
					rowNum[tmp] = true;
				}

				int bx = i / 3;
				int by = j / 3;
				int box_key = by * 3 + bx;

				// check cube(小九宫格)
				if (board[i][j] != '.') {
					int tmp = board[i][j] - '0';
					if (cubeNum[box_key][tmp]) {
						return false;
					}
					cubeNum[box_key][tmp] = true;
				}
			}
		}

		return true;
	}

}


class Solution {
	//9.10pm - 10.00pm

	public boolean isValidSudoku(char[][] board) {
		int n = board.length;

		HashSet[] cube = new HashSet[10];
        
        for(int i=0;i<10;i++){
                cube[i]=new HashSet<Character>();
        }
    

		for (int i = 0; i<board.length; i++) {

        HashSet<Character> row=new HashSet<Character>();
        HashSet<Character> col=new HashSet<Character>();

			for (int j = 0; j<board[0].length; j++) {

				if (board[j][i] != '.' && !row.add(board[j][i])) {
	                 return false;
				}

				if (board[i][j] != '.' && !col.add(board[i][j])) {
				     return false;
				}

				int bx = i / 3;
				int by = j / 3;
				int box_key = by * 3 + bx;

				// check cube(小九宫格)
				if (board[i][j] != '.') {
					if (!cube[box_key].add(board[i][j])) {
						return false;
					}
				}
			}
		}

		return true;
	}

}




class Solution {
	//9.10pm - 10.12pm

	public boolean isValidSudoku(char[][] board) {
		int n = board.length;

		for (int i = 0; i<board.length; i++) {

			boolean[] rowNum = new boolean[10];
			boolean[] colNum = new boolean[10];
			boolean[] cubeNum = new boolean[10];

			for (int j = 0; j<board[0].length; j++) {

				if (board[i][j] != '.') {
					int tmp = board[i][j] - '0';
					if (colNum[tmp]) {
						return false;
					}
					colNum[tmp] = true;
				}

				if (board[j][i] != '.') {
					int tmp = board[j][i] - '0';
					if (rowNum[tmp]) {
						return false;
					}
					rowNum[tmp] = true;
				}

				// check cube(小九宫格)
				int rdx = i / 3 * 3;
				int cdx = j / 3 * 3;

				for (int k = rdx; k<rdx + 3; k++) {
					for (int f = cdx; f<cdx + 3; f++) {
						if (board[k][f] != '.') {
							int tmp = board[k][f] - '0';
							if (cubeNum[tmp]) {
								return false;
							}
							cubeNum[tmp] = true;
						}
					}
				}
				cubeNum = new boolean[10];

			}
		}

		return true;
	}

}












