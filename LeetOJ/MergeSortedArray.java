/*
https://leetcode.com/problems/merge-sorted-array/


Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. The number of elements initialized in nums1 and nums2 are m 
and n respectively.

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
    }
}
 * 
 */
public class MergeSortedArray {
	
	
	
	public static void main(String args[]){
		MergeSortedArray arr=new MergeSortedArray();
		
		int[] nums1={4,0,0,0,0,0};
		int[] nums2={1,2,3,5,6};
		
		arr.merge2(nums1, 1, nums2, 5);
	}
	
	
	
	
/*
 

Input:
[1,2,3,0,0,0]
3
[2,5,6]
3
Output:
[1,2,2,3,5,0]
Expected:
[1,2,2,3,5,6]

//		while (p2 < n) {}     // as we reduce the n, then it affect the judgement.

Reason: 	(1)need to reduce the number of n;
			(2)should be m+n-2  as  (m-1)+(n-1)  if so, need to use <=
			
			
Input:
[4,0,0,0,0,0]
1
[1,2,3,5,6]
5
Output:
[1,2,3,5,6,4]
Expected:
[1,2,3,4,5,6]

Reason:
should add below sentences into the else{}(nums2[p2] <= nums1[p1]){
 				m++;
				n--;
			}
			
			
	Accepted.		
			
 * 
 * 	
 */
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {

		if (nums2.length == 0)
			return;
		

		int p1 = 0, p2 = 0;
//		while (p2 < n) {     // as we reduce the n, then it affect the judgement.
		while (p2 < nums2.length) {

			// if the nums2 > nums1 that means we need to continue searching.
			if (nums2[p2] > nums1[p1]) {
				
				// Search in the nums1 to find the position of insertion point.
				while (nums2[p2] > nums1[p1]) {
					
				//	Reason: need to check whether nums1's index is to be the end.
					if(p1<m){
					p1++;
					}else {
						break;
					}
				}

				int nextTmp = nums1[p1];
				int prevSave = nums1[p1];

				nums1[p1] = nums2[p2];

 
				
				for (int i = p1; i < m + n - 1; i++) {
					prevSave = nums1[i + 1];
					nums1[i + 1] = nextTmp;
					nextTmp = prevSave;

				}
				
				//need to add the number of m;
				m++;
				
				//need to reduce the number of n;
				n--;
				
				
				// if the nums1>nums2, that means we need to insert the nums2
				// into the nums1.
			} else {

				int nextTmp = nums1[p1];
				int prevSave = nums1[p1];

				nums1[p1] = nums2[p2];
				
//				for (int i = p1; i <= m + n - 2; i++) {     //should be m+n-2  as  (m-1)+(n-1)  if so, need to use <=
				for (int i = p1; i < m + n - 1; i++) {

					prevSave = nums1[i + 1];
					nums1[i + 1] = nextTmp;
					nextTmp = prevSave;

				}
				
				m++;
				n--;

			}

			p2++;
		}

		for (int tmp : nums1)
			System.out.print(tmp + " ");

	}	
	
	
	
/*
Runtime Error More Details 

Runtime Error Message:
Line 11: java.lang.ArrayIndexOutOfBoundsException: 1
Last executed input:
[0]
0
[1]
1


Reason: (1)need to check whether nums1's index is to be the end.
		(2)need to add the number of m after add elements into the nums1 array.
 * 	
 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		if (nums2.length == 0)
			return;

		int p1 = 0, p2 = 0;
		while (p2 < n) {

			// if the nums2 > nums1 that means we need to continue searching.
			if (nums2[p2] > nums1[p1]) {
				
				// Search in the nums1 to find the position of insertion point.
				while (nums2[p2] > nums1[p1]) {
					
				//	Reason: need to check whether nums1's index is to be the end.
					if(p1<m){
					p1++;
					}else {
						break;
					}
				}

				int nextTmp = nums1[p1];
				int prevSave = nums1[p1];

				nums1[p1] = nums2[p2];

				for (int i = p1; i < m + n - 1; i++) {

					prevSave = nums1[i + 1];
					nums1[i + 1] = nextTmp;
					nextTmp = prevSave;

				}
				
				//need to add the number of m;
				m++;
				
				
				
				// if the nums1>nums2, that means we need to insert the nums2
				// into the nums1.
			} else {

				int nextTmp = nums1[p1];
				int prevSave = nums1[p1];

				nums1[p1] = nums2[p2];

				for (int i = p1; i < m + n - 1; i++) {

					prevSave = nums1[i + 1];
					nums1[i + 1] = nextTmp;
					nextTmp = prevSave;

				}

			}

			p2++;
		}

//		for (int tmp : nums1)
//			System.out.print(tmp + " ");

	}
}
