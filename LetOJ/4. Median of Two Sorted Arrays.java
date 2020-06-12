
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


4. Median of Two Sorted Arrays
Hard

6580

1009

Add to List

Share
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

11 May 2020 at 12:05 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






//https://blog.csdn.net/liuchonge/article/details/72842044
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
         int m = A.length, n = B.length;
         int l = (m + n + 1) / 2;
         int r = (m + n + 2) / 2;
         return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
     }
 
     public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
         if (aStart > A.length - 1) return B[bStart + k - 1];            
         if (bStart > B.length - 1) return A[aStart + k - 1];                
         if (k == 1) return Math.min(A[aStart], B[bStart]);
 
         int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
         if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
         if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
 
         if (aMid < bMid) 
             return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
         else 
             return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
     }
 }








//https://blog.csdn.net/liuchonge/article/details/72842044
class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
       int n = A.length;
       int m = B.length;
       if (n > m)
           return findMedianSortedArrays(B, A);

       // now, do binary search
       int k = (n + m - 1) / 2;
       int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
       while (l < r) {
           int midA = (l + r) / 2;
           int midB = k - midA;
           if (A[midA] < B[midB])
               l = midA + 1;
           else
               r = midA;
       }

       // after binary search, we almost get the median because it must be between
       // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

       // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
       // and there are some corner cases we need to take care of.
       int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
       if (((n + m) & 1) == 1)
           return (double) a;

       // if (n+m) is even, the median can be calculated by
       //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
       // also, there are some corner cases to take care of.
       int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
       return (a + b) / 2.0;
   }
}








