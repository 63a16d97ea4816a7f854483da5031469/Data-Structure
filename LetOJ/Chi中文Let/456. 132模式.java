
/*
 * 
link: 
https://leetcode-cn.com/problems/132-pattern/

2020-7-30 at 8:24 am

456. 132模式
难度
中等

185

收藏

分享
切换为英文
关注
反馈
给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

注意：n 的值小于15000。

示例1:

输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。
示例 2:

输入: [3, 1, 4, 2]

输出: True

解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
示例 3:

输入: [-1, 3, 2, 0]

输出: True

解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 从后向前找到最大的次大值

// 从后往前遍历找到符合条件的次大值（注意只用找次大值）
// 之后只需要和次大数值比较即可，如果当前元素<次大值则返回true

// 寻找右面符合条件的最大值和次大值的方法如下：

// 如果当前元素小于栈顶元素，则入栈
// 如果当前元素大于栈顶元素，则先出栈，出到当前元素小于栈顶元素（之前的一个局部最大值），出的同时让second和出栈元素比较，取较大的那个（临界条件）

// 作者：jiaxin-2
// 链接：https://leetcode-cn.com/problems/132-pattern/solution/cong-hou-xiang-qian-zhao-dao-zui-da-de-ci-da-zhi-b/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int second = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<> ();
        stack.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = Math.max(stack.pop(), second);
                }
                stack.push(nums[i]);
            }
        }
    }
}

// 作者：jiaxin-2
// 链接：https://leetcode-cn.com/problems/132-pattern/solution/cong-hou-xiang-qian-zhao-dao-zui-da-de-ci-da-zhi-b/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int leftMin = nums[0];
		int right = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			// 獲取當中的數字
			int num2 = nums[i];
                        // 左邊始終獲取最小值
			if (leftMin > nums[i-1]) leftMin = nums[i-1];
			if (leftMin > num2) continue;
                        // 右邊遍歷，得到符合條件的就返回true
			for (int j = i + 1; j < nums.length; j++) {
				right = nums[j];
				if (right < num2 && right > leftMin) return true;
			}
		}
		return false;
    }
}

// 作者：shdvgj
// 链接：https://leetcode-cn.com/problems/132-pattern/solution/javade-yi-zhong-jie-fa-by-shdvgj/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//根据答案，重写：
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length==0) return false;
         int second=Integer.MIN_VALUE;
         Stack<Integer> stack=new Stack<Integer>();
         stack.add(nums[nums.length-1]);
         for(int i=nums.length-2;i>=0;i--){
             if(nums[i]<second){
                 return true;
             }else{
                 while(!stack.isEmpty()&&nums[i]>stack.peek()){
                      second=Math.max(second,stack.pop());
                 }
             }
             stack.push(nums[i]);
         }
         return false;
    }
}