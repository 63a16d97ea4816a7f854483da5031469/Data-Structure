
##Coding Practice 1

Rules  
1. It is important to solve the challenge without referring to existing solutions. Don't search for solutions online.  
2. Submit a working, buildable solution with test cases in 1 single file (each question maps to a different method or group of methods). Include test cases in your solution: e.g. 0, -1, min/max,
overflow, etc.  
3. Write clear, good documentation in your code.  
4. Be aware of differences between HashTable vs HashMap vs HashSet, or Array vs ArrayList, and other 'similarly'-named data structures. Understand what problems these structures are suitable for. Be familiar with how 1 data structure can be converted to another, if the programming language supports it natively, use it.  
5. Use existing data structures supported by the language, unless the problem is 'implement a hash table'.  
6. After solving the problem, think about space/time complexity and improve the solution.  
7. This is a coding practice. We do not provide solutions or feedback after your submission.  

##Questions
1. Given two strings, write a method to decide if one is a permutation of the other.  

		public boolean isPermutation(String str1,String str2){
			if(str1==null&&str2==null) return true;
			if(str1==null||str2==null) return false;
			
			
			if(str1!=null&&str2!=null){
				
			if(str1.length()!=str2.length()) return false;
			
			
			HashMap<Character,Integer> strMap1=new HashMap<Character,Integer>();
			HashMap<Character,Integer> strMap2=new HashMap<Character,Integer>();
			
			for(int i=0;i<str1.length();i++){
				Character c=str1.charAt(i);
				if(strMap1.get(str1.charAt(i))==null){
					strMap1.put(str1.charAt(i), 1);
				}else{
					strMap1.put(str1.charAt(i),strMap1.get(str1.charAt(i)+1));
				}		
			}
			
			
			for(int i=0;i<str2.length();i++){
				Character c=str2.charAt(i);
				if(strMap2.get(str2.charAt(i))==null){
					strMap2.put(str2.charAt(i),1);
				}else{
					strMap2.put(str2.charAt(i), strMap2.get(str2.charAt(i)+1));
				}
			}
			
			for(int i=0;i<str1.length();i++){
					Character tmp=str1.charAt(i);
					if(strMap2.get(tmp)==null){
						return false;
					}				
			}
			
			for(int i=0;i<str2.length();i++){
					Character tmp=str2.charAt(i);
					if(strMap1.get(tmp)==null){
						return false;
					}
			}
			
			}
			
			
			return true;
		}


2. Given a sorted (in increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.  




3. Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = {
S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.  

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So
output should be 4.

	int[] nums;
	public void findSum(int[] nums,int sum){
		this.nums=nums;
		combine(sum);
	}
	
	public void combine(int m){
		if(m<1) return;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		getCombination(m,arr);
	}
	
	public void getCombination(int m,ArrayList<Integer> arr){
		if(m==0 && arr.size()>=1){
			for(int tmp:arr)
			System.out.print(tmp+" ");
			
			System.out.println();
			return;
		}
		
		if(m<1) return;
		
		for(int i=0;i<nums.length;i++){
			if((!arr.isEmpty()) && nums[i]<arr.get(arr.size()-1))
			continue;
			
			arr.add(nums[i]);
			getCombination(m-nums[i],arr);
			
			if(!arr.isEmpty()){
				arr.remove(arr.size()-1);
			}
		}
	
	}

