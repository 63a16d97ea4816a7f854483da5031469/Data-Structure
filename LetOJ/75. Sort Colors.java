
/*
 * 
https://leetcode.com/problems/sort-colors/

75. Sort Colors
Medium

3117

213

Add to List

Share
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

11 June 2020 at 11:56 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 只能扫一遍：
/*

如果只能扫一遍，很容易想到的就是左边存放0和1，右边存放2.两边往中间靠。

设置两个index，left记录第一个1的位置，left左边为0，right记录第一个非2的位置，right右边为2.

然后使用i从头到尾扫一遍，直到与right相遇。

i遇到0就换到左边去，遇到2就换到右边去，遇到1就跳过。

需要注意的是：由于left记录第一个1的位置，因此A[left]与A[i]交换后，A[left]为0,A[i]为1，因此i++；

而right记录第一个非2的位置，可能为0或1，因此A[right]与A[i]交换后，A[right]为2,A[i]为0或1，i不能前进，要后续判断。

由此该数组分为4段：[0,left)-->0; [left,i)-->1; [i,right]-->乱序; (right,n-1]-->2
————————————————
版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/mine_song/article/details/70473583

*/
class Solution {
    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int i = 0;
        while (i <= right) {
            if (A[i] == 0) {
                swap(A, left, i);
                left++;  //left要指向1的位置，现在已经是0了，必须前进一个
                i++;
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, i, right);
                right--; //right要指向非2的位置，现在已经是2了，要减一个
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}




// https://blog.csdn.net/mine_song/article/details/70473583

class Solution {
	public void sortColors(int[] A) {
		int n = A.length;
		// 0的个数
		int i = 0;
		// 1的个数
		int j = 0;
		// 2的个数
		int k = 0;
		for (int p = 0; p < n; p++) {
			if (A[p] == 0) {
				i++;
			} else if (A[p] == 1) {
				j++;
			} else
				k++;
		}
 
		for (int p = 0; p < n; p++) {
			if (p < i)
				A[p] = 0;
			else if (p >= i && p < i + j)
				A[p] = 1;
			else
				A[p] = 2;
		}
	}
}
















// Counting sort which takes negative numbers as well  
// import java.util.*; 
  
class GFG  
{ 
  
    static void countSort(int[] arr)  
    { 
        int max = Arrays.stream(arr).max().getAsInt(); 
        int min = Arrays.stream(arr).min().getAsInt(); 
        int range = max - min + 1; 
        int count[] = new int[range]; 
        int output[] = new int[arr.length]; 
        for (int i = 0; i < arr.length; i++)  
        { 
            count[arr[i] - min]++; 
        } 
  
        for (int i = 1; i < count.length; i++)  
        { 
            count[i] += count[i - 1]; 
        } 
  
        for (int i = arr.length - 1; i >= 0; i--)  
        { 
            output[count[arr[i] - min] - 1] = arr[i]; 
            count[arr[i] - min]--; 
        } 
  
        for (int i = 0; i < arr.length; i++) 
        { 
            arr[i] = output[i]; 
        } 
    } 
  
    static void printArray(int[] arr)  
    { 
        for (int i = 0; i < arr.length; i++)  
        { 
            System.out.print(arr[i] + " "); 
        } 
        System.out.println(""); 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10}; 
        countSort(arr); 
        printArray(arr); 
    } 
}  
  
// This code is contributed by princiRaj1992 
