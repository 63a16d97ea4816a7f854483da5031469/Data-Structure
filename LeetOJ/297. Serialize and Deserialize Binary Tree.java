
/*
 * 
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


297. Serialize and Deserialize Binary Tree
Hard

2690

136

Add to List

Share
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */











// http://www.noteanddata.com/leetcode-297-Serialize-and-Deserialize-Binary-Tree-java-solution-note.html

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
        if(null == root) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",").append(serialize(root.left)).append(",").append(serialize(root.right));
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr.length == 0) return null;
        Queue<String> queue = new LinkedList<>();
        for(String item: arr) {
            queue.add(item);
        }
        return des(queue);
    }   
    public TreeNode des(Queue<String> queue) {        
        String cur = queue.poll();
        if("#".equals(cur)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = des(queue);
        root.right = des(queue);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));








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
    //8.44pm-9.11pm
    // Encodes a tree to a single string.
 public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean first = true;
        while(!queue.isEmpty()) {
            if(!first) {
                sb.append(",");
            }
            first = false;
            TreeNode node = queue.poll();
            if(null == node) {
                sb.append("null");
            }
            else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(null == data || data.length() <= 2) return null;
        data = data.substring(1, data.length()-1);
        String[] arr = data.split(",");
        TreeNode root = null;
        TreeNode parent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean expectLeft = true;
        for(int i = 0; i < arr.length; ++i) {
            String cur = arr[i];
            if("null".equalsIgnoreCase(cur)) {
                if(null == root) {
                    root = null; // do nothing
                }
                else {
                    if(expectLeft) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                        parent = queue.poll();
                    }
                    expectLeft = !expectLeft;
                }
            }
            else {
                int v = Integer.valueOf(cur);
                TreeNode node = new TreeNode(v);
                queue.add(node);
                if(null == root) {
                    root = node;
                    parent = queue.poll();
                }
                else {
                    if(expectLeft) {
                        parent.left = node;
                    }
                    else {
                        parent.right = node;
                        parent = queue.poll();
                    }
                    expectLeft = !expectLeft;
                }
            }
        }
        return root;
    } 
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));






import java.io.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public final class Codec {

    public String serialize(TreeNode root) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(128);
        serialize(root, bos);
        return new String(bos.toByteArray(), StandardCharsets.ISO_8859_1);
    }

    public TreeNode deserialize(String data) {
        byte[] bytes = data.getBytes(StandardCharsets.ISO_8859_1);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return deserialize(bis);
    }
    
    static void serialize(TreeNode node, ByteArrayOutputStream bos) {
        if (node == null) {
            bos.write(0);
        } else {
            bos.write(1);
            bos.write((node.val >>> 24) & 0xFF);
            bos.write((node.val >>> 16) & 0xFF);
            bos.write((node.val >>> 8) & 0xFF);
            bos.write(node.val & 0xFF);
            serialize(node.left, bos);
            serialize(node.right, bos);
        }
    }
    
    static TreeNode deserialize(ByteArrayInputStream bis) {
        if (bis.available() == 0 || bis.read() == 0) {
            return null;
        }
        int val = bis.read() << 24;
        val |= bis.read() << 16;
        val |= bis.read() << 8;
        val |= bis.read();
        TreeNode n = new TreeNode(val);
        n.left = deserialize(bis);
        n.right = deserialize(bis);
        return n;
    }
    
    static void writeInt(ByteArrayOutputStream bos, int val) {
        bos.write((val >>> 24) & 0xFF);
        bos.write((val >>> 16) & 0xFF);
        bos.write((val >>> 8) & 0xFF);
        bos.write(val & 0xFF);
    }

    static int readInt(ByteArrayInputStream bis) {
        int val = bis.read() << 24;
        val |= bis.read() << 16;
        val |= bis.read() << 8;
        val |= bis.read();
        return val;
    }
}


// Revision:1
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

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append('x').append(',');
            return;
        } 
        
        builder.append(root.val).append(',');
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","), new AtomicInteger(0));
    }

    // Encodes a tree to a single string.
    public String serialize (TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }
    
    private TreeNode deserialize(String[] data, AtomicInteger atomic) {
        
        if (data[atomic.get()].equals("x")) {
            atomic.getAndIncrement();
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(data[atomic.getAndIncrement()]));
        root.left = deserialize(data, atomic);
        root.right = deserialize(data, atomic);
        
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


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
        if(root == null) return "#,";
        String result = Integer.toString(root.val) + ",";
        result = result + serialize(root.left);
        result = result + serialize(root.right);
        return result;
    }   

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringValues = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String value : stringValues){
            queue.offer(value);
        }
        
        return deserialize(queue);
        
    }
    private TreeNode deserialize(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        } else{
            TreeNode root = new TreeNode(Integer.parseInt(value));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));