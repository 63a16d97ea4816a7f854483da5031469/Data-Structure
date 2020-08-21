
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/

2020-8-20 at 9:33 pm

剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
难度
简单

51

收藏

分享
切换为英文
关注
反馈
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]



 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。


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
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
       dfs(root,p,q);

       return result;
    }

    public void dfs(TreeNode root,TreeNode p, TreeNode q){
        if(root==null) return;
        isMatch(root,p,q);
        if(root.left!=null){
            dfs(root.left,p,q);
        }
        if(root.right!=null){
            dfs(root.right,p,q);
        }
    }

    public void isMatch(TreeNode root, TreeNode p, TreeNode q){
         if(root==null) return;
         if(root.left!=null&&root.right!=null){
            if((p.val==root.left.val||p.val==root.right.val)&&(q.val==root.left.val||q.val==root.right.val)){
                result=root;
            }
         }
   if((root.val==p.val&&((root.left!=null&&root.left.val==q.val)||root.right!=null&&root.right.val==q.val))||(root.val==q.val&&((root.left!=null&&root.left.val==p.val)||root.right!=null&&root.right.val==p.val))){
            result=root;
        }

        //  System.out.println(root.val);
        if(root.left!=null&&p.val==root.left.val){
            if(findNode(root.left.right,q)){
                result=root.left;
            }
        }
        if(root.right!=null&&p.val==root.right.val){
            if(findNode(root.right.left,q)){
                result=root.right;
            }
        }

        if(root.left!=null&&q.val==root.left.val){
            if(findNode(root.left.right,p)){
                result=root.left;
            }
        }

        if(root.right!=null&&q.val==root.right.val){
            if(findNode(root.right.left,p)){
                result=root.right;
            }
        }
    }

    public boolean findNode(TreeNode root, TreeNode target){
        if(root==null) return false;
        if(root.val==target.val) return true;
        return findNode(root.left,target)||findNode(root.right,target);
    }
    
}