
/*
 * 
https://leetcode.com/problems/rotate-list/


Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

28 March 2020 at //10.47pm - 11.04pm (17 minutes)
 * 
 */






以下是一个偷懒的写法，我是用额外的空间，转换成了别的arr的rotate：

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//10.47pm - 11.04pm (17 minutes)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        
        if(head.next==null) return head;
            
         // use the extra space.
        
        ListNode curr=head;
        
        List<Integer> list=new ArrayList<Integer>();
        
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        
        //to get the rotated list
        
        int n=list.size();
        
        int[] arr=new int[n];
    
        for(int i=0;i<list.size();i++){
           arr[(i+k)%n]=list.get(i);
        }
        
        curr=head;
        
        for(int i=0;i<arr.length;i++){
            curr.val=arr[i];
            curr=curr.next;
        }
        
        
        return head;
        
    }
}



















