
/*
 * 
https://leetcode.com/problems/longest-increasing-subsequence/

300. Longest Increasing Subsequence
Medium

4476

104

Add to List

Share
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

14 June 2020 at 12:01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */










class Solution {
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
                int position=Arrays.binarySearch(increasingSequence,0,len,nums[i]);
                System.out.println(position);
                if(position<0){
                    // returned -position-1
                    position=-(position+1);
                }
                
                increasingSequence[position]=nums[i];
                
                if(position==len){
                    len++;
                }
            }
        }
        return len;
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


// DP:
class Solution {
    //5.11pm-5.37pm 看题解
      public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}




