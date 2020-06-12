
/*
 * 
https://leetcode.com/problems/burst-balloons/


312. Burst Balloons
Hard

2118

58

Add to List

Share
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



class Solution {
    public int maxCoins(int[] nums) {
         int[] modifiedNums = new int[nums.length + 2];
         int n = 1;
         for(int num : nums){modifiedNums[n++] = num;}
         modifiedNums[0] = modifiedNums[n++] = 1;
         
         int[][] memo = new int[n][n];
         return maxCoins(modifiedNums, 0, n-1, memo);
     }
     
     public int maxCoins(int[] nums, int left, int right, int[][] memo){
         if(left+1 >=right) return 0;
         if(memo[left][right] != 0) return memo[left][right];
         int res = 0;
         for(int i = left+1; i<right ; i++){
             res = Math.max(res, nums[i]*nums[left]*nums[right] +  maxCoins(nums, left, i, memo)  + maxCoins(nums, i, right, memo));
         }
         memo[left][right] = res;
         return res;
     }
 }
 
 /*
 
 我直接解释一下看到的最高票的回答。
 
 如果采用暴力法的话，我们会遍历出所有可能的结果，并且比较其最终获得最高积分值。这意味着O(n!)的时间复杂度。
 
 如果采用动态规划法的话，我们在知道了炸掉k个气球之后的最大积分，然后计算炸掉k+1个气球的最大积分。时间依旧感人。
 
 这里采用的是backtracking+分治法来解决。当我们正向思考这道题时，我们可能会想，随机选择一个气球，按该气球作为分界线分为两个子气球队列。这时再分别计算左右两个队列可以得到的最大积分。
 但是这里有一个问题在于，左边队列炸掉气球的顺序可能会影响到右边气球的顺序，比如假设存在这样一列气球对应的积分为3，2，4，1，5,我们取4作为分界点，分为两个子数组3,2,1,5那么如果左边气球炸掉的顺序为2,3，则右边队列的最左侧值则会先是2，再是3。这样就违背了分治法将问题分解为独立问题的要求。因此这种思路无法解决该问题。
 
 但是如果反过来思考，假设我们先选取最后一个炸掉的气球，那么我们知道这个获得的积分一定是nums[i]*nums[left]*nums[right]，则以该气球作为分界点将队列分解后获得的两个子队列的边界是一定的。举个例子3,2,4,1,5：
 首先，我们将其填充为1,3,2,4,1,5,1
 然后我们将队列从2分解开来，即2是最后一个炸掉的气球，那么该气球的积分数为1*2*1
 自队列分别为1,3,2和2,4,1,5,1。
 那么假设我们再拆解1,3,2中的3，则结果为1*3*2。此时得到的子队列长度等于2，因此将无法拆解，即结束。
 https://segmentfault.com/a/1190000013800037
 
 */
 










class Solution {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int[][] dp = new int[n][n];
		for (int[] arr: dp) {
			Arrays.fill(arr, -1);
		}
		return find(nums, 0, n - 1, dp);
	}

	int find(int[] nums, int from, int to, int[][] dp) {
		if (dp[from][to] != -1) {
			return dp[from][to];
		}
		// note, the loop is is to loop the last balloon to burst
		for (int i = from; i <= to; ++i) {
			// every balloon between [from,to] can be bursted 
			int points = nums[i] * getValue(nums, from - 1) * getValue(nums, to + 1);
			if (i > from) { // if there is left part 
				points += find(nums, from, i - 1, dp);
			}
			if (i < to) { // if there is right part 
				points += find(nums, i + 1, to, dp);
			}
			dp[from][to] = Math.max(dp[from][to], points);
		}
		return dp[from][to];

	}
	int getValue(int[] nums, int i) {
		if (i < 0 || i >= nums.length) return 1;
		return nums[i];
	}
}

/*

解题思路分析

从一个小样本开始，如果输入的气球是[3,1,5,8]
那么，我们第一步可能有4种情况如下
a. 选择第一个气球， total_price = 131 + calc_price(1,5,8)
b. 选择第二个气球， total_price = 315 + calc_price(3,5,8)
c. 选择第三个气球， total_price = 158 + calc_price(3,1,8)
d. 选择第四个气球， total_price = 581 + calc_price(3,1,5)
这样来看，虽然问题有点类似重叠子问题，好像可以用动态规划，但是这里难点在于，由于气球被扎了以后，重叠的子问题变化比较大，不好定义。
因为每次扎了任何一个中间的气球以后，左边和右边的气球发生变化了。 导致状态定义比较困难。

如果用brute force递归硬算的话，时间复杂度会是O(N!), 空间复杂度也会特别高， 因为每次需要拷贝生成一个新的数组

从前面的分析，大概可以看到有点重叠子问题的意思， 因为扎了一个气球以后，可以算出当前的价格，然后剩下的问题，又变成一个数据规模更小的一样的问题。
所以这里可以想一下大概怎么用动态规划的思路。
前面写了两个动态规划的题解，和这个题目多少有点类似
http://www.noteanddata.com/leetcode-375-Guess-Number-Higher-or-Lower-II-java-solution-note.html 这个稍微简单一点，因为每次选择，当前的选择是不影响后面每次选择当次的价格，也就是单次价格只由自己决定，和之前的选择没有关系， 所以可以从前向后算。
http://www.noteanddata.com/leetcode-1000-Minimum-Cost-to-Merge-Stones-java-solution-note.html就和现在这个burst balloon有点类似了， 每次选择后，会影响到左边和右边的状态，那么, 在前面的题目中，我们考虑了最后一次操作的场景。
所以，这里可以考虑一下是不是也可以用最后一次操作的场景来判断状态和子问题的递推关系呢？

假设考虑最后一个被扎的气球， 那么最后一个气球的价格就是1num[i] 1, 最后一个气球左边的成本可以在一个二维数组里面表示为dp[0][i-1],
最后一个气球右边的成本可以表示为dp[i+1][n-1],
那么，dp[0][n-1] = max(nums[i] + dp[0][i-1] + dp[i+1][n-1])
这时候，重叠子问题已经形成了， 我们需要考虑对于任意的dp[i][j]怎么计算？ 同样，我们也可以选择考虑第一步或者最后一步。
如果考虑第一步一样会会陷入前面说的状态变化太大的问题。 我们再考虑如果做最后一步是怎么样？
这里， dp[i][j]的最后一步会有一个好处， 就是最后一步的左边和右边是确定的。 就是nums[i-1]和nums[j+1].
如果从第一步开始考虑就不会有这个好处， 前面的例子已经解释了， 第一步开始考虑的话左边和右边就会发生变化。
为什么从最后一步开始做的话, dp[i][j]的左右都是固定的呢？ 因为我们从后向前递推的话，每次要算dp[i]j]的时候，左边和右边都是在后面， 那么， 左边和右边都还没有被扎， 所以对于所有[i,j]里面的最后一个气球， 左边和右边都是num[i-1]和nums[j+1],
这样， 就有dp[i][j] = max(nums[i-1] * nums[t] * nums[j+1] + dp[i][t-1] + dp[t+1][j])
这个从后向前计算的重点在于左边和右边是固定的。
所以， 我们可以用top-down + memorization 的方式做递归的动态规划

*/













