/**
 * [803] Bricks Falling When Hit
 * 
 * difficulty: Hard
 * 
 * TestCase Example: [[1,0,0,0],[1,1,1,0]] [[1,0]]
 * 
 * https://leetcode-cn.com/problems/bricks-falling-when-hit/
 * 
 * 
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.
 * 
 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.
 * 
 * Return an array representing the number of bricks that will drop after each erasure in sequence.
 * 
 * 
 * Example 1:
 * Input: 
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation: 
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 * 
 * 
 * Example 2:
 * Input: 
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation: 
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * 
 *  
 * 
 * Note:
 * 
 * 
 * 	The number of rows and columns in the grid will be in the range [1, 200].
 * 	The number of erasures will not exceed the area of the grid.
 * 	It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
 * 	An erasure may refer to a location with no brick - if it does, no bricks drop.
 * 
 * 
 * 
 * 
 * >>>>>>中文描述<<<<<<
 * 
 * 
 * [803] 打砖块
 * 
 * 
 * 我们有一组包含1和0的网格；其中1表示砖块。 当且仅当一块砖直接连接到网格的顶部，或者它至少连接着(4个方向)相邻的砖块之一时，它才不会落下。
 * 
 * 我们会依次消除一些砖块。每当我们消除 (i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。
 * 
 * 返回一个数组表示每次消除操作对应落下的砖块数目。
 * 
 * 示例 1：
 * 输入：
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * 输出: [2]
 * 解释: 
 * 如果我们消除(1, 0)位置的砖块, 在(1, 1) 和(1, 2) 的砖块会落下。所以我们应该返回2。
 * 
 * 示例 2：
 * 输入：
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 当我们消除(1, 0)的砖块时，(1, 1)的砖块已经由于上一步消除而消失了。所以每次消除操作不会造成砖块落下。注意(1, 0)砖块不会记作落下的砖块。
 * 
 * 注意:
 * 
 * 
 * 	网格的行数和列数的范围是[1, 200]。
 * 	消除的数字不会超过网格的区域。
 * 	可以保证每次的消除都不相同，并且位于网格的内部。
 * 	一个消除的位置可能没有砖块，如果这样的话，就不会有砖块落下。
 * 
 */
public class H_803_BricksFallingWhenHit {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
    }
}