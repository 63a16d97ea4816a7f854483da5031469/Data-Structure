
/*
 * 
link: https://leetcode-cn.com/problems/path-sum-iii/

437. 路径总和 III
难度
中等

1214

收藏

分享
切换为英文
接收动态
反馈
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 

示例 1：



输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
 

提示:

二叉树的节点个数的范围是 [0,1000]
-109 <= Node.val <= 109 
-1000 <= targetSum <= 1000 



2022-02-02 at 16:51
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 回溯模板:

class Solution {
    List<Integer> list = new ArrayList<>();
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        // 特殊情况
        if(root == null)    return 0;
        // 先将根节点加入list，再进入递归
        list.add(root.val);

        helper(root, sum);
        return res;
    }

    public void helper(TreeNode root, int sum) {
        // if 路径是否为解
        int tmp = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            tmp += list.get(i);
            if(tmp == sum)  res++;
        }

        // for 多路选择
        if(root.left != null){
            // 做选择
            list.add(root.left.val);
            helper(root.left, sum);
            // 撤销选择
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            // 做选择
            list.add(root.right.val);
            helper(root.right, sum);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}


10  res: 0
5  10  res: 0
3  5  10  res: 1
3  3  5  10  res: 1
-2  3  5  10  res: 1
2  5  10  res: 1
1  2  5  10  res: 2
-3  10  res: 2
11  -3  10  res: 3





回溯非模板：

class Solution {
    public int pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    List<Integer> list = new ArrayList<>();
    int res = 0;
    public void helper(TreeNode root, int sum) {
        // if 是否遍历到底
        if(root == null)    return;
        // if 路径是否为解
        int tmp = 0;
        list.add(root.val);
        for(int i = list.size() - 1; i >= 0; i--){
            tmp += list.get(i);
            if(tmp == sum)  res++;
        }

        // for 多路选择
        helper(root.left, sum);
        helper(root.right, sum);

        for(int ele:list){
            System.out.print(ele+" ");
        }
        System.out.println();
        // 撤销选择
        list.remove(list.size() - 1);
    }
}


10 5 3 3 
10 5 3 -2 
10 5 3 
10 5 2 1 
10 5 2 
10 5 
10 -3 11 
10 -3 
10 












执行结果：
超出内存限制

TEST case: 

[0,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0,null,0]
0

超出内存限制
class Solution {
    int target=0;
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        target=targetSum;
        //遍历所有节点
        preOrder(root);
        return result.size();
    }
    public void preOrder(TreeNode root){
        findPath(root,new ArrayList<Integer>());
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
    }
    public void findPath(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(target==getSum(list)){
            result.add(new ArrayList<Integer>(list));
        }
        if(root.left!=null) findPath(root.left,list);
        if(root.right!=null) findPath(root.right,list);
        // remove last node
        if(list.size()>0)
        list.remove(list.size()-1);
    }
    public int getSum(List<Integer> list){
        int currSum=0;
        for(int tmp:list){
            currSum+=tmp;
        }
        return currSum;
    }
}




超出时间限制
N/A N/A Java    2022/02/02 16:58:

class Solution {
    int target=0;
    int result=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        target=targetSum;
        //遍历所有节点
        preOrder(root);
        return result;
    }
    public void preOrder(TreeNode root){
        findPath(root,new ArrayList<Integer>());
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
    }
    public void findPath(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(target==getSum(list)){
                result++;
        }
        if(root.left!=null) findPath(root.left,list);
        if(root.right!=null) findPath(root.right,list);
        // remove last node
        if(list.size()>0)
        list.remove(list.size()-1);
    }
    public int getSum(List<Integer> list){
        int currSum=0;
        for(int tmp:list){
            currSum+=tmp;
        }
        return currSum;
    }
}



执行用时：
16 ms
, 在所有 Java 提交中击败了
54.89%

class Solution {
    int target=0;
    int result=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        target=targetSum;
        //遍历所有节点
        preOrder(root);
        return result;
    }
    public void preOrder(TreeNode root){
        findPath(root,target);
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
    }
    public void findPath(TreeNode root,int sum){
        if(root==null) return;
        if(root.val==sum){
            result++;
        }
        if(root.left!=null) findPath(root.left,sum-root.val);
        if(root.right!=null) findPath(root.right,sum-root.val);
    }
    public int getSum(List<Integer> list){
        int currSum=0;
        for(int tmp:list){
            currSum+=tmp;
        }
        return currSum;
    }
}






执行用时：
28 ms
, 在所有 Java 提交中击败了
9.72%
的用户

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        } 

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}


时间复杂度：
O(N平方)，其中 
N 为该二叉树节点的个数。对于每一个节点，求以该节点为起点的路径数目时，则需要遍历以该节点为根节点的子树的所有节点，因此求该路径所花费的最大时间为 O(N)，我们会对每个节点都求一次以该节点为起点的路径数目，因此时间复杂度为  O(N平方)

空间复杂度：
O(N)，考虑到递归需要在栈上开辟空间。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/path-sum-iii/solution/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/path-sum-iii/solution/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



只对root.left!=null root.right!=null进行操作：

执行用时：
16 ms
, 在所有 Java 提交中击败了
54.89%
的用户

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        if(root.left!=null){
            ret += pathSum(root.left, targetSum);
        }
        if(root.right!=null){
            ret += pathSum(root.right, targetSum);
        }
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        } 
        if(root.left!=null){
            ret += rootSum(root.left, targetSum - val);
        }
        
        if(root.right!=null){
            ret += rootSum(root.right, targetSum - val);
        }
        return ret;
    }
}










