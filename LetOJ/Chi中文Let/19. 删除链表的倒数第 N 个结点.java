
/*
 * 
link: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/


19. 删除链表的倒数第 N 个结点
难度
中等

1766

收藏

分享
切换为英文
接收动态
反馈
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 

示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 

提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

进阶：你能尝试使用一趟扫描实现吗？


2022-01-23 at 21:29
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



尝试使用 快节点与慢节点解：，但是有一些case过不了，这种是错误的：
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode tmp=head;
        while(tmp!=null){
            length++;
            tmp=tmp.next;
        }
        if(length==1&&n==1) return null;
        if(length==2&&n==2) return head.next;

        ListNode fastNode=head;
        ListNode slowNode=head;
        int count=n;
        while(fastNode!=null&&count>0){
            fastNode=fastNode.next;
            count--;
        }
        //move the fastNode and slowNode together.
        while(fastNode.next!=null&&slowNode.next!=null){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
        }
        ListNode delNode=slowNode.next;
        slowNode.next=delNode.next;
        return head;
    }
}



计算链表长度，然后按长度去操作：

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



堆栈：

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

复杂度分析
时间复杂度：
O(L)，其中  L 是链表的长度。
空间复杂度：
O(L)，其中 L 是链表的长度。主要为栈的开销。

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。













