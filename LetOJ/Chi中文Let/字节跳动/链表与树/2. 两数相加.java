
/*
 * 
link: 
https://leetcode-cn.com/problems/add-two-numbers/

2020-7-16 at 12:05 am

2. 两数相加
难度
中等

4600



给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807



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
    //11.53pm-12.05pm
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=new ListNode(-1);
        ListNode newlist=head;
        int carry=0;
        while(l1!=null&&l2!=null){
            int curr=l1.val+l2.val;
            curr+=carry;
            carry=curr/10;
            curr=curr%10;
            newlist.next=new ListNode(curr);
            newlist=newlist.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int curr=l1.val;
            curr+=carry;
            carry=curr/10;
            curr=curr%10;
            newlist.next=new ListNode(curr);
            newlist=newlist.next;
            l1=l1.next;
        }
        while(l2!=null){
            int curr=l2.val;
            curr+=carry;
            carry=curr/10;
            curr=curr%10;
            newlist.next=new ListNode(curr);
            newlist=newlist.next;
            l2=l2.next;
        }
        if(carry!=0){
            newlist.next=new ListNode(carry);
        }
        return head.next;
    }
}















