
/*
 * 
link: https://leetcode.cn/problems/Best-Time-to-Buy-and-Sell-Stock/

121.买卖股票的最佳时机

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。注意你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

链接：https://juejin.cn/post/6844903955030343694



2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


动态规划解决:

for (int i = 1; i < prices.length; i++) {
      // 持有股票，还有两次交易机会
      hold[0][i] = Math.max(hold[0][i - 1], -prices[i])
      // 持有股票，还有一次交易机会
      hold[1][i] = Math.max(hold[1][i - 1], notHold[0][i - 1] - prices[i])

      // 不持有股票，还有两次交易机会
      notHold[0][i] = Math.max(notHold[0][i - 1], prices[i] + hold[0][i - 1])
      // 不持有股票，还有一次交易机会
      notHold[1][i] = Math.max(notHold[1][i - 1], prices[i] + hold[1][i - 1])
    }
    
    return notHold[1][prices.length - 1]




在约等于o(n)的范围内解决:

public class Solution5 {

  public static void main(String[] args) {
    int[] arr = new int[]{100, 80, 120, 130, 70, 60, 100, 125};
    Solution5 solution = new Solution5();
    solution.getResult(arr);
  }

  public void getResult(int[] arr) {
    int result = 0;
    int min = 0, max = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      min = getMin(arr, 0, i);
      max = getMax(arr, i, arr.length - 1);
    }
    result = Math.max(max - min, result);

    System.out.println(result);
  }

  public int getMin(int[] arr, int s, int e) {
    int min = Integer.MAX_VALUE;
    for (int i = s; i <= e; i++) {
      min = Math.min(min, arr[i]);
    }
    return min;
  }

  public int getMax(int[] arr, int s, int e) {
    int max = Integer.MIN_VALUE;
    for (int i = s; i <= e; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }
}


在o(n)范围内解决:

public class Solution55 {

  public static void main(String[] args) {
    int[] arr = new int[]{100, 80, 120, 130, 70, 60, 100, 125};
    Solution55 solution = new Solution55();
    solution.getResult(arr);
  }

  public void getResult(int[] arr) {
    int result = 0;
    int n = arr.length;
    int[] minArr = new int[n];
    int[] maxArr = new int[n];
    minArr[0] = arr[0];
    maxArr[n - 1] = arr[n - 1];
    for (int i = 1; i < n; i++) {
      minArr[i] = Math.min(minArr[i - 1], arr[i]);
    }
    for (int i = n - 2; i >= 0; i--) {
      maxArr[i] = Math.max(maxArr[i + 1], arr[i]);
    }

    for (int i = 0; i < n; i++) {
      result = Math.max(maxArr[i] - minArr[i], result);
    }

    System.out.println(result);
  }
}

















