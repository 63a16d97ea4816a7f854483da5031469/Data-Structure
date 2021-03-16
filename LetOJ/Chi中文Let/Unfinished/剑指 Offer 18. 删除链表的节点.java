
/*
 * 
link: 
https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/

2021-3-16 at 10:51 pm

剑指 Offer 18. 删除链表的节点

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

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
    //10.53pm-10.59pm
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==val){
                if(prev==null) { // 删除的是头结点
                    head=curr.next;
                }else{
                    //删除当前节点
                    prev.next=curr.next;
                }
            }
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}

















