
/*
 * 
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

82. Remove Duplicates from Sorted List II
Medium

2689

122

Add to List

Share
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.


21 Feb 2021 at 16:36


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node 
        // before the sublist of duplicates
        ListNode pred = sentinel;
        
        while (head != null) {
            // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }
                // skip all duplicates
                pred.next = head.next;     
            // otherwise, move predecessor
            } else {
                pred = pred.next;    
            }
                
            // move forward
            head = head.next;    
        }  
        return sentinel.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode listLastNode=dummyHead;
        while(head!=null){
            if(head.next!=null&& head.val==head.next.val){
                 while(head.next!=null&& head.val==head.next.val){
                    head=head.next;
                 }
                listLastNode.next=head.next;
            }else{
              listLastNode=listLastNode.next;  
            }
           head=head.next;
        }
        return dummyHead.next;
    }
}





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 三指针
        // 0 1 2 3 3 4 4 5
        //     r
        //             p c
        // 1. 如果cur node的前后node都不一样, 则将real -> c, 并同时移动prev, cur
        //    否则只移动prev, cur
        // 2. 
        
        ListNode dummy = new ListNode(0);
        ListNode real = dummy;
        ListNode prev = dummy;
        ListNode cur = head;
        
        while(cur != null) {
            // 比较curNode前后两个node
            if((prev == dummy || prev.val != cur.val) && (cur.next == null || cur.val != cur.next.val)) {
                real.next = cur;
                real = real.next;
            }
            
            prev = cur;
            cur = cur.next;
            // 每次prev要先断开
            prev.next = null;
        }
        
        return dummy.next;
    }
}









