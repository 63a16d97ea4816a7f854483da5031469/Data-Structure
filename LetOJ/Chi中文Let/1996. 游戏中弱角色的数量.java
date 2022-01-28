
/*
 * 
link: https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/

1996. 游戏中弱角色的数量
难度
中等

73

收藏

分享
切换为英文
接收动态
反馈
你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。

如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。

返回 弱角色 的数量。

 

示例 1：

输入：properties = [[5,5],[6,3],[3,6]]
输出：0
解释：不存在攻击和防御都严格高于其他角色的角色。
示例 2：

输入：properties = [[2,2],[3,3]]
输出：1
解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
示例 3：

输入：properties = [[1,5],[10,4],[4,3]]
输出：1
解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 

提示：

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105



2022-01-28 at 11:56




刚看到想到的思路是什么？：

>> 想到使用暴力破解法，使用HashMap来记录每次找到的对，但是不太好写


>> 优化方法是，每次找到一个弱角色，就将其标记，然后总count++

意识到的边界条件是什么？：
相等情况（就是攻击力或者防御力相等）


考虑到的速度和空间复杂度是多少？：
时间： O(n平方) 
空间： O(n)


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */






class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // 先按攻击力排序（升序 ASC，底部是最大的），然后倒序遍历，记录后面最大的防御力
        // 这里排序要注意一下，如果有相同攻击力的，我们让防御力低的排在后面
        // 这样就可以避免出现 [攻击力相同，防御力不同] 数据的干扰
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        // 反向遍历，只要后面有更大的防御力，当前角色就是弱角色
        int ans = 0, max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < max) {
                ans++;
            } else {
                max = properties[i][1];
            }
        }

        return ans;
    }
}

时间复杂度：
O(nlogn)，主要耗时在排序上。
空间复杂度：
O(logn)，快排递归栈使用的额外空间。

// 作者：tong-zhu
// 链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/solution/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-p-50ng/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // 先按攻击力排序（降序 DESC，底部是最小的,头部是最大的），然后正序遍历，记录后面最大的防御力
        // 这里排序要注意一下，如果有相同攻击力的，我们让防御力高的排在后面
        // 这样就可以避免出现 [攻击力相同，防御力不同] 数据的干扰        
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/solution/you-xi-zhong-ruo-jiao-se-de-shu-liang-by-3d2g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








