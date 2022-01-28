
/*
 * 
link: https://leetcode-cn.com/problems/merge-sorted-array/


88. 合并两个有序数组
难度
简单

1259





给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：

输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？


2022-01-28 at 15:04

刚看到想到的思路是什么？：

从nums1中剥离出来一个子数组，然后就转化为 两个有序子数组合并问题


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=nums1.length;
        int[] n1=new int[len-nums2.length];
        // 生成n1数组
        for(int i=0;i<n1.length;i++){
            n1[i]=nums1[i];
        }
        int c1=0;
        int c2=0;
        int l1=n1.length;
        int l2=nums2.length;
        int index=0;
        while(c1<l1&&c2<l2){
            if(n1[c1]<=nums2[c2]){
                nums1[index++]=n1[c1];
                c1++;
            }else if(n1[c1]>nums2[c2]){
                    nums1[index++]=nums2[c2];
                    c2++;
                }
        }
        while(c1<l1){
             nums1[index++]=n1[c1];
             c1++; 
        }
        while(c2<l2){
             nums1[index++]=nums2[c2];
             c2++; 
        }
    }
}




















