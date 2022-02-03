
/*
 * 
link: https://leetcode-cn.com/problems/diameter-of-binary-tree/

543. 二叉树的直径
难度
简单

901


给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

 

示例 :
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 

注意：两结点之间的路径长度是以它们之间边的数目表示。




2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




通过测试用例：
47 / 104
输入：
[1,2,3,4,5]
输出：
5
预期结果：
3

class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        preOrder(root);
        return max;
    }
    // loop all the nodes
    public void preOrder(TreeNode root){
        if(root==null) return;
        findMaxPath(root,0);
        if(root.left!=null) preOrder(root.left);    
        if(root.right!=null) preOrder(root.right);
    }
    public int findMaxPath(TreeNode root, int count){
        if(root==null) return 0;
        count++;
        int left=findMaxPath(root.left,count);
        int right=findMaxPath(root.right,count);

        max=Math.max(count-1,max);
        max=Math.max(left-1+right-1,max);

        return count;
    }
}




class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}


class Solution {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxPath(root);
        return ans-1;
    }
    public int findMaxPath(TreeNode root){
        if(root==null) return 0;
    
        int left=findMaxPath(root.left);  // 求左子树的最大路径
        int right=findMaxPath(root.right); // 求右子树的最大路径
        ans = Math.max(ans, left+right+1); // 计算curr_node最长path=left+right+1 并更新ans

        return Math.max(left,right)+1; // 求左右子树，谁最长
    }
}

// 复杂度分析
// 时间复杂度：
// O(N)，其中 
// N 为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
// 空间复杂度：
// O(Height)，其中 
// Height 为二叉树的高度。由于递归函数在递归过程中需要为每一层递归函数分配栈空间，所以这里需要额外的空间且该空间取决于递归的深度，而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，所以所需空间复杂度为 
// O(Height) 。

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









