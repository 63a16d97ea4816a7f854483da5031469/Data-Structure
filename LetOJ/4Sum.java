
/*
 * 
https://leetcode.com/problems/4sum/


18. 4Sum
Medium

1587

296

Add to List

Share
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

28 March 2020 at 11.57pm
 * 
 */

看题解写的

class Solution {
    
    // 11.37pm -11.56pm
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j-1]==nums[j]){
                    continue;
                }
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        if(l==j+1 || r==nums.length-1){
                            result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[l],nums[r]}));
                            l++;
                            r--;
                        }else if(nums[l-1]==nums[l] || nums[r+1]==nums[r]){
                            l++;
                            r--;
                            continue;
                        }else{
                             result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[l],nums[r]}));
                            l++;
                            r--;
                        }
                    }else if(sum>target){
                        r--;
                    }else if(sum<target){
                        l++;
                    }
                }
            }
        }
        return result;
    }
}






















