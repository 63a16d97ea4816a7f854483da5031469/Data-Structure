
/*
 * 
link: 
https://leetcode-cn.com/problems/russian-doll-envelopes/

2020-7-29 at 8:26 am

354. 俄罗斯套娃信封问题
难度
困难

171

给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

说明:
不允许旋转信封。

示例:

输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3 
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */
    // KEYPOINT 对数组进行宽w升序，高h降序的排序
        // 排序前 [4,5],[4,6],[6,7],[2,3],[1,1]
        // 排序后 [1,1],[2,3],[4,6],[4,5],[6,7]
        Arrays.sort(envelopes, (o1, o2)
                -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1]);

// 作者：twobugs
// 链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/354-e-luo-si-tao-wa-de-sortlisjie-fa-by-twobugs/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }
}

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





public int maxEnvelopes(int[][] envelopes) {
    int len = envelopes.length;
    if(len == 0 || envelopes[0].length ==0){
        return 0;
    }
    // 排序
    Arrays.sort(envelopes, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        }
    });
    int max =  1;
    // 动态数组: 表示以i为结尾的最大信封数，其中i必须有
    int[] dp = new int[len] ;
    dp[0] = 1;
    for(int i=1;i<len;i++){
        int j = i-1;
        // 初始化为1，至少有一个信封
        dp[i] = 1;
        // 遍历之前的数组
        while(j>=0){
            if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                // 更新 dp[i]
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
            j--;
        }
        max = Math.max(max,dp[i]);
    }
    return max;
}

// 作者：xiaoyiyang
// 链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/e-luo-si-tao-wa-xin-feng-wen-ti-java-dong-tai-gui-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



