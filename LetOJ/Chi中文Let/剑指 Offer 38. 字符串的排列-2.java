
/*
 * 
link: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/

剑指 Offer 38. 字符串的排列
难度
中等

487

收藏

分享
切换为英文
接收动态
反馈
输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8


2022-02-03 at 21:08
 


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    // 因为题目提到，不能有重复的，所以使用HashSet
    Set<String> result=new HashSet<String>();
    public String[] permutation(String s) {
        char[] c=new char[s.length()];
        for(int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        findAll(c,0);
        String[] arr=new String[result.size()];
        int index=0;
        for(String tmp:result){
            arr[index++]=tmp;
        }
        return arr;
    }

    public void findAll(char[] c, int index){
        if(index>=c.length) return;

        if(c.length-1==index){
            StringBuilder sb=new StringBuilder();
            for(Character tmp:c){
                sb.append(tmp+"");
            }
            result.add(sb.toString());
            return;
        }

        for(int i=index;i<c.length;i++){
            swap(c,i,index);
            findAll(c,index+1);
            swap(c,i,index);
        }
    }
    public void swap(char[] c, int i, int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}






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
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
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














