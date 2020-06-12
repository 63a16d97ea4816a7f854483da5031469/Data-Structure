
/*
 * 
https://leetcode.com/problems/sudoku-solver/

37. Sudoku Solver
Hard

1451

83

Add to List

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.


30 March 2020 at //11.36pm-11.51pm （看题解写的）
 * 
 */



class Solution {
	//11.36pm-11.51pm （看题解写的）
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) return;

		dfs(board);
	}

	boolean dfs(char[][] board) {

		int n = board.length;

		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num<= '9'; num++) {
						if (isValid(board, i, j, num)) {
							board[i][j] = num;
							if (dfs(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					//如果9个数都试完了都不行，说明真不行
					return false;
				}

			}
		}
		return true;
	}

	boolean isValid(char[][] board, int x, int y, char num) {
		int n = board.length;

		for (int j = 0; j<n; j++) {
			if (board[x][j] == num) return false;

		}

		for (int i = 0; i<n; i++) {
			if (board[i][y] == num) return false;
		}

		// check cube(小九宫格)
		int rdx = x / 3 * 3;
		int cdx = y / 3 * 3;

		for (int i = rdx; i<rdx + 3; i++) {
			for (int j = cdx; j<cdx + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}





















