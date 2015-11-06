/*
 * 
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    }
}
 * 
 */


















import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
	
}

public class MergeTwoSortedLists {

	public static void main(String args[]) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next=new ListNode(5);
		
		
		ListNode l2=new ListNode(0);
		l2.next=new ListNode(44);
		
		
		ListNode root=mergeTwoLists(l1,l2);
		
		
		/*
		 * Test cases:
		 * 
		 * [1,3,5]
		 * []
		 * 
		 * []
		 * [1,3,5]
		 * 
		 * [1,3,5]
		 * [0,2]
		 * 
		 * [1,3,5]
		 * [2,10]
		 * 
		 * 
		 */
		
		
		
		while(root!=null){
			System.out.print(root.val+" ");
			root=root.next;
		}
	}
	
	/*
	 * 
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
	 */

	
	/*
	 * 
	 * Accepted.
	 * 
	 * 
	 */
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		//if l1 is empty and l2 is empty, then return l1;
		if(l1==null&&l2==null) return l1;
		
		/*
		 * Considering cases:
		 * 
		 *  l1 is empty, l2 is not empty.
		 *  l1 is not empty, l2 is empty.  
		 *  l1 is not empty and l2 is not empty.
		 * 
		 */
		
		ListNode prevFirst = null;
		ListNode currFirst = null;
		ListNode currSecond = null;
		
		prevFirst = null;
		currFirst = l1;
		currSecond= l2;
 

			

			while (currSecond != null) {
				
				//that means it is in the head or it is in the rear.
				if(currFirst==null){
					
					// it means it is in the head
					if(prevFirst==null){
						ListNode newNode=new ListNode(currSecond.val);
						//leave the prevFirst as null.  ---wrong.
		
						newNode.next=currFirst;
						currFirst=newNode;
						prevFirst=newNode;
						currSecond=currSecond.next;
						
						/*
						 * if l1==null, we need to allocate memory for l1.
						 * otherwise, l1 will be always null.
						 */
						if(l1==null){
							l1=currFirst;
						}
						
						
					}
					//it means it is in the rear
					else{
						ListNode newNode=new ListNode(currSecond.val);
						prevFirst.next=newNode;
						prevFirst=newNode;
						
						//leave the currFirst as null;
//						currFirst=newNode;
						
						currSecond=currSecond.next;
					}
		 
				}else{
				
				
				
				
				
				
				
				//The simplest case:
				/*
				 * from simple to complex
				 * (1)   l1 is empty, l2 is not empty.
				 */
//				if (currFirst.next != null) {
//					currFirst = currFirst.next;
//				}
				
				
				 
				//search from the list 1
				while(currFirst!=null){
					
					if(currSecond.val>currFirst.val) {
						
						//if currFirst Next is not null, that means it is not reach the rear.
						if(currFirst.next!=null){
							prevFirst=currFirst;
							currFirst=currFirst.next;
							
							break;
						// if the currFirst reaches the end of the List 1, we need to insert the value into the list 1 now
						}else{
							ListNode newNode=new ListNode(currSecond.val);
							
//							if (prevFirst != null) {

								currFirst.next=newNode;
								prevFirst = currFirst;

								currFirst = newNode;

								// leave the currFirst as null
								// currFirst=newNode;

								currSecond = currSecond.next;
								break;
							
 
//							}  
						}
						
						
					//if the currSecond.val <=  currFirst.	
					}else{

						//it means it is head, we need to add value from head of list 1.
						if(prevFirst==null){
//							System.out.println(currSecond.val);
							ListNode newNode=new ListNode(currSecond.val);

							newNode.next=currFirst;
							//leave the prevFirst pointer to null, do not modify it. But modify the currFirst pointer.
							currFirst=newNode;
							
							//as the head is changed, we need to modified the l1 accordingly
							l1=newNode;
							
							currSecond=currSecond.next;
							break;
							
						//if the insert position is not in the head, maybe it is in the middle or in the end of list 1
						}else{
							
							ListNode newNode=new ListNode(currSecond.val);
							newNode.next=prevFirst.next;
							prevFirst.next=newNode;
							
							prevFirst=newNode;
							
							
							currFirst=newNode;
							
							//currFirst.next==null, it is rear.
//							if(currFirst.next==null){
//								currFirst=null;
//							}
//							//prevFirst!=null and currFirst.next!=null, it is in the middle.
//							else{
//							   currFirst=newNode;	
//							}
							
							currSecond=currSecond.next;
							break;
						}
						
					}
					
					
					
					
				}
				
				
				}
				
				// if l2 to be the end, then finish all the things
			}
			
		   return l1; 	
		}


}
























