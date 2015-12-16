#ArrayDeque

deque 即双端队列。
（deque，全名double-ended queue）是一种具有队列和栈的性质的数据结构。双端队列中的元素可以从两端弹出，其限定插入和删除操作在表的两端进行。
双端队列是限定插入和删除操作在表的两端进行的线性表。这两端分别称做端点1和端点2。也可像栈一样，可以用一个铁道转轨网络来比喻双端队列。在实际使用中，还可以有输出受限的双端队列（即一个端点允许插入和删除，另一个端点只允许插入的双端队列）和输入受限的双端队列（即一个端点允许插入和删除，另一个端点只允许删除的双端队列）。而如果限定双端队列从某个端点插入的元素只能从该端点删除，则该双端队列就蜕变为两个栈底相邻的栈了。


http://www.yiibai.com/java/util/java_util_arraydeque.html

	java.util.ArrayDeque 类提供了可调整大小的阵列，并实现了Deque接口。以下是关于阵列双端队列的要点：
	
	数组双端队列没有容量限制，使他们增长为必要支持使用。
	
	它们不是线程安全的;如果没有外部同步。
	
	不支持多线程并发访问。
	
	null元素被禁止使用在数组deques。
	
	它们要比堆栈Stack和LinkedList快。
	
	此类及其迭代器实现Collection和Iteratorinterfaces方法可选。
	
	类的声明
	以下是java.util.ArrayDeque类的声明：
	
	public class ArrayDeque<E>
	   extends AbstractCollection<E>
	      implements Deque<E>, Cloneable, Serializable
	这里<E>代表一个元素，它可以是任何类。例如，如果你正在构建一个整数数组列表，那么初始化可为
	
	ArrayList<Integer> list = new ArrayList<Integer>();  
	类构造函数
	S.N.	构造函数 & 描述
	1	ArrayDeque()
	此构造函数用于创建一个空数组双端队列容纳16个元素的初始容量。
	2	ArrayDeque(Collection<? extends E> c) 
	此构造函数用于创建一个包含指定集合的元素的双端队列。
	3	ArrayDeque(int numElements)
	此构造函数用于创建一个空数组与双端队列的初始容量足以容纳指定的元素数。 类方法
	S.N.	方法 & 描述
	1	boolean add(E e) 
	此方法将添加指定的元素，在此deque队列的末尾。
	2	void addFirst(E e) 
	此方法将添加指定的元素，在此deque队列的前面。
	3	void addLast(E e) 
	此方法将插入指定的元素，在此deque队列的末尾。
	4	void clear() 
	此方法移除此deque队列的元素。
	5	ArrayDeque<E> clone() 
	此方法返回此deque队列的副本。
	6	boolean contains(Object o) 
	如果此deque 队列包含指定的元素，此方法返回true。
	7	Iterator<E> descendingIterator() 
	此方法返回一个迭代器在此deque队列以逆向顺序的元素。
	8	E element() 
	此方法检索，但是不移除此deque队列表示的队列的头部。
	9	E getFirst()
	此方法检索，但是不移除此deque队列的第一个元素。
	10	E getLast() 
	此方法检索，但是不移除此deque队列的最后一个元素。
	11	boolean isEmpty() 
	如果此deque队列不包含元素，此方法返回true。
	12	Iterator<E> iterator() 
	此方法返回一个迭代器在此deque队列的元素。
	13	boolean offer(E e)
	此方法将指定的元素，在此deque队列的末尾。
	14	boolean offerFirst(E e) 
	此方法将指定的元素，在此deque队列的前面。
	15	boolean offerLast(E e) 
	此方法将指定的元素，在此deque队列的末尾。
	16	E peek() 
	此方法检索，但是不移除此deque队列表示的队列的头部，如果此deque队列为空，则返回null。
	17	E peekFirst() 
	此方法检索，但是不移除此deque 队列的第一个元素，或者如果此deque 队列为空，则返回null。
	18	E peekLast() 
	此方法检索，但是不移除此deque队列的最后一个元素，如果此deque队列为空，则返回null。
	19	E poll() 
	此方法检索并移除此deque队列表示的队列的头部，如果此deque队列为空，则返回null。
	20	E pollFirst() 
	此方法检索并移除此deque队列的第一个元素，或者如果此deque队列为空，则返回null。
	21	E pollLast() 
	此方法检索并移除此deque队列的最后一个元素，如果此deque队列为空，则返回null。
	22	E pop() 
	这种方法的此deque队列所表示的堆栈弹出一个元素。
	23	void push(E e) 
	这种方法将元素推入此deque队列所表示的堆栈。
	24	E remove() 
	此方法检索并移除此deque队列表示的队列的头部。
	25	boolean remove(Object o) 
	此方法从此deque队列中移除指定元素的单个实例。
	26	E removeFirst() 
	此方法检索并移除此deque队列的第一个元素。
	27	boolean removeFirstOccurrence(Object o) 
	此方法移除此deque队列的指定元素的第一个匹配。
	28	E removeLast() 
	此方法检索并移除此deque队列的最后一个元素。
	29	boolean removeLastOccurrence(Object o) 
	此方法移除此deque队列的指定元素的最后一次出现。
	30	int size() 
	此方法返回在此deque队列的元素个数。
	31	object[] toArray() 
	这个方法返回一个包含所有在此deque队列在适当的序列中元素的数组。
	

http://czj4451.iteye.com/blog/1688693
	
* ArrayDeque不是线程安全的。 
* ArrayDeque不可以存取null元素，因为系统根据某个位置是否为null来判断元素的存在。 
* 当作为栈使用时，性能比Stack好；当作为队列使用时，性能比LinkedList好。 
