
/*
 * 
https://leetcode.com/problems/permutation-sequence/


60. Permutation Sequence
Medium

1357

311

Add to List

Share
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

1 June 2020 at 12:32 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


https://www.bilibili.com/video/av81017944?from=search&seid=1979390467047348943

 * 
 */




public String getPermutation(int n, int k) {
    List<Integer> nums = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
        nums.add(i + 1);
    }
    return getAns(nums, n, k);
}
private String getAns(List<Integer> nums, int n, int k) {
    if (n == 1) {
        //把剩下的最后一个数字返回就可以了
        return nums.get(0) + "";
    }
    int perGroupNum = factorial(n - 1); //每组的个数
    int groupNum = (k - 1) / perGroupNum;
    int num = nums.get(groupNum);
    nums.remove(groupNum);
    k = k % perGroupNum; //更新下次的 k 
    k = k == 0 ? perGroupNum : k;
    return num + getAns(nums, n - 1, k);
}
public int factorial(int number) {
    if (number <= 1)
        return 1;
    else
        return number * factorial(number - 1);
}




// 方法一：对数组求全排列，用ArrayList<String> array存放结果，返回array.get(k-1)即可，但是超时。
// import java.util.*;
public class Solution {
    public String getPermutation(int n, int k) {
        if(n<1 || k<0)
            return "";
        ArrayList<String> array=new ArrayList();
        int[] nums=new int[n];
        for(int i=0;i<nums.length;i++)
            {
            nums[i]=i+1;
        }
        perm(nums,0,array);
        return array.get(k-1);//array中的k-1索引存放第k个序列！！
    }
    public void perm(int[] nums,int index, ArrayList<String> array)
        {
            if(index == nums.length)
            {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<nums.length;i++)
                {
                    sb.append(nums[i]);
                }
                array.add(sb.toString());
                return;
            }
            for(int i=index;i<nums.length;i++)
                {
                swap(nums,i,index);
                perm(nums,index+1,array);
                swap(nums,i,index);
            }
    }
    
    public void swap(int[] nums,int i,int index)
        {
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }
}








public class Solution {
    // https://www.jianshu.com/p/db90675cb82b
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        int[] array = new int[n+1];
        int sum = 1;
        array[0] = 1;

        // array[] = [1, 1, 2, 6, 24, ... , n!]
        for (int i=1; i<=n; i++){
            sum *= i;
            array[i] = sum;
        }

        // nums[] = [1, 2, 3, ... n]
        List<Integer> nums = new LinkedList<>();
        for (int i=0; i<n; i++){
            nums.add(i+1);
        }
        
        k--;
        for (int i=1; i<=n; i++){
            int index = k / array[n-i];
            sb.append("" + nums.get(index));
            nums.remove(index);
            k = k % array[n-i];
        }
        return sb.toString();
    }
}





class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList<>();
        int[] factorial=new int[n];
        factorial[0]=1;
        list.add(1);
        for(int i=1;i<n;i++){
            factorial[i]=(i+1)*factorial[i-1];
            list.add(i+1);
        }
        StringBuilder sb=new StringBuilder();
        while(list.size()>1){
            int index=k/factorial[list.size()-2];
            int mod=k%factorial[list.size()-2];
            k=k%factorial[list.size()-2];
            int tempIndex=(mod==0)?index-1:index;
            sb.append(list.get(tempIndex));
            list.remove(tempIndex);
            if(k==0){
                break;
            }
        }
        for(int t=list.size()-1;t>=0;t--){
            sb.append(list.get(t));
        }
        return sb.toString();
    }
}



class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / getFactorial(n - i);
            System.out.println(index);
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * getFactorial(n - i);
        }
        
        return sb.toString();
        
    }
    public int getFactorial(int n) {
        int x = 1;
        for (int i = 1; i <= n; i++) {
            x = x * i;
        }
        return x;
    }
}





class Solution {
    public String getPermutation(int n, int k) {
      int[] factorials = new int[n];
      List<Integer> nums = new ArrayList() {{add(1);}};
  
      factorials[0] = 1;
      for(int i = 1; i < n; ++i) {
        // generate factorial system bases 0!, 1!, ..., (n - 1)!
        factorials[i] = factorials[i - 1] * i;
        // generate nums 1, 2, ..., n
        nums.add(i + 1);
      }
  
      // fit k in the interval 0 ... (n! - 1)
      --k;
  
      // compute factorial representation of k
      StringBuilder sb = new StringBuilder();
      for (int i = n - 1; i > -1; --i) {
        int idx = k / factorials[i];
        k -= idx * factorials[i];
  
        sb.append(nums.get(idx));
        nums.remove(idx);
      }
      return sb.toString();
    }
  }