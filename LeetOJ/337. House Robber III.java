
/*
 * 
https://leetcode.com/problems/house-robber-iii/

337. House Robber III
Medium

2370

49

Add to List

Share
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

9 May 2020 at 1.48 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    // [rob this, don't rob this]
    private int[] robHelper(TreeNode root) {
        int rob = root.val, noRob = 0;
        if(root.left != null) {
            int[] left = robHelper(root.left);
            rob += left[1]; //如果选择rob这个root，对于其左节点，只能选不rob
            noRob += Math.max(left[0], left[1]);//如果选择不rob这个root，对于其左节点，可以选择rob，也可以选择不rob
        }
        if(root.right != null) {
            int[] right = robHelper(root.right);
            rob += right[1];
            noRob += Math.max(right[0], right[1]);
        }
        return new int[]{rob, noRob};
    }
}


















