
/*
 * 
https://leetcode.com/problems/odd-even-linked-list/

328. Odd Even Linked List
Medium

1518

280

Add to List

Share
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...

16 May 2020 at 9:01 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :





 * 
 */










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
    //8.42pm-8.59pm AC
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode curr=head;
        
        ListNode oddHead=head;
        ListNode evenHead=head.next;
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null&&slow.next!=null){
            ListNode tmp=fast;
            fast=slow.next.next;
            slow=slow.next;
            if(fast!=null){
                slow.next=fast.next;
            }
            tmp.next=fast;
        }
        while(oddHead!=null&&oddHead.next!=null){
            oddHead=oddHead.next;
        }
        oddHead.next=evenHead;
        
        return head;
    }
}















