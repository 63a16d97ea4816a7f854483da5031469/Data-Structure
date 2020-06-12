
/*
 * 
https://leetcode.com/problems/linked-list-random-node/


382. Linked List Random Node
Medium

536

155

Add to List

Share
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

6 June 2020 at 7:51 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

// Follow up:
// What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
// 蓄水池抽样
// https://www.hrwhisper.me/leetcode-random-sample-from-array-or-linked-list/
// https://www.jianshu.com/p/7a9ea6ece2af

// 蓄水池抽样算法的核心如下：


// int[] reservoir = new int[m];

// // init
// for (int i = 0; i < reservoir.length; i++)
// {
//     reservoir[i] = dataStream[i];
// }

// for (int i = m; i < dataStream.length; i++)
// {
//     // 随机获得一个[0, i]内的随机整数
//     int d = rand.nextInt(i + 1);
//     // 如果随机整数落在[0, m-1]范围内，则替换蓄水池中的元素
//     if (d < m)
//     {
//         reservoir[d] = dataStream[i];
//     }
// }

// 作者：邱simple
// 链接：https://www.jianshu.com/p/7a9ea6ece2af
// 来源：简书
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//蓄水池抽样：
class Solution {

    private ListNode head;
    private Random rnd;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.rnd = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head;
        int reservoir = head.val;
        int j = 1;
        while (curr != null) {
            //double prob = 1.0 / j; // prob to replace reservoir with curr.val
             //在这个题目中，蓄水池m就是1个元素reservoir，如果抽到的数是0，其实就是要替换的时候：
            if (rnd.nextInt(j) == 0) {
                reservoir = curr.val;
            }
            j++;
            curr = curr.next;
        }
        return reservoir;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int result = head.val;
        int num = 1;
        for(ListNode tmp=head.next;tmp!=null;tmp=tmp.next){
            num++;
            double pp = random.nextFloat();
            //选取的概率为(1/2)* （2/3）*（3/4）* ……….. (n-1) / n = 1/n   （选取第2个数在长度为2的时候为1/2，其他的都不要选)
            if(pp>(1.0/num)){continue;}
            result = tmp.val;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */



import java.util.Random;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode head;
    private Random random;
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ans = 0;
		ListNode p = head;
		for (int cnt = 1; p != null; cnt++, p = p.next) 
            if (random.nextInt(cnt) == 0) {
                ans = p.val;
            }
		return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;
    int length = 0;
    Random rand = new Random(); 
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        //calculate and store length
        this.head =head;
        int l=0;
        ListNode node = head;
        while (node!=null){
            l++;
            node = node.next;
        }
        this.length=l;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int r = rand.nextInt(this.length);
        int count = 0;
        int val=0;
        ListNode node = this.head;
        while (count<r && node!=null){
            //val = node.val;
            node = node.next;
            count++;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */







