




比较好的学习算法的博客：

https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.06.html





https://blog.csdn.net/u013132035/article/details/80639439

HashSet:
http://c.biancheng.net/view/1064.html



	1. 导入必要包，常用包导入  import java.util.*;
	2. 是否考虑边界条件
	3. 主要方法描述：通过数学计算 new_arr[index]= original_arr[(index+K-1)%Array_length];
	4. 易错点: 
	（1）不能在原arr上直接操作，会出现错误的结果
	（2）对于输入的变量，要拷贝后使用，否则会影响后面逻辑。


import java.util.*;

		String --->  str.length();  
		Array---> arr.length; 
		List--->int len=list.size();
			
		String.valueOf(char[] ch);
	

			import java.util.Arrays;
			Arrays.sort(array[])  //对数组进行快排

		System.out.print(Arrays.toString(array));//输出快排后的数组  ---> [1,2,7,9,11]
			
			Collections.sort(List<xxxx>);
			
			Collections.reverse(list);
			
			//static int  binarySearch(List list, Object key) 使用二分查找法查找指定元素在指定列表的索引位置 
			int index = Collections.binarySearch(list, 4);
			
			
		//static void swap(List list, int i, int j) :将指定列表中的两个索引进行位置互换
		Collections.swap(list, 0, 1);



			int[] int_n=new int[10];
			// clone the array
			int_n.clone(xxx[]);
			
			
		 
		 // copying array org to copy 
		Following is the declaration for java.util.Arrays.copyOf() method
		 copyOf(int[] original, int newLength) 
        int[] copy = Arrays.copyOf(org, 5); 


输入：

Scanner input = new Scanner(System.in);
int i = input.nextInt()


import java.util.Scanner;


public static void main(String args[]) {
        int a, b;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(summation(a, b));


		System.out.println("请输入你的名字：");
		String name = scanner.next();
		
    }



public boolean hasNextInt()

public boolean hasNextFloat()



JAVA一些语法整理：

>>>>>>>>>>>>Queue:  先进先出 FIFO (First In First Out)

import java.util.Queue;

Queue<String> queue = new LinkedList<String>();
Queue<Integer> queue = new LinkedList<Integer>();

Queue<TreeNode> queue = new LinkedList<TreeNode>();

	queue.offer("a");  //  添加一个元素并返回true 
	queue.poll();  // get and pop the first element
	queue.peek();  // 返回队列头部的元素    


>>>>>>>>>>>>Stack: 先进后出 FILO(First In Last Out)

import java.util.Stack;

Stack<TreeNode> stack = new Stack<TreeNode>();

Stack<Integer> stack = new Stack<Integer>();

	stack.push(root);  添加元素
	stack.pop();  //弹出该元素
	stack.peek(); // 查看最后一个元素，但不删除
	stack.empty(); // 返回bollean


>>>>>>>>>>>>LinkedList:

import java.util.LinkedList;

List<String> res = new LinkedList<>();
res.toArray(new String[0]);  // 转array
res.add("添加");
res.remove(0); // 按位置删除

E remove()；移除链表中第一个元素；
boolean remove(Object o)：移除链表中指定的元素；
E remove(int index)：移除链表中指定位置的元素； 
E removeFirst()：移除链表中第一个元素，与remove类似；  						TreeSet 是  poolFirst()
E removeLast()：移除链表中最后一个元素；										TreeSet 是  poolLast()
boolean removeFirstOccurrence(Object o)：移除链表中第一次出现所在位置的元素；
boolean removeLastOccurrence(Object o)：移除链表中最后一次出现所在位置的元素；



		LinkedList<Integer> list=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		 
		 可以被collection 去排序：
		Collections.sort(list);



原文链接：https://blog.csdn.net/sinat_36246371/article/details/53709625

	String removed_first_element=linkedList.removeFirst();
	System.out.println("removeFirst: " + linkedList+" "+removed_first_element);

	String removed_last_element=linkedList.removeLast();
	System.out.println("removeLast:" + linkedList+" "+removed_last_element);

java.util.NoSuchElementException



ArrayList:

     List<String> list=new ArrayList<String>();
     list.add("Hello");
 
     ArrayList<Integer> list = new ArrayList<Integer>();




Collections:

 List<Integer> list = new LinkedList<Integer>(); 

 		int max=Collections.max(list);
 		int min = Collections.min(list); 

     System.out.println("Max value is: "
                               + Collections.max(list)); 


Arrays:

打印数组
int[] intArray = { 1, 2, 3, 4, 5 };
String intArrayString = Arrays.toString(intArray);

检查数组是否包含某个值
String[] stringArray = { "a", "b", "c", "d", "e" };
boolean b = Arrays.asList(stringArray).contains("a");


将ArrayList转换为数组
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
String[] stringArr = new String[arrayList.size()];
arrayList.toArray(stringArr);
for (String s : stringArr)
	System.out.println(s);

数组转List ---asList
    public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);
    }
这个被“普遍”称为数组转List的方法，可能是Arrays内大家使用频率最高的一个静态方法了。使用起来也很简单,下面就很容易的实现了将数组转为List。
        String[] b = new String[]{"5", "6", "7", "8"};
        List<String> datas = Arrays.asList(b);

