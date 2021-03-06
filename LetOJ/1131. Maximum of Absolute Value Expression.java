
/*
 * 
https://leetcode.com/problems/maximum-of-absolute-value-expression/


1131. Maximum of Absolute Value Expression
Medium

128

151

Add to List

Share
Given two arrays of integers with equal lengths, return the maximum value of:

|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

where the maximum is taken over all 0 <= i, j < arr1.length.

 

Example 1:

Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13
Example 2:

Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20
 

Constraints:

2 <= arr1.length == arr2.length <= 40000
-10^6 <= arr1[i], arr2[i] <= 10^6

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    //10.03pm-
       public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length];
        int result = 0;
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i < arr.length; i++) {
                switch(k) {
                    case 0 : arr[i] = arr1[i] + arr2[i] - i; break;
                    case 1 : arr[i] = arr1[i] - arr2[i] - i; break;
                    case 2 : arr[i] = -arr1[i] + arr2[i] - i; break;
                    case 3 : arr[i] = -arr1[i] - arr2[i] - i; break;
                }
            }
            result = Math.max(result, maxDist(arr));
        }
        return result;
    }
     public int maxDist(int[] arr) {
        int result = 0, max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = Math.max(result, max - arr[i]);
            max = Math.max(max, arr[i]);
        }
        return result;
    }
}







class Solution {
    //10.03pm-10.17pm
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max=-1;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
              max=Math.max(Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j),max);
            }
        }
 
        return max;
    }
}














