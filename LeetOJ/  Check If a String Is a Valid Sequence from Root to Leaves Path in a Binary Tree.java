
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


  Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

 

Example 1:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0
Example 2:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
Example 3:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 

Constraints:

1 <= arr.length <= 5000
0 <= arr[i] <= 9
Each node's value is between [0 - 9].

12 April 2020 at 12.36am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


AC:

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
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(arr.length==0) return true;
        dfs(root, new ArrayList<Integer>());
            for(List<Integer> tmpList:result){
                for(int tmp:tmpList){
                    System.out.print(tmp+" ");
                }
            System.out.println();
            }
        for(List<Integer> tmpList:result){
            if(tmpList.size()==arr.length){
                boolean findDiff=false;
                for(int i=0;i<arr.length;i++){
                  if(arr[i]!=tmpList.get(i)){
                        findDiff=true;
                        break;
                  }
                }
                if(!findDiff){
                    return true;
                }
            } 
        }
        return false;
    }
    void dfs(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);//切记不能放下面
        if(root.left==null & root.right==null){
            //reach to the leaf
            result.add(new ArrayList<Integer>(list));
            return; // 切记不能忘记
        }
        if(root.left!=null){  //必须加这个条件
             dfs(root.left, list);
                list.remove(list.size()-1);
        }
       if(root.right!=null){ //必须加这个条件
                   dfs(root.right, list);
                list.remove(list.size()-1);
       }
    }
}











