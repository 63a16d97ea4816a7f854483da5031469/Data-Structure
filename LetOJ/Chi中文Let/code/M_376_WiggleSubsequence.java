/**
 * [376] Wiggle Subsequence
 * 
 * difficulty: Medium
 * 
 * TestCase Example: [1,7,4,9,2,5]
 * 
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 * 
 * 
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence. 
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * 
 * Examples:
 * 
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * 
 * 
 * Follow up:
 * Can you do it in O(n) time?
 * 
 * 
 * Credits:Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.
 * 
 * 
 * 
 * >>>>>>中文描述<<<<<<
 * 
 * 
 * [376] 摆动序列
 * 
 * 
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * 
 * 示例:
 * 
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列就是一个摆动序列。
 * 
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 它的几个子序列满足摆动序列。其中一个是[1,17,10,13,10,16,8]。
 * 
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 
 * 
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 * 
 */
public class M_376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        
    }
}