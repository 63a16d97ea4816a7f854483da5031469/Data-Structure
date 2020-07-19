
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



//  最快solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeLists(ListNode root1,ListNode root2){
        ListNode dummyHead=new ListNode(0);
        ListNode curnode=dummyHead;
        while(root1!=null&&root2!=null){
            if(root1.val>root2.val){
                curnode.next=root2;
                root2=root2.next;
                curnode=curnode.next;
            }
            else{
                curnode.next=root1;
                root1=root1.next;
                curnode=curnode.next;
            }
        }
        curnode.next=root2==null?root1:root2;
        return dummyHead.next;
    }
    public ListNode mergeKLists(ListNode[] lists,int lo,int hi){
        if(lo==hi) return lists[lo];
        if(lo+1==hi) return mergeLists(lists[lo],lists[hi]);
        int mid=lo+(hi-lo)/2;
        return mergeLists(mergeKLists(lists,lo,mid),mergeKLists(lists,mid+1,hi));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        return mergeKLists(lists,0,lists.length-1);
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





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = merge2Lists(res, list);
        }
        return res;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}













