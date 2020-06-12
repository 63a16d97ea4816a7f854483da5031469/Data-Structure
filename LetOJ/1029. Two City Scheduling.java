
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/

1029. Two City Scheduling
Easy

734

98

Add to List

Share
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000

16 May 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :





 * 
 */





class Solution {
    public int twoCitySchedCost(int[][] costs) {
    // Sort by a gain which company has 
    // by sending a person to city A and not to city B
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o1[0] - (o2[1] - o2[0]);
      }
    });

    int total = 0;
    int n = costs.length / 2;
    // To optimize the company expenses,
    // send the first n persons to the city A
    // and the others to the city B
    for (int i = 0; i < n; ++i) total += costs[i][1];
    for (int i = n; i < 2*n; ++i) total += costs[i][0];
    return total;
  }
}

//a(1-x) + bx

//a + (b-a)x




class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, 
                (int[] a, int[] b) -> (a[0] - a[1]) - (b[0] - b[1])  
                   );
        
        int cost = 0;
        for(int i = 0; i < costs.length; i++) {
            if(i < costs.length/2) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}




// http://www.noteanddata.com/leetcode-1029-Two-City-Scheduling-java-solution-note.html

// 题目 leetcode 1029 Two City Scheduling

// 输入一个长度是2*N的二维数组， a[i][0]表示第i个人分配到A城市的价格， a[i][1]表示第i个人分配到B城市的价格
// 把这2*N个数组分成长度相等的两份， 其中一半选择A， 另外一半选择B， 问总共最小的总共价格是多少？
// 刷题感悟

// 这个题目暴力肯定不行， 直接简单的贪心选择最小的也不对， 卡壳了好一会儿。
// 还好后来终于想出来了，感觉这样的题目能不能分析出来很没有把握。
// 解题思路分析

// 假设所有的人都选择城市A， 这时候sum=sum{a[i][0]},
// 然后要选择一半的人改成B， 这个时候, 选择某一个人对sum的影响是d=a[i][1]-a[i][0],
// 那么， 我们要让结果最小， 就需要让这个d最小， 那按照这个d对数组排序，然后选择最小的一半就好

public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            int v1 = a[1] - a[0];    
            int v2 = b[1] - b[0];
            return v1-v2;
        }
    });
    int sum = 0;
    for(int[] cost: costs) {
        sum += cost[0];
    }
    for(int i = 0; i < costs.length/2; ++i) {
        sum += costs[i][1] - costs[i][0];
    }
    return sum;
}








class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        List<int[]> cityA = new ArrayList<int[]>();
        List<int[]> cityB = new ArrayList<int[]>();
        
        int optimum = (costs.length)/2;
        
        for(int i = 0; i<costs.length; i++){
            if(costs[i][0] < costs[i][1]){
                cityA.add(costs[i]);
            } else{
                cityB.add(costs[i]);
            }
        }
        
        
        List<int[]> heavy = cityA.size() > cityB.size() ? cityA : cityB;
        List<int[]> light = cityA.size() > cityB.size() ? cityB : cityA;
        boolean aHeavy = cityA.size() > cityB.size();
        
        if(aHeavy){
            //cityA
            heavy = heavy.stream().sorted((x,y) -> (x[1] - x[0])- (y[1] - y[0])).collect(Collectors.toList());
        } else{
            //cityB
            heavy = heavy.stream().sorted((x,y) -> (x[0] - x[1])- (y[0] - y[1])).collect(Collectors.toList());
        }
        
        while(heavy.size() != light.size()){
                light.add(heavy.remove(0));
        }
        
        int cost = aHeavy ? findCost(heavy, light) : findCost(light, heavy);

        //System.out.println(cost);
        return cost;
        
    }
    
    private static int findCost(List<int[]> a, List<int[]> b){
        
        int sum = 0;
        
        for( int[] i : a){
            sum += i[0];
        }
        
        for( int[] i : b){
            sum += i[1];
        }
        
        return sum;
        
    }
    
}







class Solution {
    //11.35pm-11.54pm
    public int twoCitySchedCost(int[][] costs) {
        int[] aArr=new int[costs.length];
        int[] bArr=new int[costs.length];
        for(int i=0;i<costs.length;i++){
            int a=costs[i][0];
            int b=costs[i][1];
            aArr[i]=a;
            bArr[i]=b;
        }
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        int k=costs.length;
        int sum=0;
        int[] used=new int[k];
        
        
        return sum;
    }
}




