package ok;

import java.util.ArrayList;
import java.util.List;

import ok.PascalsTriangle;

/*
https://leetcode.com/problems/pascals-triangle-ii/

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
    }
}

24 November 2015 at 7:39:53 pm

 * 
 */
public class PascalsTriangleII {

	
	
	public static void main(String args[]){
		PascalsTriangleII tri=new PascalsTriangleII();
		List<Integer> list=tri.getRow(3);
		
		for(int tmp:list)
			System.out.print(tmp+" ");

//		for(List<Integer> tmp:list){
//				System.out.print("[");
//			for(int i=0;i<tmp.size();i++){
//				System.out.print(tmp.get(i));
//				if(i!=tmp.size()-1){
//					System.out.print(",");
//				}
//			}
//			System.out.println("]");
//		}
	
	}
	
	
	/*
	 * Accepted.
	 * 
	 */
	
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	List<Integer> tmp=new ArrayList<Integer>();
	

    public List<Integer> getRow(int numRows) {
 
    
    	if(numRows==0) {
    		tmp.add(1);
    		result.add(tmp);
    		return result.get(result.size()-1);
    	}
    	
    	if(numRows==1){
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();
    		tmp.add(1);
    		tmp.add(1);
    		result.add(tmp);
    		return result.get(result.size()-1);
    	}
    	
    	if(numRows>=2){
    		
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();
    		tmp.add(1);
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();

    		

    		for(int i=2;i<=numRows;i++){
    			
        		//only keep the last item and remove all other items
    			for(int k=0;k<result.size()-1;k++){
    				result.remove(k);
    			}
        		List<Integer> last=result.get(result.size()-1);
        		

        			
        		tmp.add(1);
        		
        		for(int j=0;j<last.size()-1;j++){
        			tmp.add(last.get(j)+last.get(j+1));
        		}
        		
        		tmp.add(1);
        		
        		result.add(tmp);
        		tmp=new ArrayList<Integer>();
    		}
    	}
		return result.get(result.size()-1);
    }
	
}
