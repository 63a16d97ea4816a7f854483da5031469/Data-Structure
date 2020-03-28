
/*
 * 
https://leetcode.com/problems/string-compression/


Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
 

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

28 March 2020 at 8:33:31 pm
 * 
 */


正确解：

我的主线思路是正确的，虽然我没有想到是堆栈的这个思维模型，但是双指针其实跟堆栈有点类似。

很重要的改进点：
1. 没想到要用 i与i+1的向后一位比较的，向后看的比较方向
2. 没有想清楚，i 与 i+1的向后比较的 两种情况下，要做的事情是什么 （这个可以通过pseudocode 来训练）


在这个题目中：

pseudocode:

int count=1;
int ctop=0;
int n=chars.length;

对i 从0开始向后遍历到n-1
	对每一个chars[i]与chars[i+1] 进行比较：
		如果chars[i]==chars[i+1]:
			则对计数器count++;
		如果chars[i]!=chars[i+1]:
			慢指针ctop移位到下一位
			如果count目前大于1，则打印该count的全部char，并且ctop移到非打印char的下一位，count重置到1
			取新的chars[i+1]放入当前位置

循环结束，如果count>1,则打印count的全部char，并且ctop移到下一个位置

返回ctop

使用堆栈更好具象化的理解，但是如果称为另一种双指针，也是可以的，重要的是对比的方向是i,i+1，对这个比较做出不一样的反应。





class Solution {
    // 28.03.2020  10.03am -10.40am
    // 28.03.2020  1.16pm - 1.57pm
    public int compress(char[] chars) {
        
        //处理极端情况
        if(chars.length==0 || chars.length==1){
            return chars.length;
        }
 
        
        int count=1;
        
        //使用堆栈原理
       
        int ctop=0;
        
        for(int i=0;i<chars.length-1;i++){
            
            if(chars[i]==chars[i+1]){
                count++;
                
                
            }else{
                ctop++;

                if(count>1){
                   
                    //如何convert 数字去char?
                    String s=(count)+"";
                    
                    for(char tmp:s.toCharArray()){
                        chars[ctop++]=tmp;
                    }
                    
                    //reset count
                    count=1;
                 }
                
                chars[ctop]=chars[i+1];
                
            }
        }
    
   // 处理最后一个元素
        ctop++;
        if(count>1){
               String s=(count)+"";
                    
                    for(char tmp:s.toCharArray()){
                        chars[ctop++]=tmp;
                    }
        }
        
        return ctop;
        
    }
}












[错误解]-陷入快慢指针模型，没有想到使用 i， i+1的向后一位比较的，向后看的比较方向

class Solution {
    // 28.03.2020  10.03am -10.40am
    //
    public int compress(char[] chars) {
        
        //处理极端情况
        if(chars.length==0 || chars.length==1){
            return chars.length;
        }
        
        Arrays.sort(chars);
        
        int count=0;
        int k=0;
        
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[k]){
                  count++;
                if(i==chars.length-1){
                    
                    k++;
                        String s=(count+1)+"";
                    for(char tmp:s.toCharArray()){
                        chars[k++]=tmp;
                    }
             
                }
            }else{
                
                if(count>=1){
                    //如何convert 数字去char?
                 
                    String s=(count+1)+"";
                    for(char tmp:s.toCharArray()){
                        chars[k++]=tmp;
                    }
                     
                    count=0;
                }
                   k++;
                
            }
        }
        
        return k;
        
    }
}





