将数组转换为Set
String[] stringArray = { "a", "b", "c", "d", "e" };
Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
//[d, e, b, c, a]
System.out.println(set);


二分查找
支持二分查找， Binaray Search: (进来的arr必须已经排过序了（升序），否则结果是不确定的, 只有找到元素，才会返回>0的index, 找不到返回 <0的负数)
  public static int binarySearch(int[] a, int key) {
        return binarySearch0(a, 0, a.length, key);
    }



HashSet类:

如果向 Set 集合中添加两个相同的元素，则后添加的会覆盖前面添加的元素，即在 Set 集合中不会出现相同的元素。

HashSet hs = new HashSet();    // 调用无参的构造函数创建HashSet对象
HashSet<String> hss = new HashSet<String>();    // 创建泛型的 HashSet 集合对象

public static void main(String[] args) {

    HashSet<String> bookSet = new HashSet<String>(); // 创建一个空的 Set 集合
    String book1 = new String("学习set");
    bookSet.add(book1); // 将 book1 存储到 Set 集合中


    Iterator<String> it = bookSet.iterator();

    while (it.hasNext()) {
        System.out.println(it.next()+""); // 输出 Set 集合中的元素
    }
}


TreeSet 类:

TreeSet 类同时实现了 Set 接口和 SortedSet 接口。SortedSet 接口是 Set 接口的子接口，可以实现对集合进行自然排序，因此使用 TreeSet 类实现的 Set 接口默认情况下是自然排序的，这里的自然排序指的是升序排序。

E first()	返回此集合中的第一个元素。其中，E 表示集合中元素的数据类型
E last()	返回此集合中的最后一个元素
E poolFirst()	获取并移除此集合中的第一个元素                        LinkedList 是 removeFirst()
E poolLast()	获取并移除此集合中的最后一个元素						LinkedList 是 removeLast()


SortedSet<E> subSet(E fromElement,E toElement)	返回一个新的集合，新集合包含原集合中 fromElement 对象与 toElement
对象之间的所有对象。包含 fromElement 对象，不包含 toElement 对象
SortedSet<E> headSet<E toElement〉	返回一个新的集合，新集合包含原集合中 toElement 对象之前的所有对象。
不包含 toElement 对象
SortedSet<E> tailSet(E fromElement)	返回一个新的集合，新集合包含原集合中 fromElement 对象之后的所有对
象。包含 fromElement 对象


 public static void main(String[] args) {

        TreeSet<Double> scores = new TreeSet<Double>(); // 创建 TreeSet 集合

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("第" + (i + 1) + "个学生成绩：");
            double score = input.nextDouble();
            // 将学生成绩转换为Double类型，添加到TreeSet集合中
            scores.add(Double.valueOf(score));
        }

        Iterator<Double> it = scores.iterator(); // 创建 Iterator 对象

        System.out.println("学生成绩从低到高的排序为：");

        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }

        System.out.println("\n请输入要查询的成绩：");

        double searchScore = input.nextDouble();
        if (scores.contains(searchScore)) {
            System.out.println("成绩为： " + searchScore + " 的学生存在！");
        } else {
            System.out.println("成绩为： " + searchScore + " 的学生不存在！");
        }
        // 查询不及格的学生成绩
        SortedSet<Double> score1 = scores.headSet(60.0);

        System.out.println("\n不及格的成绩有：");
        for (int i = 0; i < score1.toArray().length; i++) {
            System.out.print(score1.toArray()[i] + "\t");
        }
        // 查询90分以上的学生成绩
        SortedSet<Double> score2 = scores.tailSet(90.0);
        System.out.println("\n90 分以上的成绩有：");
        for (int i = 0; i < score2.toArray().length; i++) {
            System.out.print(score2.toArray()[i] + "\t");
        }
    }













递归回退：

	int count = 1;
	ListNode node;
	public ListNode FindKthToTail(ListNode head,int k) {
	    if(head != null){
	        this.FindKthToTail(head.next,k);
	        if(count++ == k){
	            node = head;
	        }
	    }
	    return node;
	}




使用LinkedList来对 首 和 尾 进行操作：

public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);

		int[] resultArr = new int[N];

		for (int i = 0; i < N; i++) {

			if (i % 2 == 0) {
				resultArr[i] = list.removeFirst();
			} else {
				resultArr[i] = list.removeLast();
			}
		}

		System.out.println(Arrays.toString(resultArr));
}





    public static void main(String args[]) {
    	
    	//rotate K times, N is the arr length
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < N; i++) {
        	list.add(sc.nextInt());
        }
        if(K%N==0) {
        	//No shifting.
        	return;
        }
        //remove > arr length shifting
        K=K%N;
        
        int[] result_arr = new int[N];
        int index=0;
        
        int tmp_k=K;
        while(tmp_k>0) {
        	result_arr[tmp_k-1]=list.removeLast();
        	tmp_k--;
        	index++;
        }
        for(int i=0;i<N-K;i++) {
        	result_arr[index++]=list.removeFirst();
        }
        System.out.println(Arrays.toString(result_arr));
    }



