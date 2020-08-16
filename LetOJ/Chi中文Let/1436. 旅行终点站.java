
/*
 * 
link: 
https://leetcode-cn.com/problems/destination-city/

2020-8-16 at 11:02 pm

1436. 旅行终点站
难度
简单

27

收藏

分享
切换为英文
关注
反馈
给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。

题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。

 

示例 1：

输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
输出："Sao Paulo" 
解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
示例 2：

输入：paths = [["B","C"],["D","B"],["C","A"]]
输出："A"
解释：所有可能的线路是：
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
显然，旅行终点站是 "A" 。
示例 3：

输入：paths = [["A","Z"]]
输出："Z"
 

提示：

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
所有字符串均由大小写英文字母和空格字符组成。

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


class Solution {
    //10.55pm-11.01pm
    public String destCity(List<List<String>> paths) {
        if(paths.size()==1) return paths.get(0).get(1);
        HashMap<String,String> map=new HashMap<String,String>();
        for(int i=0;i<paths.size();i++){
            map.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        for(int i=0;i<paths.size();i++){
            if(map.get(paths.get(i).get(1))==null){
                return paths.get(i).get(1);
            }
        }
        return null;
    }
}





















