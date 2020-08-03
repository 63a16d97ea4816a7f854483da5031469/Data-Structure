
/*
 * 
link: 
https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

2020-8-3 at 9:09 am

剑指 Offer 05. 替换空格
难度
简单

31

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

限制：

0 <= s 的长度 <= 10000

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    //9.08am-9.08am
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}


//稍微看了一下提示
class Solution {
    public String replaceSpace(String s) {
        char[] c=s.toCharArray();
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(c[i]==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else{
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}





class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

// 作者：画手大鹏
// 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzn4b6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





