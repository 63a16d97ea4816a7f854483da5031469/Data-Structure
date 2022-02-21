
/*
 * 
link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/


3. 无重复字符的最长子串
难度
中等

6902





给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成


2022-02-21 at 20:42
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String,String> map=new HashMap<String,String>();
        LinkedList<String> list=new LinkedList<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            String str=String.valueOf(s.charAt(i));
            String saved=map.get(str);
            if(saved==null){
                map.put(str,"");
                list.add(str);
            }else{
                while(map.get(str)!=null){
                    String removeObj=list.removeFirst();
                    map.put(removeObj,null);
                }
                map.put(str,"");
                list.add(str);
            }

            max=Math.max(max,list.size());
        }
        
        return max;
    }
}




class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] a=new int[128];
        int max=0;
        int left=0;

        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i);
            a[curr]++;  // 累加1到当前character
           
            while(a[curr]>1){
                a[s.charAt(left++)]--;
            }
            max=Math.max(i-left+1,max); 
        }
        return max;
    }
}



















