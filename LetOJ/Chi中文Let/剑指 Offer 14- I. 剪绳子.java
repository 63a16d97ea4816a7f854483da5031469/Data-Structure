
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}

// 作者：97wgl
// 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-sheng-zi-dong-tai-gui-hua-by-97wgl/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//状态转移方程 dp[i] = dp[j] * dp[i - j]
class Solution {
    public int cuttingRope(int n) {
        //边界情况
        if(n == 2) return 1;
        if(n == 3) return 2;

        //dp[i]表示绳子长度为i时的最大乘积
        int[] dp = new int[n + 1];
        //下面的初始化的意思是，长度为1时，参与计算乘积的最大值为1，
        //长度为2时，参与计算乘积时最大值为2（即长度为2的绳子与其他部分的绳子相乘），长度为3的时候同理
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //第一层遍历，是遍历绳子长度，自底向上计算
        for(int i = 4; i <= n; ++i){
            //第二层遍历，j代表剪掉的长度，因为左右剪掉计算都是一样的，因此 j <= i / 2可以减少一半的计算
            for(int j = 2; j <= i / 2; ++j){
                //状态转移方程，更新当前dp[i]的值，如果减下j长度来的乘积更大，则更新
                //dp[j]减下来的左边的乘积的最大值，dp[i - j]减下来的右边的乘积的最大值
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        //返回长度为n时的最大成绩即满足题意
        return dp[n];
    }
}

// 作者：ming-xi-si-he-xi
// 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/javashi-xian-dong-tai-gui-hua-jian-dan-yi-li-jie-3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public int cuttingRope(int n) {
        int[] countArray = new int[n];
        maxCount(n, countArray);
        return countArray[n-1];
    }

    public  void maxCount(int n,int[] countArray) {
        if (n < 2) {
            return;
        }

        if (1 == n) {
            countArray[0] = 1;
        }
        if (2 == n) {
            countArray[1] = 1;
        }
        for (int i = 3; i <=n; i++){
            int max = 0;
            for (int j = 1; j <= i-1; j++){
                max = Math.max(max, j*countArray[i-j-1]);
                max = Math.max(max, j*(i-j));
            }
            countArray[i-1] = max;
        }
    }
}










