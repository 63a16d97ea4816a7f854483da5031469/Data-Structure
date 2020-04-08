
/*
 * 
https://leetcode.com/problems/search-insert-position/


35. Search Insert Position
Easy

1923

228

Add to List

Share
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0

20 March 2020 at 8:33:31 pm
 * 
 */



 二分法解：
class Solution {
    //8.42-8.43pm
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
     
        
        return l;
    }
}




class Solution {
    //8.26pm-8.36pm
    public int searchInsert(int[] nums, int target) {
        
        int n=nums.length;
        if(target>nums[n-1]) return n;
        if(n==0||target<=nums[0]) return 0;
        
        for(int i=0;i<n-1;i++){
            if(nums[i]==target){
                return i;
            }else if(target>nums[i] && target<nums[i+1]){
                return i+1;
            }else if(nums[i+1]==target){
                return i+1;
            }
        }
        
        return 0;
    }
}





















