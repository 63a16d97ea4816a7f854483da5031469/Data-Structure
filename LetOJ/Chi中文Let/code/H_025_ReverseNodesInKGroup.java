/**
 * [25] Reverse Nodes in k-Group
 * 
 * difficulty: Hard
 * 
 * TestCase Example: [1,2,3,4,5] 2
 * 
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * 	Only constant extra memory is allowed.
 * 	You may not alter the values in the list's nodes, only nodes itself may be changed.
 * 
 * 
 * 
 * 
 * >>>>>>中文描述<<<<<<
 * 
 * 
 * [25] k个一组翻转链表
 * 
 * 
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 	你的算法只能使用常数的额外空间。
 * 	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
public class H_025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        
    }
}