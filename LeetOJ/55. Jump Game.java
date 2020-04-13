
/*
 * 
https://leetcode.com/problems/jump-game/

55. Jump Game
Medium

3248

291

Add to List

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

在思维逻辑上，我是正确的，然后在实现上，我是错误的，

 * 
 */





class Solution {
    //4.33pm-5.47pm
    public boolean canJump(int[] nums) {
        
        //使用贪心法，每次选择最大的
        int maxReach=0;
        for(int i=0;i<=maxReach && i<nums.length;i++){
            if(maxReach<nums[i]+i){
                maxReach=nums[i]+i;
            }
        }
        if(maxReach>=nums.length-1){
            return true;
        }
        return false;
    }
}


思路：贪心法，从前往后依次搜索最远达到距离。


class Solution {
    public:
        //贪心法，从前往后搜索最远达到距离
        bool canJump(vector<int>& nums) {
            if(nums.size()==0) return false;
            int reach=nums[0], i=0;
            while(i <= reach && i < nums.size()-1){       
                reach = max(reach, i+nums[i]);    //选择最远达到距离
                i++;
            }
            if(reach >= nums.size()-1) return true;
            return false;        
        }
    
    ————————————————
    版权声明：本文为CSDN博主「沙丁鱼鱼鱼」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/u014694994/article/details/80109039




错误答案:

class Solution {
    //4.33pm-
    public boolean canJump(int[] nums) {
        
        //1. 在有限距离里面寻找目前范围内的最大值，和下一个jump_base_index
        //2. 从下一个jump_base_index开始，继续在下一个范围内寻找
        
        if(nums.length==1) return true;
        
        int max=nums[0];
        int startIndex=0;
        
        int currLeft=startIndex;
        int currRight=startIndex+max;
        
        if(currRight>nums.length-1) return true;

        while(currRight<nums.length&&currLeft<=currRight){
               //在有限距离里面寻找目前范围内的最大值，和下一个jump_base_index
                if(max<=nums[currLeft]){
                     max=Math.max(max, nums[currLeft]);
                     startIndex=currLeft;
                    
                     currLeft=startIndex;
                     currRight=startIndex+max;
                }
            
            System.out.println(startIndex+" "+max);
            
            if(startIndex+max>=nums.length-1){
                return true;
            }
            currLeft++;
            
       
        } 
        
        return false;
    }
}












