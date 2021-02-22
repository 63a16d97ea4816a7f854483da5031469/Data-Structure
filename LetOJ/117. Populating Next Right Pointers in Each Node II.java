
/*
 * 
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

117. Populating Next Right Pointers in Each Node II
Medium

2271

196

Add to List

Share
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100


12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */







class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        
        Queue<Node> que=new LinkedList<Node>();
        que.add(root);
        que.add(new Node(-9999));
        Node linkRightNode=null;
        while(!que.isEmpty()){
            Node elem=que.poll();
            if(elem.val==-9999){
                if(!que.isEmpty()){
                    que.add(new Node(-9999));
                    linkRightNode=null;
                }
            }else{
                if(linkRightNode!=null) {
                    linkRightNode.next=elem;
                }
                if(elem.left!=null){
                    que.add(elem.left);
                }
                if(elem.right!=null){
                    que.add(elem.right);
                }
                linkRightNode=elem;
            }
        }
        return root;
    }
}














// 未完成的代码：

// Wrong Answer
// Runtime: 0 ms
// Your input
// [1,2,3,4,5,null,7]
// Output
// [1,#,2,#,4,#]
// Diff
// Expected
// [1,#,2,3,#,4,5,7,#]

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> que=new LinkedList<Node>();
        que.add(root);
        que.add(new Node(-9999));
        Node linkRightNode=null;
        while(!que.isEmpty()){
            Node elem=que.poll();
            
            if(elem.val==-9999){
                if(!que.isEmpty()){
                    que.add(new Node(-9999));
                    if(linkRightNode!=null){
                        linkRightNode.right=null;
                    }
                    linkRightNode=null;
                }
            }else{
                if(linkRightNode!=null) {
                    linkRightNode.right=elem;
                }
                linkRightNode=elem;
                
                if(elem.left!=null){
                    que.add(elem.left);
                }
                if(elem.right!=null){
                    que.add(elem.right);
                }
            }
        }
        return root;
    }
}