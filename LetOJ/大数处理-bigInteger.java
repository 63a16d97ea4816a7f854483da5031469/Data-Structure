
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */






这两个类都在java.math.*包中，因此每次必须在开头处引用该包。


Ⅰ基本函数：

1.valueOf(parament); 将参数转换为制定的类型

比如 int a=3;

BigInteger b=BigInteger.valueOf(a);

则b=3;

String s=”12345”;

BigInteger c=BigInteger.valueOf(s);

则c=12345；


2.add(); 大整数相加

BigInteger a=new BigInteger(“23”);

BigInteger b=new BigInteger(“34”);

a. add(b);


3.subtract(); 相减

4.multiply(); 相乘

5.divide(); 相除取整

6.remainder(); 取余

7.pow(); a.pow(b)=a^b

8.gcd(); 最大公约数

9.abs(); 绝对值

10.negate(); 取反数

11.mod(); a.mod(b)=a%b=a.remainder(b);

12.max(); min();

13.punlic int comareTo();

14.boolean equals(); 是否相等

15.BigInteger构造函数：

一般用到以下两种：

BigInteger(String val);

将指定字符串转换为十进制表示形式；

BigInteger(String val,int radix);

将指定基数的 BigInteger 的字符串表示形式转换为 BigInteger

Ⅱ.基本常量：

A=BigInteger.ONE 1

B=BigInteger.TEN 10

C=BigInteger.ZERO 0

Ⅲ.基本操作

1. 读入：

用Scanner类定义对象进行控制台读入,Scanner类在java.util.*包中

Scanner cin=new Scanner(System.in);// 读入

while(cin.hasNext()) //等同于!=EOF

{

int n;

BigInteger m;

n=cin.nextInt(); //读入一个int;

m=cin.BigInteger();//读入一个BigInteger;

System.out.print(m.toString());

}

 

if( a.compareTo(b) == 0 ) System.out.println("a == b"); //大整数a==b

else if( a.compareTo(b) > 0 ) System.out.println("a > b"); //大整数a>b

else if( a.compareTo(b) < 0 ) System.out.println("a < b"); //大整数a<b

//大整数绝对值

System.out.println(a.abs()); //大整数a的绝对值

//大整数的幂

int exponent=10;

System.out.println(a.pow(exponent)); //大整数a的exponent次幂

//返回大整数十进制的字符串表示

System.out.println(a.toString());

//返回大整数p进制的字符串表示

int p=8;

System.out.println(a.toString(p));

















