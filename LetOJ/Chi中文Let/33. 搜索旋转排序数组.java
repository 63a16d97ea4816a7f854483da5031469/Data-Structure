
/*
 * 
link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

33. 搜索旋转排序数组
难度
中等

1793

收藏

分享
切换为英文
关闭提醒
反馈
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

 

示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1
 

提示：

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4



2022-01-23 at 19:02
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


错误输入：
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target);
    }

    public int binarySearch(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;

            if(nums[mid]==target) return mid;

            if(nums[l]<=nums[mid]){
                if(nums[mid]>target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else {
                if(nums[mid]>target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}






2,1,0,-1,5,6,7,


二分查找只能在有序的区间里面去查找，对于倒序的是没法查找的，所以只能定位到有序的区间，跳到那里去继续寻找
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target);
    }

    public int binarySearch(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;

            if(nums[mid]==target) return mid;

            if(nums[0]<=nums[mid]){
                // target 在这个区间内
                if(nums[0]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else {
                // target 在这个区间内
                if(nums[mid]<target && target<=nums[nums.length-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}




class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target);
    }

    public int binarySearch(int[] nums, int target){
        int l=0;
        int r=nums.length-1;

        while(l<=r){

            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            //  只能感觉nums[mid]与nums[l]确定，mid是在左边半段还是在右边半段
            if(nums[l]<=nums[mid]){
                //如果是在左边半段，那么我们只能在左边是升序的时候，使用二分查找规则，另一种情况只能用反之else来handle
                //确定target在左边界与mid形成的右边界里面
                if(nums[l]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{  
                //如果是在右边半段，那么我们只能在右边是升序的时候，使用二分查找规则，另一种情况只能用反之else来handle
                if(nums[mid]<target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}








