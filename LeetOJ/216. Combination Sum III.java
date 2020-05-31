
/*
 * 
https://leetcode.com/problems/reverse-linked-list-ii/


Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
     List<List<Integer>> result = new ArrayList<List<Integer>>();
     List<Integer> curr = new ArrayList<Integer>();
     helper(result, curr, k, 1, n);
     return result;
 }
     public void helper(List<List<Integer>> result, List<Integer> curr, int k, int start, int sum){
         if(sum<0){
             return;
         }
 
         if(sum==0 && curr.size()==k){
             result.add(new ArrayList<Integer>(curr));
             return;
         }
 
         for(int i=start; i<=9; i++){
             curr.add(i);
             helper(result, curr, k, i+1, sum-i);
             curr.remove(curr.size()-1);
         }
     }
 }









class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return ret;
    }
    
    private void dfs(int k, int n, int index)
    {
        if (k == 0 || n <= 0)
        {
            if (k == 0 && n == 0)
                ret.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= 9; ++i)
        {
            temp.add(i);
            dfs(k - 1, n - i, i + 1);
            temp.pollLast();
        }
    }
}












class Solution {
    List<List<Integer>> res = new ArrayList<>();
public List<List<Integer>> combinationSum3(int k, int n) {
    helper( 1, n, new ArrayList<Integer>(), k);
    return res;
}

private void helper( int start, int target, List<Integer> each, int len) {
     if (each.size() >= len) {
            return;
        }
        for (int i = start; i < 10; i++) {
            List<Integer> temp = new ArrayList<>(each);
            if (i == target) {
                if (each.size() == len - 1) {
                    temp.add(i);
                    res.add(temp);
                }
                break;
            } else if (i < target) {
                temp.add(i);
                helper(i+1, target-i, new ArrayList<>(temp),len);
            } else {break;}
        }
    return;
}
}


