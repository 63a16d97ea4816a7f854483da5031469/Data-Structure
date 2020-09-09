
/*
 * 
link: 
https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/

2020-9-9 at 8:43 pm


剑指 Offer 38. 字符串的排列
难度
中等

103

收藏

分享
切换为英文
关注
反馈
输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




// DFS:


class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位 
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








 //超时

class Solution {
	//8.29pm-8.42pm
	Set < String > list = new HashSet < String > ();
	public String[] permutation(String s) {
		permutate(s.toCharArray(), 0);
		String[] ans = new String[list.size()];
		int idx = 0;
		for (String tmp: list) {
			ans[idx++] = tmp;
		}
		return ans;
	}

	public void permutate(char[] arr, int start) {
		if (start >= arr.length) return;

		StringBuffer sb = new StringBuffer();
		for (Character tmp: arr) {
			sb.append(tmp + "");
		}

		list.add(sb.toString());

		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, start);
			permutate(arr, start + 1);
			swap(arr, i, start);
		}
	}
	public void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}




















