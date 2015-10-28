
/*

https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Given a binary tree, return the bottom-up level order traversal of its
 nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
    }
}

 * 
 */
import java.util.*;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//
//	public String toString() {
//		return this.val + "";
//	}
//
//}

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String args[]) {

		/*
		 *     1 
		 * 	  / \ 
		 * 	 2   5 
		 *  / \ 
		 * 3  4
		 * 
		 */

		TreeNode root = new TreeNode(1);
		TreeNode sec = new TreeNode(2);
		sec.left = new TreeNode(3);
		sec.right = new TreeNode(4);
		root.left = sec;
		root.right = new TreeNode(5);

		System.out.println(levelOrderbottom2(root));
	}

	
	/*
	 * 
	 * Accepted:
	 * 
	 *  Use stack to reverse the result ArrayList.
	 * 
	 * 
	 */
	
	public static List<List<Integer>> levelOrderbottom2(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<List<Integer>> saveStack=new Stack<List<Integer>>();

		if (root == null)
			return result;

		LinkedList<TreeNode> que = new LinkedList<TreeNode>();

		que.add(root);
		que.add(null);

		List<Integer> levelElement = new ArrayList<Integer>();

		while (!que.isEmpty()) {

			TreeNode firstNode = que.removeFirst();

			if (firstNode != null) {
				levelElement.add(firstNode.val);
			}

			if (firstNode == null) {

				// One level end.
				if (!que.isEmpty()) {
					que.addLast(null);
					saveStack.push(levelElement);
					levelElement = new ArrayList();
				}

			} else {

				if (firstNode.left != null) {
					que.add(firstNode.left);
				}

				if (firstNode.right != null) {
					que.add(firstNode.right);
				}
			}
		}
		

		

		saveStack.push(levelElement);

		// reverse the result arraylist
		
		while(!saveStack.isEmpty())
		  result.add(saveStack.pop());
		
		
		
//		for (int i = 0; i < result.size() / 2; i++) {
//			List<Integer> tmp;
//			tmp = result.get(i);
//			result.set(i, result.get(result.size() - 1 - i));
//			result.set(result.size() - 1 - i, tmp);
//			System.out.println(result);
//		}

		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * Status: Time Limit Exceeded Submitted: 0 minutes ago Last executed input:
	 * [-150,null,-149,null,-148,null,-147,null,-146,null,-145,null,-144,null,-
	 * 143,null,-142,null,-141,null,-140,null,-139,null,-138,null,-137,null,-136
	 * ,null,-135,null,-134,null,-133,null,-132,null,-131,null,-130,null,-129,
	 * null,-128,null,-127,null,-126,null,-125,null,-124,null,-123,null,-122,
	 * null,-121,null,-120,null,-119,null,-118,null,-117,null,-116,null,-115,
	 * null,-114,null,-113,null,-112,null,-111,null,-110,null,-109,null,-108,
	 * null,-107,null,-106,null,-105,null,-104,null,-103,null,-102,null,-101,
	 * null,-100,null,-99,null,-98,null,-97,null,-96,null,-95,null,-94,null,-93,
	 * null,-92,null,-91,null,-90,null,-89,null,-88,null,-87,null,-86,null,-85,
	 * null,-84,null,-83,null,-82,null,-81,null,-80,null,-79,null,-78,null,-77,
	 * null,-76,null,-75,null,-74,null,-73,null,-72,null,-71,null,-70,null,-69,
	 * null,-68,null,-67,null,-66,null,-65,null,-64,null,-63,null,-62,null,-61,
	 * null,-60,null,-59,null,-58,null,-57,null,-56,null,-55,null,-54,null,-53,
	 * null,-52,null,-51,null,-50,null,-49,null,-48,null,-47,null,-46,null,-45,
	 * null,-44,null,-43,null,-42,null,-41,null,-40,null,-39,null,-38,null,-37,
	 * null,-36,null,-35,null,-34,null,-33,null,-32,null,-31,null,-30,null,-29,
	 * null,-28,null,-27,null,-26,null,-25,null,-24,null,-23,null,-22,null,-21,
	 * null,-20,null,-19,null,-18,null,-17,null,-16,null,-15,null,-14,null,-13,
	 * null,-12,null,-11,null,-10,null,-9,null,-8,null,-7,null,-6,null,-5,null,-
	 * 4,null,-3,null,-2,null,-1,null,0,null,1,null,2,null,3,null,4,null,5,null,
	 * 6,null,7,null,8,null,9,null,10,null,11,null,12,null,13,null,14,null,15,
	 * null,16,null,17,null,18,null,19,null,20,null,21,null,22,null,23,null,24,
	 * null,25,null,26,null,27,null,28,null,29,null,30,null,31,null,32,null,33,
	 * null,34,null,35,null,36,null,37,null,38,null,39,null,40,null,41,null,42,
	 * null,43,null,44,null,45,null,46,null,47,null,48,null,49,null,50,null,51,
	 * null,52,null,53,null,54,null,55,null,56,null,57,null,58,null,59,null,60,
	 * null,61,null,62,null,63,null,64,null,65,null,66,null,67,null,68,null,69,
	 * null,70,null,71,null,72,null,73,null,74,null,75,null,76,null,77,null,78,
	 * null,79,null,80,null,81,null,82,null,83,null,84,null,85,null,86,null,87,
	 * null,88,null,89,null,90,null,91,null,92,null,93,null,94,null,95,null,96,
	 * null,97,null,98,null,99,null,100,null,101,null,102,null,103,null,104,null
	 * ,105,null,106,null,107,null,108,null,109,null,110,null,111,null,112,null,
	 * 113,null,114,null,115,null,116,null,117,null,118,null,119,null,120,null,
	 * 121,null,122,null,123,null,124,null,125,null,126,null,127,null,128,null,
	 * 129,null,130,null,131,null,132,null,133,null,134,null,135,null,136,null,
	 * 137,null,138,null,139,null,140,null,141,null,142,null,143,null,144,null,
	 * 145,null,146,null,147,null,148,null,149,null,150,null,151,null,152,null,
	 * 153,null,154,null,155,null,156,null,157,null,158,null,159,null,160,null,
	 * 161,null,162,null,163,null,164,null,165,null,166,null,167,null,168,null,
	 * 169,null,170,null,171,null,172,null,173,null,174,null,175,null,176,null,
	 * 177,null,178,null,179,null,180,null,181,null,182,null,183,null,184,null,
	 * 185,null,186,null,187,null,188,null,189,null,190,null,191,null,192,null,
	 * 193,null,194,null,195,null,196,null,197,null,198,null,199,null,200,null,
	 * 201,null,202,null,203,null,204,null,205,null,206,null,207,null,208,null,
	 * 209,null,210,null,211,null,212,null,213,null,214,null,215,null,216,null,
	 * 217,null,218,null,219,null,220,null,221,null,222,null,223,null,224,null,
	 * 225,null,226,null,227,null,228,null,229,null,230,null,231,null,232,null,
	 * 233,null,234,null,235,null,236,null,237,null,238,null,239,null,240,null,
	 * 241,null,242,null,243,null,244,null,245,null,246,null,247,null,248,null,
	 * 249,null,250,null,251,null,252,null,253,null,254,null,255,null,256,null,
	 * 257,null,258,null,259,null,260,null,261,null,262,null,263,null,264,null,
	 * 265,null,266,null,267,null,268,null,269,null,270,null,271,null,272,null,
	 * 273,null,274,null,275,null,276,null,277,null,278,null,279,null,280,null,
	 * 281,null,282,null,283,null,284,null,285,null,286,null,287,null,288,null,
	 * 289,null,290,null,291,null,292,null,293,null,294,null,295,null,296,null,
	 * 297,null,298,null,299,null,300,null,301,null,302,null,303,null,304,null,
	 * 305,null,306,null,307,null,308,null,309,null,310,null,311,null,312,null,
	 * 313,null,314,null,315,null,316,null,317,null,318,null,319,null,320,null,
	 * 321,null,322,null,323,null,324,null,325,null,326,null,327,null,328,null,
	 * 329,null,330,null,331,null,332,null,333,null,334,null,335,null,336,null,
	 * 337,null,338,null,339,null,340,null,341,null,342,null,343,null,344,null,
	 * 345,null,346,null,347,null,348,null,349,null,350,null,351,null,352,null,
	 * 353,null,354,null,355,null,356,null,357,null,358,null,359,null,360,null,
	 * 361,null,362,null,363,null,364,null,365,null,366,null,367,null,368,null,
	 * 369,null,370,null,371,null,372,null,373,null,374,null,375,null,376,null,
	 * 377,null,378,null,379,null,380,null,381,null,382,null,383,null,384,null,
	 * 385,null,386,null,387,null,388,null,389,null,390,null,391,null,392,null,
	 * 393,null,394,null,395,null,396,null,397,null,398,null,399,null,400,null,
	 * 401,null,402,null,403,null,404,null,405,null,406,null,407,null,408,null,
	 * 409,null,410,null,411,null,412,null,413,null,414,null,415,null,416,null,
	 * 417,null,418,null,419,null,420,null,421,null,422,null,423,null,424,null,
	 * 425,null,426,null,427,null,428,null,429,null,430,null,431,null,432,null,
	 * 433,null,434,null,435,null,436,null,437,null,438,null,439,null,440,null,
	 * 441,null,442,null,443,null,444,null,445,null,446,null,447,null,448,null,
	 * 449,null,450,null,451,null,452,null,453,null,454,null,455,null,456,null,
	 * 457,null,458,null,459,null,460,null,461,null,462,null,463,null,464,null,
	 * 465,null,466,null,467,null,468,null,469,null,470,null,471,null,472,null,
	 * 473,null,474,null,475,null,476,null,477,null,478,null,479,null,480,null,
	 * 481,null,482,null,483,null,484,null,485,null,486,null,487,null,488,null,
	 * 489,null,490,null,491,null,492,null,493,null,494,null,495,null,496,null,
	 * 497,null,498,null,499,null,500,null,501,null,502,null,503,null,504,null,
	 * 505,null,506,null,507,null,508,null,509,null,510,null,511,null,512,null,
	 * 513,null,514,null,515,null,516,null,517,null,518,null,519,null,520,null,
	 * 521,null,522,null,523,null,524,null,525,null,526,null,527,null,528,null,
	 * 529,null,530,null,531,null,532,null,533,null,534,null,535,null,536,null,
	 * 537,null,538,null,539,null,540,null,541,null,542,null,543,null,544,null,
	 * 545,null,546,null,547,null,548,null,549,null,550,null,551,null,552,null,
	 * 553,null,554,null,555,null,556,null,557,null,558,null,559,null,560,null,
	 * 561,null,562,null,563,null,564,null,565,null,566,null,567,null,568,null,
	 * 569,null,570,null,571,null,572,null,573,null,574,null,575,null,576,null,
	 * 577,null,578,null,579,null,580,null,581,null,582,null,583,null,584,null,
	 * 585,null,586,null,587,null,588,null,589,null,590,null,591,null,592,null,
	 * 593,null,594,null,595,null,596,null,597,null,598,null,599,null,600]
	 * 
	 * 
	 */

	public static List<List<Integer>> levelOrderbottom(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		LinkedList<TreeNode> que = new LinkedList<TreeNode>();

		que.add(root);
		que.add(null);

		List<Integer> levelElement = new ArrayList<Integer>();

		while (!que.isEmpty()) {

			TreeNode firstNode = que.removeFirst();

			if (firstNode != null) {
				levelElement.add(firstNode.val);
			}

			if (firstNode == null) {

				// One level end.
				if (!que.isEmpty()) {
					que.addLast(null);
					result.add(levelElement);
					levelElement = new ArrayList();
				}

			} else {

				if (firstNode.left != null) {
					que.add(firstNode.left);
				}

				if (firstNode.right != null) {
					que.add(firstNode.right);
				}
			}
		}
		

		

		result.add(levelElement);

		System.out.println(result);

		// reverse the result arraylist
		for (int i = 0; i < result.size() / 2; i++) {
			List<Integer> tmp;
			tmp = result.get(i);
			result.set(i, result.get(result.size() - 1 - i));
			result.set(result.size() - 1 - i, tmp);
			System.out.println(result);
		}

		return result;
	}

}
