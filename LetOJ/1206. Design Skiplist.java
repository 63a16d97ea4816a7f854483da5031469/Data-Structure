
/*
 * 
https://leetcode.com/problems/design-skiplist/


1206. Design Skiplist
Hard

115

14

Add to List

Share
Design a Skiplist without using any built-in libraries.

A Skiplist is a data structure that takes O(log(n)) time to add, erase and search. Comparing with treap and red-black tree which has the same function and performance, the code length of Skiplist can be comparatively short and the idea behind Skiplists are just simple linked lists.

For example: we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it. The Skiplist works this way:


Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

You can see there are many layers in the Skiplist. Each layer is a sorted linked list. With the help of the top layers, add , erase and search can be faster than O(n). It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).

To be specific, your design should include these functions:

bool search(int target) : Return whether the target exists in the Skiplist or not.
void add(int num): Insert a value into the SkipList. 
bool erase(int num): Remove a value in the Skiplist. If num does not exist in the Skiplist, do nothing and return false. If there exists multiple num values, removing any one of them is fine.
See more about Skiplist : https://en.wikipedia.org/wiki/Skip_list

Note that duplicates may exist in the Skiplist, your code needs to handle this situation.

 

Example:

Skiplist skiplist = new Skiplist();

skiplist.add(1);
skiplist.add(2);
skiplist.add(3);
skiplist.search(0);   // return false.
skiplist.add(4);
skiplist.search(1);   // return true.
skiplist.erase(0);    // return false, 0 is not in skiplist.
skiplist.erase(1);    // return true.
skiplist.search(1);   // return false, 1 has already been erased.
 

Constraints:

0 <= num, target <= 20000
At most 50000 calls will be made to search, add, and erase.


25 May 2020 at 12:28 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





import java.util.Random;
public class Skiplist {
	Random random = new Random();
	int maxLevel = 0;
	Node topHead = new Node(Integer.MIN_VALUE, null, null);
	public boolean search(int target) {
		Node prev = topHead;
		while (prev != null) {
			while (prev.right != null && prev.right.value < target) {
				prev = prev.right;
			}
			if (prev.right != null && prev.right.value == target) {
				return true;
			}
			prev = prev.down;
		}
		return false;
	}
	public void add(int num) {
		int beginLevel = 0;
		while (true) {
			if (random.nextInt(2) != 0) {
				break;
			}
			beginLevel++;
		}
		while (maxLevel < beginLevel) {
			maxLevel++;
			Node node = new Node(Integer.MIN_VALUE, null, topHead);
			topHead = node;
		}
		Node prev = topHead;
		Node top = null;
		for (int level = maxLevel; level >= 0; level--) {
			while (prev.right != null && prev.right.value < num) {
				prev = prev.right;
			}
			if (level <= beginLevel) {
				Node node = new Node(num, prev.right, null);
				if (top != null) {
					top.down = node;
				}
				prev.right = node;
				top = node;
			}
			prev = prev.down;
		}
	}
	public boolean erase(int num) {
		boolean result = false;
		Node prev = topHead;
		while (prev != null) {
			while (prev.right != null && prev.right.value < num) {
				prev = prev.right;
			}
			if (prev.right != null && prev.right.value == num) {
				prev.right = prev.right.right;
				result = true;
			}
			prev = prev.down;
		}
		return result;
	}
}
class Node {
	int value;
	Node right;
	Node down;
	Node(int value, Node right, Node down) {
		this.value = value;
		this.right = right;
		this.down = down;
	}
}
// Your Skiplist object will be instantiated and called as such:
// Skiplist obj = new Skiplist();
// boolean param_1 = obj.search(target);
// obj.add(num);
// boolean param_3 = obj.erase(num);


















