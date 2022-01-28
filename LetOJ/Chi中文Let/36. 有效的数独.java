
/*
 * 
link: https://leetcode-cn.com/problems/valid-sudoku/


36. 有效的数独
难度
中等

752

收藏

分享
切换为英文
关闭提醒
反馈
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。
 

示例 1：


输入：board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
示例 2：

输入：board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 

提示：

board.length == 9
board[i].length == 9
board[i][j] 是一位数字（1-9）或者 '.'

2022-01-28 at 17:04 
 
结束时间: 2022-01-28 at 17:32 

刚看到想到的思路是什么？：

对数组的使用，以及如何定位九宫格，如何分开各个过程


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'&&!isRight(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isRight(char[][] board, int x, int y){
        if(board[x][y]=='.') return true;

        for(int i=0;i<9;i++){
            if(y!=i){
               if(board[x][i]==board[x][y]){
                   return false;
               }
            }
            if(x!=i){
                if(board[i][y]==board[x][y]){
                    return false;
                }
            }
        }
        if(!isSubBoxRight(board,x,y)){
            System.out.println("sub box false");
            return false;
        }
        return true;
    }
    public boolean isSubBoxRight(char[][] board, int x, int y){
        //locate in which box
        // (0,0) --> (2,2)   =/3=> (0,0) to (0,0)
        // (3,0) --> (5,2)   =/3=> (1,0) to (1,0)
        // (6,0) --> (8,2)   =/3=> (2,0) to (2,0)
        if(board[x][y]=='.') return true;
        HashMap<Character, String> map=new HashMap<>();
        int dx=x/3;
        int dy=y/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int fx=dx*3+i;
                int fy=dy*3+j;
                if(map.get(board[fx][fy])==null){
                    map.put(board[fx][fy],"");
                }else{
                    if(fx==x&&fy==y) continue;
                    if(board[fx][fy]=='.') continue;
                    System.out.println(x+" "+y+" "+fx+" "+fy+" "+board[fx][fy]);
                    return false;
                }
            }
        }
        return true;
    }
}




















