
/*
 * 
https://leetcode.com/problems/find-duplicate-subtrees/


652. Find Duplicate Subtrees
Medium

1141

191

Add to List

Share
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.

12 April 2020 at 8:33: pm


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
// https://www.cnblogs.com/Dylan-Java-NYC/p/11049932.html
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        preorder(root, hm, res);
        return res;
    }
    
    private String preorder(TreeNode root, HashMap<String, Integer> hm, List<TreeNode> res){
        if(root == null){
            return "#";
        }
        
        String key = root.val + "," + preorder(root.left, hm, res) + "," + preorder(root.right, hm, res);
        if(hm.containsKey(key) && hm.get(key) == 1){
            res.add(root);
        }
        
        hm.put(key, hm.getOrDefault(key, 0)+1);
        return key;
    }
}




// 速度最快解法：
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
    private Map<Long, TreeNode> map = new HashMap<>();
    private Map<Long, TreeNode> ret = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        search(root);
        for(Map.Entry<Long, TreeNode> entry : ret.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
    
    private long search(TreeNode node){
        if(node == null){
            return 31;
        }
        
        long left = search(node.left);
        long right = search(node.right);
        long val = node.val + 5381;
        long hash = val + val * left + val * left * right;
        if(map.get(hash) == null){
            map.put(hash, node);
        } else {
            if(ret.get(hash) == null){
                ret.put(hash, node);
            }
        }
        
        return hash;
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> count;
    Map<String, Integer> map;
    List<TreeNode> ans;
    int counter = 1;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        map = new HashMap<>();
        ans = new LinkedList<>();
        findInTree(root);
        return ans;
    }
    
    int findInTree(TreeNode node){
        if(node==null){
            return 0;
        }
            String str = node.val + "," + findInTree(node.left) + "," + findInTree(node.right);
            int idx = map.computeIfAbsent(str, x-> counter++);
            count.put(idx , count.getOrDefault(idx, 0) + 1);
                if(count.get(idx) == 2){
                    ans.add(node);
                }
        return idx;
    }
    
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //6.06pm-6.56pm  Wrong WA:
    //收集所有的node到一个list中，然后对这个list进行去除这个node，然后在余下list中搜索这个node，如果搜索到，就对比左子树和右子树
    List<TreeNode> list=new ArrayList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        // for(TreeNode tmp:list){
        //     System.out.print(tmp.val+" ");
        // }
        List<TreeNode> cloneList=new ArrayList<TreeNode>(list);
        List<TreeNode> result=new ArrayList<TreeNode>();
        for(TreeNode tmp:list){
          //remove current element
          cloneList.remove(tmp);
           TreeNode nextNode=findValueEqualIndex(cloneList,tmp.val);
          if(nextNode!=null){
              if(isEqualTree(tmp,nextNode)){
                  if(findValueEqualIndex(result,tmp.val)==null){
                     result.add(tmp); 
                  }
                  cloneList.remove(nextNode);
              }
          }
        } 
        return result;
    }
    TreeNode findValueEqualIndex(List<TreeNode> list, int val){
        for(int i=0;i<list.size();i++){
            if(list.get(i).val==val){
                return list.get(i);
            }
        }
        return null;
    }
    boolean isEqualTree(TreeNode treeA, TreeNode treeB){
        //left equals
        boolean isLeft=false;
        if((treeA.left!=null && treeB.left!=null) && treeA.left.val==treeB.left.val) {
            isLeft=true;
        }else if(treeA.left==null && treeB.left==null){
            isLeft=true;
        }
        //right equals
        boolean isRight=false;
        if((treeA.right!=null && treeB.right!=null) && treeA.right.val==treeB.right.val) {
            isRight=true;
        }else if(treeA.right==null && treeB.right==null){
            isRight=true;
        }
        return isLeft&&isRight;
    }
    void dfs(TreeNode root){
        if(root==null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
