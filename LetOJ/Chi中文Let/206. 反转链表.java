
/*
 * 
link: https://leetcode-cn.com/problems/reverse-linked-list/

206. 反转链表
难度
简单

2237

收藏

分享
切换为英文
接收动态
反馈
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 

示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]
 

提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000
 

进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？


2022-01-17 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




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
    public ListNode reverseList(ListNode head) {
        // 空节点或者只有一个节点
        if(head==null || head.next==null) return head;

        ListNode pre=null;
        ListNode curr=head;
        ListNode next=head.next;

        while(curr!=null&&curr.next!=null){
            curr.next=pre;
            pre=curr;
            curr=next;
            next=next.next;
        }
        //链接一下最后一个节点，与其前面的节点（这个时候curr.next==null)
        curr.next=pre;
        return curr;
    }
}



class Solution {
    ListNode newHead=null;
    public ListNode reverseList(ListNode head) {
        // 极限情况,空节点，或者只有一个节点
        if(head==null||head.next==null) return head;

        reverse(head);
        head.next=null;
        return newHead;
    }
    public ListNode reverse(ListNode node){
        if(node==null) return null;

        //进入递归前，存下来当前变量
        ListNode saved=node;
        
        //到下一层
        ListNode returned=reverse(node.next);

        if(returned==null){
            //这就是最后一个节点
            newHead=node;
            return node;
        }
        returned.next=saved;
        return node;
    }
}



















