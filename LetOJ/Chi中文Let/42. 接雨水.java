
/*
 * 
link: 
https://leetcode-cn.com/problems/trapping-rain-water/submissions/

2020-7-20 at 9:44 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :





 * 
 */





class Solution {
    //9.28pm-9.44pm(看答案)
   public int trap(int[] height) {
		if (height.length <= 2)
			return 0;
		int res = 0;
		int maxHeight = height[0];
		int maxIndex = 0;
		// 最大值以及最大值下标
		for (int i = 1; i < height.length; i++)
			if (maxHeight < height[i]) {
				maxHeight = height[i];
				maxIndex = i;
			}
		// 左边
		int maxLeft = height[0];
		for (int i = 1; i < maxIndex; i++) {
			if (maxLeft > height[i])
				res += (maxLeft - height[i]);
			else
				maxLeft = height[i];
		}
		// 右边
		int maxRight = height[height.length - 1];
		for (int i = height.length - 2; 
				i > maxIndex; i--) {
			if (maxRight > height[i])
				res += (maxRight - height[i]);
			else
				maxRight = height[i];
		}
		return res;
 
	}
}



class Solution {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        // 跳过两边不能盛水的
        while (l < r && height[l] <= height[l + 1])
            l++;
        while (l < r && height[r] <= height[r - 1])
            r--;
        // 此时l指向左侧递增序列中最高的下标
        while (l < r) {
            int left = height[l++];
            int right = height[r--];
            if (left < right) {
                while (l < r && left >= height[l]) {
                    res += left - height[l];
                    l++;
                }
            } else {
                while (l < r && right >= height[r]) {
                    res += right - height[r];
                    r--;
                }
            }
        }
        return res;
    }
}












