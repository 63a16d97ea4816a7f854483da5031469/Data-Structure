
/*
 * 
https://leetcode.com/problems/daily-temperatures/


739. Daily Temperatures
Medium

2325

69

Add to List

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

栈，递减栈Descending Stack


 * 
 */



题解：

递减栈-[LeetCode] 739. Daily Temperatures 每日温度 - 轻风舞动 - 博客园

https://www.cnblogs.com/lightwindy/p/9881122.html

https://www.cnblogs.com/Dylan-Java-NYC/p/8192500.html

class Solution {
    //10.48pm-10.59pm
 
    public int[] dailyTemperatures(int[] T) {
        
        int len=T.length;
        Stack<Integer> stack=new Stack<Integer>();
        
        int[] res=new int[len];
          
        for(int i=len-1;i>=0;i--)
        {
            while(!stack.isEmpty() && T[i]>=T[stack.peek()]){
                stack.pop();
            }
            
            res[i]=stack.isEmpty()?0:(stack.peek()-i);
            
            stack.push(i);
        }
        return res;
    }
}







Over time limit:

class Solution {
    //10.48pm-10.59pm
 
    public int[] dailyTemperatures(int[] T) {
     
        for(int i=0;i<T.length;i++)
        {
            int wait=0;
            for(int j=i+1;j<T.length;j++){
                if(T[i]<T[j]&&wait==0){
                    wait=j-i;
                }
            }
            T[i]=wait;
        }
        return T;
    }
}



















