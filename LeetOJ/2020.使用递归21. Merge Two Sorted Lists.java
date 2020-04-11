
/*
 * 
https://leetcode.com/problems/merge-two-sorted-lists/


21. Merge Two Sorted Lists
Easy

3602

537

Add to List

Share
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


11 April 2020 at 5.02 pm
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
class Solution {
    // ListNode list=new ListNode(-1);
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     
        return merge(l1,l2);
    }
    
    ListNode merge(ListNode node1, ListNode node2){
         if(node1==null){
            return node2;
        }else if(node2==null){
            return node1;
        }
        
        ListNode selected=node1;
 
        if(node1.val<node2.val){
            selected=node1;
            node1.next=merge(node1.next, node2);
     
        }else{
            selected=node2;
            node2.next=merge(node1,node2.next);
        }
        return selected;
    }
}



















