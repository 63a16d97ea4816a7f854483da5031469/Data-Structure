
/*
 * 
link: 


2020-7-19 at 4:07 pm

236. 二叉树的最近公共祖先
难度
中等

660

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


//递归写法:


class Solution {

    public TreeNode lowestCommonAncestor(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null || cur == p || cur == q)
            return cur;
        TreeNode left = lowestCommonAncestor(cur.left, p, q);
        TreeNode right = lowestCommonAncestor(cur.right, p, q);
        //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null)
            return right;
        //同上
        if (right == null)
            return left;
        //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
        //我们只需要返回cur结点即可。
        return cur;
    }
}

// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/javadai-ma-di-gui-he-fei-di-gui-tu-wen-xiang-jie-b/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor = new TreeNode(0);
        dfs(p, q, root);
        return ancestor;
    }
    public boolean dfs(TreeNode p, TreeNode q, TreeNode root) {
        if(root == null)
            return false;
        boolean sonInLeft = dfs(p, q, root.left);
        boolean sonInRight = dfs(p, q, root.right);
        if((root.val == p.val || root.val == q.val) && (sonInLeft || sonInRight )){
            ancestor = root;
        }
            
        if(sonInLeft && sonInRight){
            ancestor = root;
        }    
        if(root.val == p.val || root.val == q.val)
            return true;
        
        return sonInLeft || sonInRight;
    }
}



class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






// 方法二：存储父节点
// 思路

// 我们可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。

// 算法

// 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
// 从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
// 同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点。

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //记录遍历到的每个节点的父节点。
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    parent.put(root, null);//根节点没有父节点，所以为空
    queue.add(root);
    //直到两个节点都找到为止。
    while (!parent.containsKey(p) || !parent.containsKey(q)) {
        //队列是一边进一边出，这里poll方法是出队，
        TreeNode node = queue.poll();
        if (node.left != null) {
            //左子节点不为空，记录下他的父节点
            parent.put(node.left, node);
            //左子节点不为空，把它加入到队列中
            queue.add(node.left);
        }
        //右节点同上
        if (node.right != null) {
            parent.put(node.right, node);
            queue.add(node.right);
        }
    }
    Set<TreeNode> ancestors = new HashSet<>();
    //记录下p和他的祖先节点，从p节点开始一直到根节点。
    while (p != null) {
        ancestors.add(p);
        p = parent.get(p);
    }
    //查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点……
    while (!ancestors.contains(q))
        q = parent.get(q);
    return q;
}

// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/javadai-ma-di-gui-he-fei-di-gui-tu-wen-xiang-jie-b/
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
    //4.08pm-
    TreeNode ansNode=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        findNode(root,p,q);
        return ansNode;
    }

    public TreeNode findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

      
            if(root==p){
                // System.out.println(">>"+root.val);
                if(isFindNode(root, q)){
                    // System.out.println("ans: "+root.val+q.val);
                    ansNode=p;
                    return p;
                }
            }
            if(root==q){
                if(isFindNode(root,p)){
                    ansNode=q;
                    return q;
                }
            }

  if((isFindNode(root.left,p)||isFindNode(root.right,p))||(isFindNode(root.left,q)||isFindNode(root.right,q))){
            ansNode=root;
            return root;
        }

        if(root.left!=null){
            findNode(root.left, p, q);
        } 

        if(root.right!=null){
            findNode(root.right, p, q);
        } 
        return null;
    }
    public boolean isFindNode(TreeNode root, TreeNode target){
        if(root==null) return false;
        boolean isFind=false;
        // System.out.println(root.val+" "+target.val);
        if(root.val==target.val){
            return true;
        }
       
        if(root.left!=null) {
            isFind=isFindNode(root.left, target);
        }
        if(isFind) return isFind;

        if(root.right!=null){
             isFind=isFindNode(root.right, target);
        } 
 
        return isFind;
    }
}