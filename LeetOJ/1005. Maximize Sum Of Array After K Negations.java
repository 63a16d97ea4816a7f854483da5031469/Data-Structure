
/*
 * 
https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

1005. Maximize Sum Of Array After K Negations
Easy

275

31

Add to List

Share
Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 

Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


题目大意
对于一个由整数构成的数组A，每次翻转可以把其中的任意一位翻转成其相反数。要求一定要做K次翻转，但是可以翻转相同位置的数字，求翻转之后的数组的最大和。

解题方法
小根堆
这个题稍微一分析就知道：我们优先翻转负数翻转成正数，这样和就会变大。那么优先翻转哪个负数呢？肯定是最小的负数，这样求相反数之后会变得最大。那么，当负数翻转完了之后怎么办？那么只能翻转非负数了，所以如果有0就一直翻转0，否则就每次挑正数翻转成负数，翻转之后继续选负数翻转。

总而言之：维护一个最小堆，每次翻转堆里面的最小数字，翻转之后的结果仍然放入堆中以便下次翻转。

每次翻转之后和会增加二倍翻转的数字的相反数。所以，不要每次翻转之后都去求和，而应该在刚开始的时候求一次和就行。
————————————————
版权声明：本文为CSDN博主「负雪明烛」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/fuxuemingzhu/article/details/88376629

 * 
 */
























