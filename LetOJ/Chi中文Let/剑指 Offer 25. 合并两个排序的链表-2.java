
/*
 * 
link: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/


2022-02-04 at 23:33 am

剑指 Offer 25. 合并两个排序的链表
难度
简单

38

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/




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
    //8.56am-8.58am
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(-1);
        ListNode newHead=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                dummyHead.next=l2;
                l2=l2.next;
                dummyHead=dummyHead.next;
            }else{
                dummyHead.next=l1;
                l1=l1.next;
                dummyHead=dummyHead.next;
            }
        }
            while(l1!=null)
                dummyHead.next=l1;
            if(l2!=null)
                dummyHead.next=l2;
            return newHead.next;
    }
}



class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;

        while(l1!=null&&l2!=null){
            dummy.next=l1.val<=l2.val?l1:l2;
            dummy=dummy.next;
            if(l1.val<=l2.val){
                l1=l1.next;
            }else{
                l2=l2.next;
            }
        }
        while(l1!=null){
            dummy.next=l1;
            l1=l1.next;
            dummy=dummy.next;
        }
        while(l2!=null){
            dummy.next=l2;
            l2=l2.next;
            dummy=dummy.next;
        }
        return head.next;
    }
}














