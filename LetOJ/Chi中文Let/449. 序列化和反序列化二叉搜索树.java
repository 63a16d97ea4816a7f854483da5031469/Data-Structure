
/*
 * 
link: https://leetcode-cn.com/problems/serialize-and-deserialize-bst/

449. 序列化和反序列化二叉搜索树
难度
中等

250

收藏

分享
切换为英文
接收动态
反馈
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。

 

示例 1：

输入：root = [2,1,3]
输出：[2,1,3]
示例 2：

输入：root = []
输出：[]
 

提示：

树中节点数范围是 [0, 104]
0 <= Node.val <= 104
题目数据 保证 输入的树是一棵二叉搜索树。


2022-02-01 at 0:25
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



错误：

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String encodeStr="";
    List<String> list=new ArrayList<String>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encodeStr="";
        inOrder(root);
        System.out.println("===> "+encodeStr);
        return encodeStr;
    }

    public void inOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null) inOrder(root.left);
        encodeStr+=root.val;
        if(root.right!=null) inOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        list=new ArrayList<String>();
        for(int i=0;i<data.length();i++){
            list.add(String.valueOf(data.charAt(i)));
        }
        TreeNode root=buildTree(list,0,list.size()-1);
        return root;
    }

    public TreeNode buildTree(List<String> list, int start, int end){
        if(start<0||end>list.size()-1||start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(Integer.parseInt(list.get(mid)));
        System.out.println(list.get(mid));
        root.left=buildTree(list,start,mid-1);
        root.right=buildTree(list,mid+1,end);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;



















