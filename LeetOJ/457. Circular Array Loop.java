
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

16 May 2020 at 9.22 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */
















class Solution {
    public boolean circularArrayLoop(int[] nums) {
		if (nums.length == 1) {
			return false;
		}
		
		for (int i=0;i<nums.length;i++) {
			// 下标已使用过，跳出
			if (isUsed(nums[i])) {
				continue;
			}
			
			int currentIndex = i;
			int current = nums[currentIndex];
			int direction = current > 0 ? 1 : -1;
			
			// 未使用的索引才能继续
			while (!isUsed(current)) {
				// 标记已使用过的下标
				setUsed(nums, currentIndex, i);
				
				int nextIndex = currentIndex + current;
				if (nextIndex > nums.length-1) {
					nextIndex = nextIndex % nums.length;
				} else if (nextIndex < 0) {
					nextIndex = nums.length + (nextIndex % nums.length);
				}
				// 下一个数的实际值
				int nextNum = nums[nextIndex];
				
				// 当前循环使用过
				if (isCircleUsed(nextNum, i)) {
					// 循环长度为1
					if (nextIndex == currentIndex) {
						break;
					} else {
						return true;
					}
				}
				
				int nextDirection = nextNum > 0 ? 1 : -1;
				// 方向相反，跳出
				if (direction != nextDirection) {
					break;
				}
				
				// 将当前下标置为下一个下标
				currentIndex = nextIndex;
				current = nextNum;
			}
		}
		return false;
    }
	
	int factor = 10;
	/*
	 * 标记已使用过的Index
	 * 
	 * 根据提示条件：
	 * 1. -1000 ≤ nums[i] ≤ 1000
	 * 2. nums[i] ≠ 0
	 * 3. 0 ≤ nums.length ≤ 5000
	 * 
	 * 除符号位外，数字占用位数为10位(2^10=1024>1000)，因此int值还有21位可供使用，确定计算因子为10
	 * 因0 ≤ nums.length ≤ 5000，可以使用11~24位来标记起始索引，表示这个索引已被使用过。
	 * 
	 */
	private void setUsed(int[] nums, int index, int startIndex) {
		nums[index] ^= (startIndex+1) << factor;
	}
	
	// 重置获取实际数字
	int resetFactor = (1 << 31) | ((1 << factor) - 1);
	private int resetUsedNum(int num, int startIndex) {
		return num ^ getCircleFactor(startIndex);
	}
	
	// 判断是否当前循环处理中的索引：还原后是-1000到1000的数字
	private boolean isCircleUsed(int num, int startIndex) {
		int oriNum = resetUsedNum(num, startIndex);
		return (oriNum >= -1000) && (oriNum <= 1000);
	}
	
	// 索引标记位：11~24位
	int indexFactor = 24;
	int usedFactor = ((1 << indexFactor) - 1) ^ ((1 << factor) - 1);
	// 判断数字是否使用过
	private boolean isUsed(int num) {
		int indexBit = num & usedFactor;
		return indexBit != usedFactor && indexBit != 0;
	}
	// 获取当前循环计算因子
	private int getCircleFactor(int startIndex) {
		return (startIndex+1) << factor;
	}
}

// 作者：user0654
// 链接：https://leetcode-cn.com/problems/circular-array-loop/solution/javabao-li-bian-li-shi-jian-fu-za-du-onkong-jian-f/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







