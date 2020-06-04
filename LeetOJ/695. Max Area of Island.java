
/*
 * 
https://leetcode.com/problems/max-area-of-island/

695. Max Area of Island
Medium


Add to List

Share
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

4 June 2020 at 11:48 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






class Solution {
    //11.34pm-11.47pm  AC
    //BFS
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid.length==0&&grid[0].length==0) return 0;
        
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]==1){
                    //only 1 need to take care 
                    findMax(grid,i,j, used, 0);
                }
                
            }
        }
        return max;
    }
    
    public void findMax(int[][] grid, int x, int y, boolean[][] used, int count){
        
        Queue<int[]> que=new LinkedList<int[]>();
        que.add(new int[]{x,y});
        
        while(!que.isEmpty()){
            int[] curr=que.poll();
            
            int dx=curr[0];
            int dy=curr[1];
            
            if(used[dx][dy]) continue;
            
            used[dx][dy]=true;
            count++;
            if(count>max){
                max=count;
            }
            
            //(-1,0)
            if(dx-1>=0 && grid[dx-1][dy]==1){
                que.add(new int[]{dx-1,dy});
            }
            //(1,0)
            if(dx+1<grid.length&&grid[dx+1][dy]==1){
                que.add(new int[]{dx+1,dy});
            }
            //(0,-1)
            if(dy-1>=0&&grid[dx][dy-1]==1){
                que.add(new int[]{dx,dy-1});
            }
            //(0,1)
            if(dy+1<grid[0].length&&grid[dx][dy+1]==1){
                que.add(new int[]{dx,dy+1});
            }
        }
        
    }
}

















