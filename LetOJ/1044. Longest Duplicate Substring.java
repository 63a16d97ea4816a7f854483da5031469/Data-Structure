
/*
 * 
https://leetcode.com/problems/longest-duplicate-substring/


1044. Longest Duplicate Substring
Hard

521

202

Add to List

Share
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

 

Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""
 

Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.

20 June 2020 at 11:18 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public String longestDupSubstring(String S) {
        int n = S.length();
        
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = (int)(S.charAt(i) - 'a');
        }    
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2,32);
        // binary search ,L = repeating string length
        int left = 1,right = n;
        int L;
        while(left != right){
            L = left + (right - left) / 2;
            if(search(L,a,modulus,n,nums) != -1){
                left = L + 1;
            }else{
                right = L;
            }
        }
        int start = search(left - 1,a,modulus,n,nums);
        return start != -1 ? S.substring(start,start + left - 1) : ""; 
    }

    // Rabin-Karp  
    public int search(int L,int a,long modulus,int n,int[] nums){
        long h = 0;
        for(int i = 0;i < L;i++){
            h = (h * a + nums[i]) % modulus;
        }
        // already seen hashes of string of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);

        long aL = 1;
        for(int i=1;i <= L;i++){
            aL = (aL * a) % modulus;
        }

        for(int start = 1;start < n-L + 1;++start){
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if(seen.contains(h))
            {
                return start;
            }

            seen.add(h);
        }

        return -1;
    }
}

// 作者：jasonnk
// 链接：https://leetcode-cn.com/problems/longest-duplicate-substring/solution/zui-chang-zhong-fu-zi-chuan-by-jasonnk/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


















