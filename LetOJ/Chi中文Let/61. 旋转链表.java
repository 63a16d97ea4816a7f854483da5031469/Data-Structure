
/*
 * 
link: https://leetcode-cn.com/problems/rotate-list/

61. 旋转链表
难度
中等

709

收藏

分享
切换为英文
接收动态
反馈
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

 

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]
 

提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109



2022-01-23 at 18:36
 

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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp=head;
        List<Integer> list=new ArrayList<Integer>();
        while(tmp!=null){
            list.add(tmp.val);
            tmp=tmp.next;
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        for(int i=0;i<arr.length;i++){
            arr[(i+k)%arr.length]=list.get(i);
        }
        ListNode second=head;
        int index=0;
        while(second!=null){
            second.val=arr[index++];
            second=second.next;
        }
        return head;
    }
}


















