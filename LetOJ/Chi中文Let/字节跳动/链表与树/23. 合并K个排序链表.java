
/*
 * 
link: 
https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1025/

2020-7-19 at 11:56 am

23. 合并K个排序链表
难度
困难

795

收藏

分享
切换为英文
关注
反馈
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6


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
    //11.24am-11.52pm
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null; // []
        List<ListNode> ori=Arrays.asList(lists);
        ArrayList<ListNode> realList=new ArrayList<>(ori);

        while(realList.size()>1){
            int left=0;
            int right=realList.size()-1;
            int mid=(left+right)/2;
            realList.set(mid,merge(realList.get(mid),realList.get(mid+1)));
            ListNode deleted=realList.get(mid+1);
            realList.remove(deleted);
        }
        return realList.get(0);
    }

    public ListNode merge(ListNode l1, ListNode l2){
       
        if(l1==null) return l2;  //[[],[1]]
        if(l2==null) return l1;
        ListNode head=new ListNode(-1);
        ListNode returnNode=head;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null){
            head.next=l1;
        }
        if(l2!=null){
            head.next=l2;
        }

        return returnNode.next;
    }
}



















