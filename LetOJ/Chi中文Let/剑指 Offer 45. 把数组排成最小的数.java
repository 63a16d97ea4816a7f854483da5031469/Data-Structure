
/*
 * 
link: 
https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/

2020-8-30 at 10:10 pm

剑指 Offer 45. 把数组排成最小的数
难度
中等

89

收藏

分享
切换为英文
关注
反馈
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

 

示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"
 

提示:

0 < nums.length <= 100
说明:

输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs, int low, int high) {
        if(low >= high) return;
        int left = low, right = high;
        String tmp = strs[left];
        while(left < right) {
            while((strs[right] + strs[low]).compareTo(strs[low] + strs[right]) >= 0 && left < right) right--;
            while((strs[left] + strs[low]).compareTo(strs[low] + strs[left]) <= 0 && left < right) left++;
            tmp = strs[left];
            strs[left] = strs[right];
            strs[right] = tmp;
        }
        strs[left] = strs[low];
        strs[low] = tmp;
        quickSort(strs, low, left - 1);
        quickSort(strs, left + 1, high);
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; ++i)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,(o1,o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s);
        return sb.toString();
    }
}

// 作者：archerxyz
// 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/javajian-dan-pai-xu-14xing-dai-ma-by-archerxyz/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public String minNumber(int[] nums) {
        PriorityQueue<String> pq=new PriorityQueue<String>((o1,o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        for(int tmp:nums){
            pq.add(tmp+"");
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}


//错误解法:
class Solution {
    public String minNumber(int[] nums) {
        PriorityQueue<String> pq=new PriorityQueue<String>();
        for(int tmp:nums){
            pq.add(tmp+"");
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}











