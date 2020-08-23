
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre==null || pre.length==0) {
            return null;
        }
        return dfs(pre,post);
    }
	
    private TreeNode dfs(int[] pre,int[] post) {
        if(pre==null || pre.length==0) {
            return null;
        }
        //数组长度为1时，直接返回即可
        if(pre.length==1) {
            return new TreeNode(pre[0]);
        }
        //根据前序数组的第一个元素，创建根节点 
        TreeNode root = new TreeNode(pre[0]);
        int n = pre.length;
        for(int i=0;i<post.length;++i) {
            if(pre[1]==post[i]) {
                //根据前序数组第二个元素，确定后序数组左子树范围
                int left_count = i+1;
                //拆分前序和后序数组，分成四份
                int[] pre_left = Arrays.copyOfRange(pre,1,left_count+1);
                int[] pre_right = Arrays.copyOfRange(pre,left_count+1,n);
                int[] post_left = Arrays.copyOfRange(post,0,left_count);
                int[] post_right = Arrays.copyOfRange(post,left_count,n-1);
                //递归执行前序数组左边、后序数组左边
                root.left = dfs(pre_left,post_left);
                //递归执行前序数组右边、后序数组右边
                root.right = dfs(pre_right,post_right);
                break;
            }
        }
        //返回根节点
        return root;
    }
}	

// 作者：wang_ni_ma
// 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/tu-jie-889-gen-ju-qian-xu-he-hou-xu-bian-li-gou-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















