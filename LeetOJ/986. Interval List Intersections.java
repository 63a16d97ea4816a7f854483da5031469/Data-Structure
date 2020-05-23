
/*
 * 
https://leetcode.com/problems/interval-list-intersections/


986. Interval List Intersections
Medium

1081

35

Add to List

Share
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

24 May 2020 at 12:08 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List < int[] > ans = new ArrayList();
		int i = 0,
		j = 0;
		while (i < A.length && j < B.length) {
			// Let’s check if A[i] intersects B[j].
			// lo — the startpoint of the intersection
			// hi — the endpoint of the intersection
			int lo = Math.max(A[i][0], B[j][0]);
			int hi = Math.min(A[i][1], B[j][1]);
			if (lo <= hi) ans.add(new int[] {
				lo,
				hi
			});
			// Remove the interval with the smallest endpoint
			if (A[i][1] < B[j][1]) i++;
			else j++;
		}
		return ans.toArray(new int[ans.size()][]);
	}
}


















