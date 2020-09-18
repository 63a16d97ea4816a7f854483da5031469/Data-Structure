
/*
 * 
link: 
https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

2020-9-5 at 11:12 pm

剑指 Offer 12. 矩阵中的路径
难度
中等

167

收藏

分享
切换为英文
关注
反馈
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


//最快solution:
class Solution {
    boolean [][] visited;
      public boolean exist(char[][] board, String word) {
           if(board==null || board.length<=0 || board[0].length<=0){
               return false;
           }
           if(word==null || word.length()<=0){
               return true;
           }
           visited=new boolean[board.length][board[0].length];
           return hasPath(board, word, 0, 0, 0);
          
       }

       public boolean hasPath(char[][] board,String word,int index,int i,int j){
           if(index==word.length()){
               return true;
           }
           char c=word.charAt(index);
           //寻找第一个
           if(index==0) {
               for(int p=0;p<board.length;p++) {
                   for(int q=0;q<board[0].length;q++) {
                      if(board[p][q]==word.charAt(0) && visited[p][q]==false){
                           visited[p][q]=true;
                           if(hasPath(board,word,index+1,p,q)){
                               return true;
                           }
                           visited[p][q]=false;
                       }
                   }
               }
               return false;
           }else {
                //向上
               if(i-1>=0 && visited[i-1][j]==false && board[i-1][j]==c){
                   visited[i-1][j]=true;
                   if(hasPath(board,word,index+1,i-1,j)) {
                       return true;
                   }else {
                        visited[i-1][j]=false;
                   }
               }
   
               //向右
                if(j+1<board[0].length && visited[i][j+1]==false && board[i][j+1]==c){
                   visited[i][j+1]=true;
                   if(hasPath(board,word,index+1,i,j+1)) {
                       return true;
                   }else {
                       visited[i][j+1]=false;
                   }
                }
   
               //向下
               if(i+1<board.length && visited[i+1][j]==false && board[i+1][j]==c){
                   visited[i+1][j]=true;
                   if(hasPath(board,word,index+1,i+1,j)) {
                       return true;
                   }else {
                       visited[i+1][j]=false;
                   }
               }
               //向左
               if(j-1>=0 && visited[i][j-1]==false && board[i][j-1]==c){
                   visited[i][j-1]=true;
                   if(hasPath(board,word,index+1,i,j-1)) {
                       return true;
                   }else {
                       visited[i][j-1]=false;
                   }
               }
               
           }
           return false;
       }
 
}


// 6ms:
class Solution {
    char[][] matrix;
    String aim;
    int row;
    int column;
    int length;

    public boolean exist(char[][] board, String word) {
        matrix = board;
        aim = word;
        row = board.length;
        column = board[0].length;
        length = word.length();
        if (word == null || row*column < length) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (search(0, j, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int index, int x, int y) {
        if (x < 0 || x >= column || y < 0 || y >= row
            || matrix[y][x] != aim.charAt(index)) {
            return false;
        }
        if (index == length - 1) {
            return true;
        }
        char temp = matrix[y][x];
        matrix[y][x] = '/';
        boolean res = search(index + 1, x + 1, y)
            || search(index + 1, x - 1, y)
            || search(index + 1, x, y + 1)
            || search(index + 1, x, y - 1);
        matrix[y][x] = temp;
        return res;
    }
}





class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




import java.util.*;
class Solution {

    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word.toCharArray(),i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int x, int y, int index){
        if(x>=board.length||x<0||y>=board[0].length||y<0||word[index]!=board[x][y]) return false;
        if(index == word.length - 1) return true; //关键一句
        char tmp=board[x][y];
        board[x][y]='/';
        boolean res=dfs(board,word,x+1,y,index+1)||dfs(board,word,x-1,y,index+1)||
        dfs(board,word,x,y+1,index+1)||dfs(board,word,x,y-1,index+1);
        board[x][y]=tmp;
        return res;
    }
   
}





public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //从[i,j]这个坐标开始查找
            if (dfs(board, words, i, j, 0))
                return true;
        }
    }
    return false;
}

boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
    //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
        return false;
    //如果word的每个字符都查找完了，直接返回true
    if (index == word.length - 1)
        return true;
    //为了防止分支污染，把board数组复制一份
    char[][] newArra = copyArray(board);
    //把newArra[i][j]置为特殊符号，表示已经被使用过了(注意：word中不能包含'.')
    newArra[i][j] = '.';
    //从当前坐标的上下左右四个方向查找
    boolean res = dfs(newArra, word, i + 1, j, index + 1) || dfs(newArra, word, i - 1, j, index + 1) ||
            dfs(newArra, word, i, j + 1, index + 1) || dfs(newArra, word, i, j - 1, index + 1);
    return res;
}

//复制一份新的数组
private char[][] copyArray(char[][] word) {
    char[][] newArray = new char[word.length][word[0].length];
    for (int i = 0; i < word.length; i++) {
        for (int j = 0; j < word[0].length; j++) {
            newArray[i][j] = word[i][j];
        }
    }
    return newArray;
}

// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/hui-su-suan-fa-qiu-jie-by-sdwwld/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //从[i,j]这个坐标开始查找
            if (dfs(board, words, i, j, 0))
                return true;
        }
    }
    return false;
}

boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
    //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
        return false;
    //如果word的每个字符都查找完了，直接返回true
    if (index == word.length - 1)
        return true;
    //把当前坐标的值保存下来，为了在最后复原
    char tmp = board[i][j];
    //然后修改当前坐标的值
    board[i][j] = '.';
    //走递归，沿着当前坐标的上下左右4个方向查找
    boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
    //递归之后再把当前的坐标复原
    board[i][j] = tmp;
    return res;
}

// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/hui-su-suan-fa-qiu-jie-by-sdwwld/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。















//错误解法：
import java.util.*;
class Solution {
    String word="";
    List<Character> result;
    boolean isTrue=false;

    public boolean exist(char[][] board, String word) {
        this.word=word;
        result=new ArrayList<Character>();
        for(char tmp:word.toCharArray()){
            result.add(tmp);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.println("[mark]:"+i+" "+j);
                dfs(board,new boolean[board.length][board[0].length],i,j,new ArrayList<Character>());
            }
        }
        
        return isTrue;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j,List<Character> list){
        if(isTrue) return;
        if(i>=board.length||i<0||j>=board[0].length||j<0) return;
        if(visited[i][j]) return;
        if(list.size()>result.size()) {
            System.out.println("trigger size:"+list.size()+" "+result.size());
            return;
        }

        visited[i][j]=true;
        list.add(board[i][j]);
        if(list.get(list.size()-1)!=result.get(list.size()-1)) {
               System.out.println("丢弃==> "+i+" "+j+" "+list.get(list.size()-1)+" "+result.get(list.size()-1));
            list.remove(list.size()-1);
            visited[i][j]=false; // 容易忘记
            return;
        }
        System.out.println("judge==> "+i+" "+j+" "+list.get(list.size()-1)+" "+result.get(list.size()-1));
        for(Character tmp:list){
            System.out.print(tmp+" ");
        }
        System.out.println();
        if(list.size()==result.size()){
            isTrue=true;
            return;
        }
        System.out.println("curr: "+i+" "+j);
        dfs(board,visited,i+1,j,list);
        dfs(board,visited,i-1,j,list);
        dfs(board,visited,i,j-1,list);
        dfs(board,visited,i,j+1,list);
    }
}



//错误解法：

import java.util.*;
class Solution {
    String word="";
    List<Character> result;
    boolean isTrue=false;

    public boolean exist(char[][] board, String word) {
        this.word=word;
        result=new ArrayList<Character>();
        for(char tmp:word.toCharArray()){
            result.add(tmp);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.println("[mark]:"+i+" "+j);
                bfs(board,new boolean[board.length][board[0].length],i,j,new ArrayList<Character>());
            }
        }
        
        return isTrue;
    }

    public void bfs(char[][] board, boolean[][] visited, int i, int j, List<Character> list){
        Queue<int[]> que=new LinkedList<int[]>();
        que.add(new int[]{i,j});

        while(!que.isEmpty()&&!isTrue){
            int[] ele=que.remove();
            int x=ele[0];
            int y=ele[1];

            if(visited[x][y]) continue;
            if(list.size()==result.size()){ 
                isTrue=true;
                return;
            }
            list.add(board[x][y]);
            for(Character tmp:list){
                System.out.print(tmp+" ");
            }
            System.out.println();
            visited[x][y]=true;

            if(list.get(list.size()-1)!=result.get(list.size()-1)){
                visited[x][y]=false;
                list.remove(list.size()-1);
                continue;
            }
            
            //1,0
            if(x+1<board.length){
                que.add(new int[]{x+1,y});
            }
            if(x-1>=0){
                que.add(new int[]{x-1,y});
            }
            if(y+1<board[0].length){
                que.add(new int[]{x,y+1});
            }
            if(y-1>=0){
                que.add(new int[]{x,y-1});
            }
        }
    }
   
}


