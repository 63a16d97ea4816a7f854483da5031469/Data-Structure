
/*
 * 
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

865. Smallest Subtree with all the Deepest Nodes
Medium

624

195

Add to List

Share
Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

 

Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:



We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.
 

Note:

The number of nodes in the tree will be between 1 and 500.
The values of each node are unique.
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




https://github.com/Cee/Leetcode/blob/master/865%20-%20Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes.java


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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
}

/**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 */
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}









/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
https://gitee.com/guobinhit/myleetcode/blob/master/codes/java/leetcodes/src/main/java/com/hit/basmath/learn/others/_865.java
class Solution {
    int maxDepth = -1;
    TreeNode[] result = new TreeNode[1];

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return root;
        result[0] = null;
        getNode(root, 0);
        return result[0];
    }

    public int getNode(TreeNode root, int depth) {
        if (root == null)
            return depth;
        int l = getNode(root.left, depth + 1);
        int r = getNode(root.right, depth + 1);

        // both left and right depth are same and if it is greater than or equal to the maxDepth so far, UPDATE result.
        //  `=` in l >= maxDepth, implies that the all the nodes with maximum depth are considered.
        if (l == r && l >= maxDepth) {
            maxDepth = l;
            result[0] = root;
        }

        // return the maximum depth that was found in this subtree.
        return Math.max(l, r);
    }
}









WA:


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//9.59am-
class Solution {
    int max=-1;
    List<List<TreeNode>> result=new ArrayList<List<TreeNode>>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        if(root==null) return null;
        if(root.left==null&&root.right==null) return root;
        
        dfs(root,new ArrayList<TreeNode>());
        TreeNode returnNode=null;
        
        if(result.size()==1){
            return result.get(0).get(result.get(0).size()-2);
        }
        
        for(int i=0;i<result.size()-1;i++){
            for(int j=i+1;j<result.size();j++){
                if(result.get(i).get(result.get(i).size()-2).val==result.get(j).get(result.get(j).size()-2).val){
                    return result.get(i).get(result.get(i).size()-2);
                }
        }
    }
          return root;
    }
    
    void dfs(TreeNode root, List<TreeNode> list){
        if(root==null) return;
        list.add(root);
        if(root.left==null && root.right==null){
            if(max<list.size()){
                max=list.size();
                result.clear();
            }
            if(list.size()>=max){
            result.add(new ArrayList<TreeNode>(list));
            }
            return;
        };
        if(root.left!=null){
            dfs(root.left,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,list);
            list.remove(list.size()-1);
        }
    }
}