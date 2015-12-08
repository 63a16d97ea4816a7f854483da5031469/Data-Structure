import java.util.*;
public class Solution3 {
	
//    public static void main(String[] args) {
//    	Solution3 s=new Solution3();
//        int[] arr = { 1, 3, 2, 4, 5, 6, 7, 8, 9 };
//        Arrays.sort(arr);
//        int sum = 7;
//        s.numGroup(arr, 0, arr.length, sum);
//    }
 
	
	public static void main(String[] args){
		
		Solution3 robot = new Solution3();
//		int[] a = {1,2,3};
//		robot.combine(a);
		int[] a = {1,2,3,6,7,3,4,10};

		robot.findSum(a,10);
//		robot.findSum(a,4);

		
	}
 
 int[] nums;
	public void findSum(int[] nums,int sum){
		
		Arrays.sort(nums);
		this.nums=nums;
		
		combine(sum);

	}
	
	
 
		public void combine(int m) {
			
			if(m < 1 )
				return;
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			getCombination(m, arr);
		}
		public void getCombination(int m, ArrayList<Integer> arr) {
			
			if (m == 0 && arr.size() >= 1) {
				for (int i = 0; i < arr.size(); i++) {
					
					System.out.print(arr.get(i) + " ");
				}
				System.out.println();
				return;
			}
			
			if(m<0) return;
			
			for (Integer i = 0; i <nums.length; i++) {
				if (!arr.isEmpty() && nums[i] < arr.get(arr.size() - 1))//使集合内元素递增，防止重复
					continue;
		
				arr.add(nums[i]);
				getCombination(m - nums[i], arr);
				if(!arr.isEmpty())
				arr.remove(arr.size()-1);
			}
		}
		
 
	
	
	
	
	
		/*保存序列集合*/
		ArrayList<List<Integer>> _arr = new ArrayList<List<Integer>>();
		
		public void combine(int[] a) {
			
			if(null == a || a.length == 0)
				return;
			List<Integer> b = new ArrayList<Integer>();//序列存储空间
			getCombination(a,b);
			printArr();//输出所有组合
		}
		public void getCombination(int[] a, List<Integer> b){
			
			if(a.length == b.size()){
				
				/*自定义按List中升序排序*/
				Collections.sort(b, new Comparator() {

					public int compare(Object o1, Object o2) {
						return (Integer)o1 - (Integer)o2;
					}
				    });
				if(!haveArray(b)){//如果序列b不存在
					
					/*拷贝一个序列b*/
					List<Integer> new_list = new ArrayList<Integer>();
					for(int i = 0; i < b.size(); i++){
						new_list.add(b.get(i));
					}
				
					_arr.add(new_list);//加入集合中
				}
				return;
			}
			for(int i = 0; i < a.length; i++){
				
				Integer num = a[i];
				b.add(num);
				getCombination(a, b);
				b.remove(num);
			}
		}
		private boolean haveArray(List<Integer> b) {
			
			for(int i = 0; i < _arr.size(); i++){
				List<Integer> temp = _arr.get(i);
				int j;
				for(j = 0; j < temp.size(); j++){
					if(temp.get(j) != b.get(j))
						break;
				}
				if(j >= temp.size())
					return true;
			}
			return false;
		}
		public void printArr(){
			for(int i = 0; i < _arr.size(); i++){
				List<Integer> temp = _arr.get(i);
				for(int j = 0; j < temp.size(); j++)
					System.out.print(temp.get(j) + " ");
				System.out.println();
			}
		}

 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 int count=0;
		
		public void runPermutation(int[] a) {
			
			if(null == a || a.length == 0)
				return;
				
			int[] b = new int[a.length];//辅助空间，保存待输出排列数
			getAllPermutation(a, b, 0);
		}

		public void getAllPermutation(int[] a, int[] b, int index) {
			
			if(index == a.length){
				for(int i = 0; i < index; i++){
					System.out.print(b[i] + " ");
				}
				System.out.println();
				return;
			}
				
			for(int i = 0; i < a.length; i++){
				count++;
				b[index] = a[i];
				getAllPermutation(a, b, index+1);
			}
			
		}
		
//		public static void main(String[] args){
//			
//			Solution3 robot = new Solution3();
//			
//			int[] a = {1,2,3,4,5,1};
////			robot.runPermutation(a);
////			System.out.println(robot.count);
//			
//			Solution3 s=new Solution3();
//			s.find_factor(10,20);
//
//			//6 numbers --> count:55986
//		}

 
	
    
    /**
     * 将一个数组内元素的所有组合输出
     * 思路：递归
     * 循环内每次按序从剩余数组中取出一个元素，和已经输出的部分合成
     */
 

    	/**
    	 * @param args
    	 */
//    	public static void main(String[] args) {
//    		// TODO Auto-generated method stub
//    		String[] array = new String[]{
//    				"1", "2", "3", "4"
//    		};
//    		listAll(Arrays.asList(array)," ");
//    		
//    	}
    	
    	public static void listAll(List<String> candidate, String prefix){
    		System.out.println(prefix);
    		
    		for(int i=0; i<candidate.size(); i++){
    			List<String> temp = new LinkedList<String>(candidate);//new LinkedList<String>(candidate)---copy candidate
    			listAll(temp, prefix+temp.remove(i));
    		}
    	}

 
    
    
	
//	public static void main(String args[]){
//		Solution3 s=new Solution3();
//		s.find_factor(10,20);
//	}
	
	
 
	    // Arrays.sort(arr);
	    static int[] flag = new int[100];
	    static int index = 0;// 记录当前
 
	    public static void numGroup(int[] arr, int start, int length, int sum) {
	        if (sum == 0) {
	            for (int j = 0; j < index; j++) {
	                System.out.print(flag[j]+" ");
	            }
	            System.out.println();
	        } else {
	            for (int i = start; i < length; i++) {
	                flag[index++] = arr[i];
	                numGroup(arr, i + 1, length-1, sum - arr[i]);
	            }
	        }
	        index--;
	    }
	

 

	
	
	
//	List<Integer> list1=new ArrayList<Integer>();
	LinkedList<Integer> list1=new LinkedList<Integer>();
	
	
	public void find_factor(int sum,int n){
		
		if(n<=0||sum<=0) return;
		if(sum==n){
		  
			//reverse the list:
			Collections.reverse(list1);
//			for(int i=0;i<list1.size();i++){
//				int tmp=list1.get(i);
//				list1.set(i, list1.get(list1.size()-1-i));
//				list1.set(list1.size()-1-i, tmp);
//			}
//			
			for(int tmp:list1)
				System.out.print(tmp+"+");
			
			System.out.println(n);
		}
		
		list1.push(n);
		find_factor(sum-n,n-1);
		list1.pop();
		find_factor(sum,n-1);
		
	}
}
