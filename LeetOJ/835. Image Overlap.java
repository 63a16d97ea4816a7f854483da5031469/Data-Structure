
/*
 * 
https://leetcode.com/problems/image-overlap/


835. Image Overlap
Medium

288

392

Add to List

Share
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1


30 March 2020 at 6:12 pm
 * 
 */


class Solution {

	//另一个方法：将A和B中的含有1的节点各塞进一个listA 和 listB中，然后对这两个lists进行求所有交叉可能的情况，对于交叉解值相同的，他们一定在同一个位移中，使用hashmap来存放，易于找到最优解

	public int largestOverlap(int[][] A, int[][] B) {
		int n = A.length;

		int max = 0;

		List<Node> listA = new ArrayList<Node> ();
		List<Node> listB = new ArrayList<Node> ();

		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if (A[i][j] == 1) listA.add(new Node(i, j));
				if (B[i][j] == 1) listB.add(new Node(i, j));
			}
		}

		HashMap<String,
			Integer > map = new HashMap<>();

		for (int i = 0; i<listA.size(); i++) {
			for (int j = 0; j<listB.size(); j++) {
				Node a = listA.get(i);
				Node b = listB.get(j);

				int dx = a.x - b.x;
				int dy = a.y - b.y;

				String s = dx + " " + dy;

				int v = 0;

				if (map.get(s) != null) {
					v = map.get(s);
				}

				map.put(s, ++v);
			}
		}

		for (Map.Entry<String, Integer> tmp: map.entrySet()) {
			max = Math.max(tmp.getValue(), max);
		}

		return max;
	}

	class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}







Accepted:

class Solution {
    
    //(有想法，但是不太懂如何构造，这是一个问题，需要克服，就是实现技巧（需要多看别人的代码，来积累相关的构造经验）)
    //这个问题等同于，选A为参照上下左右移动，或者选B为参照上下左右移动，来扫描overlap，看哪个最大
    
    public int largestOverlap(int[][] A, int[][] B) {
        int n=A.length;
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               int curr=Math.max(count(A,B,i,j),count(B,A,i,j));
               max=Math.max(max,curr);
            }
        }
        
        return max;
    }
    
    
    int count(int[][] A, int[][] B, int dx, int dy){
        
        int n=A.length;
            
        int result=0;
   
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //相乘来看谁是1，1就是重叠了
                if(i-dx<0 || j-dy <0) continue;
                int tmp=A[i][j]*B[Math.abs(i-dx)][Math.abs(j-dy)];
                if(tmp==1) result++;
            }
        }
        return result;
    }
}





















