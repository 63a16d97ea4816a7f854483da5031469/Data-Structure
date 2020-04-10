
/*
 * 
https://leetcode.com/problems/subsets-ii/

90. Subsets II
Medium

1415

61

Add to List

Share
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


10 April 2020 at 9.58pm
 * 
 */









AC:

class Solution {
  
    List<List<Integer>> list=new ArrayList<List<Integer>>();
   public List<List<Integer>> subsetsWithDup(int[] nums) {
        
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
       
       for(int i=curr;i<nums.length;i++){
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









超时：

Submission Detail
16 / 19 test cases passed.
Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
[1,2,3,4,5,6,7,8,10,0]

class Solution {
  
     List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         
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








class Solution {
  
 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        
        for(int i=0;i<=n;i++){
            
            findSet(nums, 0, nums.length, i, list, result, new boolean[nums.length]);
        }
        return result;
    }
     
     void findSet(int[] nums, int start, int end, int m, ArrayList<Integer> pass, ArrayList<List<Integer>> result, boolean[] used){
         
         if(m==0) {
             Collections.sort(pass);
             //使用result.add(pass); 是极端错误的，因为pass这个list还会继续被改变，最后只会是空的
             if(!result.contains(pass)){
                  result.add(new ArrayList<Integer>(pass));
             }
             pass=new ArrayList<Integer>();
             
             return;
         }
         for(int i=start;i+m<=end;i++){
             if(used[i]) continue;
             used[i]=true;
             pass.add(nums[i]);
             findSet(nums,i+1, end,m-1, pass, result,used);
             pass.remove(pass.size()-1);
             used[i]=false;
         }   
     }
 } 












