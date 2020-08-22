
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
    //9.15am-9.30am
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}






//变形一下：

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
    //9.15am-9.30am
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null&&right!=null) return root;
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }
}


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

// 作者：zzz-ai
// 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/quan-wang-du-jia-er-bu-fa-xie-di-gui-ru-he-shui-co/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。












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
    //原理：我们可以根据前序遍历的顺序来序列化二叉树,因为前序遍历是从根节点开始的。在遍历二叉树碰到 null时,将其序列化为一个特殊的字符(如'$')
    //另外,节点的数值之间要用一个特殊字符(如',')隔开,因为节点的值位数不定且正负不定。
    //则下面二叉树               1               可以序列化为：
    //				 /  \              [1,2,4,$,$,$,3,5,$,$,6,$,$]
    //				2    3
    //             /    / \
    //            4    5   6
    //我们接着以上述字符串为例分析如何反序列化二叉树。第一个读出的数字是1。由于前序遍历是从根节点开始的,这是根节点的值。
    //接下来读出的数字是2,根据前序遍历的规则,这是根节点的左子节点的值。同样,接下来的数字4是值为2的节点的左子节点。
    //接着从字符串里读出两个字符'$',这表明值为4的节点的左、右子节点均不存在,因此它是一个叶节点。接下来回到值为2的节点,重建它的右子节点。
    //由于下一个字符是'$',这表明值为2的节点的右子节点不存在， 2这个节点的左、右子树都己经构建完毕,接下来回到根节点,反序列化根节点的右子树
    //下一个序列化字符串中的数字是3,因此右子树的根节点的值为3。它的左子节点是一个值为5的叶节点,因为接下来的三个字符是"5,$,$"。
    //同样,它的右子节点是值为6的叶节点,因为最后3个字符是"6,$,$"。
    
        int start=0;//注意这里必须是全局变量，否则后面的迭代过程中start无法正确变化
        public String serialize(TreeNode root) {
            if(root==null) return "$";
            StringBuilder res = new StringBuilder();
            recur(root,res);
            return res.toString();
        }
        public void recur(TreeNode root,StringBuilder res){//前序遍历
            if(root==null){ 
                res.append("$,");//可以append string
                return;}
            res.append(root.val);//append int 由于int位数不定，且可正可负，因此各元素间必须用,分割
            res.append(',');//append char
            recur(root.left,res);
            recur(root.right,res);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("$")) return null;//Sting值相等的判别不能用==
            String inputs[] = data.split(",");
            //虽然data中以,结尾，但是上述分割后会默认最后一个,不存在  不会使最后一个分割元素为空
            return build(inputs);
        }
        public TreeNode build(String[] inputs){
            TreeNode res;
            if(inputs[start].equals("$")){ 
                start++;
                return null;//这里说明当前节点为null，自然不存在左右节点了，直接返回
            }
            res = new TreeNode(Integer.parseInt(inputs[start]));
            start++;
            //注意：start不能以形参的形式引入build方法中，build(inputs,start);如果是这样
            //下面res.left = build(inputs,start); res.right = build(inputs,start+1);由于处于同一级迭代中start值连续
            //但实际上res.right中应该是上面res.left迭代完成后才会执行的，start不连续，因此把start作为全局变量较为合适
            res.left = build(inputs);
            res.right = build(inputs);
            return res;
        }
    }
    
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    
    作者：mo-fei-25
    链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/javashi-xian-jian-zhi-offersi-lu-xian-xu-bian-li-b/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。