
/*
 * 
https://leetcode.com/problems/find-mode-in-binary-search-tree/

501. Find Mode in Binary Search Tree
Easy

845

326

Add to List

Share
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



解题过程
寻找二叉搜索树 BST 的众数，众数就是一组数据中出现次数最多的一个或多个数。
没想到怎么用 BST 的性质，写了个通用的二叉树找众数，遍历放到map中统计，最后再排序输出。
后来看题解总结了一个很重要的思想：
二叉搜索树的中序遍历序列是一个升序序列，这是二叉搜索树的一个重要性质，巧妙利用这一性质可以解决一系列二叉搜索树问题。所以可以把BST看成和有序数组是等价的，一看到BST马上就要想到是有序数组。
逐个比对当前结点(root)值与前驱结点（pre)值。更新当前节点值出现次数(curTimes)及最大出现次数(maxTimes)


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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) if (max < value) max = value; 
        for (Integer key : map.keySet()) if (map.get(key) == max) list.add(key);
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
    
    private void inOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inOrder(root.right, map);
    }
}







public int[] findMode(TreeNode root) {
    if (null == root) {
        return new int[0];
    }
    // 结点值及对应的出现次数map
    Map<Integer, Integer> map = new TreeMap<>();
    preOrderTraverse(root, map);
    // 出现次数与结点值map，出现次数相同的放入list，利用 TreeMap 自动按 key 升序排列的性质，最后一个kv就是结果
    TreeMap<Integer, List<Integer>> countMap = new TreeMap<>();
    map.forEach((k, v) -> {
        List<Integer> list = countMap.getOrDefault(v, new ArrayList<>());
        list.add(k);
        countMap.put(v, list);
    });
    List<Integer> result = countMap.get(countMap.lastKey());
    System.out.println(result);
    return result.stream().mapToInt(i -> i).toArray();
}
private void preOrderTraverse(TreeNode root, Map<Integer, Integer> map) {
    if (null == root) {
        return;
    }
    map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    preOrderTraverse(root.left, map);
    preOrderTraverse(root.right, map);
}






// 线索二叉树
// https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html



