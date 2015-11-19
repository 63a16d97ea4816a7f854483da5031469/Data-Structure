
public class BinarySearchImplementation {
	
	public static void main(String args[]){
		BinarySearchImplementation binary=new BinarySearchImplementation();
		int[] nums={1,2,3,4,5,6,12};
		int result=binary.binarySearch4(nums, 12);
		System.out.println("Index:"+result+" Value:"+nums[result]);
	}
	

	//Non-recursion implementation 1:	
	
	public int binarySearch4(int[] nums,int key){
		
		int low=0;
		int high=nums.length-1;
		int curr=low+(high-low)/2;
		for(;low<=high;curr=low+(high-low)/2){
			
			if(nums[curr]==key) return curr;
			
			if(nums[curr]>key) {
				high=curr-1;
			}
			
			if(nums[curr]<key){
				low=curr+1;
			}
		}
		
		
		return -1;
	}
	
	
	
	
	
	
	

	//Non-recursion implementation 2:
	public int binarySearch3(int[] nums,int key){
		
		int low=0;
		int high=nums.length-1;
		
		while(low<=high){
			int middle=(low+high)/2;
			
			if(nums[middle]==key) return middle;
			
			if(nums[middle]>key){
				high=middle-1;
			}
			
			if(nums[middle]<key){
				low=middle+1;
			}
		}
		
		
		return -1;
	}

	
	
	/*
	 * (1) Make it readable
	 * (2) Check the threshold condition for variables.
	 * 
	 */
	public int binarySearch2(int[] nums, int start, int end, int key){
		int middle=(end-start+1)/2+start;

		if(nums[middle]==key){
			return start+(end-start+1)/2;
		}


		if(nums[middle]>key&&end>0){
		return binarySearch(nums,start,end-1,key);
		}

		if(nums[middle]<key&&start<nums.length-1){
		return binarySearch(nums,start+1,end,key);
		}

		return -1;
	}

	
	
	
	/*
	 *  if you only write below code, you ignore these things:
	 *  (1) Checking the threshold condition for your variables.
	 *  (2) You did not make it readable.
	 * 
	 */
	public int binarySearch(int[] nums, int start, int end, int key){

		if(nums[start+(end-start+1)/2]==key){
			return start+(end-start+1)/2;
		}


		if(nums[start+(end-start+1)/2]>key){
		return binarySearch(nums,start,end-1,key);
		}

		if(nums[start+(end-start+1)/2]<key){
		return binarySearch(nums,start+1,end,key);
		}

		return -1;
	}

	
}


