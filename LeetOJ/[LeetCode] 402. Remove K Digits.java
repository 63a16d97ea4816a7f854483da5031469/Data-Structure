
/*
 * 
https://leetcode.com/problems/remove-k-digits/

402. Remove K Digits
Medium
1700
88
Add to List

Share
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :





这道题让我们将给定的数字去掉k位，要使得留下来的数字最小，这题跟 LeetCode 上之前那道 Create Maximum Number 有些类似，可以借鉴其中的思路，如果n是 num 的长度，我们要去除k个，那么需要剩下 n-k 个，怎么判断哪些数字应该去掉呢？首先来考虑，若数字是递增的话，比如 1234，那么肯定是要从最后面移除最大的数字。若是乱序的时候，比如 1324，若只移除一个数字，移除谁呢？这个例子比较简单，我们一眼可以看出是移除3，变成 124 是最小。但是怎么设计算法呢，实际上这里利用到了单调栈的思想，可以参见博主之前的一篇总结帖 LeetCode Monotonous Stack Summary 单调栈小结。这里我们维护一个递增栈，只要发现当前的数字小于栈顶元素的话，就将栈顶元素移除，比如点那个遍历到2的时候，栈里面有1和3，此时2小于栈顶元素3，那么将3移除即可。为何一定要移除栈顶元素呢，后面说不定有更大的数字呢？这是因为此时栈顶元素在高位上，就算后面的数字再大，也是在低位上，我们只有将高位上的数字尽可能的变小，才能使整个剩下的数字尽可能的小。这里虽然利用了单调栈的思想，但我们并不用真正用栈 stack 的数据结构，直接用个字符串就行了，因为字符串 string 也可以移除末尾字符。我们开始遍历给定数字 num 的每一位，对于当前遍历到的数字c，进行如下 while 循环，如果 res 不为空，且k大于0，且 res 的最后一位大于c，那么应该将 res 的最后一位移去，且k自减1。当跳出 while 循环后，我们将c加入 res 中，最后将 res 的大小重设为 n-k。根据题目中的描述，可能会出现 "0200" 这样不符合要求的情况，所以我们用一个 while 循环来去掉前面的所有0，然后返回时判断是否为空，为空则返回 “0”，


class Solution {
public:
    string removeKdigits(string num, int k) {
        string res = "";
        int n = num.size(), keep = n - k;
        for (char c : num) {
            while (k && res.size() && res.back() > c) {
                res.pop_back();
                --k;
            }
            res.push_back(c);
        }
        res.resize(keep);
        while (!res.empty() && res[0] == '0') res.erase(res.begin());
        return res.empty() ? "0" : res;
    }
};
复制代码

 * 
 */




class Solution {
    //11.51pm-12.15am
    public String removeKdigits(String num, int k) {
        if(k==1&&num.length()==1) return "0"; 
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<num.length();i++){
            int curr=Integer.parseInt(num.charAt(i)+"");
            if(stack.isEmpty()){
                stack.push(curr);
            }else{
                while(!stack.isEmpty()&&stack.peek()>curr&&k>0){
                    stack.pop();
                    k--;
                }
                stack.push(curr);
            }
        }
        //解决这种case "1111111"    3
        while(k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }
        LinkedList<Integer> list=new LinkedList<Integer>();
        //remove the left 0
        while(!stack.isEmpty()){
            list.addFirst(stack.pop());
        }
        String str="";
        boolean isStart=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=0){
               isStart=true;
            }
            if(isStart){
                str+=list.get(i);
            }
        }
        if(str.equals("")) return "0";
        return str;
    }
}



















