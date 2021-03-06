
/*
 * 
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/


421. Maximum XOR of Two Numbers in an Array
Medium

977

168

Add to List

Share
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
 



10 April 2020 at 11.53pm pm
 * 
 */


 暴力破解: 但是没有到 O(n)

class Solution {
    
    public int findMaximumXOR(int[] nums) {
    int result = 0;
    for(int i = 0; i < nums.length; i++){
        for (int j = i + 1; j < nums.length; j ++){
            result = Math.max(result,nums[i] ^ nums[j]);
        }
    }
    return result;
    }
    
}
    
// ————————————————
// 版权声明：本文为CSDN博主「weixin_kite」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/weixin_37608065/article/details/70183731




class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        // test each bit pose, 判断能不能构成所需要的值；
        for(int i = 31; i >= 0; i --) {
            // 每次都在之前的基础上更新mask
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                // add the number which has the mask as its prefix;
                set.add(num & mask);
            }
            // 假设当前所能达到的最大值是这个temp值；
            int tmp = max | (1 << i);
            for(Integer prefix : set) {
                if(set.contains(prefix ^ tmp)) {
                    // 如果能组成就直接break 
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
    
// ————————————————
// 版权声明：本文为CSDN博主「weixin_kite」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/weixin_37608065/article/details/70183731
// ————————————————
// 版权声明：本文为CSDN博主「weixin_kite」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/weixin_37608065/article/details/70183731





https://www.cnblogs.com/njufl/p/6403043.html


class Solution {
    //11.15pm
  
    class Trie {
        Trie[] next;

        public Trie() {
            next = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1 || nums == null)
            return 0;
        Trie root = new Trie();
        for (int num : nums) {
            Trie node = root;
            for (int i = 30; i >= 0; i--) {
                int cur = (num >>> i) & 1;
                if (node.next[cur] == null) {
                    node.next[cur] = new Trie();
                }
                node = node.next[cur];
            }
        }

        int result = 0;
        for (int num : nums) {
            Trie node = root;
            int xor = 0;
            for (int i = 30; i >= 0; i--) {
                int cur = (num >>> i) & 1;
                //cur = cur ^ 1;
                if (node.next[cur ^ 1] != null) {
                    xor += (1 << i);
                    node = node.next[cur ^ 1];
                } else {
                    node = node.next[cur];
                }
            }
            result = result > xor ? result : xor;
        }
        return result;
    }
}
























