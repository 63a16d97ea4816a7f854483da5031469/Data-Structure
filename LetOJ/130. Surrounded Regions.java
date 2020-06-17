
/*
 * 
https://leetcode.com/problems/surrounded-regions/


130. Surrounded Regions
Medium

1540

627

Add to List

Share
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    //10.11pm-10.47pm  (36 minutes)
    //优化: 10.50pm-11.07pm AC   (17 minutes)
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'&&isBoard(board,i,j)){
                    toMarkOnBoardO(board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               if(board[i][j]=='R'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'&&!isBoard(board,i,j)){
                   board[i][j]='X';
               }
            }
        }
   
    }
    public boolean isBoard(char[][] board,int x, int y){
        if(x==0||y==0) return true;
        if(x==board.length-1||y==board[0].length-1) return true;
        return false;
    }
    public void toMarkOnBoardO(char[][] board, int x, int y){
        Queue<int[]> que=new LinkedList<int[]>();
        boolean[][] used=new boolean[board.length][board[0].length];
        if(board[x][y]=='O'){
           que.add(new int[]{x,y}); 
           used[x][y]=true;
        }
        int[][] dix=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            int[] head=que.poll();
            for(int[] tmp:dix){
                int dx=head[0]+tmp[0];
                int dy=head[1]+tmp[1];
                if(dx<0||dy<0||dx>=board.length||dy>=board[0].length||used[dx][dy]) continue;
                if(board[dx][dy]=='O'){
                    board[dx][dy]='R';
                    que.add(new int[]{dx,dy});
                }
                used[dx][dy]=true; 
            }
        }
    }
}






// 超时:

class Solution {
    //10.11pm-10.47pm
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    flip(board,i,j);
                }
            }
        }
    }
    public void flip(char[][] board, int x, int y){
        int[][] dix=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean isConnectedO=false;
        for(int[] tmp:dix){
            int dx=x+tmp[0];
            int dy=y+tmp[1];
            if(dx<0||dy<0||dx>=board.length||dy>=board[0].length) continue;
            if(board[dx][dy]=='O'&&isBoard(board,dx,dy)){
                isConnectedO=true;
            }
        }
        if(!isConnectedO&&!isBoard(board,x,y)&&!isReachAbleToBoard(board,x,y)){
             board[x][y]='X';
        }
    }
    public boolean isBoard(char[][] board,int x, int y){
        if(x==0||y==0) return true;
        if(x==board.length-1||y==board[0].length-1) return true;
        return false;
    }
    public boolean isReachAbleToBoard(char[][] board, int x, int y){
        Queue<int[]> que=new LinkedList<int[]>();
        boolean[][] used=new boolean[board.length][board[0].length];
        if(board[x][y]=='O'){
           que.add(new int[]{x,y}); 
           used[x][y]=true;
        }
        int[][] dix=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean isConnectedO=false;
        while(!que.isEmpty()){
            int[] head=que.poll();
            for(int[] tmp:dix){
                int dx=head[0]+tmp[0];
                int dy=head[1]+tmp[1];
                if(dx<0||dy<0||dx>=board.length||dy>=board[0].length||used[dx][dy]) continue;
                if(board[dx][dy]=='O'&&isBoard(board,dx,dy)){
                    isConnectedO=true;
                    return true;
                }
                used[dx][dy]=true;
                if(board[dx][dy]=='O'){
                    que.add(new int[]{dx,dy});
                }
            }
        }
         return false;
    }
}





class Solution {
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0){
            return;
        }
        int row=board.length-1;
        int col=board[0].length-1;
        for(int i=0;i<=col;i++){
            if(board[0][i]=='O'){
                dfsUtil(board,0,i);
            }
            if(board[row][i]=='O'){
                dfsUtil(board,board.length-1,i);
            }    
        }
        for(int i=1;i<=row;i++){
            if(board[i][0]=='O'){
                dfsUtil(board,i,0);
            }
            if(board[i][col]=='O') {
                dfsUtil(board,i,col);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='v') {
                    board[i][j]='O';
                } else if(board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfsUtil(char[][] board,int i,int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
            return;
        }
            board[i][j]='v';
            dfsUtil(board,i-1,j);
            dfsUtil(board,i+1,j);
            dfsUtil(board,i,j-1);
            dfsUtil(board,i,j+1);
    }
}

