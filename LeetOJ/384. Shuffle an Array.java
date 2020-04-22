
/*
 * 
https://leetcode.com/problems/shuffle-an-array/


384. Shuffle an Array
Medium

443

929

Add to List

Share
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


















class Solution {
    
    //基本思路，将这个数组的所有组合求出来，然后使用random函数来进行选择，使用mod函数进行回旋到数组上

    public Solution(int[] nums) {
        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */




// 题解:

public class Solution {

    public Solution(int[] nums) {
        array = nums.clone();
        res = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();  
        random.nextInt();
        int len = res.length;
        for(int i = 0; i < len; i++)
        {
            int change = random.nextInt(len-i);
            swap(res, i, change);

        }
        return res;
    }
    private void swap(int[] a, int i, int change){
        int tmp = a[i];
        a[i] = a[change];
        a[change] = tmp;
    }

    private int[] array;
    private int[] res;
}
————————————————
版权声明：本文为CSDN博主「五山小新新」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Al_xin/article/details/52324913

