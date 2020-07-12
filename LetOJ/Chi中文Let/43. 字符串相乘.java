
/*
 * 
link: 
https://leetcode-cn.com/problems/multiply-strings/

2020-7-12 at 11:33 am

43. 字符串相乘
难度
中等

383

收藏

分享
切换为英文
关注
反馈
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

 * 
 */


/**
 * Copyright © 2018 by afei. All rights reserved.
 * 
 * @author: afei
 * @date: 2018年11月7日
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(multiply("123456", "0"));
        System.out.println(multiply("25", "4"));
    }
    
    public static String multiply(String num1, String num2) {
        char[] value = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                value[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 处理进位
        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }
        // 处理前端的 0
        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) {
            beginIndex++;
        }
        for (int i = beginIndex; i < value.length; i++) {
            value[i] += '0';
        }
        return new String(value, beginIndex, value.length - beginIndex);
    }
}





class Solution {
    //11.39am-12.05pm 看了题解
    public static String multiply(String num1, String num2) {
        char[] value = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                value[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 处理进位
        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }
        // 处理前端的 0
        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) {
            beginIndex++;
        }
        for (int i = beginIndex; i < value.length; i++) {
            value[i] += '0';
        }
        return new String(value, beginIndex, value.length - beginIndex);
    }
}
 


class Solution {
    //6.50pm-7.02pm （看过题解后，复原 ）
    public String multiply(String num1, String num2) {
        char[] value=new char[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
            for(int j=num2.length()-1;j>=0;j--){
                value[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        
        //解决进位问题
        int carry=0;
        for(int i=value.length-1;i>=0;i--){
            value[i]+=carry;
            carry=value[i]/10;
            value[i]%=10;  //不能写成 value[i]=value[i]%10; 编译器会提示精度丢失
        }
        //解决前头有0的问题
        int beginIndex=0;
        while(beginIndex<value.length-1&&value[beginIndex]==0){
            beginIndex++;
        }
        for(int i=beginIndex;i<value.length;i++){
            value[i]+='0';
        }
        return new String(value,beginIndex, value.length-beginIndex);
    }
}