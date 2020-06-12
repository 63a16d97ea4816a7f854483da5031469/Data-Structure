
/*
 * 
https://leetcode.com/problems/duplicate-zeros/

1089. Duplicate Zeros
Easy

387

172

Add to List

Share
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9

4 May 2020 at 8:34 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //8.28pm-8.33pm
    public void duplicateZeros(int[] arr) {
        if(arr.length==0) return;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==0){
                for(int j=arr.length-1;j>=i+2;j--){
                    arr[j]=arr[j-1];
                }
                //shifting the rest 
                arr[i+1]=0;
                i++;
            }
        }
    }
}


















