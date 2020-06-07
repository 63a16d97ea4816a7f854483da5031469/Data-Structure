
/*
 * 
https://leetcode.com/problems/coin-change-2/

518. Coin Change 2
Medium

1649

58

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

8 June 2020 at 12:12 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



// Coin change 2:
class Solution {
    public int change(int amount, int[] coins) {

        int dp[] = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int coin:coins)
        {
            for(int j = coin; j<=amount; j++){
            dp[j] += dp[j - coin];
            }
        }
            return dp[amount];
    }
}
    


class Solution {
    // Once you figure out all these, it's easy to write out the code:

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    class Solution {
        public int change(int amount, int[] coins) {
           int [][]ways = new int [coins.length+1][amount + 1];
            for (int i=0; i<= coins.length; i++) {
                ways[i][0] = 1;   
            }
            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if(j >= coins[i-1]) {
                        ways[i][j] =  ways[i-1][j] + ways[i][j-coins[i-1]];
                    } else {
                        ways[i][j] = ways[i-1][j];
                    }
                }
            }
    
            return ways[coins.length][amount];
        }
    }


    class Solution {
        public int change(int amount, int[] coins) {
            Integer[][] dp = new Integer[coins.length][amount + 1];
            //an Integer can be null, while int can only be a specific number; if you use int, when dp[idx][amount] == 0, you can't distinguish if it's really zero kind of combinations or you haven't calculated it so you will go into another recursion instead of return 0 directly.
            //number of combs choose curr coin and not choose curr coin
            return helper(amount, coins, 0, dp);
        }
        
        private int helper(int amount, int[] coins, int currIdx, Integer[][] dp) {
            if (amount == 0) return 1;
            if (currIdx >= coins.length) return 0;
            //memo
            if (dp[currIdx][amount] != null) return dp[currIdx][amount];
            
            int numIncludeCurr = 0;
            if (amount >= coins[currIdx]) {
                numIncludeCurr = helper(amount - coins[currIdx], coins, currIdx, dp);
            }
            
            int numExcludeCurr = helper(amount, coins, currIdx + 1, dp);
            dp[currIdx][amount] = numIncludeCurr + numExcludeCurr;
            
            return numIncludeCurr + numExcludeCurr;
        }
    }



    class Solution {
        public int change(int amount, int[] coins) {
            if(amount <= 0) return 1;
            if(coins == null || coins.length == 0) return 0;
            
            Integer[][] counts = new Integer[coins.length][amount+1];
            return findCount(0, amount, coins, counts);
        }
        
        private int findCount(int idx, int rem, int[] coins, Integer[][] counts) {
            if(rem == 0) return 1;
            if(rem < 0 || idx == coins.length) return 0;
            
            if(counts[idx][rem] != null) return counts[idx][rem];
            
            int withCoin = 0;
            if(coins[idx] <= rem) 
                withCoin += findCount(idx, rem - coins[idx], coins, counts);
            
            int withOutCoin = findCount(idx+1, rem, coins, counts);
            
            counts[idx][rem] = withCoin + withOutCoin;
            
            return withCoin + withOutCoin;
        }
    }



    class Solution {
        public int change(int amount, int[] coins) {
            Arrays.sort(coins);
            Integer[][] dp = new Integer[amount][coins.length];
            return doRecursive(amount, coins, dp, 0);
        }
        
        private int doRecursive(int amount, int[] coins, Integer[][] dp, int prev) {
            if (amount == 0) {
                return 1;
            } else if (amount < 0 || coins.length == 0) {
                return 0;
            }
            
            if (dp[amount-1][prev] != null) {
                return dp[amount-1][prev];
            }
            int sum = 0;
            for (int i=prev; i<coins.length; i++) {
                if (coins[i] > amount) {
                    break;
                }
                sum += doRecursive(amount-coins[i], coins, dp, i);
            }
            dp[amount-1][prev] = sum;
            return sum;
        }
    }




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








