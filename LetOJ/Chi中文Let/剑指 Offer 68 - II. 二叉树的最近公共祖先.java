
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

2020-8-21 at 8:31 am

剑指 Offer 68 - II. 二叉树的最近公共祖先
难度
简单

116

收藏

分享
切换为英文
关注
反馈
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    TreeNode find;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bianli(root,p,q);
        return find;
    }

    //函数作用：后序遍历发现root是p或q时候尝试看看能不能找到祖先，可能可以也可能不行，但遍历完一遍后一定可以
    //返回值：返回p或q其中一个，没有返回null
    public TreeNode bianli(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        return null;

        TreeNode left=bianli(root.left,p,q);
        TreeNode right=bianli(root.right,p,q);       
        
        //不同层
        if(root.val==p.val||root.val==q.val){
            if(left!=null||right!=null){
                find=root;
            }
            return root;
        }
        //同层
        if(left!=null&&right!=null){
            find=root;
        }

        if(left!=null)
        return left;
        if(right!=null)
        return right;

        return null;

    }
}

作者：zzz-ai
链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/quan-wang-du-jia-er-bu-fa-xie-di-gui-ru-he-shui-co/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















