
/*
 * 
https://leetcode.com/problems/self-dividing-numbers/


728. Self Dividing Numbers
Easy

580

282

Add to List

Share
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

16 May 2020 at 12:20 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result=new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            boolean isValid=true;
            int curr=i;
            String str=curr+"";
            if(str.contains("0")) continue;
            while(curr>0){
                int currDigital=curr%10;
                // System.out.println(curr+" "+currDigital);
                if(i%currDigital==0){
                    curr=curr/10;
                }else{
                    isValid=false;
                    break;
                }
            }
            if(isValid){
                result.add(i);
            }
        }
        return result;
    }
}



















