package ok;

/*
https://leetcode.com/problems/permutations-ii/

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    }
}

24 November 2015 at 4:27:18 pm

 */
import java.util.*;
public class PermutationsII {
	
	public static void main(String args[]){
		PermutationsII i=new PermutationsII();
		int[] nums={1,1,2,2};
		List<List<Integer>> list=i.permuteUnique(nums);
		for(List<Integer> tmp:list){
			for(int num:tmp)
				System.out.print(num+" ");
			System.out.println();
		}
	}
	
	
	/*
	 * 
	 * Accepted.
	 * 
	 */
    List<Integer> list=new ArrayList<Integer>();
	Set<List<Integer>> set=new HashSet<List<Integer>>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    
    	List<List<Integer>> result=new ArrayList<List<Integer>>();

    	permute(nums,0,nums.length-1);
    	
    	for(Iterator<List<Integer>> it=set.iterator();it.hasNext();){
    		result.add(it.next());

    	}
    	
		return result;
 
    }
    

	
    public void permute(int[] nums,int i,int n){
    
    	if(i==n){
    		for(int tmp:nums){
    			list.add(tmp);
    		}
    	  set.add(list);
    	  list=new ArrayList<Integer>();
    	}else{
    		
    		for(int j=i;j<=n;j++){
    			swap(nums,i,j);
    			permute(nums,i+1,n);
    			swap(nums,i,j);
    		}
    		
    	}
    	
    }
    
    
    
    public void swap(int[] arr,int i,int j){
    	int tmp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=tmp;
    }
    
}












