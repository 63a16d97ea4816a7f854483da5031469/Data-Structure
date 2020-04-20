
/*
 * 
https://leetcode.com/problems/copy-list-with-random-pointer/


138. Copy List with Random Pointer
Medium

2755

610

Add to List

Share
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.
 

Constraints:

-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
Number of Nodes will not exceed 1000.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

HashMap的巧妙运用，可以节省不少力气，而且非常有效。


 * 
 */


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

早上看的题解，然后晚上，现在复现出来了：

class Solution {
    //9.36pm-9.43pm
    public Node copyRandomList(Node head) {
        
        if(head==null) return null;
        
        HashMap<Node,Node> map=new HashMap<Node,Node>();
        
        Node curr=head;
        
        while(curr!=null){
            map.put(curr, new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        
        return map.get(head);
    }
}
















