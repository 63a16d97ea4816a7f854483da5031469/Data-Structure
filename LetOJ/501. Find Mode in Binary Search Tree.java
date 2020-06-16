
/*
 * 
https://leetcode.com/problems/find-mode-in-binary-search-tree/

501. Find Mode in Binary Search Tree
Easy

845

326

Add to List

Share
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



解题过程
寻找二叉搜索树 BST 的众数，众数就是一组数据中出现次数最多的一个或多个数。
没想到怎么用 BST 的性质，写了个通用的二叉树找众数，遍历放到map中统计，最后再排序输出。
后来看题解总结了一个很重要的思想：
二叉搜索树的中序遍历序列是一个升序序列，这是二叉搜索树的一个重要性质，巧妙利用这一性质可以解决一系列二叉搜索树问题。所以可以把BST看成和有序数组是等价的，一看到BST马上就要想到是有序数组。
逐个比对当前结点(root)值与前驱结点（pre)值。更新当前节点值出现次数(curTimes)及最大出现次数(maxTimes)





 * 
 */





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) if (max < value) max = value; 
        for (Integer key : map.keySet()) if (map.get(key) == max) list.add(key);
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
    
    private void inOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inOrder(root.right, map);
    }
}







public int[] findMode(TreeNode root) {
    if (null == root) {
        return new int[0];
    }
    // 结点值及对应的出现次数map
    Map<Integer, Integer> map = new TreeMap<>();
    preOrderTraverse(root, map);
    // 出现次数与结点值map，出现次数相同的放入list，利用 TreeMap 自动按 key 升序排列的性质，最后一个kv就是结果
    TreeMap<Integer, List<Integer>> countMap = new TreeMap<>();
    map.forEach((k, v) -> {
        List<Integer> list = countMap.getOrDefault(v, new ArrayList<>());
        list.add(k);
        countMap.put(v, list);
    });
    List<Integer> result = countMap.get(countMap.lastKey());
    System.out.println(result);
    return result.stream().mapToInt(i -> i).toArray();
}
private void preOrderTraverse(TreeNode root, Map<Integer, Integer> map) {
    if (null == root) {
        return;
    }
    map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    preOrderTraverse(root.left, map);
    preOrderTraverse(root.right, map);
}






// 线索二叉树
// https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html



/*
解题思路

查找一组（无序的）数中的众数，无非就是遍历数组，统计每个数字的出现频率。那么二叉搜索树可以提供什么信息呢？
二叉搜索树的左右子结点和父结点之间有大小关系的限制，且二叉树的中序遍历是升序的。由此，问题可以转变成在一组升序排列的数中查找众数。

既然数字是升序的，就可以遍历一次完成统计。
借助三个变量，一个记录当前数字，一个记录当前数字的频率，一个记录上一个添加到List的数字的频率。

每访问一个数字，就将这个数字的出现次数加一，如果当前出现次数等于上一个添加到List的数字的出现次数，则在结果List中添加这个数字；
如果当前出现次数大于上一个添加到List的数字的出现次数，则清空结果List再添加这个数字，并把上一个添加到List数字的出现次数更新为当前出现次数。

还需注意两点：
若是首次访问，需要将上一个添加到List的数字的频率设为1；
每遇到一个新数字，则将当前数字的出现次数清零。

作者：tyanyonecancode
链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/marveljian-dan-de-xue-xi-bi-ji-501-by-tyanyonecanc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
//最快解法 100%
class Solution {
    private List<Integer> modes;
    private int cur;
    private int curTimes;
    private int lastTimes;
    public int[] findMode(TreeNode root) {
        modes = new LinkedList<>();
        inOrder(root);
        int[] res = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++)
            res[i] = modes.get(i);
        return res;
    }
    private void inOrder(TreeNode root) {
        if(root == null)    return;
        inOrder(root.left);
        if(lastTimes == 0)
            lastTimes = 1;
        if(root.val != cur)
            curTimes = 0;
        cur = root.val;
        curTimes++;
        if(curTimes == lastTimes)   
            modes.add(cur);
        if(curTimes > lastTimes)
        {
            lastTimes = curTimes;
            modes.clear();
            modes.add(cur);
        }
        inOrder(root.right);
    }
}

// 作者：tyanyonecancode
// 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/marveljian-dan-de-xue-xi-bi-ji-501-by-tyanyonecanc/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。