
/*
 * 

https://leetcode.com/problems/ways-to-make-a-fair-array/

1664. Ways to Make a Fair Array
Medium

1010

28

Add to List

Share
You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.

For example, if nums = [6,1,7,4,1]:

Choosing to remove index 1 results in nums = [6,7,4,1].
Choosing to remove index 2 results in nums = [6,1,4,1].
Choosing to remove index 4 results in nums = [6,1,7,4].
An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the number of indices that you could choose such that after the removal, nums is fair.

 

Example 1:

Input: nums = [2,1,6,4]
Output: 1
Explanation:
Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
There is 1 index that you can remove to make nums fair.
Example 2:

Input: nums = [1,1,1]
Output: 3
Explanation: You can remove any index and the remaining array is fair.
Example 3:

Input: nums = [1,2,3]
Output: 0
Explanation: You cannot make a fair array after removing any index.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// Time Limit Exceeded
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1...

class Solution {
    public int waysToMakeFair(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int tmp:nums){
            l.add(tmp);
        }
        int count=0;
        for(int i=0;i<l.size();i++){
            if(isOk(new ArrayList<Integer>(l),i)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isOk(List<Integer> l, int k){
        l.remove(k);//remove the k
        int odd=0;
        int even=0;
        for(int i=0;i<l.size();i++){
            if(i%2==0){
                even+=l.get(i);
            }else{
                odd+=l.get(i);
            }
        }
        return odd==even;
    }
}


Time Limit Exceeded
Details 
Last executed input
[4855,2798,9960,850,6293,3357,2294,8418,3418,4692,2758,1294,5766,3636,1539,6344,4247,6514,1558,72,5977,7935,5111,7437,8948,8487,1362,3740,1001,3409,1031,6006,2194,1541,8189,5341,241,3709,151,1110,4865,3824,1776,2679,8298,5005,1695,9337,4089,9874,282,8983,2350,1725,1162,8023,2445,6890,915,4217,7544,5058,6015,3372,64,4987,1133,2200,8463,2839,1429,6855,3500,769,4789,8937,1768,9778,9126,2985,2827,6964,7969,5584,435,8264,4625,9313,2852,6912,627,5208,5941,2918,5961,3655,9143,8277,8364,3012,6370,1533,3460,6703,8057

class Solution {
    HashMap<Integer, int[]> map=new HashMap<>();
    public int waysToMakeFair(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int tmp:nums){
            l.add(tmp);
        }
        
        int odd=0,even=0;
        for(int i=0;i<l.size();i++){
                if(i%2==0){
                    even+=l.get(i);
                }else{
                    odd+=l.get(i);
                }
            map.put(i,new int[]{odd,even});
        }
        
        int count=0;
        for(int i=0;i<l.size();i++){
            if(isOk(new ArrayList<Integer>(l),i)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isOk(List<Integer> l, int k){
        l.remove(k);//remove the k
        int odd=0;
        int even=0;
        
        if(map.get(k-1)!=null){
            
            odd=map.get(k-1)[0];
            even=map.get(k-1)[1];
            
            // System.out.println(odd+" "+even);
            
        for(int i=k;i<l.size();i++){
            if(i%2==0){
                even+=l.get(i);
            }else{
                odd+=l.get(i);
            }
        }
        
        }else{
            for(int i=0;i<l.size();i++){
                if(i%2==0){
                    even+=l.get(i);
                }else{
                    odd+=l.get(i);
                }
            }
        }
        return odd==even;
    }
}



class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        //删除某一个元素后，这个元素前面的元素下标奇偶性保持不变，这个元素后面的元素奇偶性翻转
        int total=0;
        int n=nums.size();
        int evensum=0; int oddsum=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
            if(i%2) oddsum+=nums[i];
            else evensum+=nums[i];
        }
        int ans=0;
        int even=0; int odd=0;
        for(int i=0;i<n;i++){
            //判断依次删除下标为i的数
            //前面的even和odd不会变
            //后面奇偶性反转
            if(i%2==1){
                //删除奇数索引
                if(odd+(evensum-even)==even+(oddsum-odd-nums[i])) ans++;
            }
            else{
                //删除偶数索引
                if(odd+(evensum-even-nums[i])==even+(oddsum-odd)) ans++;
            }

            if(i%2==1) odd+=nums[i];
            else even+=nums[i];
        }
        return ans;
    }
};

作者：Black Ghost
链接：https://leetcode.cn/problems/ways-to-make-a-fair-array/solutions/1715328/mo-ni-by-zhen-tian-xia-5j0z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 差分数组
上图所示, 只考虑 奇数个长度的数组的时候，可以基于差分数组，列出递推公示
if (i%2 == 0) {
    dp[i] = dp[i-1]-diff[i];
} else {
    dp[i] = dp[i-1]+diff[i];
}


class Solution {
    public int waysToMakeFair(int[] nums) {
        //差分数组，奇数个
        int n = nums.length;
        int temp = 0;
        int m = n;
        //如果是偶数个数组, 那么如果和跟最后一个相等就行了
        if (n%2 == 0) {
            temp = nums[n-1];
            //去掉最后一个数
            m--;
        }
        int[] diff = new int[m];
        diff[0] = nums[0];
        //sum1就是去掉第一个元素的时候
        int sum1 = 0;
        for(int i=1;i<m;i++) {
            diff[i] = nums[i] - nums[i-1];
            if (i%2 == 0) {
                sum1+=diff[i];
            }
        }
        int[] dp = new int[m];
        dp[0] = sum1;
        int ans = sum1 == temp?1:0;
        for(int i=1; i<m; i++) {
            if (i%2 == 0) {
                dp[i] = dp[i-1]-diff[i];
            } else {
                dp[i] = dp[i-1]+diff[i];
            }
            ans+=dp[i] == temp?1:0;
        }
        return ans;
    }
}

作者：clevertension
链接：https://leetcode.cn/problems/ways-to-make-a-fair-array/solutions/1719215/by-clevertension-k1k9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


