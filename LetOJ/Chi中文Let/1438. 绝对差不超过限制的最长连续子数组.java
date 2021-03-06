
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

2020-8-18 at 9:00 am

1438. 绝对差不超过限制的最长连续子数组
难度
中等

38

收藏

分享
切换为英文
关注
反馈
给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。

如果不存在满足条件的子数组，则返回 0 。

 

示例 1：

输入：nums = [8,2,4,7], limit = 4
输出：2 
解释：所有子数组如下：
[8] 最大绝对差 |8-8| = 0 <= 4.
[8,2] 最大绝对差 |8-2| = 6 > 4. 
[8,2,4] 最大绝对差 |8-2| = 6 > 4.
[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
[2] 最大绝对差 |2-2| = 0 <= 4.
[2,4] 最大绝对差 |2-4| = 2 <= 4.
[2,4,7] 最大绝对差 |2-7| = 5 > 4.
[4] 最大绝对差 |4-4| = 0 <= 4.
[4,7] 最大绝对差 |4-7| = 3 <= 4.
[7] 最大绝对差 |7-7| = 0 <= 4. 
因此，满足题意的最长子数组的长度为 2 。
示例 2：

输入：nums = [10,1,2,4,7,2], limit = 5
输出：4 
解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
示例 3：

输入：nums = [4,2,2,2,4,4,2,2], limit = 0
输出：3
 

提示：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

//用单调队列维护当前窗口的最大值和最小值，保持最大值与最小值的差小于 limit 即可。
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //这里维护的是最大值们对应的下标
        Deque<Integer> maxQ=new LinkedList<>();
        Deque<Integer> minQ=new LinkedList<>();
        int ans=0;
        //窗口左沿
        int start=0;
        //窗口右沿
        for (int end=0; end<nums.length;end++){
            //右沿元素进入窗口、维护最大值单调队列
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()]<nums[end]){
                maxQ.pollLast();
            }
            maxQ.add(end);
            //右沿元素进入窗口、维护最小值单调队列
            while(!minQ.isEmpty() && nums[minQ.peekLast()]>nums[end]){
                minQ.pollLast();
            }
            minQ.add(end);

            //如果当前窗口的最大值最小值的差大于 limit，则不断缩小窗口（左沿++），直至最大值变小或者最小值变大从而满足 limit 限制
            while(!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peek()]-nums[minQ.peek()]>limit){
                if(maxQ.peek()<=start) maxQ.poll();
                if(minQ.peek()<=start) minQ.poll();
                start++;
            }
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }
}

// 作者：orangex
// 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-chang-lia/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // 两个单调队列分别维护从left到right之间的最大值最小值
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int result = 0;
        int left = 0, right = 0;
        minDeque.offer(0);
        maxDeque.offer(0);
        while (right < nums.length) {
            int minIdx = minDeque.peekFirst();
            int maxIdx = maxDeque.peekFirst();
            if (nums[maxIdx] - nums[minIdx] <= limit) {
                // 最大值与最小值之差小于等于限制的情况下右指针右移
                result = Math.max(result, right - left + 1);
                ++right;
                // 维护两个单调队列
                while (right < nums.length && minDeque.size() > 0 && nums[right] < nums[minDeque.peekLast()]) {
                    minDeque.pollLast();
                }
                minDeque.offerLast(right);
                while (right < nums.length && maxDeque.size() > 0 && nums[right] > nums[maxDeque.peekLast()]) {
                    maxDeque.pollLast();
                }
                maxDeque.offerLast(right);
            }
            else {
                // 最大值与最小值之差大于限制的情况下左指针右移
                left = Math.min(minIdx, maxIdx) + 1;
                while (minDeque.size() > 0 && minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
                while (maxDeque.size() > 0 && maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
            }
        }
        return result;
    }
}

// 作者：cjjohn
// 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/shuang-zhi-zhen-dan-diao-dui-lie-on-by-cjjohn/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums ==null || nums.length==0)
            return 0;
        int curr_max = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        int curr_min = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        Queue<Integer> sub_nums = new LinkedList<>();
        
        for(int num:nums){
            if (Math.abs(num - curr_max) <=  limit && Math.abs(num - curr_min) <=  limit && Math.abs(curr_max - curr_min) <= limit) {
                curr_max = Math.max(num,curr_max);
                curr_min = Math.min(num,curr_min);
                sub_nums.offer(num);
            }else{
                sub_nums.offer(num);
                sub_nums.poll();
                curr_max = Collections.max(sub_nums); // 当子数组最大值
                curr_min = Collections.min(sub_nums); // 当前子数组最小值
            }
        }

        return sub_nums.size();
    }
}

// 作者：javaniuniu
// 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/hua-dong-chuang-kou-shi-jian-0n-kong-jian-0n-by-ja/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









