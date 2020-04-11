
/*
 * 
https://leetcode.com/problems/unique-binary-search-trees/


96. Unique Binary Search Trees
Medium

2713

103

Add to List

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


12 April 2020 at 12.27 pm
 * 
 */

class Solution {
    
    //     二叉查找树的性质是左子节点一定小于父节点，右子节点一定大于父节点。
    
    // 我们思考一下可以发现，要形成不同的二叉树，最基本的分类是1~n各自都做一次根节点。在它们作为根节点时，又分别还有多少种不同的组合方式呢？由于这是一个二叉查找树，那么根节点的左边一定都是小于他的数，右边一定都是大于它的数，所以1~n就会被分成两部分去放置，这时候由可以分别把左子节点、右子节点分别看成要安放一部分数字的根节点，又变成了一样的规律。
    
    // 所以假设以i为根节点，可能的组合情况为F（i，n），而G（n）为输入n后的结果。则
    
    // F（i，n） = G（i-1）*G（n-i）
    
    // 也就是左子节点以下的可能数量乘以右子节点以下的可能数量。
    
    // 而因为1~n都可能作为根节点，所以最终的值是它们的和，也就是
    
    // G（n） = F（1，n） + Ｆ（２，ｎ）　＋　……　＋Ｆ（ｎ，ｎ）
    
    // 换算一下就是
    
    // Ｇ（ｎ）　＝　Ｇ（０） * G（n-1） + G（1） * G（n-2） ＋ …… ＋ G（n-1） *Ｇ（０）
    
    // 其中我们可以直接看出　Ｇ（０）　＝　Ｇ（１）　＝　１。这个作为初始值来递归计算就可以了，要知道G（n），我们必须把前面的数都计算出来。
    // ————————————————
    // 版权声明：本文为CSDN博主「Cloudox_」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    // 原文链接：https://blog.csdn.net/Cloudox_/article/details/70236770
        
        public int numTrees(int n) {
            int[] arr=new int[n+1];
            arr[0]=1;
            arr[1]=1;
            
            //假使i是root，把数分成 1 to i 和 n-i两组
            for(int i=2;i<=n;i++){
                for(int j=1;j<=i;j++){
                    arr[i]+=arr[j-1]*arr[i-j];
                }
            }
            return arr[n];
        }
    }









