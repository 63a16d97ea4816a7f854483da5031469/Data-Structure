
/*
 * 
https://leetcode.com/problems/jump-game-iii/

1306. Jump Game III
Medium

241

7

Add to List

Share
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

答题抓主干，要明确思路和方法，然后沿着合格思路，坚决实施这个算法。


 * 
 */


class Solution {
    //11.42pm-12.01pm AC  成功AC
    public boolean canReach(int[] arr, int start) {
        
        boolean[] used=new boolean[arr.length];
        
        return dfs(arr, start, used);
        
    }
    
    boolean dfs(int[] arr, int start, boolean[] used){
        
        if(arr[start]==0) return true;
        
        int moveBack=start-arr[start];
        int moveForward=start+arr[start];
        
        if(moveBack>=0 && !used[moveBack]){
             used[moveBack]=true;
             if(dfs(arr, start-arr[start], used)){
                 return true;
             }
             used[moveBack]=false;
        }
        
        if(moveForward<arr.length && !used[moveForward]){
            used[moveForward]=true;
            if(dfs(arr, start+arr[start], used)){
                return true;
            }
            used[moveForward]=false;
        }
        
        return false;
    }
        
    
}







刚开始写了这种方法，发现used数组没法避免被重复使用，所以赶紧换了:

class Solution {
    //11.42pm- 
    public boolean canReach(int[] arr, int start) {
        
        boolean[] used=new boolean[arr.length];
        
        return dfs(arr, start, used);
        
    }
    
    boolean dfs(int[] arr, int start, boolean[] used){
        
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        used[start]=true;
        
        int currIndex=start;
        
        while(!queue.isEmpty()){
            
            int head=queue.poll();
            
            if(arr[head]==0) return true;
            
            
            if(currIndex+head<arr.length&&!used[currIndex+head]){
                queue.add(currIndex+head);
                used[currIndex+head]=true;
            }
            
            if(currIndex-head>=0&&!used[currIndex-head]){
                queue.add(currIndex-head);
                 used[currIndex-head]=true;
            }
        }
        return false;
    }
}






