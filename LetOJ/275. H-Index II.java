
/*
 * 
https://leetcode.com/problems/h-index-ii/


275. H-Index II
Medium

321

522

Add to List

Share
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?

18 June 2020 at 5:40 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */
// 我们求的结果就是求影响力x和不小于该影响力的论文个数的最小值，然后再求这个最小值的最大值。




class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        if(n==0) return 0;
        
         if (n== 1) {
            if (citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int low=0;
        int high=n-1;
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int h=citations[mid];
            result = Math.max(result, Math.min(h, n - mid));
            if(n-h==mid){
                return n-mid;
            }else if(n-h<mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return n-low;
    }
}






class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        if(n==0) return 0;
        
         if (n== 1) {
            if (citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int h=citations[mid];
            if(n-h==mid){
                return n-mid;
            }else if(n-h<mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return n-low;
    }
}









// Wrong answers: passed 40 test cases. 不是很理解题意
class Solution {
    //5.16pm-5.30pm 
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        if(citations.length==1) return 1;
        
        int low=0;
        int high=citations.length-1;
        
        int n=citations.length;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int h=citations[mid];
            if(n-h==mid){
                return h;
            }else if(n-h<mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return 0;
    }
}











