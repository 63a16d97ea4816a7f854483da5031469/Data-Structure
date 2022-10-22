
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


638. Shopping Offers
Medium

1171

679

Add to List

Share
In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given an integer array price where price[i] is the price of the ith item, and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.

You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.

Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.

 

Example 1:

Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:

Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
Output: 11
Explanation: The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
 

Constraints:

n == price.length == needs.length
1 <= n <= 6
0 <= price[i], needs[i] <= 10
1 <= special.length <= 100
special[i].length == n + 1
0 <= special[i][j] <= 50


DATE: 2022-October-15
TIME: 17:27:59


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        // handle the 0 cases
        int count=0;
        for(int tmp:needs){
            count+=tmp;
        }
        if(count==0) return 0;
        
        
        // 1. scan the needs
        // 2. check the special price (priority on special price
        // --special price may have more than one kind of choices)
        // 
        
    }
}


https://leetcode.cn/problems/shopping-offers/solutions/1063610/gong-shui-san-xie-yi-ti-shuang-jie-zhuan-qgk1/?languageTags=java

 * 
 */


// Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]

//作者思路非常清晰，值得学习
//构造DFS搜索，必须是一个非常擅长的技能。

class Solution {
    public  int minprice=0;//最低价格

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minprice=notusespecial( price,needs);//直接购买的价格
        DFS(price,  special,  needs,0, 0);//深度遍历穷举

        return minprice;

    }

    //直接购买的价格
    public  int  notusespecial(List<Integer> price,List<Integer> needs){
        int total=0;//总和
        int n=price.size();//价格
        for(int i=0;i<n;i++){
            total+= needs.get(i)*price.get(i);//价格乘以数量
        }
        return total;//返回总和
    }

    //是否可以购买礼包
    public boolean canusespecial(List<Integer> needs,List<Integer> offer){
        int n=needs.size();//需要的数量
        for(int i=0;i<n;i++){
            if(needs.get(i)<offer.get(i)){ //不可以购买超出待购清单的物品
                return false;//不可以使用礼包
            }
        }
        return true;

    }
    
    //穷举所有可以购买，确保最低,index索引，used已经使用的money
    public void  DFS(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int index, int used){
        if(used >=minprice){
            return ;//比不用购买大礼包，直接购买还贵，不需要比较了
        }
        if(index==special.size()){ //礼包的索引循环到最后了
            used+=notusespecial(price,needs);//买完礼包剩下的直接购买了
            if(used<minprice){
                minprice=used;//保存最小花销
            }
            return; //在这里结束

        }
        List<Integer>  offer=special.get(index);//抓取礼包
        if(canusespecial(needs,offer)){//判断礼包可以使用
            int n=needs.size(); //需求arr的长度
            List<Integer> updateneeds=new ArrayList<>();//更新的需求
            for(int i=0;i<n;i++){//减去处理好的需求
                updateneeds.add(needs.get(i)-offer.get(i));//更新需求，减去提供

            }
            int specialPrice=offer.get(n); //拿到 特价值
            DFS(price,special,updateneeds,index,used+specialPrice);//深度遍历

        }
        //当前offer用完了，可能需要下一个，index+1
        DFS(price,special,needs,index+1,used);
    }
}

作者：尹成大魔王
链接：https://leetcode.cn/problems/shopping-offers/solutions/1705239/di-gui-shen-du-bian-li-100-by-tsinghuach-5do0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








class Solution {
    int min=0;
    List<Integer> _price=null;
    List<List<Integer>> _special=null;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        _price=price;
        _special=special;
        
        // no use of the special offer
        min=noSpecialOffer(needs);
        
        // dfs for using the special offers
        dfs(needs, 0, 0);
        
        return min;
    }
    
    
    public void dfs(List<Integer> needs, int index, int cost){
        
        if(cost>min){
            // stop if already over min
            return;
        }
        
        // stop condition
        if(index==_special.size()){
            min=Math.min(min,cost+noSpecialOffer(needs));
            return;
        }
        
        List<Integer> currSpecial=_special.get(index);
        if(canUseOffer(currSpecial, needs)){
            List<Integer> newNeeds=new ArrayList<Integer>();
            for(int i=0;i<needs.size();i++){
                newNeeds.add(needs.get(i)-currSpecial.get(i));
            }
            // cost+=currSpecial.get(needs.size()); 这里不能改变cost的值
            // special offer可以反复使用，所以index不能变
            dfs(newNeeds,index,cost+currSpecial.get(needs.size()));
        }
        dfs(needs,index+1,cost);
    }
    
    public boolean canUseOffer(List<Integer> special, List<Integer> needs){
        for(int i=0;i<needs.size();i++){
            // Cannot over needs
            if(needs.get(i)<special.get(i)){
                return false;
            }
        }
        return true;
    }
    
    
    public int noSpecialOffer(List<Integer> needs){
        int total=0;
        for(int i=0;i<_price.size();i++){
            total+=_price.get(i)*needs.get(i);
        }
        return total;
    }
    
    
    
    
    
}










