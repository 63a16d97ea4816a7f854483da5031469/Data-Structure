
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


46. Permutations
Medium

3384

98

Add to List

Share
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //8.03pm-8.26pm 看了题解。写错了一个参数
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        createPermutation(nums, 0);
        return result;
    }
    void createPermutation(int[] nums, int start){
           if(start==nums.length){
               List<Integer> list=new ArrayList<Integer>();
               for(int tmp:nums){
                   list.add(tmp);
               }
               result.add(list);
           }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            createPermutation(nums, start+1);
            swap(nums,i,start);
        }
    }
    void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}












class Solution {
    //8.03pm-
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        
        createPermutation(nums, 0);
        
        return result;
    }
    
    
    void createPermutation(int[] nums, int start){
           if(start==nums.length)
            System.out.println(Arrays.toString(nums));
 
        
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            createPermutation(nums, i+1);
        
            swap(nums,i,start);
        }
    }
    
    void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    
}


[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[3, 2, 1]