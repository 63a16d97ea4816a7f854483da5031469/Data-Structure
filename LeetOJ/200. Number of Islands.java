
/*
 * 
https://leetcode.com/problems/number-of-islands/


200. Number of Islands
Medium

4653

174

Add to List

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


1. 一个错误，将char与数字 1 直接相等了，结果导致永远得不到正确答案，因为char的'1'和数字1永远不等
2. 刚开始将四个方向，写成了 if...else if...的结构，这样不是走4个方向，而是选了一个方向来走
3. 刚开始，因为长期没有写BFS，结果忘记如何写了
4. 刚开始将input的 x, y,当成queue 出队的那个tx和ty，并且使用input的x和y，结果导致一直在原地x和y转圈
5. 刚开始对于如何界定土地，搞了好半天，这个题目有点像那个 黑白图像
6. 其实只有在1的时候，才应该进入到bfs那个函数中去，刚开始没有限制这个，感觉主线思维不够明晰，就开始写了。。。然后出了一堆问题
7. 把数组写成了 used[x,y] 这个要注意
8. 又一次在面试中，把  'a'=>c[i]>='z' 这个也要注意，极端错误
9. int[] tmp=(int[])queue.poll();  要强制转换，否则不行。
10. 刚开始把 boolean used[][] 数组，写成了  char used[][]数组，这个类型写错了。
11. 忘记处理极端条件    //处理极限条件
        if(grid.length==0) return 0;



对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



第一，一切动作和结果都要记录在案。
第二，训练中的假想敌——蓝军——得有针对性，越真实越好，最好还要让蓝军比红军更厉害。
第三，必须进行行动后点评。



 * 
 */

// https://leetcode.com/problems/valid-parenthesis-string/discuss/107566/Java-12-lines-solution-backtracking

// How to check valid parenthesis w/ only ( and )? Easy. Count each char from left to right. When we see (, count++; when we see ) count--; if count < 0, it is invalid () is more than (); At last, count should == 0.
// This problem added *. The easiest way is to try 3 possible ways when we see it. Return true if one of them is valid.

class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        
        return count == 0;
    }
}



