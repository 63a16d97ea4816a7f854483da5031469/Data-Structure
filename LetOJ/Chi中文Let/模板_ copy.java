
/*
 * 
https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/


718. 最长重复子数组
难度
中等

261

收藏

分享
切换为英文
关注
反馈
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

 

示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。
 

提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100



1 July 2020 at 11:25 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

// 执行用时：
// 44 ms
// , 在所有 Java 提交中击败了
// 91.71%
// 的用户
// 内存消耗：
// 49.2 MB
// , 在所有 Java 提交中击败了
// 100.00%
// 的用户

// 0 0 1 0 0 
// 0 1 0 0 0 
// 1 0 0 0 0 
// 0 2 0 0 0 
// 0 0 3 0 0 

class Solution {
    //11.28pm-11.32pm
    //11.36pm-11.41pm DP
    public int findLength(int[] A, int[] B) {
        int max=0;
        int lenA=A.length;
        int lenB=B.length;

        int[][] dp=new int[lenA+1][lenB+1];

        for(int i=1;i<lenA+1;i++){
            for(int j=1;j<lenB+1;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}


//
// 54 / 54 个通过测试用例
// 状态：通过
// 执行用时：2623 ms
// 内存消耗：39.4 MB

class Solution {
    //11.28pm-11.32pm
    public int findLength(int[] A, int[] B) {
        int max=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]!=B[j]){
                    continue;
                }else{
                    int ii=i;
                    int jj=j;
                    int tmp=0;
                    while(ii<A.length&&jj<B.length){
                        if(A[ii]==B[jj]){
                            tmp++;
                            max=Math.max(tmp, max);
                            ii++;
                            jj++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }
}

















