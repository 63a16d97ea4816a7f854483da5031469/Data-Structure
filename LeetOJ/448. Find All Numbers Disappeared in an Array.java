
/*
 * 
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

448. Find All Numbers Disappeared in an Array
Easy

2442

223

Add to List

Share
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */

看了题解：
class Solution {
    //10.09pm-11.05pm
    public List<Integer> findDisappearedNumbers(int[] nums) {
 
        List<Integer> list=new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            int positionValue=Math.abs(nums[i])-1;
            if(nums[positionValue]>0)
            nums[positionValue]=-nums[positionValue];
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
    
}



















