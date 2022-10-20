
/*
 * 
link: 

https://leetcode.cn/problems/longest-consecutive-sequence/


Test cases:

[]
[0]
[0,-1]



128. 最长连续序列
中等
1.5K
相关企业
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109


DATE: 2022-October-20
TIME: 18:51:06


刚看到想到的思路是什么？：


意识到的边界条件是什么？：


考虑到的速度和空间复杂度是多少？：




对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



// [0,-1]

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, nums[i]);
        }
        int[] p=new int[max+1];
        for(int tmp:nums){
            p[tmp]++;
        }
        max=1;
        int index=-1;
        int count=0;
        for(int i=0;i<p.length;i++){
            if(p[i]>0){
                if(index==-1){ //如果是第一个刚开始
                    index=i;  //记录当前i
                    count++;
                }else{
                    if(i-index==1){ //如果是连续的序列
                        count++;  
                        index=i; //设置为当前i
                        max=Math.max(max,count);
                    }else{
                        //重新记录开始count
                        count=1;
                        index=-1; //重置为重头开始
                    }
                }
            }
        }
        return max;
    }
}




[9,1,4,7,3,-1,0,5,8,-1,6]

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return 1;

        List<Integer> negitive=new ArrayList<>();
        List<Integer> postive=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                negitive.add(nums[i]);
            }else{
                postive.add(nums[i]);
            }
        }
        int max=getMax(negitive,postive);
        return max;
    }

    public int[] getMax(List<Integer> negitive,List<Integer> postive){
        int n=list.size();
        int isContainsZero=0;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, Math.abs(list.get(i)));
        }
        int[] p=new int[max+1];
        for(int tmp:list){
            tmp=Math.abs(tmp);
            if(tmp==0) isContainsZero=1;
            p[tmp]++;
        }
        max=0;
        int index=-1;
        int count=0;
        for(int i=0;i<p.length;i++){
            if(p[i]>0){
                if(index==-1){ //如果是第一个刚开始
                    index=i;  //记录当前i
                    count++;
                }else{
                    if(i-index==1){ //如果是连续的序列
                        count++;  
                        index=i; //设置为当前i
                    }else{
                        //重新记录开始count
                        count=1;
                        index=-1; //重置为重头开始
                    }
                }
                max=Math.max(max,count);
            }
        }
        
        return new int[]{max,isContainsZero};
    }
}






class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        Set<Integer> set = new HashSet<>(); // 防止重复判断
        Map<Integer, Integer> map = new HashMap<>(); // 只是为了快速判断
        int index = 0;
        for (int num : nums) {
            map.put(num, index);
            index++;
        }

        for (int num : nums) {
            int temp = num;  // 

            if (!set.contains(temp)) { // 如果在子集里面已经判断过了, 就不再进行判断
                int count = 0; // 每次置0
                while (map.containsKey(temp)) {  //如果不连续就跳出了
                    set.add(temp);
                    temp++;  // 每次从num这个数本身开始
                    count++;
                }
                len = Math.max(len, count);
            }
        }
        return len;
    }
}

// 作者：Vigil
// 链接：https://leetcode.cn/problems/longest-consecutive-sequence/solutions/1886148/javajie-fa-by-zejiang-q12y/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

