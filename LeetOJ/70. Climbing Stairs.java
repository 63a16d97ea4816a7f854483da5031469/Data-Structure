
/*
 * 
https://leetcode.com/problems/climbing-stairs/

70. Climbing Stairs
Easy

3605

119

Add to List

Share
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

4 April 2020 at 11.00pm
 * 
 */

 改进到只用三个变量：

class Solution {
    //10.45pm- 10.51  over time limit.
    //10.51pm-10.56pm 动态规划解法
    //10.56pm-
    //f(n)=f(n-1)+f(n-2);
    public int climbStairs(int n) {

        return dig(n);
        
    }
    
    int dig(int n){
    
        if(n==1) return 1;
        if(n==2) return 2;
        
        int a=1;
        int b=2;
        int c=a+b;
        
        for(int i=3;i<=n;i++){
          
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}



改进版  DP：AC
class Solution {
    //10.45pm- 10.51  over time limit.
    //10.51pm-
    //f(n)=f(n-1)+f(n-2);
    public int climbStairs(int n) {

        return dig(n);
        
    }
    
    int dig(int n){
    
        if(n==1) return 1;
        if(n==2) return 2;
        
        int[] arr=new int[n+1];
        
        arr[1]=1;
        arr[2]=2;
        
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}


 超时：

class Solution {
    //10.45pm- 10.51  over time limit.
    //f(n)=f(n-1)+f(n-2);
    public int climbStairs(int n) {

        return dig(n);
        
    }
    
    int dig(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        
        return dig(n-1)+dig(n-2);
    }
}



















