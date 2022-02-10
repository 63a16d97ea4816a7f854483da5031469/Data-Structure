
/*
 * 
link: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

剑指 Offer 11. 旋转数组的最小数字
难度
简单

508

收藏

分享
切换为英文
接收动态
反馈
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/




2022-02-11 at 0:10 am
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int minArray(int[] numbers) {
        return minArr(numbers,0,numbers.length-1);
    }
    public int minArr(int[] numbers, int start, int end){
        if(start+1>=end){
            return Math.min(numbers[start],numbers[end]);
        }

        if(numbers[start]<numbers[end]){
            return numbers[start];
        }
        int mid=(start+end)/2;
        return Math.min(minArr(numbers,start,mid-1),minArr(numbers,mid,end));
    }
}


















