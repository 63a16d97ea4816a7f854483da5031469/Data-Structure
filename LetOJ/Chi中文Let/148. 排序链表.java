
/*
 * 
link: 
https://leetcode-cn.com/problems/sort-list/

2020-7-16 at 12:07 am

148. 排序链表
难度
中等

627


在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5



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
    //12.07am-12.12am
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        ListNode curr=head;
        while(curr!=null){
            pq.add(curr.val);
            curr=curr.next;
        }
        ListNode newHead=new ListNode(-1);
        ListNode tmpNode=newHead;
        while(!pq.isEmpty()){
            tmpNode.next=new ListNode(pq.poll());
            tmpNode=tmpNode.next;
        }
        return newHead.next;
    }
}





















