
/*
 * 
link: 
https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/

2020-7-12 at 10:52 pm

674. 最长连续递增序列
难度
简单

89

收藏

分享
切换为英文
关注
反馈
给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。

 

示例 1:

输入: [1,3,5,4,7]
输出: 3
解释: 最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
示例 2:

输入: [2,2,2,2,2]
输出: 1
解释: 最长连续递增序列是 [2], 长度为1。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



// AC:
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int max=1;
        for(int i=nums.length-1;i>=1;i--){
            int tmp=1;
            for(int j=i;j>0;j--){
                if(nums[j]>nums[j-1]){
                    tmp++;
                }else{
                    tmp=0;
                }
                max=Math.max(tmp,max);
            }
        }
    return max;
    }
}

//更改后AC：

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int max=1;
        
        int tmp=1;
            for(int j=nums.length-1;j>0;j--){
                if(nums[j]>nums[j-1]){
                    tmp++;
                }else{
                    tmp=1;
                }
                max=Math.max(tmp,max);
            }
    return max;
    }
}




class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int ans = 1;
        int count = 1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i+1] > nums[i]) {
                count++;
            } else {  
                count = 1;
            }
            ans = count > ans ? count : ans;
        }
        return ans;
    }
}

// 作者：guanpengchn
// 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/hua-jie-suan-fa-674-zui-chang-lian-xu-di-zeng-xu-l/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




// 思路：
// 1、记录递增序列的起始位置i
// 2、j++查找递增序列的结束位置
// 3、计算递增序列的长度，并且保存最大值

public int findLengthOfLCIS(int[] nums) {
    //长度为1的时候
    if (nums.length <= 1){
        return nums.length;
    }
    //记录起始位置
    int i = 0;
    //记录最大长度
    int ans = 0;
    for (int j = 1; j < nums.length; j++){
        //递增序列的结尾
        if (nums[j]<= nums[j-1]){
            i = j;
        }
        //保留最大长度
        ans = Math.max(ans, j-i+1);
    }
    return ans;
}

// 作者：rooki
// 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/javazui-chang-lian-xu-di-zeng-xu-lie-by-rooki/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





