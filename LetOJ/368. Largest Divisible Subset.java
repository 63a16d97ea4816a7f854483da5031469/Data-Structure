
/*
 * 
https://leetcode.com/problems/largest-divisible-subset/


368. Largest Divisible Subset
Medium

1062

51

Add to List

Share
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]

14 June 2020 at 12:05 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


https://www.coursera.org/lecture/suanfa-jichu/zui-chang-shang-sheng-zi-xu-lie-tOhEr

 * 
 */

// 动态规划：

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0)
            return result;

        Arrays.sort(nums);

        int[] t = new int[nums.length];
        int[] index = new int[nums.length];
        Arrays.fill(t, 1);
        Arrays.fill(index, -1);

        int max=0;
        int maxIndex=-1;

        for(int i=0; i<t.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0 && t[j]+1>t[i]){
                    t[i]=t[j]+1;
                    index[i]=j;
                }
            }

            if(max<t[i]){
                max=t[i];
                maxIndex=i;
            }
        }

        int i=maxIndex;
        while(i>=0){
            result.add(nums[i]);
            i=index[i];
        }

        return result;
    }
}





// 超时：

public class Solution {
    List<Integer> answer;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();
 
        Arrays.sort(nums);
 
        int[] max = new int[1];
        List<Integer> result = new ArrayList<Integer>();
        helper(nums, 0, result, max);
        return answer;
    }
 
    public void helper(int[] nums, int start, List<Integer> result, int[] max){
        if(result.size()>max[0]){
            max[0]=result.size();
            answer=new ArrayList<Integer>(result);
        }
 
        if(start==nums.length)
            return;
 
        for(int i=start; i<nums.length; i++){
            if(result.size()==0){
                result.add(nums[i]);
                helper(nums, i+1, result, max);
                result.remove(result.size()-1);
 
            }else{
 
                int top = result.get(result.size()-1);
                if(nums[i]%top==0){
                    result.add(nums[i]);
                    helper(nums, i+1, result, max);
                    result.remove(result.size()-1);
                }
            }
        }
    }
}













