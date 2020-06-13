
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse arr linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



// https://www.programcreek.com/2012/11/quicksort-array-in-java/

public class QuickSort {
 
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3, 3};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
 
    public static void quickSort(int[] arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }
}




// Version 2: Middle element as pivot

public class QuickSort {
	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
 
		quickSort(x, low, high);
		System.out.println(Arrays.toString(x));
	}
 
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}






// Java program for Quick Sort on Singly Linled List 

// https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/

/*sort a linked list using quick sort*/
public class QuickSortLinkedList 
{ 
static class Node 
{ 
	int data; 
	Node next; 

	Node(int d) 
	{ 
		this.data = d; 
		this.next= null; 
	} 
} 

Node head; 

void addNode(int data) 
{ 
	if(head == null) 
	{ 
		head = new Node(data); 
		return; 
	} 

	Node curr = head; 
	while(curr.next != null) 
		curr = curr.next; 

	Node newNode = new Node(data); 
	curr.next = newNode; 
} 

void printList(Node n) 
{ 
	while(n != null) 
	{ 
		System.out.print(n.data); 
		System.out.print(" "); 
		n = n.next; 
	} 
} 

// takes first and last node, 
// but do not break any links in 
// the whole linked list 
Node paritionLast(Node start, Node end) 
{ 
	if(start == end || 
	start == null || end == null) 
		return start; 

	Node pivot_prev = start; 
	Node curr = start; 
	int pivot = end.data; 
	
	// iterate till one before the end, 
	// no need to iterate till the end 
	// because end is pivot 
	while(start != end ) 
	{ 
		if(start.data < pivot) 
		{ 
			// keep tracks of last modified item 
			pivot_prev = curr; 
			int temp = curr.data; 
			curr.data = start.data; 
			start.data = temp; 
			curr = curr.next; 
		} 
		start = start.next; 
	} 
	
	// swap the position of curr i.e. 
	// next suitable index and pivot 
	int temp = curr.data; 
	curr.data = pivot; 
	end.data = temp; 

	// return one previous to current 
	// because current is now pointing to pivot 
	return pivot_prev; 
} 

void sort(Node start, Node end) 
{ 
	if(start == end ) 
		return; 
		
	// split list and partion recurse 
	Node pivot_prev = paritionLast(start, end); 
	sort(start, pivot_prev); 
	
	// if pivot is picked and moved to the start, 
	// that means start and pivot is same 
	// so pick from next of pivot 
	if( pivot_prev != null && 
		pivot_prev == start ) 
		sort(pivot_prev.next, end); 
		
	// if pivot is in between of the list, 
	// start from next of pivot, 
	// since we have pivot_prev, so we move two nodes 
	else if(pivot_prev != null && 
			pivot_prev.next != null) 
		sort(pivot_prev.next.next, end); 
} 

// Driver Code 
public static void main(String[] args) 
{ 
	QuickSortLinkedList list = new QuickSortLinkedList(); 
	list.addNode(30); 
	list.addNode(3); 
	list.addNode(4); 
	list.addNode(20); 
	list.addNode(5); 

	Node n = list.head; 
	while(n.next != null) 
		n= n.next; 

	System.out.println("Linked List before sorting"); 
	list.printList(list.head); 

	list.sort(list.head , n); 

	System.out.println("\nLinked List after sorting"); 
	list.printList(list.head); 
} 
} 

// This code is contributed by trinadumca 
















