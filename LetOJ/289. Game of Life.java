
/*
 * 
https://leetcode.com/problems/game-of-life/


289. Game of Life
Medium

1514

250

Add to List

Share
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


5 April 2020 at //2.51pm-3.18pm (27minutes) AC.
 * 
 */




class Solution {
    // 2.51pm-3.18pm (27minutes) AC.

    /*
     * Any live cell with fewer than two live neighbors dies, as if caused by
     * under-population. (<2个生存，则自己挂) Any live cell with two or three live neighbors
     * lives on to the next generation.（有=2个或者=3个活着，则可以到下一个纪元） Any live cell with
     * more than three live neighbors dies, as if by over-population..(>3个，则要挂) Any
     * dead cell with exactly three live neighbors becomes a live cell, as if by
     * reproduction.（如果已经挂了，旁边=3个活着的，就可以复活）
     */

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                getNextState(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Object tmp = map.get(i + "-" + j);
                if (tmp != null) {
                    board[i][j] = Integer.parseInt(tmp + "");
                }
            }
        }
    }

    void getNextState(int[][] board, int x, int y) {

        int[][] dot = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        int live = 0;

        for (int i = 0; i < dot.length; i++) {
            int dx = dot[i][0];
            int dy = dot[i][1];

            if (x + dx >= 0 && y + dy >= 0 && x + dx < board.length && y + dy < board[0].length
                    && board[x + dx][y + dy] == 1) {
                live++;
            }
        }

        if (board[x][y] == 1) {
            // if it is alive
            if (live < 2) {
                map.put(x + "-" + y, 0);
            } else if (live == 2 && live == 3) {
                map.put(x + "-" + y, 1);
            } else if (live > 3) {
                map.put(x + "-" + y, 0);
            }
        } else {
            // if it is dead
            if (live == 3) {
                map.put(x + "-" + y, 1);
            }
        }

    }

}



Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. 

In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
// 如果boarder更新，就重新扫描，重新做

















