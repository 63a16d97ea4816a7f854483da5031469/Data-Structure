
/*
 * 
link: https://leetcode-cn.com/problems/longest-common-prefix/

14. 最长公共前缀
难度
简单

1982

收藏

分享
切换为英文
接收动态
反馈
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

 

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 

提示：

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成



2022-01-23 at 20:52
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        int count=strs.length;
        for(int i=1;i<count;i++){
            prefix=getLongestCommon(prefix,strs[i]);
            if(prefix.length()==0){
                break;
            }
        }
        return prefix;
    }
    public String getLongestCommon(String str1, String str2){
        int minLength=Math.min(str1.length(),str2.length());
        int index=0;
        while(index<minLength && str1.charAt(index)==str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}
















