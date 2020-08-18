
/*
 * 
link: 
https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

2020-8-18 at 8:57 am

1437. 是否所有 1 都至少相隔 k 个元素
难度
中等

5

收藏

分享
切换为英文
关注
反馈
给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。

 

示例 1：



输入：nums = [1,0,0,0,1,0,0,1], k = 2
输出：true
解释：每个 1 都至少相隔 2 个元素。
示例 2：



输入：nums = [1,0,0,1,0,1], k = 2
输出：false
解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
示例 3：

输入：nums = [1,1,1,1,1], k = 0
输出：true
示例 4：

输入：nums = [0,1,0,1], k = 1
输出：true
 

提示：

1 <= nums.length <= 10^5
0 <= k <= nums.length
nums[i] 的值为 0 或 1

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    //8.48am-8.56am
    public boolean kLengthApart(int[] nums, int k) {
        int lastOne=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(lastOne==-1){
                    lastOne=i;
                }else{
                    int dist=i-lastOne-1;
                    if(dist<k){
                        return false;
                    }
                    lastOne=i;
                }
            }
        }
        return true;
    }
}



public class kLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        for (int pre = -100000, next = 0; next < nums.length; next++) {
            if (nums[next] == 1) {
                if (next - pre <= k)
                    return false;
                pre = next;
            }
        }
        return true;
    }
}

// 作者：ustcyyw
// 链接：https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/solution/5401java-zhi-jie-shuang-zhi-zhen-1ms-hen-jian-dan-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
















