
/*
 * 
link: 
https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/

2020-8-22 at 9:56 pm

剑指 Offer 37. 序列化二叉树
难度
困难

62

收藏

分享
切换为英文
关注
反馈
请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */



class Codec {

    public void serializeHelper(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("#");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
        return;
    }

    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        this.serializeHelper(root, list);
        return String.join(" ", list);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList(Arrays.asList(data.split(" ")));
        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }

        String text = list.removeFirst();
        if ( "#".equals(text)) {
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(text));
        current.left = deserializeHelper(list);
        current.right = deserializeHelper(list);
        return current;
    }


    // public static void main(String[] args) {
    //     Codec c = new Codec();
    //     TreeNode root = new TreeNode(10);
    //     root.right = new TreeNode(9);
    //     root.left = new TreeNode(3);
    //     root.left.left = new TreeNode(4);
    //     root.right.right = new TreeNode(8);
    //     System.out.println(c.serialize(root));

    //     root = c.deserialize(c.serialize(root));
    //     System.out.println(c.serialize(root));
    // }

}

// 作者：Huweicai
// 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/java-dfs-xian-gen-xu-fu-ce-shi-yong-li-by-huweic-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





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
    String serializeStr="";
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return serializeStr;
    }
    
       public void serializeHelper(TreeNode root) {
        if(root==null) {
            serializeStr+="null,";
            return;
        }
        serializeStr+=root.val+",";
        serialize(root.left);
        serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.substring(0,data.length()-1);
        String[] arr=data.split(",");
        TreeNode root=buildTree(arr);
        return root;
    }
    
    public TreeNode buildTree(String[] arr){
        if(index>=arr.length){
            return null;
        }
        
        if(arr[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[index++]));
        root.left=buildTree(arr);
        root.right=buildTree(arr);
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
    //原理：我们可以根据前序遍历的顺序来序列化二叉树,因为前序遍历是从根节点开始的。在遍历二叉树碰到 null时,将其序列化为一个特殊的字符(如'$')
    //另外,节点的数值之间要用一个特殊字符(如',')隔开,因为节点的值位数不定且正负不定。
    //则下面二叉树               1               可以序列化为：
    //				 /  \              [1,2,4,$,$,$,3,5,$,$,6,$,$]
    //				2    3
    //             /    / \
    //            4    5   6
    //我们接着以上述字符串为例分析如何反序列化二叉树。第一个读出的数字是1。由于前序遍历是从根节点开始的,这是根节点的值。
    //接下来读出的数字是2,根据前序遍历的规则,这是根节点的左子节点的值。同样,接下来的数字4是值为2的节点的左子节点。
    //接着从字符串里读出两个字符'$',这表明值为4的节点的左、右子节点均不存在,因此它是一个叶节点。接下来回到值为2的节点,重建它的右子节点。
    //由于下一个字符是'$',这表明值为2的节点的右子节点不存在， 2这个节点的左、右子树都己经构建完毕,接下来回到根节点,反序列化根节点的右子树
    //下一个序列化字符串中的数字是3,因此右子树的根节点的值为3。它的左子节点是一个值为5的叶节点,因为接下来的三个字符是"5,$,$"。
    //同样,它的右子节点是值为6的叶节点,因为最后3个字符是"6,$,$"。
    
        int start=0;//注意这里必须是全局变量，否则后面的迭代过程中start无法正确变化
        public String serialize(TreeNode root) {
            if(root==null) return "$";
            StringBuilder res = new StringBuilder();
            recur(root,res);
            return res.toString();
        }
        public void recur(TreeNode root,StringBuilder res){//前序遍历
            if(root==null){ 
                res.append("$,");//可以append string
                return;}
            res.append(root.val);//append int 由于int位数不定，且可正可负，因此各元素间必须用,分割
            res.append(',');//append char
            recur(root.left,res);
            recur(root.right,res);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("$")) return null;//Sting值相等的判别不能用==
            String inputs[] = data.split(",");
            //虽然data中以,结尾，但是上述分割后会默认最后一个,不存在  不会使最后一个分割元素为空
            return build(inputs);
        }
        public TreeNode build(String[] inputs){
            TreeNode res;
            if(inputs[start].equals("$")){ 
                start++;
                return null;//这里说明当前节点为null，自然不存在左右节点了，直接返回
            }
            res = new TreeNode(Integer.parseInt(inputs[start]));
            start++;
            //注意：start不能以形参的形式引入build方法中，build(inputs,start);如果是这样
            //下面res.left = build(inputs,start); res.right = build(inputs,start+1);由于处于同一级迭代中start值连续
            //但实际上res.right中应该是上面res.left迭代完成后才会执行的，start不连续，因此把start作为全局变量较为合适
            res.left = build(inputs);
            res.right = build(inputs);
            return res;
        }
    }
    
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    
    作者：mo-fei-25
    链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/javashi-xian-jian-zhi-offersi-lu-xian-xu-bian-li-b/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








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
    public void serializeHelper(TreeNode root, List<String> list){
        if(root==null) {
            list.add("#"); 
            return;
        }
        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right,list);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list=new ArrayList<String>();
        serializeHelper(root,list);
        return String.join(" ",list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list=new LinkedList(Arrays.asList(data.split(" ")));
        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String text=list.removeFirst();
        if(text.equals("#")){
            return null;
        }
        TreeNode curr=new TreeNode(Integer.parseInt(text));
        curr.left=deserializeHelper(list);
        curr.right=deserializeHelper(list);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));









