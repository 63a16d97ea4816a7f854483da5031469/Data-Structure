 
/*
 * 

Code
public class Node
{
    public Node[] Children;
    public Node Right;
}
Question
Each node represents an element of a tree and specifies a list of immediate children.
The 'Children' property lists all children (in order) but the 'Right' property is set to null.
Suppose you are given the root of a fully populated tree (i.e. a Node called RootNode). 
Write code to set the 'Right' property so that each node is linked to its right sibling.


 * 
 */
import java.util.*;

class Node
{
    public Node[] Children;
    public Node Right;
    public int val;
    Node(int x){val=x;}
}





public class NewTiTan {
	
	/*
	 * 				  1
	 *   		   /  \  \	
	 * 			  2    6  7
	 *          /  \    
	 *         9    3  
	 * 
	 * 
	 */
	
	public static void main(String args[]){
		
//		Node root=new Node(1);
//		Node secLeft=new Node(2);
//		Node secRight=new Node(6);
//		Node secThird=new Node(7);
//		Node thirdRight=new Node(3);
//		Node thirdLeft=new Node(9);
//		secLeft.Children=new Node[2];
//		secLeft.Children[0]=thirdLeft;
//		secLeft.Children[1]=thirdRight;
//		
//		root.Children=new Node[3];
//		root.Children[0]=secLeft;
//		root.Children[1]=secRight;
//		root.Children[2]=secThird;
		
		
		Node root=new Node(1);
		root.Children=new Node[2];
		root.Children[0]=new Node(2);
		root.Children[1]=new Node(3);
		
		
		
		
		NewTiTan ti=new NewTiTan();
		Node result=ti.linkRightNode(root);
		
//		System.out.println(result);
		ti.loopTree(result);
		
	}
	
	public void loopTree(Node root){
		
		LinkedList<Node> que=new LinkedList<Node>();
		
		que.addLast(root);
		
		while(!que.isEmpty()){
			
			Node firstNode=que.removeFirst();
			
			if(firstNode!=null){
				System.out.print("the Node's value:"+firstNode.val);
				if(firstNode.Right!=null) System.out.print(" Its right:"+firstNode.Right.val);
				System.out.println();
				
				if(firstNode.Children!=null)
					for(Node tmp:firstNode.Children){
						que.addLast(tmp);
					}
				
			}
			
		}
		
	}
	
	
	
	public Node linkRightNode(Node rootNode){
		
		if(rootNode==null) return null;
		
		LinkedList<Node> que=new LinkedList<Node>();
		
		que.addLast(rootNode);
		que.addLast(null);
		
		Node prev=null;
		
		while(!que.isEmpty()){
			Node firstNode=que.removeFirst();
			
			if(firstNode==null){
				prev=null;
				if(!que.isEmpty()){
					que.addLast(null);
				}
			}else{
				
				if(prev!=null){
					prev.Right=firstNode;
				}
				
				if(firstNode.Children!=null)
				for(Node tmp:firstNode.Children){
					que.addLast(tmp);
				}
				prev=firstNode;
			}
		}
		return rootNode;
	}
	

	
}
