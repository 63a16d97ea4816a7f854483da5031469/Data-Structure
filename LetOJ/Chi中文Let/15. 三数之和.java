
/*
 * 
link: 
https://leetcode-cn.com/problems/3sum/

2020-7-12 at 8:46 pm

15. 三数之和
难度
中等

2364

收藏

分享
切换为英文
已关注
反馈
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}



//通过：

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            for(int first=i+1,last=nums.length-1;first<last;){
                // System.out.println(nums[i]+" "+nums[first]+" "+nums[last]);
                int sum=nums[i]+nums[first]+nums[last];
               if(sum==0){
                   List<Integer> tmp=new ArrayList<Integer>();
                   tmp.add(nums[i]);
                   tmp.add(nums[first]);
                   tmp.add(nums[last]);
                   ans.add(new ArrayList<Integer>(tmp));
                    first++;
                    last--;
                    
                    while(first<last&&nums[first]==nums[first-1]){
                        first++;
                    }
                    while(first<last&&nums[last]==nums[last+1]){
                        last--;
                    }

               }else if(sum>0){
                   last--;
               }else{
                   first++;
               }
                
            }
        }
        return ans;
    }
}







//超时

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            for(int first=i+1,last=nums.length-1;first<last;){
                // System.out.println(nums[i]+" "+nums[first]+" "+nums[last]);
                int sum=nums[i]+nums[first]+nums[last];
               if(sum==0){
                   List<Integer> tmp=new ArrayList<Integer>();
                   tmp.add(nums[i]);
                   tmp.add(nums[first]);
                   tmp.add(nums[last]);
                   if(!ans.contains(tmp)){   //这句特别耗时
                      ans.add(new ArrayList<Integer>(tmp));
                   }
                    first++;
                    last--;
                    
                    while(first<last&&nums[first]==nums[first-1]){
                        first++;
                    }
                    while(first<last&&nums[last]==nums[last+1]){
                        last--;
                    }

               }else if(sum>0){
                   last--;
               }else{
                   first++;
               }
                
            }
        }
        return ans;
    }
}









// 311/313 超时

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<=nums.length-2;i++){
            for(int first=i+1,last=nums.length-1;first<last;){
                System.out.println(nums[i]+" "+nums[first]+" "+nums[last]);
                int sum=nums[i]+nums[first]+nums[last];
               if(sum==0){
                   List<Integer> tmp=new ArrayList<Integer>();
                   tmp.add(nums[i]);
                   tmp.add(nums[first]);
                   tmp.add(nums[last]);
                   if(!ans.contains(tmp)){
                      ans.add(new ArrayList<Integer>(tmp));
                   }
                    first++;
                    last--;
               }else if(sum>0){
                   last--;
               }else{
                   first++;
               }
                
            }
        }
        return ans;
    }
}

//总是无法过一些case:
// 输入：
// [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
// 输出：
// [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4]]
// 预期：
// [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<=nums.length-2;i++){
            for(int first=i+1,last=nums.length-1;first<last;){
                while(first+1<nums.length-1&&nums[first]==nums[first+1]){
                    first++;
                }
                while(last-1>0&&nums[last-1]==nums[last]){
                    last--;
                }
                System.out.println(nums[i]+" "+nums[first]+" "+nums[last]);
                int sum=nums[i]+nums[first]+nums[last];
               if(sum==0){
                   List<Integer> tmp=new ArrayList<Integer>();
                   tmp.add(nums[i]);
                   tmp.add(nums[first]);
                   tmp.add(nums[last]);
                   if(!ans.contains(tmp)){
                      ans.add(new ArrayList<Integer>(tmp));
                   }
                    first++;
                    last--;
               }else if(sum>0){
                   last--;
               }else{
                   first++;
               }
            }
        }
        return ans;
    }
}








