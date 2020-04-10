
/*
 * 
https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/2378/


Reverse Linked List
Solution
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

10 April 2020 at 2.21 pm
 * 
 */


正确的结果:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode newHead=null;
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        
        ListNode copyHead=head;
        
  
        ListNode firstNode=reverseNode(head);
        
        firstNode.next=null;
    
        return newHead;
    }
    
    ListNode reverseNode(ListNode head){
        
        if(head.next==null){
            
            newHead=head;
            return head;
        }
        
        ListNode curr=head;
        ListNode nextEle=reverseNode(head.next);
        nextEle.next=curr;
        return curr;
        
    }
}







 错误结果：

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        
        ListNode copyHead=head;
        
        ListNode newHead=head;
        ListNode firstNode=reverseNode(head, newHead);
        
        firstNode.next=null;
    
        return newHead;
    }
    
    ListNode reverseNode(ListNode head, ListNode finalHead){
        

        if(head.next==null){
            
            finalHead=head;
            return head;
        }
        
        ListNode curr=head;
        ListNode nextEle=reverseNode(head.next,finalHead);
        
        nextEle.next=curr;
        
        if(nextEle!=null && nextEle.next==null){
            
        }
        
        return curr;
        
    }
}

Run Code Status: Finished
×
Run Code Result:
Your input
[1,2,3,4,5]
Your answer
[1]
Expected answer
[5,4,3,2,1]
















