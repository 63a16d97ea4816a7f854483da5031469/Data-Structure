
/*
 * 
https://leetcode.com/problems/serialize-and-deserialize-bst/

449. Serialize and Deserialize BST
Medium

1140

65

Add to List

Share
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

9 May 2020 at 10:53 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



类似题目：
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


推荐题目：
https://leetcode.com/problems/find-duplicate-subtrees/


 * 
 */



// 使用BST的特性：
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://github.com/praphull27/science-of-happiness/blob/master/leetcode/449-Serialize%20and%20Deserialize%20BST.java
public class Codec {
	// Tc: O(M*11), SC: O(M*11)
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}
	public void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root != null) {
			sb.append(root.val).append(",");
			serializeHelper(root.left, sb);
			serializeHelper(root.right, sb);
		}
	}
	// TC: O(N+N+M), SC: O(N+M)
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		return deserialize(new LinkedList<>(Arrays.asList(data.split(","))), null, null);
	}
	public TreeNode deserialize(Queue<String> queue, Integer min, Integer max) {
		if (queue.isEmpty()) {
			return null;
		}
		Integer cur = Integer.parseInt(queue.peek());
		if (min != null && cur.compareTo(min)<0) {
			return null;
		}
		if (max != null && cur.compareTo(max) > 0) {
			return null;
		}
		queue.poll();
		TreeNode node = new TreeNode((int) cur);
		node.left = deserialize(queue, min, cur);
		node.right = deserialize(queue, cur, max);
		return node;
	}
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



// 书写方式语法值得学习：

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		return sb.toString();
	}

	private void preorder(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#").append(",");
			return;
		}
		sb.append(root.val).append(",");
		preorder(root.left, sb);
		preorder(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		LinkedList<String> que = new LinkedList<String> ();
		que.addAll(Arrays.asList(data.split(",")));
		return deserial(que);
	}

	private TreeNode deserial(LinkedList<String> que) {
		String str = que.pollFirst();
		if (str.equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(str));
		root.left = deserial(que);
		root.right = deserial(que);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));





//  利用BST的特性：
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    void dfs(TreeNode node, StringBuilder sb) {
        if(null == node) return;
        sb.append(node.val);
        if(null != node.left) {
            sb.append(",");
            dfs(node.left, sb);                    
        }
        if(null != node.right) {
            sb.append(",");
            dfs(node.right, sb);                    
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(String s: arr) {
            if(s.length() > 0) {
                queue.add(Integer.valueOf(s));    
            }
        }
        return dfs(queue);
    }
    public TreeNode dfs(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        int cur = queue.poll();
        TreeNode root = new TreeNode(cur);
        Queue<Integer> small = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < cur) {
            small.add(queue.poll());
        }
        root.left = dfs(small);
        root.right = dfs(queue);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



// 这个是标准的任何二叉树都可以的一种方式：

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//10.38pm-10.52pm (有回看之前的记录)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null){
            return "null";
        }
       sb.append(root.val+",");
       sb.append(serialize(root.left)+",");
       sb.append(serialize(root.right));
        
       return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sArr=data.split(",");
        if(sArr.length==0) return null;
        
        Queue<String> que=new LinkedList<String>();
        for(String tmp:sArr){
            que.add(tmp);
        }
        return buildTree(que);
    }
    
    TreeNode buildTree(Queue<String> que){
        String head=que.poll();
        if(head.equals("null")) return null;
        TreeNode root=new TreeNode(Integer.valueOf(head));
        root.left=buildTree(que);
        root.right=buildTree(que);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));









// 类似题目:
// 108. Convert Sorted Array to Binary Search Tree
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //10.55pm-11.05pm
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums, int start, int end){
        if(start>end) return null;
        int mid=(start+end+1)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,start,mid-1);
        root.right=buildTree(nums,mid+1,end);
        return root;
    }
}


