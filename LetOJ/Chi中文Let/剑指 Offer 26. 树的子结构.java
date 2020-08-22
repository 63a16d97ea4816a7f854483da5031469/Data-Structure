
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A == null || B == null)
        return false;
    //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
    //只要有一个为true，就说明B是A的子结构
    return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
}

boolean isSub(TreeNode A, TreeNode B) {
    //这里如果B为空，说明B已经访问完了，确定是A的子结构
    if (B == null)
        return true;
    //如果B不为空A为空，或者这两个节点值不同，说明B树不是
    //A的子结构，直接返回false
    if (A == null || A.val != B.val)
        return false;
    //当前节点比较完之后还要继续判断左右子节点
    return isSub(A.left, B.left) && isSub(A.right, B.right);
}
 
// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/di-gui-fang-shi-jie-jue-by-sdwwld/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















//错误解：
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
    //10.25am-
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return dfs(A,B);
    }

    public boolean dfs(TreeNode aNode, TreeNode bNode){
        if(aNode==null||bNode==null) return false;
        if(aNode.val==bNode.val){
            if(aNode.left!=null&&bNode.left!=null&&aNode.left.val==bNode.left.val){
                return true;
            }
            if(aNode.right!=null&&bNode.right!=null&&aNode.right.val==bNode.right.val){
                return true;
            }
            if(bNode.left==null&&bNode.right==null){
                return true;
            }
        }
        if(aNode.left!=null){
            if(dfs(aNode.left, bNode)){
                return true;
            }
        }
        if(aNode.right!=null){
            if(dfs(aNode.right, bNode)){
                return true;
            }
        }
        return false;
    }
}