package ok;
/*

Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        
    }
}


28 October 2015 at 9:32:52 pm
 * 
 */

/*
 * 
 * 
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?





public static int multipleN(int n){
	if(n==1) return 1;

	return n*multipleN(n-1);
}

 if n=1     1
 	n=2		1 1 ,2 
 	n=3 	1 1 1, 1 2, 2 1
 	n=4  1111, 112,121,22,211,212

Even when I tried to use enumeration way to list down all the combinations about n=4. I made mistakes.
From this you can tell, finding the methods to solve problem is more important than guessing 
or using intuition.

 Each time, I have two choices.  So I imaged the binary tree.

 */
import java.util.*;
public class ClimbingStairs {

	/*
Wrong
Input: 1 Output: 0 Expected: 1
	 * 
	 */
	public static void main(String args[]) {
		
//		for(int i=0;i<1000;i++)
//		System.out.println(i+"->"+climbStairs3(i));
		
		System.out.println("->"+climbStairs3(35));
	}
	
	
	/*
	 * 
	 * Need to find a fast way to do it:
	From the result you can find out the law:
running time(second):0
1->1
running time(second):0
2->2
running time(second):0
3->3
running time(second):0
4->5
running time(second):0
5->8
running time(second):0
6->13
running time(second):0
7->21


Also from the binary tree, you also will think whether we can reuse the previous results.

But reuse,first you need to have that value. So we cannot reuse, but we get the law.

1,1
2,2
3,3
4,5
5,8
6,13

f(1)=1 f(2)=2 
f(3)=f(1)+f(2)
f(4)=f(3)+f(2)

f(n)=f(n-1)+f(n-2)


	 * 
	 * Accepted:
	 * 
	 */
	
	public static int climbStairs3(int n) {
	 
		long startTime = System.currentTimeMillis();
 
		if (n==1)return 1;
		if(n==2)return 2;
		
		int result=0;
		int s=1;
		int u=2;
		
		for(int i=2;i<n;i++){
			result=s+u;
			s=u;
			u=result;
		}
		

		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("running time(second):"+totalTime/1000);
		
		return result;
 
	}
	
	
	public static int getN(int n){
		
		if (n==1)return 1;
		if(n==2)return 2;
		
		int result=0;
		int s=1;
		int u=2;
		
		for(int i=2;i<n;i++){
			result=s+u;
			s=u;
			u=result;
		}
		
		return result;
	}
	
	
	/*
	 * speed is not high
	 * 
	 */
	
//	public static int getN(int n){
//		
//		if(n==1) return 1;
//		if(n==2) return 2;
//		
//		return getN(n-1)+getN(n-2);
//	}
//	
	
	
	
	
	/*
	 * 
Status: Time Limit Exceeded
Last executed input:
35


Record the time costs:

31->2178309
running time(second):0
32->3524578
running time(second):0
33->5702887
running time(second):3
34->9227465
running time(second):7
35->14930352
running time(second):19
36->24157817
running time(second):56


	 * 
	 */
	
	public static int climbStairs2(int n) {
		long startTime = System.currentTimeMillis();
		int result=0;
		LinkedList<Integer> que=new LinkedList<Integer>();
		que.add(n);
		
		
		while(!que.isEmpty()){
			
			int firstEle=que.removeFirst();
			if(firstEle>0){
				que.addLast(firstEle-1);
				que.addLast(firstEle-2);
			}else if(firstEle==0){
				result++;
			}

		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("running time(second):"+totalTime/1000);
	return result;
	}
	
	
	/*
	 * 
When n=4, print the Queue:
So beautiful:

[3, 2]
[2, 2, 1]
[2, 1, 1, 0]
[1, 1, 0, 1, 0]
[1, 0, 1, 0, 0, -1]
[0, 1, 0, 0, -1, 0, -1]
[1, 0, 0, -1, 0, -1]
[0, 0, -1, 0, -1, 0, -1]
[0, -1, 0, -1, 0, -1]
[-1, 0, -1, 0, -1]
[0, -1, 0, -1]
[-1, 0, -1]
[0, -1]
[-1]
[]
5

	 * 
	 * 
	 * 
	 */


	
	/*
	 * 

 if n=1     1
 	n=2		1 1 ,2 
 	n=3 	1 1 1, 1 2, 2 1
 	n=4  1111, 112,121,22,211,212

Even when I tried to use enumeration way to list down all the combinations about n=4. 
I made mistakes.

From this you can tell, finding the methods to solve problem is more important 
than guessing or using intuition.

Each time, I have two choices.  so I imaged the binary tree.

So finding the right way is more important than trying or guessing blindly out.

Thinking, thinking, thinking, thinking.......... Thinking makes us different.

not keep trying .... no use....


	 * 
	 */

	public static int climbStairs(int n) {

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return multipleN(n) / 2;

	}

	public static int multipleN(int n) {

		if (n == 1)
			return 1;
		return n * multipleN(n - 1);
	}

}
