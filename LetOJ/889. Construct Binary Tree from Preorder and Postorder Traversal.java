
/*
 * 

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

889. Construct Binary Tree from Preorder and Postorder Traversal
Medium

2222

95

Add to List

Share
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

 

Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]
 

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
 
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder==null||postorder==null) return null;

        int n=preorder.length;
        if(n==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        if(n==1) return root;
        int point=0;
        for(int i=0;i<postorder.length;i++){
            if(preorder[1]==postorder[i]){
                point=i+1;
            }
        }

        root.left=constructFromPrePost(Arrays.copyOfRange(preorder,1,point+1),Arrays.copyOfRange(postorder,0,point));
        root.right=constructFromPrePost(Arrays.copyOfRange(preorder,point+1,n),Arrays.copyOfRange(postorder,point,n-1));
        return root;
    }
 
}

//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]

// copyOfRange(int []original,int from,int to),original为原始的int型数组，from为开始角标值，to为终止角标值。（其中包括from角标，不包括to角标。即处于[from,to)状态）

// point: 3
// left: preorder Arr - copyOfRange(preorder,1,4)
// left: postorder Arr - copyOfRange(postorder,0,3)
// right: preorder Arr - copyOfRange(preorder,4,7)
// right: postorder Arr - copyOfRange(postorder,3,6)
// point: 1
// left: preorder Arr - copyOfRange(preorder,1,2)
// left: postorder Arr - copyOfRange(postorder,0,1)
// right: preorder Arr - copyOfRange(preorder,2,3)
// right: postorder Arr - copyOfRange(postorder,1,2)
// point: 1
// left: preorder Arr - copyOfRange(preorder,1,2)
// left: postorder Arr - copyOfRange(postorder,0,1)
// right: preorder Arr - copyOfRange(preorder,2,3)
// right: postorder Arr - copyOfRange(postorder,1,2)





















