
/*
 * 
https://leetcode.com/problems/target-sum/


494. Target Sum
Medium

2140

95

Add to List

Share
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */











class Solution {
    //1.53pm-2.01pm
    //2.01pm-2.37pm
    public int findTargetSumWays(int[] nums, int S) {
        int max=1000;
        if(S>max) return 0;
        int[][] dp=new int[nums.length+1][2*max+1];
        for (int[] row : dp) 
            Arrays.fill(row, -1); 
       return dfs(nums, dp, 0, max, S+max);
    }
   int dfs(int[] nums, int[][] dp, int curr, int sum, int target){
       if(curr==nums.length) return sum==target?1:0;
       if(dp[curr][sum]>-1) return dp[curr][sum];
       return dp[curr][sum]=dfs(nums,dp,curr+1,sum+nums[curr],target)+dfs(nums,dp,curr+1,sum-nums[curr],target);
    }
}





//简化版：
public class Solution {
    //1.53pm-2.01pm
     //2.01pm-2.37pm
     int count=0;
     public int findTargetSumWays(int[] nums, int S) {
         dfs(nums,0, S, 0);
        return  count;
     }
    void dfs(int[] nums, int sum, int target, int curr){
         if(curr==nums.length) {
             if(sum==target) count++; 
             return;
         }
         dfs(nums,sum+nums[curr],target, curr+1);
         dfs(nums,sum-nums[curr],target,curr+1);
     }
 }
 
 


 
// Over time limit:
class Solution {
    //1.53pm-2.01pm
    //2.01pm-2.37pm
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
       return  count;
    }
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        if(target==sum && list.size()==nums.length) {
            count++;
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            return;
        }
        if(curr>=nums.length){
            list=new ArrayList<Integer>();
            return;
        }  
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);
        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
    }
}




class Solution {
    //1.53pm-2.01pm
    //2.01pm- 
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
        
        
//         for(List<Integer> tmp:result)
//         {
//             for(int t:tmp){
//                 System.out.print(t+" ");
//             }
//             System.out.println();
//         }
        
       return  count;
    }
    
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        
        if(target==sum && list.size()==nums.length) {
            count++;
            
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            
            return;
        }
        
       
      // System.out.println(curr+" "+sum+" "+target);
        if(curr>=nums.length){
            list=new ArrayList<Integer>();
            return;
        }  
       // System.out.println(target+" "+sum+" "+list.size()+" "+nums.length;)
    
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);

        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
 
    }
    
}




WA:

class Solution {
    //1.53pm-2.01pm
    //2.01pm- 
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
        
        
        for(List<Integer> tmp:result)
        {
            for(int t:tmp){
                System.out.print(t+" ");
            }
            System.out.println();
        }
        
       return  count;
    }
    
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        
        if(target==sum && list.size()==nums.length) {
            count++;
            
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            
            return;
        }
        
       
      // System.out.println(curr+" "+sum+" "+target);
        if(curr>=nums.length || sum>target){
            list=new ArrayList<Integer>();
            return;
        }  
       // System.out.println(target+" "+sum+" "+list.size()+" "+nums.length;)
    
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);

        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
 
    }
    
}



[1,1,1,1,1]
3


-1 1 1 1 1 
1 -1 1 1 1 
1 1 -1 1 1 
1 1 1 -1 1 









