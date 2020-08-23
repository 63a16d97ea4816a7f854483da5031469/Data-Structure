
/*
 * 
link: 
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

2020-7-1 at 8:33 pm


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
    //9.01pm-9.09
    int head=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        head=postorder.length-1;
        return helper(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode helper(int[]inorder,int[] postorder,int instart,int inend){
        if(instart>inend) return null;

        TreeNode root=new TreeNode(postorder[head--]);
        int mid=findMid(inorder,root.val);
        root.right=helper(inorder,postorder,mid+1,inend);
        root.left=helper(inorder,postorder,instart,mid-1);
        return root;
    }
    public int findMid(int[] inorder, int target){
        for(int i=0;i<inorder.length;i++){
            if(target==inorder[i]) return i;
        }
        return 0;
    }
}



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null) {
            return null;
        }
        return helper(inorder,postorder);
    }

    private TreeNode helper(int[] in, int[] post) {
        if(in.length==0) {
            return null;
        }
        //根据后序数组的最后一个元素，创建根节点
        TreeNode root = new TreeNode(post[post.length-1]);
        //在中序数组中查找值等于【后序数组最后一个元素】的下标
        for(int i=0;i<in.length;++i) {
            if(in[i]==post[post.length-1]) {
                //确定这个下标i后，将中序数组分成两部分，后序数组分成两部分
                int[] inLeft = Arrays.copyOfRange(in,0,i);
                int[] inRight = Arrays.copyOfRange(in,i+1,in.length);
                int[] postLeft = Arrays.copyOfRange(post,0,i);
                int[] postRight = Arrays.copyOfRange(post,i,post.length-1);
                //递归处理中序数组左边，后序数组左边
                root.left = helper(inLeft,postLeft);
                //递归处理中序数组右边，后序数组右边
                root.right = helper(inRight,postRight);
                break;
            }
        }
        return root;
    }
}

// 作者：wang_ni_ma
// 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/liang-chong-shi-xian-dong-hua-yan-shi-106-cong-zho/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。












