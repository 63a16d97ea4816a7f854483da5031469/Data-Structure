
/*
 * 
https://leetcode.com/problems/di-string-match/

942. DI String Match
Easy

733

292

Add to List

Share
Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
 

Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




 

class Solution {
    //7.33pm-7.51pm
    //使用笨方法，枚举所有的可能，然后看是否符合，如果符合就返回
    //7.51pm-7.57pm        使用linkedList，如果遇到I就从前面调，遇到D就从后面调
   
    public int[] diStringMatch(String S) {
        int[] result=new int[S.length()+1];
        LinkedList<Integer> list=new LinkedList();
        
        for(int i=0;i<S.length()+1;i++){
            list.add(i);
        }
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='I'){
                result[i]=list.removeFirst();
            }else{
                result[i]=list.removeLast(); 
            }
        }
        result[S.length()]=list.removeLast();
        
        
        return result;
    }
    
   
    
    
}








Time Limit Exceeded
Details 

class Solution {
    //7.33pm-7.51pm
    //使用笨方法，枚举所有的可能，然后看是否符合，如果符合就返回
    int[] result=null;
    public int[] diStringMatch(String S) {
        
        int[] nums=new int[S.length()+1];
        
        for(int i=0;i<nums.length;i++){
            nums[i]=i;
        }
         
        createPermutation(S.toCharArray(),nums, 0);
        
        return result;
    }
    
    void createPermutation(char[] scharArr, int[] nums, int start){
        if(start>nums.length) return;
        
        boolean isNotValid=false;
        for(int i=0;i<scharArr.length;i++){
            if(scharArr[i]=='I'){
                if(nums[i]>=nums[i+1]){
                    isNotValid=true;
                }
            }else{
                if(nums[i]<=nums[i+1]){
                    isNotValid=true;
                }
            }
        }
        if(!isNotValid){
            result=nums.clone();
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            
            swap(nums,i,start);
            createPermutation(scharArr,nums,start+1);
            swap(nums,i,start);
        }
        
        
    }
    
    void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    
    
}















