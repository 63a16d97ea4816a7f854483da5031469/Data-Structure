
/*
 * 
https://leetcode.com/problems/multiply-strings/

43. Multiply Strings
Medium

1525

701

Add to List

Share
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

8 April 2020 at 10.19pm
 * 
 */



class Solution {
	//11.16pm - 11.53pm 中间有看题解
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		int l1 = num1.length(),
		l2 = num2.length(),
		l = l1 + l2;
		char[] res = new char[l];
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();

		for (int i = l1 - 1; i >= 0; i--) {
			int first = c1[i] - '0';

			for (int j = l2 - 1; j >= 0; j--) {
				int last = c2[j] - '0';
				res[i + j + 1] += first * last;
			}
		}

		for (int i = res.length - 1; i > 0; i--) {
			if (res[i] > 9) {
				res[i - 1] += res[i] / 10;
				res[i] %= 10;
			}
		}

		int i = 0;
		// for(;i<res.length;i++){  //用这个无法得到正确结果
		//     if(res[i]!='0') break;
		// }
		for (;; ++i) if (res[i] != 0) break;
		// String s="";
		StringBuilder sb = new StringBuilder();
		for (; i < res.length; ++i) {
			// s+=String.valueOf(res[k]);   //用这个无法得到正确结果
			sb.append((char)(res[i] + '0'));
		}
		return sb.toString();
	}
}


模拟数字乘法，得出一个大于10的数字就进位，先存在一个为L1+L2的数组中(因为这是可能最大符长),然后转换为String即可

class Solution {
    public String multiply(String num1, String num2) {
       if (num1.equals("0") || num2.equals("0")) return "0";
       int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
       char[] ans = new char[l];
       char[] c1 = num1.toCharArray();
       char[] c2 = num2.toCharArray();

       for (int i = l1 - 1; i >= 0; --i) {
           int c = c1[i] - '0';
           for (int j = l2 - 1; j >= 0; --j) {
               int cc = c2[j] - '0';
               ans[i + j + 1] +=  c * cc;   //模拟数学乘法
           }
       }
       for (int i = l - 1; i > 0; --i) {
           if (ans[i] > 9) {
               ans[i - 1] += ans[i] / 10;   //大于10了就要进位
               ans[i] %= 10;
           }
       }
       StringBuilder sb = new StringBuilder();
       int i = 0;
       for (; ; ++i) if (ans[i] != 0) break;
       for (; i < ans.length; ++i) sb.append((char) (ans[i] + '0'));
       return sb.toString();
   }
}

作者：charles-gao
链接：https://leetcode-cn.com/problems/multiply-strings/solution/java-yong-shi-ji-bai-100de-yong-hu-by-charles-gao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





可以过简单的，不可以过最复杂的:

116 / 311 test cases passed.
Status: Wrong Answer
Submitted: 1 minute ago
Input:
"123456789"
"987654321"
Output:
"-67153019"
Expected:
"121932631112635269"

class Solution {
    //10.06pm-
    public String multiply(String num1, String num2) {
        if(num1.length()==1 && num2.length()==1) return (Integer.parseInt(num1)*Integer.parseInt(num2))+"";
        
        int res=0;
        int n1=Integer.parseInt(num1);
        for(int i=num2.length()-1;i>=0;i--){
            int tmp=num2.charAt(i)-'0';
             tmp=tmp*n1;
            for(int j=0;j<num2.length()-1-i;j++){
                tmp*=10;
            }
            // System.out.println(tmp);
            
            res+=tmp;
        }
        
        return res+"";
    }
}














