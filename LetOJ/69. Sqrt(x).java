
/*
 * 
https://leetcode.com/problems/sqrtx/

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.


27 March 2020 at 8:33:31 pm
 * 
 */



class Solution {
    
    //start 7.01pm   end: 7.31pm
    public int mySqrt(int x) {
        int prev=1;
        if(x==0){
            return 0;
        }
        
        if(x<=3){
            return 1;
        }
        
        for(int i=2;i<x;i++){
            long tmp=(long)i*i;
            
             if(tmp==x){
                 return i;
             }
            
            if(prev<x && x<tmp){
                return prev;
            }
            
            prev=i;
        }
        
        return prev;
    }
}




















