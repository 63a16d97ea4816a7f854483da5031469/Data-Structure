
/*
 * 
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/


1281. Subtract the Product and Sum of Digits of an Integer
Easy

200

80

Add to List

Share
Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 

Example 1:

Input: n = 234
Output: 15 
Explanation: 
Product of digits = 2 * 3 * 4 = 24 
Sum of digits = 2 + 3 + 4 = 9 
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation: 
Product of digits = 4 * 4 * 2 * 1 = 32 
Sum of digits = 4 + 4 + 2 + 1 = 11 
Result = 32 - 11 = 21
 

Constraints:

1 <= n <= 10^5

3 May 2020 at 8:01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //7.58pm-8.00pm
    public int subtractProductAndSum(int n) {
        String s=n+"";
        
        int product=1;
        int sum=0;
        
        for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           int curr=Integer.parseInt(c+"");
            product*=curr;
            sum+=curr;
        }
        
        return product-sum;
    }
}


















