
/*
 * 
link: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/


2022-02-03 at 20:51

103. 二叉树的锯齿形层序遍历
难度
中等

585

收藏

分享
切换为英文
接收动态
反馈
给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]
 

提示：

树中节点数目在范围 [0, 2000] 内
-100 <= Node.val <= 100

 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 极限条件，一定要判断
        if(root==null) return result;

        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(null);
        List<Integer> currList=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode head=queue.removeFirst();
            if(head==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                result.add(new ArrayList<Integer>(currList));
                currList=new ArrayList<Integer>();
            }else{
                currList.add(head.val);
                if(head.left!=null) queue.add(head.left);
                if(head.right!=null) queue.add(head.right);
            }
        }
        for(int i=0;i<result.size();i++){
            List<Integer> tmp=result.get(i);
            if(i%2!=0){
                Collections.reverse(tmp);
            }
        }
        return result;
    }

}





















