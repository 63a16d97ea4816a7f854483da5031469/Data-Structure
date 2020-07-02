
/*
 * 
link: 
https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/


378. 有序矩阵中第K小的元素
难度
中等

335

收藏

分享
切换为英文
关注
反馈
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

 

示例：

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
 

提示：
你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。

2020-7-2 at 11:09 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */




//错误思路：

//[1,2] [1,3]

class Solution {
    //10.59pm-11:09
    
    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        if(row==0||col==0) return -1;

        int i=0;
        for(;i<row;i++){
            if(k>(i+1)*col){
                continue;
            }else{
                break;
            }
        }
        // System.out.println(i+" "+(k-i*col-1));
        return matrix[i][k-i*col-1];
    }
}




public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
    for (int[] row : matrix) {
        for (int num : row) {
            if (MaxPQ.size() == k && num > MaxPQ.peek())
                break;
            MaxPQ.add(num);
            if (MaxPQ.size() > k)
                MaxPQ.remove();
        }
    }
    return MaxPQ.remove();
}

// 作者：ustcyyw
// 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378java-er-fen-fa-tu-jie-you-xian-dui-lie-liang-ch/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//直接排序：
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






// 思路非常简单：（难理解）
// 1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
// 2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
// 3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
// 4.若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
// 5.因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right

// 注意：这里的left mid right是数值，不是索引位置。

// 作者：jacksu1024
// 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public int kthSmallest(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    int left = matrix[0][0];
    int right = matrix[row - 1][col - 1];
    while (left < right) {
        // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
        int mid = (left + right) / 2;
        // 找二维矩阵中<=mid的元素总个数
        int count = findNotBiggerThanMid(matrix, mid, row, col);
        if (count < k) {
            // 第k小的数在右半部分，且不包含mid
            left = mid + 1;
        } else {
            // 第k小的数在左半部分，可能包含mid
            right = mid;
        }
    }
    return right;
}

private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
    // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
    int i = row - 1;
    int j = 0;
    int count = 0;
    while (i >= 0 && j < col) {
        if (matrix[i][j] <= mid) {
            // 第j列有i+1个元素<=mid
            count += i + 1;
            j++;
        } else {
            // 第j列目前的数大于mid，需要继续在当前列往上找
            i--;
        }
    }
    return count;
}

作者：jacksu1024
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。