 
//https://leetcode.com/problems/reverse-bits/



/*
 * 
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
10100101000001111010011100																													  
0100101000001111010011100

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
    }
}


100   -->001       index+2%3

101 ---> 101        
12345678   87654321     (index+k)%length    (7+1)%8     (6+x)%8=2


Remember:    String --->  str.length();
			 Array---> arr.length;

 * 
 */
public class ReverseBits {
	
	public static void main(String args[]){
		ReverseBits bit=new ReverseBits();
		System.out.println("10000000000000000000000000000000".length());
		System.out.println(Integer.toBinaryString(bit.reverse1(1)));
	}
	
	
/*
 * After accepted, I searched online to see whether there are better solution:
 * 	http://articles.leetcode.com/2011/08/reverse-bits.html
 * 	Therefore, only a total of log(n) operations are necessary.
 */

	public int reverse2(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
	 
		return n;
	}
	 
	public int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
	 
		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}
	 
		return n;
	}
	

	
	/*
	 * 
	 * Accepted.
	 * 
	 * Used the long first and used (int) to cast the value. So it will not cause exception.
	 * 
	 */
	public int reverse3(int n){
		
		// Convert the n to be 32 bits Binary number.
		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));
		nb.reverse();
		// for(int i=0;i<32-nb.length();i++){ ===> this is wrong. as nb.length
		// is changing. Be careful!!!!!!!!
		int tmpN = 32 - nb.length();
		for (int i = 0; i < tmpN; i++) {
			nb.append("0");
		}
		nb = nb.reverse();
		System.out.println(nb.toString());
 
		char[] nbchar=nb.toString().toCharArray();
		int head=0;
		int end=nb.length()-1;
		
		/*
		 *   replace(old char,new char) this one will 
		 *   replace all the old char to new char.
		nbstr=nbstr.replace(nbstr.charAt(end), nbstr.charAt(head));
		nbstr=nbstr.replace(nbstr.charAt(head), tmp);
		 */
		
	while(head<end){
		char tmp=nbchar[end];
		nbchar[end]=nbchar[head];
		nbchar[head]=tmp;
 
		head++;
		end--;
	}
	
	System.out.println("final:"+String.valueOf(nbchar));
	
	return (int)Long.parseLong(String.valueOf(nbchar),2);  //Used the long first and used (int) to cast the value. So it will not cause exception.
 
	}

	
	
	
	/*
Runtime Error Message:
Line 33: java.lang.NumberFormatException: For input string: "10000000000000000000000000000000"
Last executed input:
           1 (00000000000000000000000000000001)
 
	 * 
	 * 
	 */
 
	public int reverse1(int n){
	
		// Convert the n to be 32 bits Binary number.
		StringBuilder nb = new StringBuilder(Integer.toBinaryString(n));
		nb.reverse();
		// for(int i=0;i<32-nb.length();i++){ ===> this is wrong. as nb.length
		// is changing. Be careful!!!!!!!!
		int tmpN = 32 - nb.length();
		for (int i = 0; i < tmpN; i++) {
			nb.append("0");
		}
		nb = nb.reverse();
		System.out.println(nb.toString());
 
		char[] nbchar=nb.toString().toCharArray();
		int head=0;
		int end=nb.length()-1;
		
		/*
		 *   replace(old char,new char) this one will 
		 *   replace all the old char to new char.
		nbstr=nbstr.replace(nbstr.charAt(end), nbstr.charAt(head));
		nbstr=nbstr.replace(nbstr.charAt(head), tmp);
		 */
		
	while(head<end){
		char tmp=nbchar[end];
		nbchar[end]=nbchar[head];
		nbchar[head]=tmp;
 
		head++;
		end--;
	}
	
	System.out.println("final:"+String.valueOf(nbchar));
	
	return Integer.parseInt(String.valueOf(nbchar),2);   // this sentence causes the exception.  as it is 10000000000000000000000000000000. Integer.parseInt do not accept this value.

	}

}










































