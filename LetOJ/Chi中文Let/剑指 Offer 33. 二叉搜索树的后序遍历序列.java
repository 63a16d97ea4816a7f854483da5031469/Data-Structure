
/*
 * 
link: 
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

2020-8-22 at 10:11 am

剑指 Offer 33. 二叉搜索树的后序遍历序列
难度
中等

96

收藏

分享
切换为英文
关注
反馈
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 

提示：

数组长度 <= 1000



后序遍历：

>> 先左子树
>> 再右子树
>> 最后根节点





对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 后序遍历：

// >> 先左子树
// >> 再右子树
// >> 最后根节点
// 输入: [1,3,2,6,5]  true

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

复杂度分析：

时间复杂度 
O(N^2) ： 每次调用 recur(i,j) 减去一个根节点，因此递归占用 O(N) ；最差情况下（即当树退化为链表），每轮递归都需遍历树所有节点，占用 O(N) 。


空间复杂度 O(N) ： 最差情况下（即当树退化为链表），递归深度将达到 N。

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

空间：
O(N) 额外空间。


// 输入: [1,3,2,6,5]  true
class Solution {
    public boolean verifyPostorder(int[] postorder) {
       return helper(postorder,0,postorder.length-1);
    }

    public boolean helper(int[] postorder, int start, int end){
        if(start>=end){
            return true;
        }
        int mid=start;
        int root=postorder[end];
        //找到比root大的那个mid
        while(postorder[mid]<root){
            mid++;
        }
        int tmp=mid;
        while(tmp<end){
            if(postorder[tmp++]<root){
                return false;
            }
        }
        return helper(postorder,start,mid-1) && helper(postorder,mid,end-1);
    }
}








class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null||postorder.length==1) return true;

        return verify(postorder,0,postorder.length-1);
    }

    public boolean verify(int[] postorder, int start, int end){
        if(start>=end||start<0||end<0||start>postorder.length-1||end>postorder.length-1) return true;

        int point=start;
        while(postorder[point]<postorder[end]){
            point++;
        }
    
        int tmp=point;
        while(tmp<=end){
            if(postorder[tmp++]<postorder[end]){
                return false;
            }
        }
        if(tmp==end) return true;
        return verify(postorder,start,point-1) && verify(postorder,point,end-1);
    }
}





单调栈解法：

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}

复杂度分析：

时间复杂度 
O(N) ： 遍历 

空间：
O(N) 额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // 最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pq) {
            result.add(entry.getKey());
        }
        
        int[] arr=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }

        return arr;
    }
}



