
/*
 * 
link: 


2020-8-7 at 8:54 am

剑指 Offer 24. 反转链表
难度
简单

77


定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000

 

注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/



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
    //8.51am-8.53am
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null&&curr.next!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        curr.next=pre;
        return curr;
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
    ListNode newHead=null;
    public ListNode reverseList(ListNode head) {
        findNext(head);
        // 切断之前的最初的head与下一个节点的联系, 如果head==null，就不用切了
        if(head!=null){
            head.next=null;
        }
        return newHead;
    }
    public ListNode findNext(ListNode curr){
        ListNode saved=curr;
        ListNode returned=null;
        if(curr!=null){
            returned=findNext(curr.next);    
        }else{
            return null;
        }
        if(curr.next==null){
            // 这个是新的开始点
            newHead=saved;
        }else{
            returned.next=saved;
        }
        return saved;
    }

}

















