
/*
 * 
https://leetcode.com/problems/maximum-product-subarray/


152. Maximum Product Subarray
Medium

3425

141

Add to List

Share
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

10 April 2020 at 10.54pm - 11.00pm
 * 
 */


class Solution {
    //10.42pm 
    
    //10.54pm - 11.00pm  题解
   
    public int maxProduct(int[] nums) {
        
        //处理极限情况
        if(nums.length==0) return 0;
        
        //由于包含负数，所以本次最大值，有可能是从 最大数与该位相乘的结果，也可能是最小数与该位相乘的结果
        int max=nums[0];
        
        int currMax=nums[0];
        int currMin=nums[0];
        
        for(int i=1;i<nums.length;i++){
            
            int curr=nums[i];
            //上次结果，跟这次相乘的结果
            int tmpMax=Math.max(curr*currMin, curr*currMax);
            int tmpMin=Math.min(curr*currMin, curr*currMax);
            
            currMax=Math.max(tmpMax, nums[i]);
            currMin=Math.min(tmpMin, nums[i]);
                
            max=Math.max(max, currMax);
        }
         
        return max;
    }
    

     
}








四年前的方法，分治思想

public class Solution {
    public int maxProduct(int[] nums) {
         int current_max=-1;
         boolean zeroFlag=false;
 
         int lastZero=-1;
 
         for(int i=0;i<nums.length;i++){
 
             if (nums[i]==0){
                 zeroFlag=true;
             }
         }
 
         if(zeroFlag) {
 
             List<Integer> list=new ArrayList<Integer>();
             int i = 0;
 
             while (i < nums.length) {
                 if (nums[i]==0) {
 
                     int k=0;
                     int[] newArr=new int[list.size()];
                     for(int tmp:list){
                         newArr[k++]=tmp;
                     }
                     int returnValue=maxProductSub(newArr);
                     current_max=Math.max(current_max,returnValue);
                     list.clear();
                 }else{
                     list.add(nums[i]);
 
 
                     if(i==nums.length-1){
                         int k=0;
                         int[] newArr=new int[list.size()];
                         for(int tmp:list){
                             newArr[k++]=tmp;
                         }
                         int returnValue=maxProductSub(newArr);
                         current_max=Math.max(current_max,returnValue);
                     }
 
                 }
  
                 i++;
             }
         }
 
         if(current_max==-1){
             return maxProductSub(nums);
         }
 
 
         return current_max;
     }
 
 
 
     public int maxProductSub(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
 
         /*
          if there is ==> 0
          */
 
         int count = 0;
         int allNumProd = 1;
 
         for (int tmp : nums) {
             allNumProd *= tmp;
             if (tmp < 0) count++;
         }
         if (count % 2 != 0) {
 
 
             int max_end_value = nums[0];
             int max_so_far = nums[0];
             int fromCurrentPointMax=nums[0];
             int fromCurrentPointMaxRev=nums[0];
             for (int i = 1; i < nums.length; i++) {
                 max_end_value = Math.max(nums[i] * max_end_value, nums[i]);
                 max_so_far = Math.max(max_so_far, max_end_value);
  
                 int[] newArrSec=new int[nums.length-i];
                 int[] newRevSec=new int[nums.length-i];
                 int p=0;
                 for(int j=i;j<=nums.length-1;j++){
                     newArrSec[p++]=nums[j];
                    System.out.print(nums[j]+" ");
                 }
                System.out.println();
 
                 int pp=0;
                 int u=nums.length-i-1;
                 for(int y=0;y<=u;y++){
                    // System.out.print(nums[y]+" ");
                     newRevSec[y]=nums[y];
 
                 }
                // System.out.println();
 
 
                 fromCurrentPointMax=maxProductSub(newArrSec);
                 fromCurrentPointMaxRev=maxProductSub(newRevSec);
                System.out.println(fromCurrentPointMax+","+fromCurrentPointMaxRev);
                 int tmp=Math.max(fromCurrentPointMax,fromCurrentPointMaxRev);
                 max_so_far=Math.max(max_so_far,tmp);
 
             }
 
             return max_so_far;
         } else {
             return allNumProd;
         }
 
     }
 }





