class Solution {
    //10.47pm-11.24pm AC.
    public int numIslands(char[][] grid) {
        int count=0;
        //处理极限条件
        if(grid.length==0) return 0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!used[i][j]&&grid[i][j]=='1')
                if(bfs(grid,used,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean bfs(char[][] grid, boolean[][] used, int x, int y){
        //注意这种泛型一维数组写法
        Queue<int[]> queue=new LinkedList<int[]>();
        queue.add(new int[]{x,y});
        int landCount=0;
        while(!queue.isEmpty()){
            int[] tmp=queue.poll();
            int tx=tmp[0];
            int ty=tmp[1];
            if(used[tx][ty]) continue;
            //mark the land
            used[tx][ty]=true;
            if(grid[tx][ty]=='1') landCount++;
            // System.out.println(tx+","+ty+" "+grid[tx][ty]);
            //向四个方向扩展
            if(tx-1>=0&&!used[tx-1][ty]&&grid[tx-1][ty]=='1'){
                //-1,0
                queue.add(new int[]{tx-1,ty});
                landCount++;
            }
            if(ty-1>=0&&!used[tx][ty-1]&&grid[tx][ty-1]=='1'){
                //0,-1
                queue.add(new int[]{tx,ty-1});
                landCount++;
            }
            if(tx+1<grid.length&&!used[tx+1][ty]&&grid[tx+1][ty]=='1'){
                //1,0
                queue.add(new int[]{tx+1,ty});
                landCount++;
            }
            if(ty+1<grid[0].length&&!used[tx][ty+1]&&grid[tx][ty+1]=='1'){
                //0,1
                queue.add(new int[]{tx,ty+1});
                landCount++;
            }
        }
        // System.out.println(landCount+"<<< ");
        return landCount>0;
    }
}




// 独立AC：

class Solution {
    //10.47pm-11.24pm AC.
    public int numIslands(char[][] grid) {
        int count=0;
        //处理极限条件
        if(grid.length==0) return 0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!used[i][j]&&grid[i][j]=='1')
                if(bfs(grid,used,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean bfs(char[][] grid, boolean[][] used, int x, int y){
        Queue queue=new LinkedList();
        queue.add(new int[]{x,y});
        int landCount=0;
        while(!queue.isEmpty()){
            int[] tmp=(int[])queue.poll();
            int tx=tmp[0];
            int ty=tmp[1];
            if(used[tx][ty]) continue;
            //mark the land
            used[tx][ty]=true;
            if(grid[tx][ty]=='1') landCount++;
            // System.out.println(tx+","+ty+" "+grid[tx][ty]);
            //向四个方向扩展
            if(tx-1>=0&&!used[tx-1][ty]&&grid[tx-1][ty]=='1'){
                //-1,0
                queue.add(new int[]{tx-1,ty});
                landCount++;
            }
            if(ty-1>=0&&!used[tx][ty-1]&&grid[tx][ty-1]=='1'){
                //0,-1
                queue.add(new int[]{tx,ty-1});
                landCount++;
            }
            if(tx+1<grid.length&&!used[tx+1][ty]&&grid[tx+1][ty]=='1'){
                //1,0
                queue.add(new int[]{tx+1,ty});
                landCount++;
            }
            if(ty+1<grid[0].length&&!used[tx][ty+1]&&grid[tx][ty+1]=='1'){
                //0,1
                queue.add(new int[]{tx,ty+1});
                landCount++;
            }
        }
        // System.out.println(landCount+"<<< ");
        return landCount>0;
    }
}





// WA:

// [["0","1","0"],["1","0","1"],["0","1","0"]]

// 0,0 0
// 1,0 1
// 0,1 1
// 4<<< 
// 0,2 0
// 1,2 1
// 2<<< 
// 1,1 0
// 2,1 1
// 2<<< 
// 2,0 0
// 0<<< 
// 2,2 0
// 0<<< 

// 没有限制条件， 应当限制，只有从1开始
for(int i=0;i<grid.length;i++){
    for(int j=0;j<grid[0].length;j++){
        if(!used[i][j])
        if(bfs(grid,used,i,j)){
            count++;
        }
    }
}


class Solution {
    //10.47pm-
    public int numIslands(char[][] grid) {
        int count=0;
        //处理极限条件
        if(grid.length==0) return 0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!used[i][j])
                if(bfs(grid,used,i,j)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    boolean bfs(char[][] grid, boolean[][] used, int x, int y){
        
        Queue queue=new LinkedList();
        
        queue.add(new int[]{x,y});
        
        int landCount=0;
        
        while(!queue.isEmpty()){
            
            int[] tmp=(int[])queue.poll();
            int tx=tmp[0];
            int ty=tmp[1];
            
            if(used[tx][ty]) continue;
            
            //mark the land
            used[tx][ty]=true;
            
            if(grid[tx][ty]=='1') landCount++;
            
            System.out.println(tx+","+ty+" "+grid[tx][ty]);
            
            //向四个方向扩展
            if(tx-1>=0&&!used[tx-1][ty]&&grid[tx-1][ty]=='1'){
                //-1,0
                queue.add(new int[]{tx-1,ty});
                landCount++;
                
            }
            if(ty-1>=0&&!used[tx][ty-1]&&grid[tx][ty-1]=='1'){
                //0,-1
                queue.add(new int[]{tx,ty-1});
                landCount++;
            }
            if(tx+1<grid.length&&!used[tx+1][ty]&&grid[tx+1][ty]=='1'){
                //1,0
                queue.add(new int[]{tx+1,ty});
                landCount++;
            }
            if(ty+1<grid[0].length&&!used[tx][ty+1]&&grid[tx][ty+1]=='1'){
                //0,1
                queue.add(new int[]{tx,ty+1});
                landCount++;
            }
        }
        System.out.println(landCount+"<<< ");
        return landCount>0;
    }
    
    
}


 WA:


class Solution {
    //9.15pm-
    public boolean checkValidString(String s) {
        if(s.length()==0) return true;
        
        Stack<Character> bracketStack=new Stack<Character>();
        
        Stack<Character> starStack=new Stack<Character>();
        
        for(char tmp:s.toCharArray()){
            
            if(tmp=='*'){
                starStack.push(tmp);
            }else if(tmp=='('){
                bracketStack.push(tmp);
            }else if(tmp==')'){
                if(!bracketStack.isEmpty()&&bracketStack.peek()=='('){
                    bracketStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        

        
        while(!bracketStack.isEmpty()){
            if(bracketStack.peek()=='('){
                if(!starStack.isEmpty()){
                    starStack.pop();
                    bracketStack.pop();
                }else{
                    return false;
                }
            }
        }
        
       
        
        return bracketStack.isEmpty();
        
    }
}












// WA:

// 翻了一个错误，将char与数字 1 直接相等了，结果导致永远得不到正确答案，因为char的'1'和数字1永远不等



class Solution {
    //10.47pm-
    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!used[i][j])
                if(bfs(grid,used,i,j)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    boolean bfs(char[][] grid, boolean[][] used, int x, int y){
        
        Queue queue=new LinkedList();
        
        queue.add(new int[]{x,y});
        
        int landCount=0;
        
        while(!queue.isEmpty()){
            
            int[] tmp=(int[])queue.poll();
            int tx=tmp[0];
            int ty=tmp[1];
            
            if(used[tx][ty]) continue;
            
            //mark the land
            used[tx][ty]=true;
            
            System.out.println(tx+","+ty+" "+grid[tx][ty]);
            
            //向四个方向扩展
            if(tx-1>=0&&!used[tx-1][ty]&&grid[tx-1][ty]==1){
                //-1,0
                queue.add(new int[]{tx-1,ty});
                landCount++;
                
            }
            if(ty-1>=0&&!used[tx][ty-1]&&grid[tx][ty-1]==1){
                //0,-1
                queue.add(new int[]{tx,ty-1});
                landCount++;
            }
            if(tx+1<grid.length&&!used[tx+1][ty]&&grid[tx+1][ty]==1){
                //1,0
                queue.add(new int[]{tx+1,ty});
                landCount++;
            }
            if(ty+1<grid[0].length&&!used[tx][ty+1]&&grid[tx][ty+1]==1){
                //0,1
                queue.add(new int[]{tx,ty+1});
                landCount++;
            }
        }
        System.out.println(landCount+"<<< ");
        return landCount>0;
    }
    
    
}








