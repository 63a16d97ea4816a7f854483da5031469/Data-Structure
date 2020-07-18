
/*
 * 
link: 


2020-7-14 at 11:50 pm

206. 反转链表
难度
简单

1091





反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

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
    //11.42pm-11.50pm
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        
        ListNode pre=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //11.51pm-12.03pm
    ListNode finalNode=null;
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        reverse(head);
        head.next=null;
        return finalNode;
    }

    public ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }

        ListNode prev=head;
        ListNode returned=reverse(head.next);
        if(returned!=null){
            returned.next=prev;
        }else{
            finalNode=prev;
        }
        return head;
    }
}














