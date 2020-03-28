
/*
 * 
 1022. Sum of Root To Leaf Binary Numbers
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/


1022. Sum of Root To Leaf Binary Numbers
Easy

350

66

Add to List

Share
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

 

Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.




27 March 2020 at 12:00:31 pm
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
//11.56pm - 12.32pm
class Solution {
    
    int sum=0;
    
    public int sumRootToLeaf(TreeNode root) {
        
         dfs(root,new ArrayList<String>());
        
        return sum;
    }
    
    
    void dfs(TreeNode root, List<String> s){
        if(root==null) return;
        
        s.add(root.val+"");
        
        if(root.left==null && root.right==null){
            //find the leaf
            
            sum+=getValue(s);  
            return;
        }
        

        
        if(root.left!=null){
            dfs(root.left, s);
            s.remove(s.size()-1);
        }
        
        if(root.right!=null){
            dfs(root.right, s);
            s.remove(s.size()-1);
        }
    }
    
    int getValue(List<String> list){
    
        int count=0;
        int n=0;
        
       for(int i=list.size()-1;i>=0;i--){
           int tmp=Integer.parseInt(list.get(i));
            // n+=tmp*(2^count);
            n += tmp * (Math.pow(2,count));
            count++;
        }
        
        return n;
        
    }
     
}




















