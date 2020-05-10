
/*
 * 
https://leetcode.com/problems/longest-consecutive-sequence/

128. Longest Consecutive Sequence
Hard

2930

165

Add to List

Share
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

10 May 2020 at 5:41 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    //5.31pm-5.40pm
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        HashSet<Integer> set=new HashSet();
        for(int tmp:nums){
            set.add(tmp);
        }
        List<Integer> list=new ArrayList<Integer>();
        for(Integer tmp:set){
            list.add(tmp);
        }
        //错误写法
        // for(int i=0;i<set.size();i++){
        //     list.add(set.get(i));
        // }
        Collections.sort(list);
        // for(Integer tmp:list){
        //     System.out.print(tmp+" ");
        // }
        int curr_length=1;
        int max=1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1)-list.get(i)==1){
                curr_length++;
                if(max<curr_length){
                    max=curr_length;
                }
            }else{
                curr_length=1;
            }
        }
        return max;
    }
}



















