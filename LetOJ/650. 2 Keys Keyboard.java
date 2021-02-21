
/*
 * 
https://leetcode.com/problems/2-keys-keyboard/

650. 2 Keys Keyboard
Medium

1625

116

Add to List

Share
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
 

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
 

Note:

The n will be in the range [1, 1000].

21 Feb 2021 at 19:27


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


class Solution {
    int n;
    int[][] memo;//memo[i][j],i是当前'A'的个数,j是当前剪贴板copy中的容量
    public int minSteps(int n) {
        this.n=n;
        memo=new int[n+1][n+1];
        return recursion(1,0,0);
    }

    //count:当前积累的'A'个数
    //copy:剪贴板上'A'的个数,初始为0
    //copyRecord:累计copy的次数,总不能一直copy的
    private int recursion(int count,int copy,int copyRecord){
        if(count==n||copyRecord==n){//有一个分支是一直在copy的，没有paste不行
            return 0;
        }
        if(memo[count][copy]>0){
            return memo[count][copy];
        }
        int ans=n+1;//打印3个A,步骤最多也是copy一次，打印n=3次，这里随意了，比 n 大就行
        if(copy==0){
            //没有就先copyAll,copyAll算一步+1
            ans=Math.min(ans,1+recursion(count,count,copyRecord+1));

        }else if(count+copy<=n){//如果粘贴paste之后'A'的总数超过n,是不允许的

            //剪贴板有内容的时候可以选择copyAll,或者paste
            ans=Math.min(ans,Math.min(1+recursion(count+copy,copy,copyRecord),1+recursion(count,count,copyRecord+1)));
        }
        memo[count][copy]=ans;
        return ans;
    }
}


作者：badthink
链接：https://leetcode-cn.com/problems/2-keys-keyboard/solution/ji-yi-hua-sou-suo-by-badthink-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。















