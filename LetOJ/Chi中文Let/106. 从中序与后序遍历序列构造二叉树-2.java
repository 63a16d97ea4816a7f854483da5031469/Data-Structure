
/*
 * 
link: 
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

2022-02-06 at 23:28


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



class Solution {
    int index=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        return build(inorder,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end){
        if(index<0) return null;
        if(start>end) return null;

        TreeNode root=new TreeNode(postorder[index--]);
        int point=findIndex(inorder,root.val);
        //注意要 Right在前，因为postorder遍历的顺序是这样的:
        root.right=build(inorder,postorder,point+1,end);
        root.left=build(inorder,postorder,start,point-1);
        return root;
    }

    public int findIndex(int[] inorder, int target){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return -1;
    }
}







class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        
        return helper(0, inorder.length - 1);
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-14/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        for(int i=0;i<inorder.length;i++){
            idx_map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length - 1);
    }
}









class Solution {
    int index=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left>right) return null;
        if(index<0) return null;

        TreeNode root=new TreeNode(postorder[index]);
        index--;
        int position=map.get(root.val);
        // 易错：后序遍历  ===》 左子树父节点，右子树父节点，父节点 9(左) 15（左）7（右）20（右） 3（父）
        root.right=build(inorder,postorder,position+1,right);
        root.left=build(inorder,postorder,left,position-1);
        return root;
    }
}

