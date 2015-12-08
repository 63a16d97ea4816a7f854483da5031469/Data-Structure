# 0/1 bag
http://love-oriented.com/pack/
背包问题九讲


https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.03.md

0-1背包问题

0-1背包问题是最基础的背包问题，其具体描述为：有N件物品和一个容量为V的背包。放入第i件物品耗费的费用是Ci，得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。

简单分析下：这是最基础的背包问题，特点是每种物品仅有一件，可以选择放或不放。用子问题定义状态：即F[i, v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：

F[i, v] = max{F[i-1, v], F[i-1, v-Ci ] + Wi}
根据前面的分析，我们不难理解这个方程的意义：“将前i件物品放入容量为v的背包中”这个子问题，若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只和前 i-1 件物品相关的问题。即：

如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”，价值为 F[i-1, v ]；
如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为v-Ci的背包中”，此时能获得的最大价值就是F[i-1, v-Ci]再加上通过放入第i件物品获得的价值Wi。
伪代码如下：

F[0,0...V] ← 0
for i ← 1 to N
    for v ← Ci to V
        F[i, v] ← max{F[i-1, v], F[i-1, v-Ci] + Wi }
这段代码的时间和空间复杂度均为 O(VN)，其中时间复杂度应该已经不能再优化了，但空间复杂度却可以优化到O(V)。感兴趣的读者可以继续思考或者参考网上一个不错的文档《背包问题九讲》。


---

http://blog.csdn.net/zmazon/article/details/8315418

3.输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数，使其和等于 m ,要求将其中所有的可能组合列出来（不可重复取）
如m =5,n=4 输出14，23

这种问法是典型01背包问题，因为要求是输出所有组合，所以我们不用DP，而用回溯

回溯法（英语：backtracking）是暴力搜寻法中的一种。

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

找到一个可能存在的正确的答案
在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。


算法思想：从最大数n开始尝试装包，输出所有情况，再尝试n不装包，输出所有情况。

	public class ZuHe {
		
		public void combine(int m, int n) {
			
			if(m < 1 || n < 1)
				return;
				
			if(n > m)//如果n>m,把n>m的数去掉
				n = m;
			
			boolean[] b = new boolean[n+1];//保存是否装包
			getCombination(m, n, b);
		}
		public void getCombination(int m, int n, boolean[] b){
			
			if(m < 1 || n < 1)//递归出口
				return;
					
			if(m == n){//输出组合
				b[n] = true;
				for(int i = 1; i < b.length; i++){
					if(b[i] == true)
						System.out.print(i + " ");
					
				}
				System.out.println();
				b[n] = false;
			}
			b[n] = true;//装包
			getCombination(m-n, n-1, b);
			b[n] = false;//不装包
			getCombination(m, n-1, b);
		}
		
		public static void main(String[] args){
			
			ZuHe robot = new ZuHe();
			
			int[] a = {1,2,3,4};
			int n = 3;
			robot.combine(10,12);
	
		}
	
	}

---


http://blog.csdn.net/v_JULY_v/article/details/6419466

	第二节、寻找和为定值的多个数
	第21题（数组）
	2010年中兴面试题
	编程求解：
	输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,
	使其和等于 m ,要求将其中所有的可能组合列出来。
	
	
		  // 21题递归方法  
	//copyright@ July && yansha  
	//July、yansha，updated。  
	#include<list>  
	#include<iostream>  
	using namespace std;  
	  
	list<int>list1;  
	void find_factor(int sum, int n)   
	{  
	    // 递归出口  
	    if(n <= 0 || sum <= 0)  
	        return;  
	      
	    // 输出找到的结果  
	    if(sum == n)  
	    {  
	        // 反转list  
	        list1.reverse();  
	        for(list<int>::iterator iter = list1.begin(); iter != list1.end(); iter++)  
	            cout << *iter << " + ";  
	        cout << n << endl;  
	        list1.reverse();      
	    }  
	      
	    list1.push_front(n);      //典型的01背包问题  
	    find_factor(sum-n, n-1);   //放n，n-1个数填满sum-n  
	    list1.pop_front();  
	    find_factor(sum, n-1);     //不放n，n-1个数填满sum   
	}  
	  
	int main()  
	{  
	    int sum, n;  
	    cout << "请输入你要等于多少的数值sum:" << endl;  
	    cin >> sum;  
	    cout << "请输入你要从1.....n数列中取值的n：" << endl;  
	    cin >> n;  
	    cout << "所有可能的序列，如下：" << endl;  
	    find_factor(sum,n);  
	    return 0;  
	}  
	
	Java-Code:
	
	import java.util.*;
	
	
		LinkedList<Integer> list1=new LinkedList<Integer>();
		
		public void find_factor(int sum,int n){
			
			if(n<=0||sum<=0) return;
			if(sum==n){
			  
				//reverse the list:
				Collections.reverse(list1);
	//			for(int i=0;i<list1.size();i++){
	//				int tmp=list1.get(i);
	//				list1.set(i, list1.get(list1.size()-1-i));
	//				list1.set(list1.size()-1-i, tmp);
	//			}
	//			
				for(int tmp:list1)
					System.out.print(tmp+"+");
				
				System.out.println(n);
			}
			
			list1.push(n);
			find_factor(sum-n,n-1);
			list1.pop();
			find_factor(sum,n-1);
			
		}
	}
		
			s.find_factor(10,20);
	result:		
		10
	9+1
	8+2
	7+3
	7+2+1
	6+4
	6+3+1
	5+4+1
	4+3+2
	4+3+2+1

	
	
	
		解法二
	@zhouzhenren：
	这个问题属于子集和问题（也是背包问题）。本程序采用 回溯法+剪枝
	X数组是解向量，t=∑(1,..,k-1)Wi*Xi, r=∑(k,..,n)Wi
	若t+Wk+W(k+1)<=M,则Xk=true，递归左儿子(X1,X2,..,X(k-1),1)；否则剪枝；
	若t+r-Wk>=M && t+W(k+1)<=M,则置Xk=0，递归右儿子(X1,X2,..,X(k-1),0)；否则剪枝；
	本题中W数组就是(1,2,..,n),所以直接用k代替WK值。
	
	代码编写如下：
	
	[cpp] view plaincopyprint?
	//copyright@ 2011 zhouzhenren  
	  
	//输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,  
	//使其和等于 m ,要求将其中所有的可能组合列出来。  
	  
	#include <stdio.h>  
	#include <stdlib.h>  
	#include <memory.h>  
	  
	/**  
	 * 输入t， r， 尝试Wk 
	 */  
	void sumofsub(int t, int k ,int r, int& M, bool& flag, bool* X)  
	{  
	    X[k] = true;   // 选第k个数  
	    if (t + k == M) // 若找到一个和为M，则设置解向量的标志位，输出解  
	    {  
	        flag = true;  
	        for (int i = 1; i <= k; ++i)  
	        {  
	            if (X[i] == 1)  
	            {  
	                printf("%d ", i);  
	            }  
	        }  
	        printf("/n");  
	    }  
	    else  
	    {   // 若第k+1个数满足条件，则递归左子树  
	        if (t + k + (k+1) <= M)  
	        {  
	            sumofsub(t + k, k + 1, r - k, M, flag, X);  
	        }  
	        // 若不选第k个数，选第k+1个数满足条件，则递归右子树  
	        if ((t + r - k >= M) && (t + (k+1) <= M))  
	        {  
	            X[k] = false;  
	            sumofsub(t, k + 1, r - k, M, flag, X);  
	        }  
	    }  
	}  
	  
	void search(int& N, int& M)  
	{  
	    // 初始化解空间  
	    bool* X = (bool*)malloc(sizeof(bool) * (N+1));  
	    memset(X, false, sizeof(bool) * (N+1));  
	    int sum = (N + 1) * N * 0.5f;  
	    if (1 > M || sum < M) // 预先排除无解情况  
	    {  
	        printf("not found/n");  
	        return;  
	    }  
	    bool f = false;  
	    sumofsub(0, 1, sum, M, f, X);  
	    if (!f)  
	    {  
	        printf("not found/n");  
	    }  
	    free(X);  
	}  
	  
	int main()  
	{  
	    int N, M;  
	    printf("请输入整数N和M/n");  
	    scanf("%d%d", &N, &M);  
	    search(N, M);  
	    return 0;  
	}  

	