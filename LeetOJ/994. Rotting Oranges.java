
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

28 March 2020 at 7.20pm
 * 
 */



class Solution {
    public int orangesRotting(int[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList();
        int fresh =0;
        int minute =0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }                
            }
        }
        
        if(queue.size()==0 && fresh==0){
            //有一个特例是 只有一个 0，空盒子，没有感染的
            return 0;
        }
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        //如果使用方向向量
        
        
        while(!queue.isEmpty()){
            //需要对当前所有的腐烂的橙子移动,因为他们可能分布在各个不同位置的格子
            int n=queue.size(); 
            minute++;
            
            for(int i=0;i<n;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                //four direction move
                for(int k=0;k<dir.length;k++)
                {
                    int[] d=dir[k];
                    
                    int nearbyr=r+d[0];
                    int nearbyc=c+d[1];
                    
                    
                    if(nearbyr>=0 && nearbyr<row && nearbyc>=0 && nearbyc<col){
                        
                        if(grid[nearbyr][nearbyc]==1){
                            grid[nearbyr][nearbyc]=2;
                            fresh--;
                            queue.add(new int[]{nearbyr,nearbyc});
                        }
                    }
                    
                }
                
                
            }
        }
        return fresh>0?-1:minute-1;
    }
}




class Solution {
    public int orangesRotting(int[][] grid) {
        
         
        int row=grid.length;
        int col=grid[0].length;
        
        Queue<int[]> queue=new LinkedList();
        
        int fresh =0;
        int minute =0;
        
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                
                if(grid[i][j]==1){
                    fresh++;
                }                
            }
        }
        
        if(queue.size()==0 && fresh==0){
            //有一个特例是 只有一个 0，空盒子，没有感染的
            return 0;
        }
        
        
        while(!queue.isEmpty()){
        
            //需要对当前所有的腐烂的橙子移动,因为他们可能分布在各个不同位置的格子
            int n=queue.size(); 
            minute++;
            
            for(int i=0;i<n;i++){

                int[] curr=queue.poll();

                int r=curr[0];
                int c=curr[1];

                //four direction move

                if(r-1>=0){
                    int move=grid[r-1][c];

                    if(move==1){
                        grid[r-1][c]=2;
                        queue.add(new int[]{r-1,c});
                        fresh--;
                    }
                }

                if(r+1<row){
                    int move=grid[r+1][c];
                    if(move==1){
                        grid[r+1][c]=2;
                        queue.add(new int[]{r+1,c});
                        fresh--;
                    }
                }

                if(c-1>=0){
                    int move=grid[r][c-1];
                    if(move==1){
                        grid[r][c-1]=2;
                        queue.add(new int[]{r,c-1});
                        fresh--;
                    }
                }

                if(c+1<col){
                    int move=grid[r][c+1];
                    if(move==1){
                        grid[r][c+1]=2;
                        queue.add(new int[]{r,c+1});
                        fresh--;
                    }
                }
                
            }
             
        }
        return fresh>0?-1:minute-1;
    }
}















