
/*
 * 
https://leetcode.com/problems/permutation-in-string/

567. Permutation in String
Medium

1050

52

Add to List

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

28 March 2020 at 2.41pm to 2.51pm
 * 
 */






class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;
        
        //count the fresh ones 
        int fresh=0;
        
        //how many minutes
        int minute=0;
        
        Queue queue=new LinkedList();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        
        while(queue.isEmpty()){
            minute++;
            
            int[] curr=queue.poll();
            
            int r=curr[0];
            int c=curr[1];
            
            //在四个方向上扩展
            if(r-1>=0){
                //在row上可以往左移动
                
                if(grid[r-1][c]==1){
                    //如果是fresh，mark这个为2
                    grid[r-1][c]=2;
                    //更新fresh的数量
                    fresh--;
                    
                    //放入队列中
                    stack
                }
                //==2 和 ==0不需要行动
            }
            
            if(r+1<row){
                //可以在row上往右边行动
                   if(grid[r+1][c]==1){
                    //如果是fresh，mark这个为2
                    grid[r+1][c]=2;
                    //更新fresh的数量
                    fresh--;
                }
            }
            
            if(c-1>=0){
                   if(grid[r][c-1]==1){
                    //如果是fresh，mark这个为2
                    grid[r][c-1]=2;
                    //更新fresh的数量
                    fresh--;
                }
            }
            
            if(c+1<col){
                    if(grid[r][c+1]==1){
                    //如果是fresh，mark这个为2
                    grid[r][c+1]=2;
                    //更新fresh的数量
                    fresh--;
                }
            }
            
            
            
        }
        
        
        return fresh>0?-1:minute-1;
    }
    
    
    
}







超过时间：

class Solution {
    
    List<String> list=new ArrayList<String>();
    
    //2.41pm to 2.51pm
    //思路，先搞出来s1的全排列，然后用在s2中寻找是否有，不过可能超时
    public boolean checkInclusion(String s1, String s2) {
        char[] sc1=s1.toCharArray();
        findPerm(sc1, 0, s1.length());
 
        for(String tmp:list){
            if(s2.contains(tmp)){
                return true;
            }
        }
        return false;
    }
    
    void findPerm(char[] arr, int from, int to){
        //找到排列
        if(from==to){
            String s="";
            for(char tmp:arr){
                s+=tmp+"";
            }
            list.add(new String(s));
        }
        for(int i=from;i<to;i++){
            
            //想不起来了，这里看了之前的如何做permutation排列的答案
         swap(arr, from, i);
         findPerm(arr,from+1, to);
            //switch back
         swap(arr, from, i);
        }
        
    }
    
    void swap(char[] arr, int i, int j){
        char tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    
}
























