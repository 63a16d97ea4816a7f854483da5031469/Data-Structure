
/*
 * 
link: https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/


2022-03-03 at 20:00


405. 数字转换为十六进制数

给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

注意:

    十六进制中所有字母(a-f)都必须是小写。
    十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
    给定的数确保在32位有符号整数范围内。
    不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

示例 1：

输入:
26

输出:
"1a"

示例 2：

输入:
-1

输出:
"ffffffff"
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */








class Solution {
    public String toHex(int _num) {
        if (_num == 0) return "0";
        long num = _num;
        StringBuilder sb = new StringBuilder();
        if(num < 0) num = (long)(Math.pow(2, 32) + num);
        while (num != 0) {
            long u = num % 16;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        return sb.reverse().toString();
    }
}


// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/gong-shui-san-xie-yi-ti-shuang-jie-jin-z-d93o/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






// 不考虑负数的话：

class Solution {
    public String toHex(int num) {
        Character[] arr=new Character[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        List<Character> list=Arrays.asList(arr);
        StringBuilder sb=new StringBuilder();
        while(num>16){
            int curr=num%16;
            sb.append(list.get(curr));
            num/=16;
        }
        sb.append(list.get(num));
        return sb.reverse().toString();
    }
}










