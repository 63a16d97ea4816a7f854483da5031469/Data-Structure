
/*
 * 
https://leetcode.com/problems/word-search/

79. Word Search
Medium

2955

150

Add to List

Share
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

29 March 2020 at 8:33:31 pm
 * 
 */


class Solution {

	String savedWord = "";

	//6.52pm - 7.30pm
	public boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;

		savedWord = word;

		int n = word.length();

		//x,y current x and y
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				if (dfs(board, x, y, 0)) return true;
			}
		}

		return false;
	}

	boolean dfs(char[][] board, int x, int y, int offset) {

		int r = board.length;
		int c = board[0].length;

		if (x < 0 || x >= r || y < 0 || y >= c) {
			return false;
		}

		if (savedWord.charAt(offset) != board[x][y]) {
			return false;
		}

		if (offset == savedWord.length() - 1) {
			return true;
		}

		char curr = board[x][y];
		//使该字符不可用
		board[x][y] = 0;

		boolean is_found = (dfs(board, x - 1, y, offset + 1) || dfs(board, x + 1, y, offset + 1) || dfs(board, x, y - 1, offset + 1) || dfs(board, x, y + 1, offset + 1));
		//恢复该字符为可用
		board[x][y] = curr;

		return is_found;
	}

}





下面的情况，已经使用过的字母会被再次重复使用：


class Solution {
      
    String savedWord="";
     
    //6.52pm - 7.30pm
    public boolean exist(char[][] board, String word) {
        
        // Arrays.fill(v,0);
        int r=board.length;
        int c=board[0].length;
        
        savedWord=word;
        
        int n=word.length();
         
        //x,y current x and y
        
        for(int x=0;x<r;x++){
              for(int y=0;y<c;y++){
                  if(dfs(board, x,y, 0)) return true;
              }
        }
        
         return false;
    }
    
    boolean dfs(char[][] board, int x, int y,int offset){
        
        int r=board.length;
        int c=board[0].length;
        
        if(x<0 || x>=r  || y<0 || y>=c){
            return false;
        }

        if(savedWord.charAt(offset)!=board[y][x]){
            return false;
        }
        
        if(offset==savedWord.length()-1){
            return true;
        }
  
        boolean is_found=(dfs(board,x-1,y,offset+1) || dfs(board,x+1,y,offset+1) ||dfs(board,x,y-1,offset+1) || dfs(board,x,y+1,offset+1));
      
        return is_found;
    }
    
    
}



进一步剪纸，结果是over time limitation

class Solution {
    
    int[][] v;
    int[][] d=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    List<String> list=new ArrayList<String>();
    
    boolean isContinue=true;
    String savedWord="";
    
    //6.52pm - 7.30pm
    public boolean exist(char[][] board, String word) {
        
        // Arrays.fill(v,0);
        int r=board.length;
        int c=board[0].length;
        
        int n=word.length();
        
        v=new int[r][c];
        
        savedWord=word;
   
        //x,y current x and y
        
        for(int x=0;x<r;x++){
              for(int y=0;y<c;y++){
                  v=new int[r][c];
                  dfs(board, x,y,"",0,n);
              }
        }
        
        return list.contains(word);
        
    }
    
    void dfs(char[][] board, int x, int y, String s, int k, int length){
        
                    if(!isContinue){
                            return;
                    }
        
        int r=board.length;
        int c=board[0].length;
        
        k++;
        s+=board[x][y];
        v[x][y]=1;
        
  
        
        for(int i=0;i<d.length;i++){
            int nx=x+d[i][0];
            int ny=y+d[i][1];
            
            //可以访问
            if(nx>=0 && nx<r && ny>=0 && ny<c && v[nx][ny]==0){
                
                        if(!isContinue){
                            return;
                        }
                
                //设置状态
                v[nx][ny]=1;
                
                      //剪枝，如果长度比输入的word的长度长，就可以停止了。
                    if(k==length){
                        
                    }else{
                       dfs(board,nx,ny,s,k,length);
                    }
             
                //恢复状态，因为后面还要继续选择
                v[nx][ny]=0;
                
                       if(!isContinue){
                            return;
                        }
            }
        }
        
      
        //四个方向都遍历完了，证明无路可走，将这个最长字符串存起来
        list.add(s);
        
          if(savedWord.equals(s)){
              isContinue=false;
          }
        
    }
    
    
}







class Solution {
    
    int[][] v;
    int[][] d=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    List<String> list=new ArrayList<String>();
    
    //6.52pm - 7.30pm
    public boolean exist(char[][] board, String word) {
        
        // Arrays.fill(v,0);
        int r=board.length;
        int c=board[0].length;
        
        int n=word.length();
        
        v=new int[r][c];
   
        //x,y current x and y
        
        for(int x=0;x<r;x++){
              for(int y=0;y<c;y++){
                  v=new int[r][c];
                  dfs(board, x,y,"",0,n);
              }
        }
        
        return list.contains(word);
        
    }
    
