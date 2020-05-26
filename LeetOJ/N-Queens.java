
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

51. N-Queens
Hard

1684

68

Add to List

Share
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

26 May 2020 at 11:51 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    private void addSolution(boolean[][] mat, List<List<String>> result) {
        List<String> curr = new ArrayList<>();
        for(int i=0; i<mat.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j])
                    sb.append('Q');
                else
                    sb.append('.');
            }
            curr.add(sb.toString());
        }
        result.add(curr);
    }
    private boolean isSafe(boolean[][] mat, int row, int col) {
        for(int j=0; j<row; j++) {
            if(mat[j][col])
                return false;
        }
        int i=row-1, j = col-1;
        while(i>=0 && j>=0) {
            if(mat[i][j])
                return false;
            i--;
            j--;
        }
        i=row-1; j=col+1;
        while(i>=0 && j<mat[i].length) {
            if(mat[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
    private void dfs(boolean[][] mat, int row, int n, List<List<String>> result) {
        if(row == n) {
            addSolution(mat,result);
            return;
        }
        for(int col=0; col<n; col++) {
            if(isSafe(mat,row,col)) {
                mat[row][col] = true;
                dfs(mat,row+1,n,result);
                mat[row][col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] mat = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        dfs(mat, 0, n, result);
        return result;
    }
}



















class Solution { 
    public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(board, 0, res);
		return res;
	}
	private void dfs(char[][] board, int colIndex, List<List<String>> res) {
		if (colIndex == board.length) {
			res.add(construct(board));
			return;
		}
		// 按列进行放置，若到了第colIndex列，
		//那么第0~colIndex-1列已经是放置好的
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, colIndex)) {
				board[i][colIndex] = 'Q';
				dfs(board, colIndex + 1, res);
				board[i][colIndex] = '.';
			}
		}
	}
	// x == i 同一行
	// x + j == y + i (y -x == j - i,斜率1,在同一条直线上) 同一主斜行
	// x + y == i + j(x-i=-(y-j),斜率-1,在同一条直线上) 同一副斜行
	private boolean validate(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			// 判断放置第j列的时候，是否与前面的冲突，
			// 不需要判断y == j（循环j<y），只是与前面的进行比较
			for (int j = 0; j < y; j++) {
				// same as if(board[i][j] == 'Q' 
				//&& (Math.abs(x - i) ==
				// Math.abs(y - j) || x == i))
				if (board[i][j] == 'Q' && 
						(x - y == i - j 
						|| x + y == i + j 
						|| x == i))
					return false;
			}
		}
		return true;
	}
	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}









