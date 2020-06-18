
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


274. H-Index
Medium

579

984

Add to List

Share
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.


18 June 2020 at 8:12 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int low=0;
        int high=n-1;
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int h=citations[mid];
            result=Math.max(result, Math.min(h,n-mid));
            if(h>n-mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return result;
    }
}




















