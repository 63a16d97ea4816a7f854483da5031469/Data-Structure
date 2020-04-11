
/*
 * 
https://leetcode.com/problems/unique-binary-search-trees/


96. Unique Binary Search Trees
Medium

2713

103

Add to List

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


12 April 2020 at 12.27 pm
 * 
 */




https://blog.csdn.net/Cloudox_/article/details/70236770

class Solution {
    
    
    public int numTrees(int n) {
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        
        //假使i是root，把数分成 1 to i 和 n-i两组
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                arr[i]+=arr[j-1]*arr[i-j];
            }
        }
        return arr[n];
    }
}





















