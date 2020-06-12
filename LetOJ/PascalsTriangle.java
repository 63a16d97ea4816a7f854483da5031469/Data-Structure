//https://leetcode.com/problems/pascals-triangle/

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    }
}

24 November 2015 at 5:24:55 pm


 * 
 * 
 */
import java.util.*;
public class PascalsTriangle {


	public static void main(String args[]){
		PascalsTriangle tri=new PascalsTriangle();
		List<List<Integer>> list=tri.generate(2);

		for(List<Integer> tmp:list){
				System.out.print("[");
			for(int i=0;i<tmp.size();i++){
				System.out.print(tmp.get(i));
				if(i!=tmp.size()-1){
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
	
	}
	
	
	/*
	 * Accepted.
	 * 
	 */
	
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	List<Integer> tmp=new ArrayList<Integer>();
	

    public List<List<Integer>> generate(int numRows) {
    	if(numRows==0) return new ArrayList<List<Integer>>();
    
    	if(numRows==1) {
    		tmp.add(1);
    		result.add(tmp);
    		return result;
    	}
    	
    	if(numRows==2){
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();
    		tmp.add(1);
    		tmp.add(1);
    		result.add(tmp);
    		return result;
    	}
    	
    	if(numRows>2){
    		
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();
    		tmp.add(1);
    		tmp.add(1);
    		result.add(tmp);
    		tmp=new ArrayList<Integer>();

    		

    		for(int i=2;i<numRows;i++){
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
    	return result;
    }
	
	
}















