
/*
 * 
link: https://leetcode-cn.com/problems/reverse-linked-list-ii/

92. 反转链表 II
难度
中等

1136

收藏

分享
切换为英文
接收动态
反馈
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 

示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]
 

提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

进阶： 你可以使用一趟扫描完成反转吗？


2022-01-24 at 20:09
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



有错误：
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        boolean isStart=false;
        boolean isEnd=false;
        ListNode preStartNode=null;
        ListNode startNode=head;
        ListNode nextEndNode=null;
        ListNode endNode=head;

        ListNode reverseHead;
        while(curr!=null&&curr.next!=null){
            if(!isStart&&curr.val==left){
                isStart=true;
                preStartNode=prev;
                startNode=curr;
            }
            if(!isEnd&&curr.val==right){
                isEnd=true;
                nextEndNode=next;
                endNode=curr;
            }
            prev=curr;
            curr=next;
            next=next.next;
        }
        reverse(startNode,endNode.val);
        if(preStartNode!=null&&nextEndNode!=null){
            System.out.println(preStartNode.val+" "+startNode.val);
            System.out.println(nextEndNode.val+" "+endNode.val);
            preStartNode.next=endNode;
            startNode.next=nextEndNode;
        }

        return preStartNode!=null?preStartNode:head;
    }
    public ListNode reverse(ListNode curr, int endVal){

        ListNode saved=curr;
        if(curr.val==endVal){
            //如果到末端就立刻返回
            return curr;
        }
        ListNode retruened=reverse(curr.next,endVal);
        
        retruened.next=saved;
        return saved;
    }
}








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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr=head;
        List<Integer> list=new ArrayList<Integer>();
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        int[] nums=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            nums[i]=list.get(i);
        }
        reverseArr(nums,left-1,right-1);
        ListNode dummy=new ListNode(-1);
        ListNode tmpNode=dummy;
        for(int tmp:nums){
            tmpNode.next=new ListNode(tmp);
            tmpNode=tmpNode.next;
        }
        return dummy.next;
    }
    public void reverseArr(int[] nums, int i, int j){
         while(i<j){
             int tmp=nums[i];
             nums[i]=nums[j];
             nums[j]=tmp;
             i++;
             j--;
         }
    }
}





class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




