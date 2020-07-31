
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

import java.util.*;

import java.math.BigInteger;  
BigInteger a=BigInteger.valueOf("23");
BigInteger b=BigInteger.valueOf("13");
a.add(b);


String tmp=Integer.toBinaryString(1)
System.out.println("Binary is " + Integer.toBinaryString(l)); 

public static String toBinaryString(long i)
System.out.println("Binary is " + Long.toBinaryString(l));


Scanner scan=new Sacnner();
scan.next();
scan.nextInt();
scan.nextLong();




二分查找:

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==arr[mid]){
                return mid;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}


PriorityQueue<Integer> pq=new PriorityQueue<Integer>(size,new Comparactor<Integer>(){
    public int compare(int a, int b){
        return a-b;
    }
});


PriorityQueue<Integer> pq=new PriorityQueue<Integer>(size, (a,b)->a-b);

PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparactor<int[]>(){
    public int compare(int[] a, int[] b){
        return a[0]-b[0];
    }
});


Arrays.sort(months,
            (String a, String b) -> a.length() - b.length());
Or shorter:
Arrays.sort(months, (a, b) -> a.length() - b.length());


Arrays.sort(months, 
    (String a, String b) -> { return Integer.signum(a.length() - b.length()); }
);



// 快排:

O(nlogn): 
public class QuickSort {
	public static void quickSort(int[] arr, int low, int high){
		if(arr==null||arr.length==0) return;
		if(low>=high) return;

		int mid=low+(high-low)/2;
		int pivot=arr[mid];

		int l=low;
		int h=high;

		while(l<=h){
			while(pivot>arr[l]){
				l++;
			}
			while(pivot<arr[h]){
				h--;
			}
			if(l<=h){
				int tmp=arr[l];
				arr[l]=arr[h];
				arr[h]=tmp;
				l++;
				h--;
			}
		}
		if(l<high){
			quickSort(arr,l,high);
		}
		if(h>low){
			quickSort(arr,low,h);
		}
	}
}





class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, hi);
        int count = hi - pivot + 1;
        // 如果找到直接返回
        if (count == k)
            return nums[pivot];
        // 从右边部分找
        if (count > k)
            return quickSelect(nums, pivot + 1, hi, k);
        // 从左边部分找
        return quickSelect(nums, lo, pivot - 1, k - count);
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
}

    // private void swap(int[] nums, int i, int j) {
    //     if (i != j) {
    //         nums[i] ^= nums[j];
    //         nums[j] ^= nums[i];
    //         nums[i] ^= nums[j];
    //     }
    // }

// 异或交换:
// a = a^b;    a^=b;
// b = a^b;    b^=a;
// a = a^b;    a^=b;



// 作者：sdwwld
// 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/javadai-ma-de-2chong-da-an-by-sdwwld/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




求中位数，O(n)的java实现【利用快速排序折半查找中位数】
public static int getMedian(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int start, int end) {
        /***快排partition函数原代码——start***/
        int left = start;
        int right = end + 1;

        int point = nums[start];
        while (true) {
            while (left < right && nums[--right] >= point)
                ;
            while (left < right && nums[++left] <= point)
                ;
            if (left == right) {
                break;
            } else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = point;
        /***快排partition函数原代码——end***/

        /***定位判断***/
        if (left == (nums.length - 1) / 2) {
            return nums[left];
        } else if (left > (nums.length - 1) / 2) {
            return partition(nums, start, left - 1);
        } else {
            return partition(nums, left + 1, end);
        }
    }


// 改良：

public static int getMedian(int[] nums) {
    return partition(nums, 0, nums.length - 1);
}

private static int partition(int[] nums, int start, int end) {
    /***快排partition函数原代码——start***/
    int left = start;
    int right = end + 1;

    int point = nums[start];
    while (left<right) {
        while (nums[right] >= point)
            right--;
        while (nums[left] <= point)
            left++;
        if (left == right) {
            break;
        } else {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
    nums[start] = nums[left];
    nums[left] = point;
    /***快排partition函数原代码——end***/

    /***定位判断***/
    if (left == (nums.length - 1) / 2) {
        return nums[left];
    } else if (left > (nums.length - 1) / 2) {
        return partition(nums, start, left - 1);
    } else {
        return partition(nums, left + 1, end);
    }
}





/**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    // 1.4 算法分析
    // 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)



