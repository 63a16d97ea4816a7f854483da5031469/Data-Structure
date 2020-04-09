
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/



Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4


9 April 2020 at 5.15pm
 * 
 */














// 5.14pm-5.24pm
// Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==0) return 0;
        
        int curr=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curr<0){
                curr=nums[i];
            }else{
                curr=curr+nums[i];
            }
            
            if(max<curr){
                max=curr;
            }
            
        }
        return max;
    }
}






// Group Anagrams
// Solution
// Given an array of strings, group anagrams together.

// Example:

// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:

// All inputs will be in lowercase.
// The order of your output does not matter.


//5.26pm-5.37pm

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<String, List<String>>();
        
       List<List<String>> result=new ArrayList<List<String>>();
        
        for(int i=0;i<strs.length;i++){
            String tmp=findUniqueSet(strs[i]);
            
            if(map.get(tmp)==null){
                List<String> list=new ArrayList<String>();
                list.add(strs[i]);
                map.put(tmp,list);
            }else{
                List<String> list=map.get(tmp);
                list.add(strs[i]);
                map.put(tmp,list);
            }
        }
        
        for(Map.Entry<String,List<String>> set:map.entrySet()){
            result.add(set.getValue());
        }
        return result;
        
    }
    
    String findUniqueSet(String s){
        char[] c=s.toCharArray();
        
        List<Character> list=new ArrayList<Character>();
        
        for(int i=0;i<c.length;i++){
            list.add(c[i]);
        }
        
        Collections.sort(list);
        
        String str="";
        for(int i=0;i<list.size();i++){
            str+=list.get(i)+"";
        }
        return str;   
    }    
}


Best Time to Buy and Sell Stock II
Solution
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i] <= 10 ^ 4


public class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
     for(int i=1;i<prices.length;i++){
         if(prices[i]-prices[i-1]>0){
             ans+=prices[i]-prices[i-1];
         }
     }
        
        return ans;
    }
}


Counting Elements
Solution
Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

 

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
 

Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000


//5.37pm - 5.47pm


class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        Arrays.sort(arr);
        
        //Map all the int into the map. 
        for(int i=0;i<arr.length;i++){
            int tmp=arr[i];
            if(map.get(tmp)==null){
                map.put(tmp, 1);
            }else{
                int saved=map.get(tmp);
                map.put(tmp, saved+1);
            }
        }
        
        int count=0;
        for(int i=0;i<arr.length;i++){
            int tmp=arr[i];
            if(map.get(tmp+1)!=null){
                int saved=map.get(tmp+1);
                // if(saved>0){
                     // map.put(tmp+1, saved-1);
                     count++;
                // }
               
            }
        }
        return count;
    }
}




Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


public class Solution {
	public static void moveZeroes(int[] nums) {
        // Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0){
                //如果左边有0， 则从后端开始找到一个不为0的，换
                for(int j=i;j<nums.length-1;j++){
                    swap(nums,j,j+1);
                }
            }
        }
        
         for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0){
                //如果左边有0， 则从后端开始找到一个不为0的，换
                for(int j=i;j<nums.length-1;j++){
                    swap(nums,j,j+1);
                }
            }
        }
	}
    
    static void swap(int[] nums, int i, int j){
        
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}





没有保证相对位置不变

public class Solution {
	public static void moveZeroes(int[] nums) {
        // Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0){
                //如果左边有0， 则从后端开始找到一个不为0的，换
                int j=nums.length-1;
                while(i<j && nums[j]==0){
                      j--;
                }
                swap(nums,i,j);
            }
        }
	}
    
    static void swap(int[] nums, int i, int j){
        
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}