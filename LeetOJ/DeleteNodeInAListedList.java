package ok;


/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should 
become 1 -> 2 -> 4 after calling your function.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

public class Solution {
    public void deleteNode(ListNode node) {
        
    }
}

29 October 2015 at 7:40:32 pm

 * 
 * 
 */
//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int val) {
//		this.val = val;
//	}
//}


/*
 * 
 * 这个问题的解法就是： 复制法。
 * 但是要考虑删除头节点的情况
 * 
 * 
 */

public class DeleteNodeInAListedList {
	public static void main(String args[]) {
		
		 //Though the code is accepted by LeetCode, it is wrong when only contain one node in list:
		ListNode root=new ListNode(1);
		DeleteNodeInAListedList l=new DeleteNodeInAListedList();
//		l.deleteNode(root);
	
	
	
		//fix the "Delete head node error:"
		l.deleteNode2(root);
	
	}
	
	
	
	
	
	
	/*
	 *
	 * 
	 * 	fix the "Delete head node error:"
	 * Considering to delete the head node.
	 * 
	 */
	
	public void deleteNode2(ListNode node) {
		
		if(node==null) return;	
		
		if(node.next!=null){
		node.val=node.next.val;
		node.next=node.next.next;
		}else{
			node=null;
		}
	}

	

	/*
	 * Accepted:
	 * 
	 * Though this code is accepted by LeetCode, it is wrong when only contain one node in list:!!!!
	 * 
	 */
	
	public void deleteNode(ListNode node) {
		if(node==null) return;	
		node.val=node.next.val;
		node.next=node.next.next;
	}

}
