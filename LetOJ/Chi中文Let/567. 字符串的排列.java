
/*
 * 
link: 

567. 字符串的排列

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

 

示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false
 

提示：

1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


//超出时间限制
class Solution {
    List<String> list=new ArrayList<>();
    public boolean checkInclusion(String s1, String s2) {
       int l1=s1.length();
       int l2=s2.length();
       getAll(s1.toCharArray(),0,"");

       for(String tmp:list){
        //    System.out.println(tmp);
        if(s2.contains(tmp)){
            return true;
        }
       }

       return false;
    }

    public void getAll(char[] str, int index, String s){
        if(index==str.length){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length;i++){
                sb.append(str[i]+"");
            }
            list.add(sb.toString());
            return;
        }
        for(int i=index;i<str.length;i++){
            swap(str,i,index);
            getAll(str,index+1,s+str[i]);
            swap(str,i,index);
        }
    }

    public void swap(char[] str, int i, int j){
        char tmp=str[i];
        str[i]=str[j];
        str[j]=tmp;
    }
}




















