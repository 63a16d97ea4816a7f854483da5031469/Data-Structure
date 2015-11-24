/*
https://leetcode.com/problems/permutations/

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
    }
} 

 * 
 */
import java.util.*;
public class Permutations {
	
	
	public static void main(String args[]){
		Permutations s=new Permutations();
		int[] nums={0,-1,1};
//		List<List<Integer>> re=s.permute(nums);
		
//		for(List<Integer> tmp:re){
//			for(int i=0;i<tmp.size();i++){
//				System.out.print(tmp.get(i));
//				if(i!=tmp.size()-1){
//				System.out.print(",");
//				}
//			}
//			System.out.println();
//		}
		s.permute2(nums);
		
	}

	
	
  /*
   * Accepted:
   * 
   */
	  List<List<Integer>> result=new ArrayList<List<Integer>>();
	    
	    public List<List<Integer>> permute2(int[] nums){
			
			permuteSub(nums,0,nums.length-1);
			return result;
		}
		
		public void permuteSub(int[] arr,int i, int n){
			
			int j;
			if(i==n)
				{
				    List<Integer> list=new ArrayList<Integer>();
				    for(int tmp:arr)
				    {
		                list.add(tmp);
				    }
	                result.add(list);
				}else{
					for(j=i;j<=n;j++){
					   swap(arr,i,j);
					   permuteSub(arr,i+1,n);
					   swap(arr,i,j);
					}
				}
			
		}
		
		public void swap(int[] nums,int i,int j){
			int tmp=nums[i];
			nums[i]=nums[j];
			nums[j]=tmp;
		}
	
	
	
	
	
	
	/*
	 * Below code cannot handle negative numbers:
	 * 
	 */
	List<List<Integer>> result2=new ArrayList<List<Integer>>();
	
    public List<List<Integer>> permute(int[] nums) {
     StringBuffer str=new StringBuffer();
    	for(int tmp:nums){
    		str.append(tmp);
    	}
    	
    	subPermute("",str.toString());
    	
    	return result;
    }
    
    public void subPermute(String pre, String str){
		boolean negative=false;
    	if(str.length()==0) {
    		List<Integer> list=new ArrayList<Integer>();

    		for(int i=0;i<pre.length();i++)
    			if(pre.charAt(i)!='-'){
    				if(!negative){
    		list.add(Integer.parseInt(pre.charAt(i)+"")); // Integer.pareseInt(-1) exception!!!!
    				}else{
    		list.add(-Integer.parseInt(pre.charAt(i)+""));			
    				}
    			}else{
    				negative=true;
    			}
    		

    		
    		result2.add(list);
    	}
    	
    	for(int i=0;i<str.length();i++){
    		subPermute(pre+str.charAt(i),str.substring(0, i)+str.substring(i+1, str.length()));
    	}
    }
    
    
    
	
}
