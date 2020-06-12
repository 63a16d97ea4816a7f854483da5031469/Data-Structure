
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


23. Merge k Sorted Lists
Hard

4009

258

Add to List

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

6 April 2020 at   //22.52pm-11.01pm
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
    //22.52pm-11.01pm
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode preHead=new ListNode(-1);
        
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
               return  a.val-b.val;
            }
        });
        
        for(ListNode head:lists){
            while(head!=null){
                pq.add(head);
                head=head.next;
            }
        }
        
        ListNode curr=preHead;
        
        while(!pq.isEmpty()){
               curr.next=new ListNode(pq.poll().val);
               curr=curr.next;
        }
        
        return preHead.next;
    }
}


归并排序：

解法一：基于“二分”思想的归并排序

     初见之下，最容易想到的方法是“归并排序”（Merging Sort）：将两个或两个以上的有序表组合成一个新的有序表，无论是顺序存储结构还是链式存储结构，对于任何两个长度分别为m和n的有序表，其组合都可在O(m+n)的时间复杂度量级上完成。对于K个有序表，假设共有N个元素，且这些有序表初始状态都不为空，每个有序表平均拥有N/K个元素。最常用的方法是采用“二分”的思想进行两两合并：第一轮循环，有序表lists[0]与lists[(K+1)/2]，lists[1]与lists[(K+1)/2+1]，lists[2]与lists[(K+1)/2+2]....，lists[K/2-1]与lists[K-1]。这样K个有序表就被组合成了K/2个有序表；第二轮循环后将减少为K/4个有序表；直到组合成一个具有N个元素的有序表。总的时间复杂度：O(NKlogK)。
————————————————
版权声明：本文为CSDN博主「Jin_Kwok」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Jin_Kwok/article/details/51582176


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
     
    public ListNode mergeKLists(ListNode[] lists)
        {
            int len=lists.length;
            
            if(lists==null||len==0)
                return null;
            if(len==1)
                return lists[0];
            
            while(len>1)//基于“二分”思想进行链表的两两组合
            {
                int mid=(len+1)/2;//二分
                for(int i=0;i<len/2;i++)
                {
                    lists[i]=mergeTwoLists(lists[i],lists[i+mid]);
                }
                len=mid;
            }
            return lists[0];
        }
        //有序链表的组合，L1和L2为头结点，归并排序的核心思想
        public ListNode mergeTwoLists(ListNode L1,ListNode L2)
        {
            if(L1==null)return L2;
            if(L2==null)return L1;
            
            ListNode head=new ListNode(0);//保存结果的链表，头结点初始化
            ListNode phead=head;
            
            while(L1!=null&&L2!=null)//两个链表归并排序
            {
                if(L1.val <=L2.val)
                {
                    phead.next=L1;//接入结果链表
                    phead=phead.next;//移动指针
                    L1=L1.next;
                }
                else
                {
                    phead.next=L2;
                    phead=phead.next;
                    L2=L2.next;
                }
            }
            if(L1!=null)
                phead.next=L1;
            else
                phead.next=L2;
            
            return head.next;//初始化的第一个节点不属于结果
        }
    }
    // ————————————————
    // 版权声明：本文为CSDN博主「Jin_Kwok」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    // 原文链接：https://blog.csdn.net/Jin_Kwok/article/details/51582176















