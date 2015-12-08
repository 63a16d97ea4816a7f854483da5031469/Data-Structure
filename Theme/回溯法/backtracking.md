##回溯法（英语：backtracking）是暴力搜寻法中的一种。

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

找到一个可能存在的正确的答案
在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

3.输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数，使其和等于 m ,要求将其中所有的可能组合列出来（不可重复取）
如m =5,n=4 输出14，23

这种问法是典型01背包问题，因为要求是输出所有组合，所以我们不用DP，而用回溯

算法思想：从最大数n开始尝试装包，输出所有情况，再尝试n不装包，输出所有情况。

http://blog.csdn.net/zmazon/article/details/8315418


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