    void dfs(char[][] board, int x, int y, String s, int k, int length){
        
        int r=board.length;
        int c=board[0].length;
        
        k++;
        s+=board[x][y];
        v[x][y]=1;
        
  
        
        for(int i=0;i<d.length;i++){
            int nx=x+d[i][0];
            int ny=y+d[i][1];
            
            //可以访问
            if(nx>=0 && nx<r && ny>=0 && ny<c && v[nx][ny]==0){
                //设置状态
                v[nx][ny]=1;
                
                      //剪枝，如果长度比输入的word的长度长，就可以停止了。
                    if(k==length){
                        
                    }else{
                       dfs(board,nx,ny,s,k,length);
                    }
             
                //恢复状态，因为后面还要继续选择
                v[nx][ny]=0;
            }
        }
        
        //四个方向都遍历完了，证明无路可走，将这个最长字符串存起来
        list.add(s);
    }
    
    
}


[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCCED"

调整后，能过上面case，但是不能过：

memory StackOverflow
53 / 89 test cases passed.

[["b","a","a","b","a","b"],["a","b","a","a","a","a"],["a","b","a","a","a","b"],["a","b","a","b","b","a"],["a","a","b","b","a","b"],["a","a","b","b","b","a"],["a","a","b","a","a","b"]]
"aabbbbabbaababaaaabababbaaba"




class Solution {
    
    int[][] v;
    int[][] d=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    List<String> list=new ArrayList<String>();
    
    //6.52pm - 7.30pm
    public boolean exist(char[][] board, String word) {
        
        // Arrays.fill(v,0);
        int r=board.length;
        int c=board[0].length;
        
        int n=word.length();
        
        v=new int[r][c];
   
        //x,y current x and y
        
        for(int x=0;x<r;x++){
              for(int y=0;y<c;y++){
                  v=new int[r][c];
                  dfs(board, x,y,"",0,n);
              }
        }
        
        return list.contains(word);
        
    }
    
    void dfs(char[][] board, int x, int y, String s, int k, int length){
        
        int r=board.length;
        int c=board[0].length;
        
        k++;
        s+=board[x][y];
        v[x][y]=1;
        
        //剪枝，如果长度比输入的word的长度长，就可以停止了。
        if(k==length){
            return;
        }
        
        for(int i=0;i<d.length;i++){
            int nx=x+d[i][0];
            int ny=y+d[i][1];
            
            //可以访问
            if(nx>=0 && nx<r && ny>=0 && ny<c && v[nx][ny]==0){
                //设置状态
                v[nx][ny]=1;
                dfs(board,nx,ny,s,k,length);
                //恢复状态，因为后面还要继续选择
                v[nx][ny]=0;
            }
        }
        
        //四个方向都遍历完了，证明无路可走，将这个最长字符串存起来
        list.add(s);
    }
    
    
}

[["F","Y","C","E","N","R","D"],["K","L","N","F","I","N","U"],["A","A","A","R","A","H","R"],["N","D","K","L","P","N","E"],["A","L","A","N","S","A","P"],["O","O","G","O","T","P","N"],["H","P","O","L","A","N","O"]]
"poland"

剪纸后，能过上面case，但是不能过：

[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCCED"







Memory Limit Exceeded:
[["F","Y","C","E","N","R","D"],["K","L","N","F","I","N","U"],["A","A","A","R","A","H","R"],["N","D","K","L","P","N","E"],["A","L","A","N","S","A","P"],["O","O","G","O","T","P","N"],["H","P","O","L","A","N","O"]]
"poland"


class Solution {
    
    int[][] v;
    int[][] d=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    List<String> list=new ArrayList<String>();
    
    //6.52pm - 7.30pm
    public boolean exist(char[][] board, String word) {
        
        // Arrays.fill(v,0);
        int r=board.length;
        int c=board[0].length;
        
        v=new int[r][c];
   
        //x,y current x and y
        
        for(int x=0;x<r;x++){
              for(int y=0;y<c;y++){
                  v=new int[r][c];
                  dfs(board, x,y,"");
              }
        }
        
        return list.contains(word);
        
    }
    
    void dfs(char[][] board, int x, int y, String s){
        
        int r=board.length;
        int c=board[0].length;
        
        s+=board[x][y];
        v[x][y]=1;
        
        for(int i=0;i<d.length;i++){
            int nx=x+d[i][0];
            int ny=y+d[i][1];
            
            //可以访问
            if(nx>=0 && nx<r && ny>=0 && ny<c && v[nx][ny]==0){
                //设置状态
                v[nx][ny]=1;
                dfs(board,nx,ny,s);
                //恢复状态，因为后面还要继续选择
                v[nx][ny]=0;
            }
        }
        
        //四个方向都遍历完了，证明无路可走，将这个最长字符串存起来
        list.add(s);
    }
    
    
}





















