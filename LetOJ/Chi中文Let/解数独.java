
/*
 * 
link: 


2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 回溯解法

// 和 N 皇后一样，是一道回溯解法裸题。

// 上一题「36. 有效的数独（中等）」是让我们判断给定的 borad 是否为有效数独。

// 这题让我们对给定 board 求数独，由于 board 固定是 9*9 的大小，我们可以使用回溯算法去做。

// 这一类题和 N 皇后一样，属于经典的回溯算法裸题。

// 这类题都有一个明显的特征，就是数据范围不会很大，如该题限制了范围为 9*9，而 N 皇后的 N 一般不会超过 13。

// 对每一个需要填入数字的位置进行填入，如果发现填入某个数会导致数独解不下去，则进行回溯。

// 代码：

// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/he-n-huang-hou-yi-yang-shi-yi-dao-hui-su-lfpd/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }
    boolean dfs(char[][] board, int x, int y) {
        if (y == 9) return dfs(board, x + 1, 0);
        if (x == 9) return true;
        if (board[x][y] != '.') return dfs(board, x, y + 1);
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char)(i + '1');
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) {
                    break;
                } else {
                    board[x][y] = '.';
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                }
            }
        }
        return board[x][y] != '.';
    }
}

// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/he-n-huang-hou-yi-yang-shi-yi-dao-hui-su-lfpd/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





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














