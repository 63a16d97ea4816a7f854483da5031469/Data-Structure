
/*
 * 
https://leetcode-cn.com/problems/compress-string-lcci/

面试题 01.06. 字符串压缩
难度
简单

字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:

 输入："aabcccccaaa"
 输出："a2b1c5a3"
示例2:

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
提示：

字符串长度在[0, 50000]范围内。

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

28 March 2020 at 2.18pm - 2.36pm
 * 
 */

class Solution {
    //2.18pm - 2.36pm
    public String compressString(String S) {
        //特殊情况
        if(S.equals("")){
            return S;
        }

        StringBuilder sb=new StringBuilder();
        char[] arr=S.toCharArray();

        int n=arr.length;
        int count=1;

        sb.append(arr[0]+"");

        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            }else{
                if(count>=1){
                   sb.append(count+"");
                   count=1;
                }
                sb.append(arr[i+1]);
            }
        }
        //处理最后一个字符
        if(count>=1){
            sb.append(count+"");
        }
        if(sb.toString().length()>=S.length()){
            return S;
        }
        return sb.toString();
    }
}






















