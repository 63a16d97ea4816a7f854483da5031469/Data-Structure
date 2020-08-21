
/*
 * 
link: 
https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/

2020-8-21 at 11:29 am

剑指 Offer 44. 数字序列中某一位的数字
难度
中等

54

收藏

分享
切换为英文
关注
反馈
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

 

示例 1：

输入：n = 3
输出：3
示例 2：

输入：n = 11
输出：0
 

限制：

0 <= n < 2^31
注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

// 解题：
// 位数 目标数范围 数字个数
// 1 1-9 9 × 1
// 2 10-99 90 × 2
// 3 100-999 900 × 3
// k 10^(k-1)-(10^k)-1 9*10^(k-1) * k
// 1.确定目标数是几位数
// 2.确定目标数的数值
// 3.确定返回目标数中的第几位

class Solution {
    public int findNthDigit(int n) {
        if (n <= 9)
            return n;
        n--;
        int num = 1;// 位数
        long first = 1; // 当前范围内第一个数， 注意越界。
        while (n > 9 * first * num){
            n -= 9 * first * num;   // 让n在循环结束后表示当前范围的第n位数字
            num++;
            first *= 10;
        }
         // 如 456 = 100(first)  +  356（n/num）  n%num 这里表示 456 中的第几位数字 
        return String.valueOf(first + n / num).charAt(n % num) - '0';
    }
}

// 作者：GQN58pYCT1
// 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/java-shuang-bai-shi-jian-kong-jian-wei-o1-by-gqn58/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public int findNthDigit(int n) {
        if (n<10)
            return n;
        int i = 1;
        while (n>i*(Math.pow(10,i-1))*9){   //循环结束后,i-1就是位数,n-1为表示还要找多少个
            n -= i*Math.pow(10,i-1)*9;
            i++;
        }
        char[] result = String.valueOf((int) Math.pow(10,i-1) + (n-1) / i).toCharArray();//我们用字符串来接收值，方便找位数 result结果为我们要的那个数的
        int value = result[(n-1)%i]-'0';    //(n-1)%位数 得出我们要的第x位的数
        return value;
    }
}

// 作者：v16tGDgz61
// 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/javashuang-bai-ti-jie-by-v16tgdgz61/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    public:
        int findNthDigit(int n) 
        {
            long base=9,digit=1;
            while(n-base*digit>0)
            {
                n-=base*digit;
                base*=10;
                digit++;    
            } //找出n处于几位数的范围内
    
            int index=n%digit;  //n此时就是在digit位数的范围里的第n位，那么index就表示是处于范围里的对应的数字number的第index位
            if(index==0)
                index=digit;   //等于0就表示是处于第digit位，
    
            long number=1;
            for(int i=1;i<digit;i++)
            {
                number*=10; //digit位数字范围里的第一个数字
            }
    
            number+=(index==digit) ? n/digit-1 : n/digit;  //要把index==digit即初始index==0的情况特别处理，因为如果index=0的话，下面的for循环当i==0时就会把number除成0，所以设置index==digit，表示第number+n/digit个数字的前一个数字的最后一位
    
            for(int i=index;i<digit;i++)
                number/=10;
    
            return number%10;
        }
    };
    
    // 作者：jianghao-pei
    // 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/zhao-gui-lu-by-jianghao-pei/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















