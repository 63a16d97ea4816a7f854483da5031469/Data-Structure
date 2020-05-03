
/*
 * 
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/


1365. How Many Numbers Are Smaller Than the Current Number
Easy

392

11

Add to List

Share
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100

3 May 2020 at 8:06: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //8.01pm-8.06pm
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums.length==0) return null;
        int[] arr=nums.clone();
        Arrays.sort(arr);
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],i);
            }
        }
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=map.get(nums[i]);
        }
        return result;
    }
}















