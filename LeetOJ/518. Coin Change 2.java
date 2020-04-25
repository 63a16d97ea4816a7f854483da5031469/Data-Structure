
/*
 * 
https://leetcode.com/problems/coin-change-2/


518. Coin Change 2
Medium

1362

52

Add to List

Share
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




518. Coin Change 2


class Solution {
	//1.58pm-2.19pm
	//dp
	public int change(int amount, int[] coins) {
		if (coins == null) return 0;
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i<coins.length; i++) {
			for (int j = coins[i]; j<= amount; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[amount];
	}
}



背包的想法：

class Solution {
	//1.58pm-2.19pm
	//dp
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i<= coins.length; i++) { //跑當前硬幣
			dp[i][0] = 1;
            for (int j = 1; j<= amount; j++) { // j 就是錢的金額
                
                //当前i个coin的长度，还拥有的amount=【（不选当前coin[i]）i-1个coin，拥有j的amount的个数】+ 【i个coin，把当前coin的value从j中减去（也就是找到了加上这个coin，刚好是j的amount），去查表，找到之前的那个个数】
				dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0); //後面的意思就是說拿這個硬幣並去查表之前的金額有幾種把它加進來
			}
		}
		return dp[coins.length][amount];
	}
}


class Solution {
    //1.58pm-2.19pm
    //dp
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0 || amount==0) return 0;
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            dp[coins[i]]=1;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    if(dp[i-coins[j]]>0 && dp[coins[j]]>0 && i!=2*coins[j])
                    dp[i]=dp[i-coins[j]]+dp[coins[j]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}









