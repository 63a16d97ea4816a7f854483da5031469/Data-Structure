
/*
 * 
link: 
https://leetcode-cn.com/problems/bulb-switcher/

2020-8-27 at 8:59 pm

319. 灯泡开关
难度
中等

127

收藏

分享
切换为英文
关注
反馈
初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。

示例:

输入: 3
输出: 1 
解释: 
初始时, 灯泡状态 [关闭, 关闭, 关闭].
第一轮后, 灯泡状态 [开启, 开启, 开启].
第二轮后, 灯泡状态 [开启, 关闭, 开启].
第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 

你应该返回 1，因为只有一个灯泡还亮着。


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */









// 规律一：第n个灯是否被点亮取决于 从 1 - n 中间有多少个可以整除个数，如果是奇数则点亮，如果是偶数则关闭。
// 基于这个版本提交了，发现会超时。


class Solution {
    public int bulbSwitch(int n) {
        if (n <= 1) {
            return n;
        }
        int ans = 0;
        for (int i = 2; i < n; i ++) {
            if(i * i <= n) {
                ans ++;
            }else{
                break;
            }
        }
        return ans + 1;
    }
}

// 作者：xteaj
// 链接：https://leetcode-cn.com/problems/bulb-switcher/solution/si-kao-liao-hao-jiu-fa-xian-gui-lu-na-wo-zhe-shi-z/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    //8.44pm-8.58pm  超时
    public int bulbSwitch(int n) {
        boolean[] arr=new boolean[n];
        Arrays.fill(arr,true);
        int count=n;
        for(int i=2;i<=n;i++){
            int k=i;
            while(k<=arr.length){
                arr[k-1]=!arr[k-1];
                if(arr[k-1]){
                    count++;
                }else{
                    count--;
                }
                k+=i;
            }
        }
        return count;
    }
}


class Solution {
    //8.44pm-8.58pm  超时
    public int bulbSwitch(int n) {
        boolean[] arr=new boolean[n];
        Arrays.fill(arr,true);
        int count=0;
        for(int i=2;i<=n;i++){
            int k=i;
            while(k<=arr.length){
                arr[k-1]=!arr[k-1];
                k+=i;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]) {
                count++;
            }
        }
        return count;
    }
}


















