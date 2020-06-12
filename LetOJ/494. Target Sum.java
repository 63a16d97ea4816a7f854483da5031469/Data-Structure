
/*
 * 
https://leetcode.com/problems/target-sum/


494. Target Sum
Medium

2140

95

Add to List

Share
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */




int findTargetSumWays(vector<int>& nums, int S) {
    int sum=accumulate(nums.begin(),nums.end(),0);
    if(sum<S||sum+S&1) return 0;
    //special case:
    int nZeros=0;
    for(auto it=nums.begin();it!=nums.end();){
        if(*it==0){
            nZeros++;
            it=nums.erase(it);
        }else ++it;
    }

    //开始动规求解
    int row=nums.size();
    int x=sum+S>>1;
    vector<vector<int>>dp(row+1,vector<int>(x+1,0));
    dp[0][0]=1;
    for(int i=0;i<row;i++){
        dp[i+1][0]=1;//注意第一列初始为1，表示容量为0时，有一种方式，即每个数值都不选
        for(int j=0;j<x;j++){
            if(nums[i]<=j+1) dp[i+1][j+1]=dp[i][j+1]+dp[i][j+1-nums[i]];//选不选这个数
            else dp[i+1][j+1]=dp[i][j+1];//放不下这个数，只能不选
        }
    }
    return dp[row][x]*(1<<nZeros);
}

// 作者：nannan
// 链接：https://leetcode-cn.com/problems/target-sum/solution/0-1bei-bao-dong-tai-gui-hua-jie-da-bai-90de-ti-jia/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

Java:

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num:nums){
            sum=sum+num;  //To get the sum
        }
        if(sum<S||(sum+S)%2==1) return 0;
        int nZeros=0;
        int idx=0;
        int[] arr=nums.clone();
        //remove 0:
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                nZeros++;
            }else{
                arr[idx++]=nums[i];
            }
        }
        int row=idx;
        int x=(sum+S)>>1;
        int[][] dp=new int[row+1][x+1];
        dp[0][0]=1;
        for(int i=0;i<row;i++){
            dp[i+1][0]=1; //注意第一列初始为1，表示容量为0时，有一种方式，即每个数值都不选
            for(int j=0;j<x;j++){
                if(arr[i]<=j+1) dp[i+1][j+1]=dp[i][j+1]+dp[i][j+1-arr[i]];//放得下，不选这个数+选这个数
                else dp[i+1][j+1]=dp[i][j+1];//放不下这个数，只能不选
            }
        }
        System.out.println(dp[row][x]);
        return dp[row][x]*(1<<nZeros);
    }
}



