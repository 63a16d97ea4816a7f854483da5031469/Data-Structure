

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists)
        {
            int len=lists.length;
            
            if(lists==null||len==0)
                return null;
            if(len==1)
                return lists[0];
            
            while(len>1)//基于“二分”思想进行链表的两两组合
            {
                int mid=(len+1)/2;//二分
                for(int i=0;i<len/2;i++)
                {
                    lists[i]=mergeTwoLists(lists[i],lists[i+mid]);
                }
                len=mid;
            }
            return lists[0];
        }
        //有序链表的组合，L1和L2为头结点，归并排序的核心思想
        public ListNode mergeTwoLists(ListNode L1,ListNode L2)
        {
            if(L1==null)return L2;
            if(L2==null)return L1;
            
            ListNode head=new ListNode(0);//保存结果的链表，头结点初始化
            ListNode phead=head;
            
            while(L1!=null&&L2!=null)//两个链表归并排序
            {
                if(L1.val <=L2.val)
                {
                    phead.next=L1;//接入结果链表
                    phead=phead.next;//移动指针
                    L1=L1.next;
                }
                else
                {
                    phead.next=L2;
                    phead=phead.next;
                    L2=L2.next;
                }
            }
            if(L1!=null)
                phead.next=L1;
            else
                phead.next=L2;
            
            return head.next;//初始化的第一个节点不属于结果
        }
    }
    // ————————————————
    // 版权声明：本文为CSDN博主「Jin_Kwok」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    // 原文链接：https://blog.csdn.net/Jin_Kwok/article/details/51582176



    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode preHead=new ListNode(-1);
        
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
               return  a.val-b.val;
            }
        });
        
        for(ListNode head:lists){
            while(head!=null){
                pq.add(head);
                head=head.next;
            }
        }
        
        ListNode curr=preHead;
        
        while(!pq.isEmpty()){
               curr.next=new ListNode(pq.poll().val);
               curr=curr.next;
        }
        
        return preHead.next;
    }
}














import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 在链头放最久未被使用的元素，链尾放刚刚添加或访问的元素
 */




    
   




class FirstUnique {
    
    class Node {
        int num, count;
        Node pre, next;
        Node(int num, int count) {
            this.num=num;
            this.count=count;
            pre = this;
            next = this;
        }
    }
    
    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    LinkedList<Node> list=new LinkedList<Node>();

    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    private Map<Integer, Node> map;//保存key-Node对，Node是双向链表节点
    
    public FirstUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            Node currNode=map.get(nums[i]);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(nums[i],currCount+1);
                   list.add(node);
                   map.put(nums[i],node);
            }else{
                Node old=map.get(nums[i]);
                list.remove(old);
            }
        }
    }
    
    public int showFirstUnique() {
        if(list.size()!=0){
           return list.getFirst().num;
        }
        return -1;
    }
    
    public void add(int value) {
            Node currNode=map.get(value);
            int currCount=currNode==null?0:currNode.count;
            if(currCount==0){
                   Node node=new Node(value,currCount+1);
                   list.add(node);
                   map.put(value,node);
            }else{
                Node old=map.get(value);
                if(list.contains(old)){
                    list.remove(old);
                }
            }
    }


     /**
     * 在链表尾部添加新节点  @param node 新节点
     */
    private void add(Node node) {
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }
    /**
     * 从双向链表中删除该节点  @param node 要删除的节点
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}

