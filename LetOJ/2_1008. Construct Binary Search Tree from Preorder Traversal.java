
/*
 * 
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

1008. Construct Binary Search Tree from Preorder Traversal
Medium

1029

34

Add to List

Share
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.

24 May 2020 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */







// Time Complexity: O(nlogn). Each level of tree, it takes O(n) time, tree height should be O(logn).

// Space: O(logn).


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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return dfs(preorder, 0, preorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int l, int r){
        if(l > r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[l]);  //注意是left
        int biggerIndex = l+1; 
        while(biggerIndex<=r && preorder[biggerIndex]<preorder[l]){  //注意这里的条件
            biggerIndex++;
        }
        root.left = dfs(preorder, l+1, biggerIndex-1);
        root.right = dfs(preorder, biggerIndex, r);
        return root;
    }
}


// Time Complexity: O(n). 

// Space: O(logn). Regardless res.

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
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int [] preorder, int min, int max){
        if(i>=preorder.length){
            return null;
        }
        if(preorder[i]<min || preorder[i]>max){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = dfs(preorder, min, root.val);
        root.right = dfs(preorder, root.val, max);
        return root;
    }
}



// Time Complexity: O(n).
// Space: O(logn). Stack space, regardless res.
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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        for(int i = 1; i<preorder.length; i++){
            TreeNode cur = new TreeNode(preorder[i]);
            TreeNode top = stk.peek();

            while(!stk.isEmpty() && stk.peek().val<preorder[i]){
                top = stk.pop();
            }

            if(top.val < preorder[i]){
                top.right = cur;
            }else{
                top.left = cur;
            }

            stk.push(cur);
        }

        return root;
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
class Solution {
    //8.24pm-8.32pm (无思路)
    public TreeNode bstFromPreorder(int[] preorder) {
        
    }
    
    public TreeNode buildTree(int[] preorder, int )
}