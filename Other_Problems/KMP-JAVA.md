##KMP
https://longwayjade.wordpress.com/2015/05/29/leetcode-two-pointers-kmp-rolling-hash-implement-strstr/

[LeetCode] -*** Two pointers / KMP / Rolling hash – Implement strStr()
 	
 	public int strStr(String haystack, String needle) {

        int i = 0;
        int hlength = haystack.length();
        int nlength = needle.length();

        if (nlength == 0) {
            return 0;
        } else {
            //get the prefix values for string: needle.
            int[] form = KMPform(needle);

            while (i <= hlength - nlength) {
                int j = 0;
                while (j < nlength) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        if (j == 0) {
                            i++;
                        } else {
                            i = i + j - form[j - 1] - 1;
                        }
                        break;
                    } else if (j == nlength - 1) {
                        return i;
                    }
                    j++;
                }
            }

            return -1;
        }
    }

    public int[] KMPform(String str) {
        int[] form = new int[str.length()];
        form[0] = -1;
        for (int i = 1; i < form.length; i++) {
            int index = form[i - 1];
            while (index >= 0 && str.charAt(i) != str.charAt(index + 1))
            {
                index = form[index];
            }
            if (str.charAt(i) == str.charAt(index + 1))
            {
                form[i] = index + 1;
            }
            else
            {
                form[i] = -1;
            }
        }
        return form;
    }
    
    
##modify the code:

 public int strStr2(String haystack, String needle) {

	        int i = 0;
	        int hlength = haystack.length();
	        int nlength = needle.length();

	        if (nlength == 0) {
	            return 0;
	        } else {
	            //get the prefix values for string: needle.
	            int[] form = KMPform(needle);
	            
	            
	            
	            for(int k=0;k<needle.length();k++){
	            	if(k!=0){
	            		System.out.print(haystack.charAt(k)+" ");
	            	}
	            }
	            
	            System.out.println();
	            for(int tmp:form)
	            System.out.print(tmp+" ");
	            System.out.println();

	            while (i <= hlength - nlength) {
	                int j = 0;
	                while (j < nlength) {
	                    if (haystack.charAt(i + j) != needle.charAt(j)) {
	                        if (j == 0) {
	                            i++;
	                        } else {
	                            i = i + j - form[j - 1] - 1;
	                        }
	                        break;
	                    } else if (j == nlength - 1) {
	                        return i;
	                    }
	                    j++;
	                }
	            }

	            return -1;
	        }
	    }

	    public int[] KMPform(String str) {
	        int[] form = new int[str.length()];
	        form[0] = -1;
	        for (int i = 1; i < form.length; i++) {
	            int index = form[i - 1];
	            while (index >= 0 && str.charAt(i) != str.charAt(index + 1))
	            {
	                index = form[index];
	            }
	            if (str.charAt(i) == str.charAt(index + 1))
	            {
	                form[i] = index + 1;
	            }
	            else
	            {
	                form[i] = -1;
	            }
	        }
	        return form;
	    }
	    

	public static void main(String args[]){
			ImplementstrStr str=new ImplementstrStr();
			System.out.println(str.strStr2("adffdsfdsfdsfds", "dsfdsfdsfds"));
		}
		
adffdsfdsfdsfds
			        
 d  s  f d s f d s f d s 
-1 -1 -1 0 1 2 3 4 5 6 7 
4


		System.out.println(str.strStr2("IloveComputerScience", "Science"));
		
IloveComputerScience

 S  c  i  e  n  c  e 
-1 -1 -1 -1 -1 -1 -1 
13
