
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-increasing-subsequence/

2020-7-12 at 11:36 pm

300. 最长上升子序列
难度
中等

818

收藏

分享
切换为英文
关注
反馈
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int lengthOfLIS(int[] nums) {;
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int ans = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}





class Solution {
    public static int findPositionToReplace(int[] arr, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target==arr[mid])
                return mid;
            else if (target<arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }
        return len;
    }
}











