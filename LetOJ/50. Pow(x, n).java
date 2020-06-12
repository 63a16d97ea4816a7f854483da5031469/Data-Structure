
/*
 * 
https://leetcode.com/problems/powx-n/


50. Pow(x, n)
Medium

1237

2752

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]

9 April 2020 at 11:36:31 pm
 * 
 */

MIN_VALUE
public static final int MIN_VALUE
A constant holding the minimum value an int can have, -2^31.


MAX_VALUE
public static final int MAX_VALUE
A constant holding the maximum value an int can have, 2^31-1.


另外，本题的难点主要是在边界条件：如果 n < 0，是不是 n = -n， x = 1 / x ，再进行递归就能解决了呢？如果 n = Intege.MIN_VALUE，n = -n 会出现溢出，怎么办呢？我们可以先将 n / 2 赋值给 t，再将 t = -n，就不会出现溢出问题。
原文链接：https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51655964


public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        int t = n / 2;
        if(n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if(n % 2 == 0) return res * res;
        return res * res * x;
	}
}

————————————————
版权声明：本文为CSDN博主「Code_Granker」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51655964


public class Solution {
    public double power(double x, int n) {
 
		//递归最边界条件
		if (n == 0)
			return 1;
	 
		//递归入口
		double v = power(x, n / 2);
        
        System.out.println(" X: "+x+" V: "+v+" N: "+n);
 
		//递归回退计算.
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	// public double myPow(double x, int n) {
	// 	if (n < 0) {
	// 		return 1 / power(x, -n);
	// 	} else {
	// 		return power(x, n);
	// 	}
	// }
 
}

x=2 n=10

X: 2.0 V: 1.0 N: 1
X: 2.0 V: 2.0 N: 2
X: 2.0 V: 4.0 N: 5
X: 2.0 V: 32.0 N: 10



















