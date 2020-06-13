
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


public class QuickSort {
    public static void sort(int arr[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = arr[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && arr[j] >= index)
                j--;
            if (i < j)
                arr[i++] = arr[j];// 用比基准小的记录替换低位记录
            while (i < j && arr[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                arr[j--] = arr[i];
        }
        arr[i] = index;// 将基准数值替换回 arr[i]
        sort(arr, low, i - 1); // 对低子表进行递归排序
        sort(arr, i + 1, hight); // 对高子表进行递归排序

    }

    public static void quickSort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        int arr[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
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
















