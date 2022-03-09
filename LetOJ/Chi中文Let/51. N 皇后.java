
/*
 * 
link: https://leetcode-cn.com/problems/n-queens/

51. N 皇后
难度
困难

1162

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 

示例 1：


输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]
 

提示：

1 <= n <= 9


2022-01-29 at 23:06
 


刚看到想到的思路是什么？：

1. 做出来 isValid()方法，主要是斜线的判断比较难一些
2. 先用数组来记录，然后注入到list中


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:

忽略了，不是只返回一个结果，而是返回所有可能。


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



错误的:

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] d=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                d[i][j]='Q';
                if(isSuitable(d,i,j)){
                    break;
                }else{
                    d[i][j]='.';
                }
            }
        }
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<n;i++){
            List<String> tmp=new ArrayList<String>();
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(String.valueOf(d[i][j]));
            }
            tmp.add(sb.toString());
            result.add(tmp);
        }
        return result;
    }

    public boolean isSuitable(char[][] d,int x, int y){
        int n=d.length;
        //横着的线,竖着的线
        for(int i=0;i<n;i++){
            if(i!=y&&d[x][i]=='Q'){
                return false;
            }
            if(x!=i&&d[i][y]=='Q'){
                return false;
            }
        }

        //斜着的线
        // (1,0), (2,1), (3,2)
        int dx=x;
        int dy=y;
        while(dx>=0&&dy>=0){
            if(dx!=x&&dy!=y&&d[dx][dy]=='Q'){
                return false;
            }
            dx--;
            dy--;
        }
        //reset dx, dy
        dx=x;
        dy=y;
        while(dx<n&&dy<n){
            if(dx!=x&&dy!=y&&d[dx][dy]=='Q'){
                return false;
            }
            dx++;
            dy++;
        }
        return true;
    }
}








class Solution {

    List<List<String>> res = new ArrayList<>();

    /* 输入棋盘的边长n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {
        // "." 表示空，"Q"表示皇后，初始化棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        // 每一行都成功放置了皇后，记录结果
        if (row == board.length) {
            res.add(charToList(board));  
            return;
        }

        int n = board[row].length;
        // 在当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            // 排除可以相互攻击的格子
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行放皇后
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /* 判断是否可以在 board[row][col] 放置皇后 */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

}

// 作者：sui-ji-guo-cheng-sui-ji-guo
// 链接：https://leetcode-cn.com/problems/n-queens/solution/n-huang-hou-java-by-sui-ji-guo-cheng-sui-q0ot/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {

    List<List<String>> res = new ArrayList<>();

    /* 输入棋盘的边长n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {
        // "." 表示空，"Q"表示皇后，初始化棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        // 每一行都成功放置了皇后，记录结果
        if (row == board.length) {
            res.add(charToList(board));  
            return;
        }

        int n = board[row].length;
        // 在当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            // 排除可以相互攻击的格子
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行放皇后
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /* 判断是否可以在 board[row][col] 放置皇后 */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        // for (char[] c : board) {
        //     list.add(String.copyValueOf(c));
        // }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<board.length;i++) {
            //reset StringBuilder
            sb=new StringBuilder();
            for(int j=0;j<board[0].length;j++){
                sb.append(String.valueOf(board[i][j]));
            }
           list.add(sb.toString());
        }
        
        return list;
    }

}









class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] c=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(c[i],'.');
        }
        //从0row开始回溯
        backtracking(c, 0);
        return result;
    }

    public void backtracking(char[][] c, int row){
        //设置结束状态
        if(row==c.length){
            List<String> tmp=new ArrayList<String>();
            for(int i=0;i<c.length;i++){
                tmp.add(String.valueOf(c[i]));
            }
            result.add(new ArrayList<String>(tmp));
            return;
        }


        for(int col=0;col<c.length;col++){
            if(!isValid(c,row,col)){
                continue;
            }
            //设置状态
            c[row][col]='Q';
            //探索下一行
            backtracking(c,row+1);
            //恢复状态
            c[row][col]='.';
        }
    }
    public boolean isValid(char[][] c, int row, int col){

        //[易错] 检查当前列是否有Q
        for(int i=0;i<c.length;i++){
            if(c[i][col]=='Q'){
                return false;
            }
        }

        //[易错] 检查左斜线
        for(int i=row-1,j=col+1;i>=0&&j<c.length;i--,j++){
            if(c[i][j]=='Q'){
                return false;
            }
        }

        //[易错] 检查右斜线
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(c[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}






