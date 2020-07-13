
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-consecutive-sequence/

2020-7-12 at 11:25 pm

128. 最长连续序列
难度
困难

459

收藏

分享
切换为英文
关注
反馈
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




    //11.47pm-11.51pm 看过答案
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int tmp:nums){
            set.add(tmp);
        }
        
        int max=0;
        
        for(int tmp:set){
            if(!set.contains(tmp-1)){
                int currNumber=tmp;
                int longthNumber=1;
                while(set.contains(currNumber+1)){
                    currNumber++;
                    longthNumber++;
                }
                max=Math.max(max,longthNumber);
            }
        }
        return max;
    }
}














