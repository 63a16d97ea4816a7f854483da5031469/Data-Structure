
/*
 * 
https://leetcode.com/problems/trapping-rain-water/description/

42. Trapping Rain Water
Hard

6011

107

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

8 April 2020 at 8.47pm-

 * 
 */


https://blog.csdn.net/liuchonge/article/details/72900074


class Solution {
    //8.47pm-xxx   9.37pm
    public int trap(int[] height) {
         
        //找到最大值索引
        int max=0;
        for(int i=0;i<height.length;i++){
            if(height[max]<height[i]){
                max=i;
            }
        }
        
        int res=0;
        
        int leftmax=0;
        int rightmax=height.length-1;
        //从左侧到max
        for(int i=1;i<max;i++){
            
            if(height[leftmax]>height[i]){
                res+=height[leftmax]-height[i];
            }else{
                leftmax=i;
            }
        }
        
        //从右侧到max
         for(int i=height.length-2;i>max;i--){
             if(height[rightmax]>height[i]){
                 res+=height[rightmax]-height[i];
             }else{
                 rightmax=i;
             }
         }
        
        return res;
    }
}



https://blog.csdn.net/Irving_zhang/article/details/78363052








class Solution {
    //8.47pm-
    public int trap(int[] height) {
        
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(height[i]==0) continue; //skip the left 0 board
            
            for(int j=i+1;j<height.length;j++){
                if(height[j]-height[i]>0){
                    sum+=height[i]-Math.min(height[j],height[i]);
                    break;
                }
            }
            
        }
        
        return sum;
    }
}




















