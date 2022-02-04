
/*
 * 
link: 
https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

2022-03-04 at 23:06

剑指 Offer 06. 从尾到头打印链表
难度
简单

112

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000

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
 // 11.34pm-11.39pm
 class Solution {
    List<Integer> result=new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[]{};
        }
        reverse(head);
        int[] arr=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;
    }   

    public void reverse(ListNode node){
        ListNode curr=node;
        if(node!=null){
            reverse(node.next);
            result.add(curr.val);
        }else{
            if(curr!=null)  //易于忘记
            result.add(curr.val);
        }
    }
}




class Solution {
    List<Integer> result=new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[]{};
        reverse(head);
        result.add(head.val);
        int[] arr=new int[result.size()];
        int index=0;
        for(int tmp:result){
            arr[index++]=tmp;
        }
        return arr;
    }
    public ListNode reverse(ListNode head){
        if(head==null) return null;

        ListNode saved=head;

        ListNode returned=reverse(head.next);
        if(returned!=null){
            result.add(returned.val);
        }
       return saved;
    }
}










