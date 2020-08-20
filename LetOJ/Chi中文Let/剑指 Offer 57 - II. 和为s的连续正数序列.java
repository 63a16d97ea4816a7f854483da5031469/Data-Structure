
/*
 * 
link: 
https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/

2020-8-20 at 2:48 pm

剑指 Offer 57 - II. 和为s的连续正数序列
难度
简单

140

收藏

分享
切换为英文
关注
反馈
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {

    private int capacity = 10;

    private int[][] ans = new int[capacity][];

    public int[][] findContinuousSequence(int target) {

        int small = 1, big = 2;
        int sum;

        int t = 0, p = 0;
        
        // 其实取到 target / 2 就可以了
        while (small < big && small <= target / 2) {
            sum = ((small + big) * (big - small + 1)) / 2;
            if (sum < target) {
                big++;
            }
            else if (sum > target) {
                small++;
            }
            else {
                
                int[] subAns = new int[big - small + 1];

                for (int i = small; i <= big; i++) {
                    subAns[t++] = i;
                }

                t = 0;
                ans[p++] = subAns;

                if (p == capacity) {
                    enlargeCapacity();
                }

                small++;
            }
        }

        changeCapacity(p);

        return ans;
    }

    /**
     * 扩容
     */
    private void enlargeCapacity() {
        capacity += 10;
        ans = Arrays.copyOf(ans, capacity);
    }

    /**
     * 删除数组多余空间
     */
    private void changeCapacity(int retCapacity) {
        ans = Arrays.copyOf(ans, retCapacity);
    }
}

// 作者：ruo-xu-5
// 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/kuai-man-zhi-zhen-by-ruo-xu-5/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
















class Solution {
    public int[][] findContinuousSequence(int target) {
        
        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);       
    }
}

// 作者：VaporMax
// 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/java-shuang-100-by-vapormax/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





class Solution {
    //2.21pm-
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public int[][] findContinuousSequence(int target) {
        int[] arr=new int[target];
        for(int i=0;i<target;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> list=new ArrayList<Integer>();
            int first=arr[i];
            int sum=first;
            list.add(first);

            for(int j=i+1;j<arr.length;j++){
                if(sum==target){
                    ans.add(new ArrayList<Integer>(list));
                    break;
                }
                if(sum>target){
                    break;
                }
                sum+=arr[j];
                list.add(arr[j]);
            }
        }
    int[] result=new int[ans.size()];
    
    }
}

