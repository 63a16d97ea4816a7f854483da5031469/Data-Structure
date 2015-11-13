package ok;
//https://leetcode.com/problems/remove-linked-list-elements/

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
    }
}


7 November 2015 at 8:53:24 pm
 */


//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x){val=x;}
//}

public class RemoveLinkedListElements {

		
	
	public static void main(String args[]){
		ListNode root=new ListNode(1);
		root.next=new ListNode(1);
		root.next.next=new ListNode(1);
		
//		root.next=new ListNode(2);
//		root.next.next=new ListNode(6);
//		root.next.next.next=new ListNode(3);
//		root.next.next.next.next=new ListNode(4);
//		root.next.next.next.next.next=new ListNode(5);
//		root.next.next.next.next.next.next=new ListNode(6);
		
		ListNode result=removeElements2(root,1);

		
		System.out.println("result:");
		while(result!=null){
			System.out.print(result.val+" ");
		result=result.next;
		}
			
		}
		
	
	/*
	 * Accepted:
	 * 
	 *  Modification----> should not move the prevNode when deleting one element from List
	 */
	public static ListNode removeElements2(ListNode head, int val){
 
		
		// Check whether the first head is null
		if(head==null) return head;
		
		// Check the head.next==null case
		if(head.next==null&&head.val==val) return null;
		
		ListNode tmp=head;
		ListNode prevNode=null;
 
		
		//if the list is more than two nodes.
		while(tmp!=null){
			if(tmp.val==val)
			{
				//if this is head, we need to adjust the head.
				if(prevNode==null){
					head=tmp.next;
					
					prevNode=null;
					
				//if it is not the head
				}else {
					prevNode.next=tmp.next;
//					System.out.println(tmp.val+" "+"prev:"+prevNode.val+" "+prevNode);
					
					/*
					    when prevNode is null, the output is empty.....(it is different with other pre-defined variable)
						1 prev:1ListNode@71b456f
						1 prev:1ListNode@f6b7e0e
						1 
					 * 
					 */

					
					//considering all the node are deleted.  delete the last element
				    if(tmp.next==null&&head==tmp){
				     head=null;
				    }
				    	  // should not move the prevNode when deleting one element from List
//				    					prevNode=tmp;
				}

			}else{
				prevNode=tmp;
			}

			tmp=tmp.next;

		}
 
		
		return head;
	}
	
	
	
	
/*
Input:
[1,2,2,1]
2
Output:
[1,2,1]
Expected:
[1,1]

Reason: should not move the prevNode when deleting one element from List
 * 		
 */

	public static ListNode removeElements(ListNode head, int val){
 
		
		// Check whether the first head is null
		if(head==null) return head;
		
		// Check the head.next==null case
		if(head.next==null&&head.val==val) return null;
		
		ListNode tmp=head;
		ListNode prevNode=null;
 
		
		//if the list is more than two nodes.
		while(tmp!=null){
			if(tmp.val==val)
			{
				//if this is head, we need to adjust the head.
				if(prevNode==null){
					head=tmp.next;
					
					prevNode=null;
					
				//if it is not the head
				}else {
					prevNode.next=tmp.next;
//					System.out.println(tmp.val+" "+"prev:"+prevNode.val+" "+prevNode);
					
					/*
					    when prevNode is null, the output is empty.....(it is different with other pre-defined variable)
						1 prev:1ListNode@71b456f
						1 prev:1ListNode@f6b7e0e
						1 
					 * 
					 */

					
					//considering all the node are deleted.  delete the last element
				    if(tmp.next==null&&head==tmp){
				     head=null;
				    }
				    	  // should not move the prevNode when deleting one element from List
				    					prevNode=tmp;
				}

			}else{
				prevNode=tmp;
			}

			tmp=tmp.next;

		}
 
		
		return head;
	}
	
}
