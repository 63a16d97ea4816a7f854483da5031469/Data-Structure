
/*
 * 
https://leetcode.com/explore/featured/card/recursion-i/253/conclusion/2384/

Unique Binary Search Trees II
Solution
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

11 April 2020 at 11.01 pm
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



 题解 AC:
class Solution {
    public List<TreeNode> generateTrees(int n) {
       if(n==0) return new ArrayList<TreeNode>();
       return uniqueTree(1,n);
    }
    
    List<TreeNode> uniqueTree(int left, int right){
        List<TreeNode> list=new ArrayList<TreeNode>();
        if(left>right) 
        {
            list.add(null);
            return list;   
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> lefts=uniqueTree(left, i-1);
            List<TreeNode> rights=uniqueTree(i+1,right);
            for(int j=0;j<lefts.size();j++){
                for(int k=0;k<rights.size();k++){
                    TreeNode root=new TreeNode(i);
                    root.left=lefts.get(j);
                    root.right=rights.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}



public ArrayList<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);//从1作为root开始，到n作为root结束
}
 
private ArrayList<TreeNode> generateTrees(int left, int right){
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    if (left > right){
        res.add(null);
        return res;
    }
    for (int i = left; i <= right; i++){
        ArrayList<TreeNode> lefts = generateTrees(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
        ArrayList<TreeNode> rights = generateTrees(i+1, right);//右子树由[i+1, n]构成
        for (int j = 0; j < lefts.size(); j++){
            for (int k = 0; k < rights.size(); k++){
                TreeNode root = new TreeNode(i);
                root.left = lefts.get(j);
                root.right = rights.get(k);
                res.add(root);//存储所有可能行
            }
        }
    }
    return res;
}

https://www.cnblogs.com/springfor/p/3884029.html

















