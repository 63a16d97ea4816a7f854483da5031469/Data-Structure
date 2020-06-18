
/*
 * 
https://segmentfault.com/a/1190000014100541


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




public class bucketSort {

    private static int[] buckets;
    private static int[] array;

    public static void main(String[] args) {
        testBucketsSort();
    }
    
    private static void testBucketsSort(){
        int[] tmp_arr = {5,7,3,5,4,8,6,4,1,2};
        int range=10;

        buckets = new int[range];
        array = tmp_arr;

        sort();
        sortOut();//输出打印排序
    }     
    /*排序*/
    public static void sort(){
        if(array!=null && array.length>1){
            for(int i=0;i<array.length;i++){
                buckets[array[i]]++;
            }
        }
    }
    /*排序输出*/
    public static void sortOut(){
        //倒序输出数据
        for (int i=buckets.length-1; i>=0; i--){
            for(int j=0;j<buckets[i];j++){
                System.out.print(i+"\t");
            }            
        }
    }
}

















