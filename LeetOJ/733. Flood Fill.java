
/*
 * 
https://leetcode.com/problems/flood-fill/
733. Flood Fill
Easy

816

158

Add to List

Share
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].



20 March 2020 at 8:33:31 pm
 * 
 */


 class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if (image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int srColor= image[sr][sc];
        dfs(image, sr,sc, srColor,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int srColor,int newColor){
        if (sr<0 || sr >= image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=srColor)
            return;
        if (image[sr][sc]==srColor)
            image[sr][sc]=newColor;
        dfs(image,sr-1,sc,srColor,newColor);
        dfs(image,sr+1,sc,srColor,newColor);
        dfs(image,sr,sc+1,srColor,newColor);
        dfs(image,sr,sc-1,srColor,newColor);
    }
}



class Solution {
    //11.22am- 11.49am
    //思路 BFS
    int sameColor=0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        sameColor=image[sr][sc];
        bfs(image, sr, sc, newColor);
        return image;
    }
    void bfs(int[][] image, int sr, int sc, int newColor){
        Queue que=new LinkedList();
        que.add(new int[]{sr,sc});
        while(!que.isEmpty()){
            int[] point=(int[])que.poll();
            int x=point[0];
            int y=point[1];
            // set the ori point to new Color;
             image[sr][sc]=newColor;
            if(x-1>=0 &&image[x-1][y]==sameColor &&image[x-1][y]!=newColor){
                image[x-1][y]=newColor;
                que.add(new int[]{x-1,y});
            }
            if(x+1<image.length && image[x+1][y]==sameColor&&image[x+1][y]!=newColor){
                image[x+1][y]=newColor;
                que.add(new int[]{x+1,y});
            }
            if(y-1>=0 && image[x][y-1]==sameColor&&image[x][y-1]!=newColor){
                image[x][y-1]=newColor;
                que.add(new int[]{x,y-1});
            }
            if(y+1<image[0].length && image[x][y+1]==sameColor &&image[x][y+1]!=newColor){
                image[x][y+1]=newColor;
                que.add(new int[]{x,y+1});
            }
        }
    }
}



// 刚开始以为是大于0，0不算，因为没注意到题目说，一定是same color的才继续传播，说明读题很关键。


class Solution {
    //11.22am- 
    //思路 BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        bfs(image, sr, sc, newColor);
        return image;
    }
    
    
    void bfs(int[][] image, int sr, int sc, int newColor){
        
        Queue que=new LinkedList();
        que.add(new int[]{sr,sc});
        
        // set the ori point to new Color;
        image[sr][sc]=newColor;
        
        while(!que.isEmpty()){
            
            int[] point=(int[])que.poll();
            
            int x=point[0];
            int y=point[1];
            
            if(x-1>=0 &&image[x-1][y]>0 &&image[x-1][y]!=newColor){
                image[x-1][y]=newColor;
                que.add(new int[]{x-1,y});
            }
            
            if(x+1<image.length && image[x+1][y]>0&&image[x+1][y]!=newColor){
                image[x+1][y]=newColor;
                que.add(new int[]{x+1,y});
            }
            
            if(y-1>=0 && image[x][y-1]>0&&image[x][y-1]!=newColor){
                image[x][y-1]=newColor;
                que.add(new int[]{x,y-1});
            }
            
            if(y+1<image[0].length && image[x][y+1]>0 &&image[x][y+1]!=newColor){
                image[x][y+1]=newColor;
                que.add(new int[]{x,y+1});
            }
        }
        
    }
    
}




// 少写了边界等号，导致输入进去，输出的是只有一个中心点被染色。

class Solution {
    //11.22am- 
    //思路 BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        bfs(image, sr, sc, newColor);
        return image;
    }
    
    
    void bfs(int[][] image, int sr, int sc, int newColor){
        
        Queue que=new LinkedList();
        que.add(new int[]{sr,sc});
        
        // set the ori point to new Color;
        image[sr][sc]=newColor;
        
        while(!que.isEmpty()){
            
            int[] point=(int[])que.poll();
            
            int x=point[0];
            int y=point[1];
            
            if(x-1>0 &&image[x-1][y]>0 &&image[x-1][y]!=newColor){
                image[x-1][y]=newColor;
                que.add(new int[]{x-1,y});
            }
            
            if(x+1<image.length && image[x+1][y]>0&&image[x+1][y]!=newColor){
                image[x+1][y]=newColor;
                que.add(new int[]{x+1,y});
            }
            
            if(y-1>0 && image[x][y-1]>0&&image[x][y-1]!=newColor){
                image[x][y-1]=newColor;
                que.add(new int[]{x,y-1});
            }
            
            if(y+1<image[0].length && image[x][y+1]>0 &&image[x][y+1]!=newColor){
                image[x][y+1]=newColor;
                que.add(new int[]{x,y+1});
            }
        }
        
    }
    
}





// 最开始少写了 &&image[x-1][y]!=newColor，所以访问过的节点又被加到que中，导致超时，无限循环。


class Solution {
    //11.22am- 
    //思路 BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        bfs(image, sr, sc, newColor);
        return image;
    }
    
    
    void bfs(int[][] image, int sr, int sc, int newColor){
        
        Queue que=new LinkedList();
        que.add(new int[]{sr,sc});
        
        // set the ori point to new Color;
        image[sr][sc]=newColor;
        
        while(!que.isEmpty()){
            
            int[] point=(int[])que.poll();
            
            int x=point[0];
            int y=point[1];
            
            if(x-1>0 &&image[x-1][y]>0 ){
                image[x-1][y]=newColor;
                que.add(new int[]{x-1,y});
            }
            
            if(x+1<image.length && image[x+1][y]>0){
                image[x+1][y]=newColor;
                que.add(new int[]{x+1,y});
            }
            
            if(y-1>0 && image[x][y-1]>0){
                image[x][y-1]=newColor;
                que.add(new int[]{x,y-1});
            }
            
            if(y+1<image[0].length && image[x][y+1]>0){
                image[x][y+1]=newColor;
                que.add(new int[]{x,y+1});
            }
        }
        
    }
    
}










