
/*
 * 
https://leetcode-cn.com/problems/stone-game/

877. 石子游戏
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。

亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。

假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。

 

示例：

输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 

提示：

2 <= piles.length <= 500
piles.length 是偶数。
1 <= piles[i] <= 500
sum(piles) 是奇数。

21 June 2020 at 7:23 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */









// 解动态规划问题的通用思路：要求解什么，就把什么设为状态。虽然一开始可能会抓不到头绪，但最终往往会发现，最平平无奇的思路才是最好的思路。

// 这道题问先行动者能不能获胜，翻译为定量的数学语言，就是问先行动者能不能确保自己游戏结束时获得的石子个数一定超过总个数的一半。

// 设 dp[start][end]dp[start][end] 代表这一步的行动者（可能为阿历克斯也可能为李）在游戏结束时最多能确保拿到的石子个数，其中 startstart 和 endend 分别代表目前剩下的石子堆的头尾序号。问题在于 dp[0][piles.length-1]dp[0][piles.length−1] 是否能确保大于石子总数的一半。

// 该从哪里找到这个状态方程的起点呢？所谓起点，就是可以直接断定的值，这个状态方程里有什么初始值可以直接断定吗？游戏开始时的状态就是要求解的问题，很明显不可能从这头入手。换一个方向，能不能从游戏结局入手呢？

// 答案是肯定的。当只剩最后一堆石子的时候，这一步的行动者别无选择，只能拿走最后这堆石子！因此，对于任意的 0<=i<=piles.length-10<=i<=piles.length−1， 有 dp[i][i]=piles[i]dp[i][i]=piles[i]。这就是状态方程的起点。

// 从只剩最后一堆石子的状态开始，一步步倒推回游戏的初始状态，就能算出 dp[0][piles.length-1]dp[0][piles.length−1]。

// 作者：frankjen
// 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-jian-ming-yi-dong-de-dong-tai-gui-hu/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {

    boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int[][] sumOfStonesLeft = new int[piles.length][piles.length];//目前剩下的石子总个数
        for (int d = 0; d < piles.length; d++) {//剩余石子堆头尾编号的距离，0代表只剩最后一堆石子
            for (int i = 0; i + d < piles.length; i++) {
                if (d == 0) {//只剩最后一堆石子时的状态作为初始值
                    dp[i][i] = piles[i];
                    sumOfStonesLeft[i][i] = piles[i];
                } else {
                    sumOfStonesLeft[i][i + d] = sumOfStonesLeft[i][i + d - 1] + piles[i + d]; 
                    //从这一步开始自己最终获得的石子数尽量多，等价于让对方从下一步开始最终可获得的石子数尽量少
                    dp[i][i + d] = Math.max(sumOfStonesLeft[i][i + d] - dp[i + 1][i + d],
                                            sumOfStonesLeft[i][i + d] - dp[i][i + d - 1]);
                }
            }
        }
        return dp[0][piles.length - 1] * 2 > sumOfStonesLeft[0][piles.length - 1];//超过一半即获胜
    }

}

// 作者：frankjen
// 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-jian-ming-yi-dong-de-dong-tai-gui-hu/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









// 解题思路
// 先排序, 后根据 优先选择当前石头数较多的石头堆 的策略选择石头
// 1.条件: piles.length是偶数, 亚里克斯和李的水平都是最佳的(说明两者都会优先考虑选择当前石头数最大的堆)
// 2.先给piles排序, 使其呈升序排列
// 3.从前往后遍历排序后的piles数组, 在遍历过程中:
// -3.1先手: 亚里克斯在当前未被选择的石头堆中优先选择石头数最大的堆
// -3.2后手: 李在当前未被选择的石头堆中优先选择石头数最大的堆
// 4.最后比较亚里克斯拥有的石头数与李拥有的石头数的大小
// 5.若亚里克斯拥有的石头数 比 李拥有的石头数多, 返回true, 否则, 返回false

// 作者：Zhang191031
// 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-dong-tai-gui-hua-ti-mu-dan-shi-mei-you-yong-de/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









class Solution {
    public boolean stoneGame(int[] piles) {
        int i = piles.length-1;
        quickSort(piles,0,i);
        int yaSum=0;
        int liSum=0;
        //从前往后遍历排序后的piles, 分别计算亚里克斯和李的可能的石头数
        while(i>0){
            yaSum += piles[i];//亚里克斯的石头数
            liSum += piles[i-1];//李的石头数
            i -=2;
        }
        return yaSum > liSum;
    }
    //快速排序
    public void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(l+r)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }

            while(arr[r]>pivot){
                r--;
            }
            if(l>=r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l]==pivot){
                r--;
            }
            if(arr[r]==pivot){
                l++;
            }
        }
        if(r==l){
            r--;
            l++;
        }

        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
    }
}

// 作者：Zhang191031
// 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-dong-tai-gui-hua-ti-mu-dan-shi-mei-you-yong-de/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






class Solution {
    public boolean stoneGame(int[] piles) {
    return judge(piles, 0, piles.length - 1, 0, 0, true);
    }
    
    private boolean judge(int[] piles, int left, int right, int yalics, int li, boolean isYalics) {
        if (left > right) {
            return yalics < li;
        }
        if (isYalics) {
            boolean res1 = judge(piles, left + 1, right, yalics + piles[left], li, false);
            if (res1) {
                return res1;
            }
            return judge(piles, left, right - 1, yalics + piles[right], li, false);
        } else {
            boolean res1 = judge(piles, left + 1, right, yalics, li + piles[left], false);
            if (res1) {
                return res1;
            }
            return judge(piles, left, right - 1, yalics, li + piles[right], false);
        }
    }
    }
    
    作者：yanghk-2
    链接：https://leetcode-cn.com/problems/stone-game/solution/hui-su-hao-li-jie-dan-shi-ben-by-yanghk-2/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
















