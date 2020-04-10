
/*
 * 
https://leetcode.com/problems/subsets/

78. Subsets
Medium

3087

72

Add to List

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

20 March 2020 at 8:33:31 pm
 * 
 */


class Solution {
 
    public List<List<Integer>> subsets(int[] nums) {
         int n=nums.length;
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        
        for(int i=0;i<=n;i++){
            
            findSet(nums, 0, nums.length, i, list, result);
        }
        
        
        return result;
    }
     
     void findSet(int[] nums, int start, int end, int m, ArrayList<Integer> pass, ArrayList<List<Integer>> result){
         
         if(m==0) {
             result.add(new ArrayList<Integer>(pass));
             return;
         }
         
         
         for(int i=start;i+m<=end;i++){
             pass.add(nums[i]);
             findSet(nums,i+1, end,m-1, pass, result);
             pass.remove(pass.size()-1);
         }
         
     }
     
     
     
 }



题解：
class Solution {
 
    public List<List<Integer>> subsets(int[] nums) {
         int n=nums.length;
         ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
         ArrayList<Integer> temp = new ArrayList<Integer>();
         for(int i=0;i<=n;i++){
             subset(nums,res,temp,i,0,n);
         }
         return res;
     }
     public void subset(int[] nums,List<List<Integer>> res, List<Integer> temp, int m, int start,int end){
         if(m==0){
             res.add(new ArrayList<Integer>(temp));
             return;
         }
         else{
             for(int i=start;i+m<=end;i++){
                 temp.add(nums[i]);
                 subset(nums,res,temp,m-1,i+1,end);
                 temp.remove(temp.size()-1);
             }
         }
     }
     
 }



Submission Detail
9 / 10 test cases passed.
Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
[1,2,3,4,5,6,7,8,10,0]


class Solution {
    //8.50pm -8.59pm
    
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {

        list.add(new ArrayList<Integer>());
 
         dfs(nums, new ArrayList<Integer>(), 0,nums.length,new boolean[nums.length]);
        
        return list;
    }
    
    void dfs(int[] nums, List<Integer> pass, int curr, int n, boolean[] used){
        
        if(curr==n){
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            
            pass.add(nums[i]);
            //mark this value
            used[i]=true;
             
            Collections.sort(pass);
            if(!list.contains(pass)){
                list.add(new ArrayList<Integer>(pass));
            }
            
            dfs(nums, pass, curr+1, n, used);
            
            pass.remove(new Integer(nums[i]));
            used[i]=false;
        }
        
    } 
    
}


Submission Detail
9 / 10 test cases passed.
Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
[1,2,3,4,5,6,7,8,10,0]

class Solution {
    //8.50pm - 8.59pm
    
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {

        list.add(new ArrayList<Integer>());
        for(int i=1;i<=nums.length;i++){
            dfs(nums, new ArrayList<Integer>(), 0,i,new boolean[nums.length]);
        }
        return list;
    }
    
    void dfs(int[] nums, List<Integer> pass, int curr, int n, boolean[] used){
        
        if(curr==n){
            Collections.sort(pass);
            if(!list.contains(pass)){
                list.add(new ArrayList<Integer>(pass));
                pass=new ArrayList<Integer>();
            }
       
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            
            pass.add(nums[i]);
            //mark this value
            used[i]=true;
            dfs(nums, pass, curr+1, n, used);
            
            pass.remove(new Integer(nums[i]));
            used[i]=false;
        }
        
    } 
    
}















