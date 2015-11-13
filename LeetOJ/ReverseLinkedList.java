package ok;

/*
 * 
https://leetcode.com/problems/reverse-linked-list/

Reverse Linked List
Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
public class Solution {
    public ListNode reverseList(ListNode head) {
        
    }
}


29 October 2015 at 7:56:10 pm
 * 
 */

 class ListNode{
	 int val;
	 ListNode next;
	 ListNode(int x){val=x;}
	 ListNode(){};
 }

public class ReverseLinkedList {
	
 
		
		public static void main(String args[]){
			ListNode head=new ListNode(1);
			head.next=new ListNode(2);
			head.next.next=new ListNode(3);
			head.next.next.next=new ListNode(4);
			ListNode root=reverseList(head);
			while(root.next!=null){
				System.out.println(root.val);
				root=root.next;
			}
			System.out.println(root.val);
		}
		
		
		
		/*
		 * Accepted.
		 * 
		 * Could you find a simple solution?
		 * 
		 */
		
	    public ListNode reverseList3(ListNode head) {
	     	if(head==null) return head;
	     	if(head.next==null) return head;
	     	if(head.next.next==null){
	 
	     	    ListNode next=head.next;
	     	    next.next=head;
	     	    head.next=null;
	     	    return next;
	     	}
	        	    	ListNode prev=head;
	 
		    	head=head.next;
		    	ListNode next=head.next;
	     
		    	prev.next=null;
		    	
		    	while(next.next!=null){
		    	head.next=prev;
		    	prev=head;
		    	head=next;
		    	next=next.next;
		    	}
		    	
		    	
		    	if(next.next==null){
		    		head.next=prev;
		    	}
	 
		    	next.next=head;
	  
		    	return next;
	    }
	    
		
 
		/*
		 * 
		 * 
Run Code Status: Runtime Error
Run Code Result: ×

Your input

[]

Reason: do not forget the boundary test


Submission Result: Runtime Error 

Runtime Error Message:
Line 19: java.lang.NullPointerException
Last executed input:
[1]


Error Message:
[1,2]
[1]
Expected output:[2,1]
		 * 
		 */
	    public static ListNode reverseList(ListNode head) {
	    	 
	    	if(head==null) return new ListNode();
        	    	ListNode prev=head;
 
	    	head=head.next;
	    	ListNode next=head.next;
     
	    	prev.next=null;
	    	
	    	while(next.next!=null){
	    	head.next=prev;
	    	prev=head;
	    	head=next;
	    	next=next.next;
	    	}
	    	
	    	
	    	if(next.next==null){
	    		head.next=prev;
	    	}
 
	    	next.next=head;
  
	    	return next;
    }
//	    public static ListNode reverseList(ListNode head) {
//	        
//	    	//Reason: do not forget the boundary test
//	    	if(head==null) return new ListNode();
//	    	
//	    	ListNode prev=head;
//
//    		
//	    	// do not forgot the new list's last element's next is null
//	    	// if put below sentence to here, it will cause null point error.
//	    	//	    	prev.next=null;
//	    	
//	    	head=head.next;
//	    	ListNode next=head.next;
//    		
//	    	// do not forgot the new list's last element's next is null
//	    	prev.next=null;
//	    	
//	    	while(next.next!=null){
//	    	head.next=prev;
//	    	prev=head;
//	    	head=next;
//	    	next=next.next;
//	    	}
//	    	
//	    	
//	    	if(next.next==null){
//	    		head.next=prev;
//	    	}
// 
//	    	next.next=head;
//  
//	    	return next;
//	    }
// 

}
