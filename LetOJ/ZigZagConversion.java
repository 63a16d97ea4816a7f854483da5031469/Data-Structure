/*
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


public class Solution {
    public String convert(String s, int numRows) {
        
    }
}

 * 
 */
public class ZigZagConversion {

	public static void main(String args[]) {
		ZigZagConversion my = new ZigZagConversion();
		System.out.println(my.convert3("PAYPALISHIRING", 3));
	}
	
	
	/*
	 * 这是一个找规律题目，要学会对问题的表示和分类方法。
	 * 
	 * 
	 */
	
	//http://www.cnblogs.com/springfor/p/3889414.html
	public String convert3(String s, int nRows) {  
        if(s == null || s.length()==0 || nRows <=0)  
            return "";  
        if(nRows == 1)  
            return s;
            
        StringBuilder res = new StringBuilder();  
        int size = 2*nRows-2;  
        for(int i=0;i<nRows;i++){  
            for(int j=i;j<s.length();j+=size){  
                res.append(s.charAt(j));
                
                if(i != 0 && i != nRows - 1){//except the first row and the last row
                    int temp = j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }                  
        }  
        return res.toString();  
    }
	
	
	// Misunderstood the questions.
	public String convert2(String text, int nRows) {
		// input validation
		if (text == null || nRows <= 0)
			return "";

		if (text.length() / (nRows + 1) == 0) {
			return text;
		}

		// Implement the main function
		int text_len = text.length();
		int arr_len = 0;
		if (text_len % (nRows + 1) == 0)
			arr_len = text.length() / (nRows + 1) * 2;
		else
			arr_len = (text.length() / (nRows + 1) + 1) * 2;

		Character[][] nums = new Character[arr_len][nRows];

		int x = 0;
		int y = 0;
		for (int i = 0; i < text_len; i++) {
			if (y != 0 && y % nRows == 0) {
				x++;
					
					nums[x][nRows / 2] = text.charAt(i);

				x++;
				y = 0;
			} else {
				nums[x][y] = text.charAt(i);
				y++;
			}

		}

		 
		
		String str = "";
		
		int y2 = 0;
		int x2 = 0;
		while (y2 < nRows) {
			if (nums[x2][y2] != null)
				str += nums[x2][y2];
			System.out.print(nums[x2][y2] + " ");
			if (x2 < arr_len - 1) {
				x2++;
			} else {
				System.out.println();
				x2 = 0;
				y2++;
			}
		}

		return str;
	}
 

}
