
/*
 * 
https://leetcode.com/problems/subarray-sum-equals-k/

560. Subarray Sum Equals K
Medium

3962

124

Add to List

Share
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
Note:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

 

class Solution {
    public int subarraySum(int[] nums, int k) {
           int count=0;
           for(int i=0;i<nums.length;i++){
               int sum=nums[i];
               if(sum==k){
                   count++;
               }
               for(int j=i+1;j<nums.length;j++){
                   sum+=nums[j];
                   if(sum==k) count++;
               }
           }
           return count;
       }
   // ————————————————
   // 版权声明：本文为CSDN博主「liuchongee」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
   // 原文链接：https://blog.csdn.net/liuchonge/article/details/71158902
   }






class Solution {
    public int subarraySum(int[] nums, int k) {
         int sum=0, count=0;
         Map<Integer, Integer> map = new HashMap<>();
         map.put(0, 1);
         for(int i=0; i<nums.length; i++){
             sum += nums[i];
             if(map.containsKey(sum-k)){
                       count += map.get(sum-k);
                   // System.out.println(sum-k +" >> "+count);
             }
           
             // System.out.println(sum+" "+(map.getOrDefault(sum, 0)+1));
             map.put(sum, map.getOrDefault(sum, 0)+1);
         }
         return count;
     }
  
 }
 // ————————————————
 // 版权声明：本文为CSDN博主「liuchongee」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 // 原文链接：https://blog.csdn.net/liuchonge/article/details/71158902
  












