package ok;

/*
 * https://leetcode.com/problems/add-binary/
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

public class Solution {
    public String addBinary(String a, String b) {
        
    }
}
 * 
 * 
 */
import java.util.*;

public class AddBinary {

	public static void main(String args[]){
		System.out.println(addBinary4("0","0"));
//		System.out.println('1'=='1');
//		System.out.println((byte)'1');		
		
		
//		System.out.println("110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011".length()-1);
		
	}
	
	
	
	//As I referenced to other people's code, I need to rewrite the code by myself:
	
	//--------------------------------------------------------------------------------------------------
	
	

public static String addBinary4(String a, String b){

		if (a == null && a.length() == 0)
			return b;
		if (b == null && b.length() == 0)
			return a;

		int currA = a.length() - 1;
		int currB = b.length() - 1;
		int flag = 0;
		StringBuilder sb = new StringBuilder();

		while (currA >= 0 || currB >= 0) {

			int va = 0;
			int vb = 0;

			if (currA >= 0) {
				va = a.charAt(currA) == '0' ? 0 : 1;
				currA--;
			}

			if (currB >= 0) {
				vb = b.charAt(currB) == '0' ? 0 : 1;
				currB--;
			}

			int sum = va + vb + flag;

			if (sum >= 2) {
				sb.append(sum - 2);
				flag = 1;
			} else {
				sb.append(sum);
				 flag=0;
			}

		}

		if (flag == 1) {
			sb.append("1");
		}

		return sb.reverse().toString();

}
	

	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	//	http://www.programcreek.com/2014/05/leetcode-add-binary-java/

	
	public static String addBinary3(String a, String b) {
		if (a == null && a.length() == 0) {
			return b;
		}

		if (b == null && b.length() == 0) {
			return a;
		}

		int currA = a.length() - 1;
		int currB = b.length() - 1;

		int flag = 0;
		StringBuilder sb = new StringBuilder();
		
		while (currA >= 0 || currB >= 0) {
			int va = 0;
			int vb = 0;
			if (currA >= 0) {
				va = a.charAt(currA) == '0' ? 0 : 1;
				currA--;
			}
			if (currB >= 0) {
				vb = b.charAt(currB) == '0' ? 0 : 1;
				currB--;
			}

			int sum = va + vb + flag;

			if (sum >= 2) {
				sb.append(String.valueOf(sum - 2));
				flag = 1;
			} else {
				flag = 0;
				sb.append(String.valueOf(sum));
			}

		}

		if (flag == 1) {
			sb.append("1");
		}

		String reversed = sb.reverse().toString();
		return reversed;
	}
	
	
	
	
	/*

System.out.println(Integer.toBinaryString(x) + "+" + Integer.toBinaryString(y)
         + "=" + Integer.toBinaryString(z));
//101+110=1011
 * 
 * 
 Convert binary string to a base 10 Integer
 ou need to specify the radix. There's an overload of Integer#parseInt() which allows you to.
 
 int foo = Integer.parseInt("1001", 2);
 * 
	 * 
	 * 
	 */
	
	
	/*
Runtime Error More Details 

Runtime Error Message:
Line 3: java.lang.NumberFormatException: For input string: "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
Last executed input:
"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"


110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011 = Math.pow(2,98);

	 * 
	 * It is not a common binary string, it is a very large number.
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String addBinary2(String a, String b) {
		
	  char[] achar=a.toCharArray();
	  char[] bchar=b.toCharArray();

	  
	  
	  int aleng=achar.length;
	  int bleng=bchar.length;
	  
	  char[] result=new char[Math.max(aleng, bleng)];  
	  
	  int minLeng=Math.min(aleng, bleng);
	  
	  
	  for(int i=0;i<minLeng;i++){
		  
		  if(achar[aleng-1-i]==bchar[bleng-1-i]&&achar[aleng-1-i]==1){
			  
			  // if it is already to the head of the array.
			  if(aleng-1-i==0){

				  char[] tmp=achar;
				  result=new char[aleng+1];
				  result[0]='1';
				  for(int j=1;j<result.length;j++){
					  result[j]=tmp[j-1];
				  }
	 
				  
			  }else{
				  
			  }
			  
			  
			  
		  }else{
			  
		  }
		  
		  
	  }
		
		
		
		return "";
	}
 
	public static String addBinary(String a, String b) {
		long aInt=Long.parseLong(a,2);
		long bInt=Integer.parseInt(b,2);
		
		LinkedList list=new LinkedList();

		return Long.toBinaryString(aInt+bInt);
	}
	
}
