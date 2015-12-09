# 动态规划

http://www.programgo.com/article/34132878160/

	/**
	 * 将一个数组内元素的所有组合输出
	 * 思路：递归
	 * 循环内每次按序从剩余数组中取出一个元素，和已经输出的部分合成
	 */

	package t7_1;
	import java.util.*;
	import java.io.*;
	public class Test7_1 {
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String[] array = new String[]{
					"1", "2", "3", "4"
			};
			listAll(Arrays.asList(array)," ");
			
		}
		
		public static void listAll(List<String> candidate, String prefix){
			System.out.println(prefix);
			
			for(int i=0; i<candidate.size(); i++){
				List<String> temp = new LinkedList<String>(candidate);//new LinkedList<String>(candidate)---copy candidate
				listAll(temp, prefix+temp.remove(i));
			}
		}
	
	}


	output:
	
	 
	 1
	 12
	 123
	 1234
	 124
	 1243
	 13
	 132
	 1324
	 134
	 1342
	 14
	 142
	 1423
	 143
	 1432
	 2
	 21
	 213
	 2134
	 214
	 2143
	 23
	 231
	 2314
	 234
	 2341
	 24
	 241
	 2413
	 243
	 2431
	 3
	 31
	 312
	 3124
	 314
	 3142
	 32
	 321
	 3214
	 324
	 3241
	 34
	 341
	 3412
	 342
	 3421
	 4
	 41
	 412
	 4123
	 413
	 4132
	 42
	 421
	 4213
	 423
	 4231
	 43
	 431
	 4312
	 432
	 4321
