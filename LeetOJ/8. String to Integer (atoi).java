
/*
 * 
8. String to Integer (atoi)
Medium
1377
8337
Add to List

Share
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

6 April 2020 at 9.19pm-10.20pm
 * 
 */





class Solution {
	//9.19pm-10.20pm
	/*
    converts a string to an integer.
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
    
    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
    
    
    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
    
    */

	public int myAtoi(String str) {
        
        //结果数字
        long result=0;
        
        //去掉开头的空白字符
        str=str.trim();
        
        //空字符传，边界条件
        if(str.equals("")) return 0;
        
        //提取符号
        int sgn;
        if(str.charAt(0)=='+' || isDigit(str.charAt(0))){
            sgn=1;
            if(isDigit(str.charAt(0))){
                str="+"+str;
            }
        } 
        else if(str.charAt(0)=='-') sgn=-1;
        else return 0;
        
        //符号位后一个不是数字，也是边界条件
        if(str.length()<=1 || !(isDigit(str.charAt(1)))) return 0;
        
        //转换逻辑由此开始
        for(int i=1;i<str.length() && isDigit(str.charAt(i));i++){
            result=result*10+str.charAt(i)-'0';
            if(sgn*result>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sgn*result<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)(sgn*result);
    }
    
    private boolean isDigit(char c){
        return c>='0' && c<='9';
    }
// ————————————————
// 版权声明：本文为CSDN博主「IT_little_superman」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/lcl574943271/article/details/50587504
}











class Solution {
	//9.19pm-10.20pm
	/*
    converts a string to an integer.
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
    
    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
    
    
    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
    
    */

	public int myAtoi(String str) {

		//处理空字符串
		if (str == null) return 0;
		if (str.isEmpty()) return 0;

		char[] arr = str.toCharArray();

		String nstr = "";
		//看是否有负号
		boolean minute = false;

		boolean onlyFirstDo = true;

		next: for (int i = 0; i < arr.length; i++) {
			//跳过空白
			while (arr[i] == ' ' && onlyFirstDo) {
				// i++;
				continue next;
			}

			onlyFirstDo = false;

			//只有一个+或者-
			if ((arr[i] == '+' || arr[i] == '-') && arr.length == 1) {
				return 0;
			}

			// "+-2"
			if (nstr.isEmpty() && arr[i] == '-' && (!nstr.contains("+") && !nstr.contains("-"))) {
				//有负号标记
				minute = true;
				nstr += arr[i];
			} else if (arr[i] == '+' && (!nstr.contains("+") && !nstr.contains("-"))) {
				// "+1"这个情况不能加+
				nstr += arr[i];
			}
			else if ('0' <= arr[i] && arr[i] <= '9') {
				nstr += arr[i];
			} else {
				break;
			}
		}
		System.out.println(nstr);

		if (nstr.length() >= 1 && (nstr.substring(0, 1).contains("+") || nstr.substring(0, 1).contains("-"))) nstr = nstr.substring(1);
		//在转换前，对字符串进行判断
		if (nstr.isEmpty()) {
			return 0;
		}

		String s = "";
		for (int i = 0; i < nstr.length(); i++) {
			//scan 看是否连续为valid 数字
			if (nstr.charAt(i) == '0' && s.isEmpty()) {
				continue;
			}

			if (nstr.charAt(i) >= '0' && nstr.charAt(i) <= '9') {
				s += nstr.charAt(i) + "";
			} else {
				break;
			}
		}

		//"20000000000000000000"
		if (s.length() > 10) {
			if (!minute) return Integer.MAX_VALUE;
			else return Integer.MIN_VALUE;
		}

		if (s.length() == 0) return 0;

		Long num = Long.parseLong(s);
		if (num > Integer.MAX_VALUE) {
			if (!minute) return Integer.MAX_VALUE;
			else return Integer.MIN_VALUE;
		}

		int n = Integer.parseInt(num + "");
		if (minute) {
			n = -n;
		}

		return n;
	}
}


















