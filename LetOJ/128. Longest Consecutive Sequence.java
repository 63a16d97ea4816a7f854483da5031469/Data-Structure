
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



// TC: (O(N))
class Solution {
    //https://blog.csdn.net/liuchonge/article/details/73385561
     public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        //先将数组中的每个数添加到set中，实现去重；
        for(int n: nums) set.add(n);
        int max = 0;
        //接下来遍历数组
        for(int n: nums){
            int count = 0;
            //如果set已经空，则返回；
            if(set.isEmpty()) break;
            //对于数组中的数，将其左右相连的数都remove掉，这样set会越来越小
            int val = n;
            while(set.remove(val--))
                count ++;
            val = n;
            while(set.remove(++val))
                count ++;
            //判断完每个连续的数块，就更新一次最大值
            max = Math.max(count,max);
        }
        return max;
    }
}






class Solution {
    //5.31pm-5.40pm  AC:
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












