
/*
 * 
link: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

剑指 Offer 46. 把数字翻译成字符串
难度
中等

198

收藏

分享
切换为英文
接收动态
反馈
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 

提示：

0 <= num < 231


2021-03-10 at 11:42 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


public class Solution {
    int res = 0;
    List<Integer> list = new ArrayList<>();

    public int translateNum(int num) {
        while (num > 0) {
            list.add(0, num % 10);
            num /= 10;
        }
        backtrack(0);
        return res;
    }

    public void backtrack(int index) {
        if (index == list.size()) {
            res++;
            return;
        }
        backtrack(index + 1);
        if (list.get(index) == 0 || list.get(index) >= 3 || index >= list.size() - 1) {
            return;
        }
        if (list.get(index) == 1 || (list.get(index) == 2 && list.get(index + 1) <= 5)) {
            backtrack(index + 2);
        }
    }
}

// 作者：1iin
// 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/java-bao-li-di-gui-0ms-by-1iin-nm0d/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















