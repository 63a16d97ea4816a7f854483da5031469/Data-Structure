
/*


46. Permutations
Medium

3271

95

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

7 April 2020 at 11.51 pm
 * 
 */





class Solution {
    
    List<List<Integer>> flist=new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
 
        permutation(nums,0,nums.length);
        
        return flist;
    }
    
    void permutation(int[] nums, int start, int end){
        
        if(start==end){
            List<Integer> list=new ArrayList<Integer>();
            
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            
            flist.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=start;i<nums.length;i++){
    
            swap(nums,start,i);
            permutation(nums,start+1,end);
            swap(nums,start,i); 
        }
        
    }
    
    void swap(int[] nums, int i, int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}





46. Permutations


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> flist=new ArrayList<List<Integer>>();
        
        permutation(nums,0,nums.length,list,flist);
        
        return flist;
    }
    
    void permutation(int[] nums, int start, int end, List<Integer> list, List<List<Integer>> flist){
        
        if(start==end){
            flist.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            
            list.add(nums[i]);
            
            swap(nums,start,i);
            permutation(nums,start+1,end,list,flist);
            swap(nums,start,i);
            
            list.remove(new Integer(nums[i]));
        }
        
    }
    
    void swap(int[] nums, int i, int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}





















