
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// AC:

class Solution {
    //8.23pm-8.45pm 看了题解。笨方法比较慢
   int hammingDistance(int x, int y) {
       int i=x^y;
    int count=0;
    while (i!=0) {
        if((i&1)==1) ++ count;
        i=i>>1;
    }
    return count;
  }    
// ————————————————
// 版权声明：本文为CSDN博主「styshoo」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/styshoo/article/details/54099552
}





// AC:

class Solution {
    //8.23pm-8.45pm 看了题解。笨方法比较慢
   int hammingDistance(int x, int y) {
    int i = x ^ y;
    int count=0;
    while (i != 0) {
        ++ count;
        i = (i-1)& i;
    }
    return count;
  }    
// ————————————————
// 版权声明：本文为CSDN博主「styshoo」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/styshoo/article/details/54099552
}




// 超时：

Submission Detail
19 / 149 test cases passed.
Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:
680142203
1111953568
Submitted Code: 0 minutes ago


class Solution {
	//8.23pm-8.45pm 看了题解。笨方法比较慢
	int hammingDistance(int x, int y) {

		return times(x ^ y);
	}

	int times(int n) {

		int count = 0;
		int flag = 1;
		while (flag<= n) {
			if ((n & flag) != 0)
				count++;
			flag = flag<< 1;
		}
		return count;
	}
	// ————————————————
	// 版权声明：本文为CSDN博主「qq_21150865」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
	// 原文链接：https://blog.csdn.net/qq_21150865/article/details/57084983
	// ————————————————
	// 版权声明：本文为CSDN博主「styshoo」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
	// 原文链接：https://blog.csdn.net/styshoo/article/details/54099552
}

