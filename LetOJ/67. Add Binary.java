
/*
 * 
https://leetcode.com/problems/add-binary/description/

67. Add Binary
Easy

2523

328

Add to List

Share
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

21 Feb 2021 at 13:50 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :






 * 
 */


public class Solution {
    public String addBinary(String a, String b) {
	if(a==null || a.length()==0) return b;
	if(b==null || b.length()==0) return a;
	int currA=a.length()-1;
	int currB=b.length()-1;
	int flag=0;
	StringBuilder sb=new StringBuilder();
		while(currA>=0||currB>=0){
			int va=0;
			int vb=0;
			if(currA>=0){
				va=a.charAt(currA)=='0'?0:1;
				currA--;
			}
			if(currB>=0){
				vb=b.charAt(currB)=='0'?0:1;
				currB--;
			}
			int sum=va+vb+flag;
			if(sum>=2){
				sb.append(sum-2);
				flag=1;
			}else{
				sb.append(sum);
                flag=0;
			}
		}
		if(flag==1){
			sb.append("1");
		}
	return sb.reverse().toString();
    }
}




public class Test36Bin {
	/**
     * 
     * 字节跳动-算法面试-36进制加法
 * 36进制由0-9，a-z，共36个字符表示，最小为'0'
 * '0''9'对应十进制的09，'a''z'对应十进制的1035
 * 例如：'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47
 * 要求按照加法规则计算出任意两个36进制正整数的和
 * 如：按照加法规则，计算'1b' + '2x' = '48'
 *
 * 要求：不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制
 *
 * @param args
 */
	public static void main(String[] args) {
		String result = addFunWithStr("1b", "2x");
		System.out.println("result = " + result);
	}
	/**
 * 获取值
 * @param ch
 * @return
 */
	public static int getIntFromChar(char ch) {
		int ret = -1;
		if (ch >= '0' && ch <= '9') {
			ret = ch - '0';
		} else if (ch >= 'a' && ch <= 'z') {
			ret = (ch - 'a') + 10;
		}
		return ret;
	}
	public static String addFunWithStr(String param1, String param2) {
		StringBuffer stringBuffer = new StringBuffer();
		String symbol = "0123456789abcdefghijklmnopqrstuvwxyz";
		int param1Len = param1.length();
		int param2Len = param2.length();
		int i = param1Len - 1;
		int j = param2Len - 1;
		if (i < 0 || j < 0) {
			return null;
		}
		int temp = 0;
		while (i >= 0 && j >= 0) {
			char ch_1 = param1.charAt(i);
			char ch_2 = param2.charAt(j);
			int v1 = getIntFromChar(ch_1);
			int v2 = getIntFromChar(ch_2);
			int ret = v1 + v2;
			if (ret >= 36) {
				int index = ret - 36 + temp;
				char sv = symbol.charAt(index);
				stringBuffer.append(sv);
				temp = 1; //进位
			} else {
				int index = ret + temp;
				char sv = symbol.charAt(index);
				stringBuffer.append(sv);
				temp = 0;
			}
			i--;
			j--;
		}
		while (i >= 0) {
			char ch_1 = param1.charAt(i);
			stringBuffer.append(ch_1);
			i--;
		}
		while (j >= 0) {
			char ch_2 = param2.charAt(i);
			stringBuffer.append(ch_2);
			j--;
		}
		StringBuffer result = stringBuffer.reverse();
		return result.toString();
	}
}



















