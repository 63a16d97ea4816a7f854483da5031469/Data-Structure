
/*
 * 
link: https://leetcode-cn.com/problems/combination-sum/

39. 组合总和
难度
中等

1723

收藏

分享
切换为英文
接收动态
反馈
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

 

示例 1：

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例 2：

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：

输入: candidates = [2], target = 1
输出: []
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都 互不相同
1 <= target <= 500


2022-01-26 at 0:01
 

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







使用这个解法，总是漏解，或者多解：

class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    int gtarget=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        gtarget=target;
        dfs(candidates,target,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] candidates, int sum, List<Integer> list){
        // handle the edge case
        if(sum<0) return;
        // define the end condition
        if(sum==0){
             int inSum=0;
             for(int tmp:list){
                 inSum+=tmp;
             }
             if(inSum==gtarget){
                Collections.sort(list);
                if(!result.contains(list))
                result.add(new ArrayList<Integer>(list));
             }
     
            return;
        }

        for(int i=0;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,sum-candidates[i],list);
            if(list.size()>=1){
                list.remove(list.size()-1);
            }
        }
    }
}











