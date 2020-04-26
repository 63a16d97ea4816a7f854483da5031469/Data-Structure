
/*
 * 
https://leetcode.com/problems/longest-increasing-subsequence/


300. Longest Increasing Subsequence
Medium

4028

91

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

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



https://blog.csdn.net/liuchonge/article/details/78037135


public static int lengthOfLIS(int[] nums) {
    //用来存储当前的增序数组，初始化为全0
    int [] res = new int[nums.length];
    int len = 0;
    //对nums中的每个元素找到其相应的插入位置
    for(int x:nums){
        //使用二叉搜索找到x应该插入的位置索引，如果没有相等元素则返回low+1的负值
        int i = Arrays.binarySearch(res, 0, len, x);
        //转换为正数
        if(i < 0) i = -(i+1);
        //将x插入相应位置，注意这里如果x比前面元素小，则对其进行替换
        res[i] = x;
        //len保存当前最大的增序数组长度，只有当i等于len时才会进行加一操作。
        if(i == len) len ++;
    }
    return len;
}




//从小往大，填表
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


 
class Solution {
    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
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


WA:

class Solution {
    //5.11pm-
    //暴力破解
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        int max=-1;
        for(int i=0;i<nums.length;i++){
            int cur=0;
            for(int j=i;j<nums.length-1;j++){
                if(nums[i]<=nums[j]){
                    cur++;
                }
            }
            max=Math.max(max,cur);
        }
        
        return max;
    }
}