/*
这道题最直接的方法就是DFS深度优先遍历，不过可能超时，但是还有一个很棒的DP做法，我是参考网上的分析，主要分析如下：
1、该问题求解数组中数字只和等于目标值的方案个数，每个数字的符号可以为正或负(减整数等于加负数)。
2、该问题和矩阵链乘很相似，是典型的动态规划问题
3、举例说明: nums = {1,2,3,4,5}, target=3, 一种可行的方案是+1-2+3-4+5 =3
该方案中数组元素可以分为两组，一组是数字符号为正(P={1,3,5})，另一组数字符号为负(N={2,4})
因此: sum(1,3,5) - sum(2,4) = target
sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)
2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)
2sum(P) = target + sum(nums)
sum(P) = (target + sum(nums)) / 2
由于target和sum(nums)是固定值，因此原始问题转化为求解nums中子集的和等于sum(P)的方案个数问题
4、求解nums中子集合只和为sum(P)的方案个数(nums中所有元素都是非负)
该问题可以通过动态规划算法求解
举例说明：给定集合nums={1,2,3,4,5}, 求解子集，使子集中元素之和等于9 = new_target = sum(P) = (target+sum(nums))/2
定义dp[10]数组, dp[10] = {1,0,0,0,0,0,0,0,0,0}
dp[i]表示子集合元素之和等于当前目标值的方案个数, 当前目标值等于9减去当前元素值
当前元素等于1时，dp[9] = dp[9] + dp[9-1]
dp[8] = dp[8] + dp[8-1]
…
dp[1] = dp[1] + dp[1-1]
当前元素等于2时，dp[9] = dp[9] + dp[9-2]
dp[8] = dp[8] + dp[8-2]
…
dp[2] = dp[2] + dp[2-2]
当前元素等于3时，dp[9] = dp[9] + dp[9-3]
dp[8] = dp[8] + dp[8-3]
…
dp[3] = dp[3] + dp[3-3]
当前元素等于4时，
…
当前元素等于5时，
…
dp[5] = dp[5] + dp[5-5]
最后返回dp[9]即是所求的解
————————————————
版权声明：本文为CSDN博主「JackZhangNJU」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/JackZhang_123/article/details/78793365

*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num:nums){
            sum=sum+num;  //To get the sum
        }
        if(sum<S||(sum+S)%2==1){  
            return 0;
        }
        int w=(sum+S)/2;
        int[] dp=new int[w+1];
        dp[0]=1;
        for(int num:nums){
            for(int j=w;j>=num;j--){
               dp[j]+=dp[j-num];
            }
        }
        return dp[w];
        
    }
}












class Solution {
    //1.53pm-2.01pm
    //2.01pm-2.37pm
    public int findTargetSumWays(int[] nums, int S) {
        int max=1000;
        if(S>max) return 0;
        int[][] dp=new int[nums.length+1][2*max+1];
        for (int[] row : dp) 
            Arrays.fill(row, -1); 
       return dfs(nums, dp, 0, max, S+max);
    }
   int dfs(int[] nums, int[][] dp, int curr, int sum, int target){
       if(curr==nums.length) return sum==target?1:0;
       if(dp[curr][sum]>-1) return dp[curr][sum];
       return dp[curr][sum]=dfs(nums,dp,curr+1,sum+nums[curr],target)+dfs(nums,dp,curr+1,sum-nums[curr],target);
    }
}





//简化版：
public class Solution {
    //1.53pm-2.01pm
     //2.01pm-2.37pm
     int count=0;
     public int findTargetSumWays(int[] nums, int S) {
         dfs(nums,0, S, 0);
        return  count;
     }
    void dfs(int[] nums, int sum, int target, int curr){
         if(curr==nums.length) {
             if(sum==target) count++; 
             return;
         }
         dfs(nums,sum+nums[curr],target, curr+1);
         dfs(nums,sum-nums[curr],target,curr+1);
     }
 }
 
 


 
// Over time limit:
class Solution {
    //1.53pm-2.01pm
    //2.01pm-2.37pm
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
       return  count;
    }
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        if(target==sum && list.size()==nums.length) {
            count++;
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            return;
        }
        if(curr>=nums.length){
            list=new ArrayList<Integer>();
            return;
        }  
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);
        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
    }
}




class Solution {
    //1.53pm-2.01pm
    //2.01pm- 
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
        
        
//         for(List<Integer> tmp:result)
//         {
//             for(int t:tmp){
//                 System.out.print(t+" ");
//             }
//             System.out.println();
//         }
        
       return  count;
    }
    
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        
        if(target==sum && list.size()==nums.length) {
            count++;
            
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            
            return;
        }
        
       
      // System.out.println(curr+" "+sum+" "+target);
        if(curr>=nums.length){
            list=new ArrayList<Integer>();
            return;
        }  
       // System.out.println(target+" "+sum+" "+list.size()+" "+nums.length;)
    
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);

        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
 
    }
    
}




WA:

class Solution {
    //1.53pm-2.01pm
    //2.01pm- 
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        
        dfs(nums, new ArrayList<Integer>(),0, S, 0);
        
        
        for(List<Integer> tmp:result)
        {
            for(int t:tmp){
                System.out.print(t+" ");
            }
            System.out.println();
        }
        
       return  count;
    }
    
   void dfs(int[] nums, List<Integer> list, int sum, int target, int curr){
        
        if(target==sum && list.size()==nums.length) {
            count++;
            
            result.add(new ArrayList<Integer>(list));
            list=new ArrayList<Integer>();
            
            return;
        }
        
       
      // System.out.println(curr+" "+sum+" "+target);
        if(curr>=nums.length || sum>target){
            list=new ArrayList<Integer>();
            return;
        }  
       // System.out.println(target+" "+sum+" "+list.size()+" "+nums.length;)
    
        //chose -
        int value=-nums[curr];
         list.add(value);
        dfs(nums, list,sum+value,target, curr+1);
        list.remove(list.size()-1);

        //chose +
       value=nums[curr];
        list.add(value);
       dfs(nums, list,sum+value,target,curr+1);
       list.remove(list.size()-1);
 
    }
    
}



[1,1,1,1,1]
3


-1 1 1 1 1 
1 -1 1 1 1 
1 1 -1 1 1 
1 1 1 -1 1 









