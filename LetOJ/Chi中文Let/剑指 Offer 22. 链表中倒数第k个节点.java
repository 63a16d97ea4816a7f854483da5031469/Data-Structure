
/*
 * 
link: 


2020-8-7 at 8:47 am

剑指 Offer 22. 链表中倒数第k个节点
难度
简单

69


输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.


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
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //8.47am-8.50am
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr=head;
        for(int i=0;i<k-1;i++){
            curr=curr.next;
        }
        ListNode another=head;
        while(curr!=null&&curr.next!=null){
            curr=curr.next;
            another=another.next;
        }
        return another;
    }
}




















