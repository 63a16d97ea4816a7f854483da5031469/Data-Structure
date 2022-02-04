
/*
 * 
link: 


2022-02-04 at 20:09


剑指 Offer 09. 用两个栈实现队列
难度
简单

103

收藏

分享
切换为英文
关注
反馈
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class CQueue {
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;
   public CQueue() {
      firstStack=new Stack<Integer>();
      secondStack=new Stack<Integer>();
   }
   
   public void appendTail(int value) {
       firstStack.push(value);
   }
   
   public int deleteHead() {
           if(!secondStack.isEmpty()){
               return secondStack.pop();
           }else{
               while(!firstStack.isEmpty()){
                   secondStack.push(firstStack.pop());
               }
           }
           if(secondStack.isEmpty()) return -1;
       return secondStack.pop();
   }
}

/**
* Your CQueue object will be instantiated and called as such:
* CQueue obj = new CQueue();
* obj.appendTail(value);
* int param_2 = obj.deleteHead();
*/




class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();   
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.isEmpty()&&stack1.isEmpty()){
            return -1;
        }

        if(!stack2.isEmpty()) return stack2.pop();

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.isEmpty()) return stack2.pop();
        
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */










class Solution {
    int land=0;
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] v=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!v[i][j]){
                    dfs(grid,v,i,j);
                    land++;
                }
            }
        }
        return land;
    }

    public void dfs(char[][] grid, boolean[][] v, int x, int y){
        //边界条件检查
        if(x<0||x>=grid.length||y<0||y>=grid[0].length){
            return;
        }

        // 如果访问过，就返回
        if(v[x][y]||grid[x][y]=='0'){
            return;
        }
        // 建立标志
        v[x][y]=true;
        dfs(grid, v, x+1,y);
        dfs(grid, v, x-1,y);
        dfs(grid, v, x,y+1);
        dfs(grid, v, x,y-1);
    }
}









