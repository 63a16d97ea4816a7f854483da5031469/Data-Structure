
/*
 * 
https://leetcode.com/problems/sort-list/

148. Sort List
Medium

2319

118

Add to List

Share
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

12 April 2020 at 8.39pm-8.45pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

对nlogn比较敏感，可以一下子理解是什么数据结构。但是这个题目是constant space，就不能使用min heap，只能使用分治法。


 * 
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 AC:

class Solution {
    //8.39pm-8.45pm
    public ListNode sortList(ListNode head) {
        
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
        });
        
        ListNode curr=head;
        
        while(curr!=null){
            queue.add(curr);
            curr=curr.next;
        }
        
       
        curr=new ListNode(-1);
        ListNode newHead=curr;
        while(!queue.isEmpty()){
            curr.next=queue.poll();
            curr=curr.next;
        }
        curr.next=null;
        
        
        return newHead.next;
    }
}






题解中的最佳，最快solution：

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode node = low;
        low = low.next;
        node.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(low);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    } 
}











