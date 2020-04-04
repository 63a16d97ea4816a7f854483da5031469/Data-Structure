
/*
 * 

698. Partition to K Equal Sum Subsets
Medium

1403

80

Add to List

Share
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.

4 April 2020 at 11.54am - 12.10pm
 * 
 */


题解：

public boolean canPartitionKSubsets(int[] nums, int k) {

  int total = 0;
  for(int i = 0; i < nums.length; ++i) {
      total += nums[i];
  }
  if(total%k != 0) {
      return false;
  }
  int avg = total /k ;

  return dfs(k, avg, nums, 0, 0, 0, new boolean[nums.length]);
}

public boolean dfs(int k, int expected, int[] nums, int from,  int sum, int matchCount, boolean[] used) {
  if(sum > expected) {
      return false;
  }
  else if(sum == expected) {
      matchCount++;
      if(matchCount == k) {
          return true;
      }
      return dfs(k, expected, nums, 0, 0, matchCount, used);
  }

  for(int i = from; i < nums.length; i++) {
      if(used[i]) continue;

      used[i] = true;
      if(dfs(k, expected, nums, i+1, sum + nums[i], matchCount, used)) {
          return true;
      }

      used[i] = false;
  }
  return false;
}


class Solution {
    // 11.54am - 12.10pm
    //有点像线段树的一种题目,
    //或者是搜索,搜索的话，应该是可以构造出来遍历所有可能的集合的case，如果不符合就返回
    //因为有k限制，特别像BFS
    //BFS这个很像电话号码那个题目 abc efc
    //mark visited, 将这个数字变成一个字母，然后跳过这个特定字母
    //也有点像求音乐那个题目，但是要求更多的是得相等
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //处理极端case
        if(nums.length<k){
            return false;
        }
        //处理刚好相等的case
        if(nums.length==k){
            for(int i=1;i<nums.length;i++){
                if(nums[i-1]!=nums[i]){
                    return false;
                }
            }
            return true;
        }
        
        
        
    }
    
    boolean bfs(List<List<Integer>> list, int[] nums, int k){
        //将所有的可能的sum的集合求出来
        
        Queue que=new LinkedList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            
        }
        
        
    }
    
    
}



















