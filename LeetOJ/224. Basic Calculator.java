
/*
 * 
 * 


224. Basic Calculator
Hard

1231

117

Add to List

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:
1. 字符串是有空白的“ ”，要对这些处理
2. 思路是清晰的，但是在实现的时候，犯了一些小的错误，例如说 
else if (ch == '(') {
				if (signOp != ' ') {
					signStack.push(signOp);
					signOp = ' ';
				}
				idx++;
            }
应当赋值 signOp到 signStack，结果 写了 ch进入到 signStack中。 因此出了错误的输出，需要调试代码。

对题目的实现思路进行几句话总结:
1. 拥有两个栈，一个栈是数字栈，一个栈是符号栈
2. 遇到（，则将缓存的signOp和数字进栈
3. 遇到 )，则要还原signOp from 符号栈，同时做计算


从这道题目学到了什么，哪些地方需要提升? :
1. hard的题目，如果你想清楚也是可以克服的，不要有恐惧心理。这题我就成功做出来了
2. 对于细节上，要额外注意，不要犯错，这要在思维的严密性上进行练习。
3. 对字符转数字的处理 s.charAt(idx)-'0'
4. 对逻辑循环idx的处理
5. 对多个数字的处理 while(Character.isDigit(s.charAt(idx))){ currNum = currNum * 10 + s.charAt(idx++) - '0';  }的这种写法，这样可以一下子把连串的数字字符转换成数字 
6. 对堆栈的使用，技巧。


 * 
 */

独自，成功AC：


class Solution {
	//4.12pm-5.10pm
	int idx = 0;
	int currNum = 0;
	char signOp = ' ';
	Stack<Character> signStack = new Stack<Character> ();
	Stack<Integer> numStack = new Stack<Integer> ();
	public int calculate(String s) {
		s = s.replace(" ", "");
		char[] c = s.toCharArray();
		while (idx<s.length()) {
			char ch = s.charAt(idx);
			// System.out.println(">"+idx+" "+ch+" ");
			if (!numStack.isEmpty()) {
				// System.out.println("stack: "+numStack.peek());
			}
			if (Character.isDigit(ch)) {
				while (idx<s.length() && Character.isDigit(s.charAt(idx))) {
					currNum = currNum * 10 + s.charAt(idx++) - '0';
				}
				// System.out.println(currNum+" "+signOp);
				numStack.push(currNum);
				currNum = 0; //reset number
				if (signOp != ' ') {
					//如果符号不为空，说明有待计算
					computerNow();
				}
			} else if (ch == '(') {
				if (signOp != ' ') {
					signStack.push(signOp);
					signOp = ' ';
				}
				idx++;
			} else if (ch == ')') {
				if (!signStack.isEmpty()) {
					signOp = signStack.pop();
				}
				computerNow();
				idx++;
			} else if (ch == '+' || ch == '-') {
				signOp = ch;
				idx++;
			}
		}
		return numStack.pop();
	}
	void computerNow() {
        //对于没有signOp的，直接过，这个很关键，否则会在第一个(1+（3+2）)这种case下报错，因为最外层的 ）没有符号signOp
        if (signOp == ' ') return;
		int right = numStack.pop();
		int left = numStack.pop();
		// System.out.println("computer: "+right+" "+left+" "+signOp);
		if (signOp == '+') {
			//+
			int result = left + right;
			numStack.push(result);
		} else {
			//-
			int result = left - right;
			numStack.push(result);
		}
		signOp = ' ';
	}
}





















