
/*
 * 
https://leetcode.com/problems/largest-3-same-digit-number-in-string/


2264. Largest 3-Same-Digit Number in String
Easy

219

14

Add to List

Share
You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.
 

Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 

Constraints:

3 <= num.length <= 1000
num only consists of digits.


DATE: 2022-October-13
TIME: 22:57:38

时间: 7 分钟


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


空间复杂度：O(1)
时间复杂度: O(1)

class Solution {
    public String largestGoodInteger(String num) {
        List<String> list=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        for(int i=9;i>=0;i--){
           for(int j=0;j<=2;j++){
               sb.append(i);
           }
           list.add(sb.toString());
           sb=new StringBuilder();
        }
        for(String tmp:list){
            if(num.contains(tmp)){
                return tmp;
            }
        }
        return "";
    }
}

















