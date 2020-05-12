
/*
 * 
https://leetcode.com/problems/single-element-in-a-sorted-array/


Single Element in a Sorted Array
Solution
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.

13 May 2020 at 12:18 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */



// 解题思路
// A^A^B^C^C=B,可知对一串数字连续异或运算可消除成对的数字,此法无论有序无序都可用,只要是偶数倍

// 代码

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int first=nums[0];
        for (int i = 1; i < nums.length; i++) {
            first=first^nums[i];
        }
        return  first;
    }
}

// 作者：CodeRusher
// 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/san-xing-dai-ma-qiao-yong-yi-huo-yun-suan-fu-ji-ba/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public int singleNonDuplicate(int[] nums) {
       int l=0,r=nums.length-1;
       while(l<r){
           int h=(r+l)/2;
           if(h%2==1){
               if(nums[h]==nums[h+1])
                   r=h-1;
               else
                   l=h+1;
           }else{
               if(nums[h]==nums[h+1])
                   l=h+2;
               else
                   r=h;
           }
       }
        return nums[l];
    }
}

// 作者：qiu-offer-3
// 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/java-er-fen-fa-0msji-bai-liao-10000-by-qiu-offer-3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

















