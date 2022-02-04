
/*
 * 
link: https://leetcode-cn.com/problems/reorder-list/

143. 重排链表
难度
中等

783

收藏

分享
切换为英文
接收动态
反馈
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例 1：



输入：head = [1,2,3,4]
输出：[1,4,2,3]
示例 2：



输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3]
 

提示：

链表的长度范围为 [1, 5 * 104]
1 <= node.val <= 1000

2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        LinkedList<ListNode> list=new LinkedList<ListNode>();
        ListNode tmp=head;
        while(tmp!=null){
            list.add(tmp);
            tmp=tmp.next;
        }
         ListNode left=null;
         ListNode right=null;
         ListNode lastRight=null;
        while(list.size()>=2){
            left=list.removeFirst();
            right=list.removeLast();
            left.next=right;

            if(lastRight!=null){
                lastRight.next=left;
            }
            lastRight=right;
        }
        if(list.size()>0){
            ListNode lastNode=list.removeFirst();;
            lastRight.next=lastNode;
            lastNode.next=null;
        }else{
            right.next=null;
        }
       
    }
}



















