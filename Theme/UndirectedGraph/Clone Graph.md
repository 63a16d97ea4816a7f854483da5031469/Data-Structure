##Clone Graph

http://n00tc0d3r.blogspot.sg/2013/09/clone-graph.html

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

	class UndirectedGraphNode {
	      int label;
	      ArrayList neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList(); }
	  };
	  
###Solution

This is a basic graph problem. It can be solved via either DFS or BFS.
One thing need to pay attention is that this is a graph not a tree, which mean it is possible to contain cycles. If cycles are not handled properly, it could result in infinite loops.

###Implementation with DFS

	   private UndirectedGraphNode cloneDFS(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {  
	     if (root == null) return root;  
	     UndirectedGraphNode node = new UndirectedGraphNode(root.label);  
	     visited.put(root, node);  
   
     // DFS  
     for (UndirectedGraphNode nb : root.neighbors) {  
       if (visited.containsKey(nb)) {  
         node.neighbors.add(visited.get(nb));  
       } else {  
         node.neighbors.add(cloneDFS(nb, visited));  
       }  
     }  
   
     return node;  
  	 }  

	   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
	     return cloneDFS(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());  
	   }  
	Implementation with BFS
	   public UndirectedGraphNode cloneBFS(UndirectedGraphNode root) {  
	     if (root == null) return root;  
   
     ArrayDeque<UndirectedGraphNode> que = new ArrayDeque<UndirectedGraphNode>();  
     que.addLast(root);  
   
     HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();  
     UndirectedGraphNode rootCopy = new UndirectedGraphNode(root.label);  
     visited.put(root, rootCopy);  
   
     // BFS  
     while (!que.isEmpty()) {  
       root = que.removeFirst();  
       UndirectedGraphNode node = visited.get(root);  
       for (UndirectedGraphNode nb : root.neighbors) {  
         if (visited.containsKey(nb)) {  
           node.neighbors.add(visited.get(nb));  
         } else {  
           UndirectedGraphNode n = new UndirectedGraphNode(nb.label);  
           node.neighbors.add(n);  
           visited.put(nb, n);  
           que.addLast(nb);  
         }  
       }  
     }  
   
     return rootCopy;  
 	  }  
In both algorithms, each vertex and each edge are visited constant times. So, both run in O(|V|+|E|) time.
