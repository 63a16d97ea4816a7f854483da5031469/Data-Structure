
/*
 * 
link: https://leetcode-cn.com/problems/merge-two-sorted-lists/


21. 合并两个有序链表
难度
简单

2158

收藏

分享
切换为英文
接收动态
反馈
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]
 

提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列



2022-01-23 at 14:10
 

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(-1);
        ListNode head=result;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                result.next=new ListNode(list1.val);
                list1=list1.next;
                result=result.next;
            }else{
                result.next=new ListNode(list2.val);
                list2=list2.next;
                result=result.next;
            }
        }
        while(list1!=null){
            result.next=new ListNode(list1.val);
            list1=list1.next;
            result=result.next;
        }
        while(list2!=null){
            result.next=new ListNode(list2.val);
            list2=list2.next;
            result=result.next;
        }
    return head.next;
    }
}





















