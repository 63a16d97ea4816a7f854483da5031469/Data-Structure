
/*
 * 
https://leetcode.com/problems/permutation-sequence/


60. Permutation Sequence
Medium

1357

311

Add to List

Share
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

1 June 2020 at 12:32 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */










public class Solution {
    // https://www.jianshu.com/p/db90675cb82b
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        int[] array = new int[n+1];
        int sum = 1;
        array[0] = 1;

        // array[] = [1, 1, 2, 6, 24, ... , n!]
        for (int i=1; i<=n; i++){
            sum *= i;
            array[i] = sum;
        }

        // nums[] = [1, 2, 3, ... n]
        List<Integer> nums = new LinkedList<>();
        for (int i=0; i<n; i++){
            nums.add(i+1);
        }
        
        k--;
        for (int i=1; i<=n; i++){
            int index = k / array[n-i];
            sb.append("" + nums.get(index));
            nums.remove(index);
            k = k % array[n-i];
        }
        return sb.toString();
    }
}













