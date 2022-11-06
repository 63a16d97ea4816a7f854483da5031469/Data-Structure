
/*
 * 
link: 


DATE: 2022-November-05
TIME: 23:35:20

面试题 10.03. 搜索旋转数组
中等
111
相关企业
搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

示例1:

 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 输出: 8（元素5在该数组中的索引）
示例2:

 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 输出：-1 （没有找到）
提示:

arr 长度范围在[1, 1000000]之间
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 错误解法 (这个解法,适合没有重复的旋转数组):
class Solution {
    public int search(int[] arr, int target) {
        return binarySearch(arr,target);
    }

    public int binarySearch(int[] arr, int target){
        int l=0;
        int r=arr.length-1;

        while(l<=r){

            int mid=(l+r)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(arr[0]<=arr[mid]){
                if(arr[0]<=target && target<arr[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(arr[mid]<target && target<=arr[arr.length-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}




// 有重复的旋转数组:
class Solution {
    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 如果找到相等的,一定要找到最左边的
            if (arr[mid] == target) {
                while (mid > 1 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] > arr[left]) {
                // 如果是正常顺序,正序的
                // 如果target在 {arr[left],arr[mid]}
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                // 如果是反序的
                // 如果target在 {arr[mid], arr[right]} 里面
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 如果是相等(arr[mid]==arr[left])
                left++;
            }
        }
        return -1;
    }
}

// 作者：小魏想进大厂
// 链接：https://leetcode.cn/problems/search-rotate-array-lcci/solutions/1509044/by-xiaowei_algorithm-0v63/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。











