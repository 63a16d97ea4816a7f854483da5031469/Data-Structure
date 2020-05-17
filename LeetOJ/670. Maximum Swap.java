
/*
 * 
https://leetcode.com/problems/maximum-swap/


670. Maximum Swap
Medium

855

62

Add to List

Share
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: 9973
Output: 9973
Explanation: No swap.
Note:

The given number is in the range [0, 108]

17 May 2020 at 1:53 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 需要找最大的整数， 那么被替换的数字需要是最左边的
// 对于某一个被替换的数字， 需要找右边最大的数字


// 这个思路有想到，但是想不到如何去实施，写出code，所以看了题解


public int maximumSwap(int num) {
    char[] arr = String.valueOf(num).toCharArray();
    for(int i = 0; i < arr.length; ++i) {
        int maxIndex = i;
        for(int j = arr.length-1; j > i; --j) {
            if(arr[j] > arr[maxIndex]) {
                maxIndex = j;
            }
        }
        if(maxIndex > i) {
            char t = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = t;
            return Integer.valueOf(new String(arr));
        }
    }
    return num;
}


class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        //建立数字与坐标映射
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}



class Solution {
    public int maximumSwap(int num) {
        String numStr = num + "";
        char[] nums = numStr.toCharArray();
        int left = -1, right = -1;
        
        int max = nums[nums.length -1];
        int max_id = nums.length - 1;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > max) {
                max = nums[i];
                max_id = i;
            }
            
            if(nums[i] < max) {
                left = i;
                right = max_id;
            }
        }
        
        if(left != -1) {
            char temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        
        String newNumStr = new String(nums);
        return Integer.valueOf(newNumStr);
    }
}




// WA:
// Input
// 98368
// Output
// 98638
// Expected
// 98863

class Solution {
    //1.45pm-1.53pm
    //使用单调栈思想
    public int maximumSwap(int num) {
        String str=num+"";
        if(str.length()<=1) return num;
        char[] c=str.toCharArray();
        for(int i=0;i<str.length()-1;i++){
            if(Integer.parseInt(c[i]+"")<Integer.parseInt(c[i+1]+"")){
                char tmp=c[i];
                c[i]=c[i+1];
                c[i+1]=tmp;
                break;
            }
        }
        String s="";
        for(int i=0;i<c.length;i++){
           s+=c[i]; 
        }
        return Integer.parseInt(s);
    }
}





