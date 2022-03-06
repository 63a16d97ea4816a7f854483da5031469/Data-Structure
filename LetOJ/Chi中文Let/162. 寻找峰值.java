
/*
 * 
link: https://leetcode-cn.com/problems/find-peak-element/

162. 寻找峰值
难度
中等

696

收藏

分享
切换为英文
接收动态
反馈
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

 

示例 1：

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。
示例 2：

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
 

提示：

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]


2022-02-02 at 19:04
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:

刚开始想到二分查找，但是二分查找是对有序数组。


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        for(int i=1;i<=nums.length-2;i++){
            if(nums[i-1]<nums[i]&&nums[i]>nums[i+1]){
                return i;
            }
            if(i==nums.length-2&&nums[nums.length-1]>nums[i]){
                return i+1;
            }
            if(i==1&&nums[0]>nums[i]){
                return 0;
            }
        }
        return 0;
    }
}




class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode-solution-96sj/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int ans=0;
        while(l<=r){
            int mid=(l+r)/2;
            // [易错] 注意这里的符号规则
            if(compare(getNum(nums,mid-1),getNum(nums,mid))<0 &&
            compare(getNum(nums,mid),getNum(nums,mid+1))>0){
                return mid;
            }
            if(compare(getNum(nums,mid),getNum(nums,mid+1))<0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    public int[] getNum(int[] nums, int id){
        //[易错]注意这里是-1 和 nums.length
        if(id==-1||id==nums.length){
            return new int[]{0,0};
        }
        return new int[]{1,nums[id]};
    }
    public int compare(int[] one, int[] two){
        if(one[0]!=two[0]){
            //[易错]注意这里的正好和负号
            return one[0]>two[0]?1:-1;
        }
 
        if(one[1]==two[1]){
            return 0;
        }
        return one[1]>two[1]?1:-1;
    }
}






