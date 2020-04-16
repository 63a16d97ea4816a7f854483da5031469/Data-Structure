
/*
 * 
https://leetcode.com/problems/path-sum-iii/

437. Path Sum III
Easy

2937

229

Add to List

Share
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:

求一个树的最大path sum，就是求，这个子树，root+左子树+右子树 的结果

然后这个左子树和右子树，又可以套用到其root这个节点的这个模式。

所以这个是一个标准递归问题。


从这道题目学到了什么，哪些地方需要提升? :
思路不够清晰，对递归理解不够清晰。



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

//1.01pm-2.10pm
//6.31pm-6.50pm
class Solution {
    
    public int pathSum(TreeNode root, int sum) {
        
       if(root==null) return 0;
        
       return dfs(root,sum)+dfs(root.left, sum)+dfs(root.right,sum);
    }
    
    int dfs(TreeNode root, int sum){
        
        int num=0; 
        
        if(root==null) return 0;
        
        if(sum==root.val){
            num++;
        }
        
         num+=dfs(root.left, sum-root.val);
       
         num+=dfs(root.right, sum-root.val);
        
        return num;
        
    }
     
}


WA:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//1.01pm-2.10pm
//6.31pm-
class Solution {
    
    public int pathSum(TreeNode root, int sum) {
        
        dfs(root, sum);
 
       return dfs(root,sum)+dfs(root.left, sum)+dfs(root.right,sum);
    }
    
    int dfs(TreeNode root, int sum){
        
        int num=0;
        
        if(sum==0){
            num++;
            return num;
        }
        
        if(root==null) return 0;
        
         int left=dfs(root.left, sum-root.val);
       
         int right=dfs(root.right, sum-root.val);
        
        return left+right;
        
    }
     
}



WA:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//1.01pm-2.10pm
class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int sum) {
        // if(sum==0) return 0;
        
        dfs(root, sum);
        
        for(List<Integer> tmp:result){
            for(int i=0;i<tmp.size();i++){
                System.out.print(tmp.get(i)+" ");
            }
            System.out.println();
        }
       return result.size();
    }
    
    void dfs(TreeNode root, int sum){
        
        if(root==null) return;
        
        sumdfs(root, sum,0,new ArrayList<Integer>());
        
        if(root.left!=null){
            sumdfs(root.left, sum,0,new ArrayList<Integer>());
        }
              
        if(root.right!=null){
            sumdfs(root.right, sum,0,new ArrayList<Integer>());
        }
    }
    
    void sumdfs(TreeNode root, int sum,int tmpSum, List<Integer> list){
        
         
        
        if(root==null) return;
        // if(root.left==null && root.right==null) {
        //     list=new ArrayList<Integer>();
        //     return;
        // }
        
        // if(root.val>sum) return;
        
     System.out.print(root.val+" ["+tmpSum+"]  ");
        list.add(root.val);
        
                   if(tmpSum+root.val==sum&&list.size()!=0){
            // System.out.println("***");
            // Collections.sort(list);
            // if(!result.contains(list)){
                result.add(new ArrayList<Integer>(list));
            // }
            // list=new ArrayList<Integer>();
                       list.remove(list.size()-1);
                       return;
        }
         
  
            sumdfs(root.left,sum,root.val+tmpSum,list);
            // list.remove(new Integer(root.val));
    
 
            sumdfs(root.right,sum,root.val+tmpSum, list);
            // list.remove(new Integer(root.val));
    }
}






















WA:

不能过这个case:


[0,1,1]
1


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//1.01pm-
class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int sum) {
        if(sum==0) return 0;
        
        dfs(root, sum);
        
        // for(List<Integer> tmp:result){
        //     for(int i=0;i<tmp.size();i++){
        //         System.out.print(tmp.get(i)+" ");
        //     }
        //     System.out.println();
        // }
       return result.size();
    }
    
    void dfs(TreeNode root, int sum){
        
        if(root==null) return;
        
        sumdfs(root, sum,0,new ArrayList<Integer>());
        
        if(root.left!=null){
            sumdfs(root.left, sum,0,new ArrayList<Integer>());
        }
              
        if(root.right!=null){
            sumdfs(root.right, sum,0,new ArrayList<Integer>());
        }
    }
    
    void sumdfs(TreeNode root, int sum,int tmpSum, List<Integer> list){
        
           if(tmpSum==sum){
            // System.out.println("***");
            Collections.sort(list);
            if(!result.contains(list)){
                result.add(new ArrayList<Integer>(list));
            }
            list=new ArrayList<Integer>();
        }
        
        if(root==null) return;
        
        // if(root.val>sum) return;
        
     // System.out.print(root.val+" ["+tmpSum+"]  ");
        list.add(root.val);
         
  
            sumdfs(root.left,sum,root.val+tmpSum,list);
    
 
            sumdfs(root.right,sum,root.val+tmpSum, list);
   
      
        
    }
}





WA:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//1.01pm-
class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        
        // for(List<Integer> tmp:result){
        //     for(int i=0;i<tmp.size();i++){
        //         System.out.print(tmp.get(i)+" ");
        //     }
        //     System.out.println();
        // }
       return result.size();
    }
    
    void dfs(TreeNode root, int sum){
        
        if(root==null) return;
        
        sumdfs(root, sum,0,new ArrayList<Integer>());
        
        if(root.left!=null){
            sumdfs(root.left, sum,0,new ArrayList<Integer>());
        }
              
        if(root.right!=null){
            sumdfs(root.right, sum,0,new ArrayList<Integer>());
        }
    }
    
    void sumdfs(TreeNode root, int sum,int tmpSum, List<Integer> list){
        
        if(root==null) return;
        
        // if(root.val>sum) return;
        
     System.out.print(root.val+" ["+tmpSum+"]  ");
        list.add(root.val);
        
        if(tmpSum==sum){
            System.out.println("***");
            Collections.sort(list);
            if(!result.contains(list)){
                result.add(new ArrayList<Integer>(list));
            }
            list=new ArrayList<Integer>();
        }

        
        if(root.left!=null){
            sumdfs(root.left,sum,root.val+tmpSum,list);
        }
        if(root.right!=null){
            sumdfs(root.right,sum,root.val+tmpSum, list);
        }
      
        
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//1.01pm-
class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        
        // for(List<Integer> tmp:result){
        //     for(int i=0;i<tmp.size();i++){
        //         System.out.print(tmp.get(i)+" ");
        //     }
        //     System.out.println();
        // }
       return result.size();
    }
    
    void dfs(TreeNode root, int sum){
        
        if(root==null) return;
        
        sumdfs(root, sum,0,new ArrayList<Integer>());
        
        if(root.left!=null){
            sumdfs(root.left, sum,0,new ArrayList<Integer>());
        }
              
        if(root.right!=null){
            sumdfs(root.right, sum,0,new ArrayList<Integer>());
        }
    }
    
    void sumdfs(TreeNode root, int sum,int tmpSum, List<Integer> list){
        
        if(root==null) return;
        
        // if(root.val>sum) return;
        

        
        if(tmpSum==sum){
            System.out.println("***");
            Collections.sort(list);
            if(!result.contains(list)){
                result.add(new ArrayList<Integer>(list));
            }
            list=new ArrayList<Integer>();
        }

             System.out.print(root.val+" ["+tmpSum+"]  ");
        list.add(root.val);
        
        if(root.left!=null){
            sumdfs(root.left,sum,root.val+tmpSum,list);
        }
        if(root.right!=null){
            sumdfs(root.right,sum,root.val+tmpSum, list);
        }
      
        
    }
}











