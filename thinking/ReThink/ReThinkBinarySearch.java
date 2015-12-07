/*
 * http://blog.csdn.net/v_july_v/article/details/7093204
 * 
 * 通过这篇文章，可以知道：  
(1) 对于算法，很多人都是眼高手低，觉得自己懂了，但是事实上写不出正确的代码
(2) 对于任何写出来的程序，努力的思考，还是有可以改进的空间的。
 * 
 */
public class ReThinkBinarySearch {
	
	public static void main(String args[]){
		ReThinkBinarySearch rb=new ReThinkBinarySearch();
		int[] nums={1,2,3,45,5,2,9};
		int key=2;
		System.out.println(rb.binarySearch(nums, key));
	}
	

	
	public int binarySearch(int[] nums,int key){
		int left=0;
		int right=nums.length-1;
		
		//如果这里是int right = nums.length 的话，那么下面有两处地方需要修改，以保证一一对应：  
	    //1、下面循环的条件则是while(left < right)  
	    //2、循环内当array[middle]>value 的时候，right = mid  

		while(left<=right){
			int middle=left+((right-left)>>1); // //防止溢出，移位也更高效。同时，每次循环都需要更新。  
			//很多人使用这个： middle= (left+right)>>1; 这样的话left与right的值比较大的时候，其和可能溢出。
			
			if(nums[middle]>key){
				right=middle-1;   //right赋值，适时而变  
			}else if(nums[middle]<key){
				left=middle+1;
			}else
				return middle;
		    //可能会有读者认为刚开始时就要判断相等，但毕竟数组中不相等的情况更多  
	        //如果每次循环都判断一下是否相等，将耗费时间  
		}

		return -1;
	}

	
}
