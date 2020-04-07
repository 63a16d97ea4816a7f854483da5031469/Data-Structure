
/*
 * 

40. Combination Sum II
Medium

1435

56

Add to List

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
Accepted
297,004
Submissions
643,602


7 April 2020 at // 10.18pm - 10.43pm
 * 
 */


class Solution {
    // 10.18pm - 10.43pm
   //10.53pm-10.55pm 重新回过头来纠正那个小问题   // list.remove(list.size()-1); ===>要用这个，因为sort了 list.remove(new Integer(candidates[i]));
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> flist=new ArrayList<List<Integer>>();
        
 
        getCombination(candidates,target,target,new boolean[candidates.length],list,flist);
        
        return flist;
        
    }
    
    void getCombination(int[] candidates, int target, int sum, boolean[] used, List<Integer> list, List<List<Integer>> flist){
        
        if(sum==0){
         
            Collections.sort(list);
            if(!flist.contains(list)){
                  flist.add(new ArrayList<Integer>(list));
                  list=new ArrayList<Integer>();
            }
      
              return;
        }
        
        if(sum<0) return;
        
        for(int i=0;i<candidates.length;i++){
            
            if(used[i]) continue;
            
            list.add(candidates[i]);
            used[i]=true;
            
            getCombination(candidates, target, sum-candidates[i], used, list, flist);
            
            //put back mark
            used[i]=false;
            // list.remove(list.size()-1);
            list.remove(new Integer(candidates[i]));
        }
    }
}






Wrong answer:


class Solution {
    // 10.18pm - 10.43pm
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> flist=new ArrayList<List<Integer>>();
        
 
        getCombination(candidates,target,target,new boolean[candidates.length],list,flist);
        
        return flist;
        
    }
    
    void getCombination(int[] candidates, int target, int sum, boolean[] used, List<Integer> list, List<List<Integer>> flist){
        
        if(sum==0){
         
            Collections.sort(list);
            if(!flist.contains(list)){
                  flist.add(new ArrayList<Integer>(list));
                  list=new ArrayList<Integer>();
            }
      
              return;
        }
        
        if(sum<0) return;
        
        for(int i=0;i<candidates.length;i++){
            
            if(used[i]) continue;
            
            list.add(candidates[i]);
            used[i]=true;
            
            getCombination(candidates, target, target-candidates[i], used, list, flist);
            
            //put back mark
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}











39. Combination Sum

public class Solution {
    // 10.43pm-10.53pm
   public List<List<Integer>> combinationSum(int[] candidates, int target) {


        if(candidates==null||candidates.length==0) return new ArrayList<List<Integer>>();

        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        getCombination(candidates,0,target,list,result);

        return result;
    }
 
    
    void getCombination(int[] nums, int sum, int target, List<Integer> list, List<List<Integer>> result){
        
        
        if(sum==target) {
            
            Collections.sort(list);
            
            if(!result.contains(list)){
                result.add(new ArrayList<Integer>(list));
                list=new ArrayList();
            }
            
        
            return;
        }
        
        if(sum>target) return;
        
        for(int i=0;i<nums.length;i++){
            
            list.add(nums[i]);
            
            getCombination(nums,nums[i]+sum,target, list,result);
            
            // list.remove(list.size()-1);  不可以使用这个语句，因为我用了sort，sort之后数组的最后一位就不是刚添加的那个
            list.remove(new Integer(nums[i]));            
        }
    }
}
   