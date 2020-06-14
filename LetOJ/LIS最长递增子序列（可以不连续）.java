
/*
 * 

https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/

14 June 2020 at 11:20 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Main
{
	// Function to find length of longest increasing subsequence
	public static int LIS(int[] A, int start, int n, int prev)
	{
		// Base case: nothing is remaining
		if (start == n) {
			return 0;
		}

		// case 1: exclude the current element and process the
		// remaining elements
		int excl = LIS(A, start + 1, n, prev);

		// case 2: include the current element if it is greater
		// than previous element in LIS
		int incl = 0;
		if (A[start] > prev) {
			incl = 1 + LIS(A, start + 1, n, A[start]);
		}

		// return maximum of above two choices
		return Integer.max(incl, excl);
	}

	// Program for Longest Increasing Subsequence
	public static void main(String[] args)
	{
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Length of LIS is "
						+ LIS(A, 0, A.length, Integer.MIN_VALUE));
	}
}

















