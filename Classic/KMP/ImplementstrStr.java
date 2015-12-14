/*
https://leetcode.com/problems/implement-strstr/
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Solution {
    public int strStr(String haystack, String needle) {
        
    }
}


 * 
 */
public class ImplementstrStr {
	
	
	public static void main(String args[]){
		ImplementstrStr str=new ImplementstrStr();
		System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsfdsfds"));
	}







   public int strStr3(String str, String subStr) {
        // Input validation.
        if (str == null || subStr == null) return -1;
        if (str.length() < subStr.length()) return -1;

        if(subStr.equals("")&&str.equals("")) return 0;
        if(subStr.length()==0) return -1;
        

        // KMP.
        int firstMatchedIndex = KMP(str, subStr);

        // Return result.
        if (firstMatchedIndex < 0) return -1;
        else return firstMatchedIndex;
    }

    public int[] getNextArr(String strItself) {
    	
    	for(int i=0;i<strItself.length();i++){
    		System.out.print(i+" ");
    	}
    	System.out.println();
    	
    	for(Character c:strItself.toCharArray()){
    		System.out.print(c+" ");
    	}
    	System.out.println();
    	
        int strItself_len = strItself.length();

        int[] next = new int[strItself_len];
        next[0] = -1;

        int prefix_index = -1;
        int suffix_index = 0;

        while (suffix_index < strItself_len) {
            if (prefix_index == -1 || 
                strItself.charAt(prefix_index) == strItself.charAt(suffix_index)) {

                int numMatched_prefix_and_suffix = prefix_index + 1;

                if (suffix_index + 1 >= strItself_len) break;
                
                next[suffix_index + 1] = numMatched_prefix_and_suffix;
              if(prefix_index>=0){ 
              System.out.print("Prefix Index:"+prefix_index+" "+ strItself.charAt(prefix_index)+" Suffix_Index:"+suffix_index+" "+strItself.charAt(suffix_index)+" ");
              }else{
              System.out.print("Prefix Index:"+prefix_index+" "+ null +" Suffix_Index:"+suffix_index+" "+null+" ");
              }
              System.out.println("add next["+(suffix_index+1)+"]="+numMatched_prefix_and_suffix);

                prefix_index ++;
                suffix_index ++;

            } else {
                // Let next array guide use how to reset the prefix_index.
                prefix_index = next[prefix_index];

            }
        }

                for(int tmp:next)
        	System.out.print(tmp+" ");

       System.out.println();
       
        return next;
    }

          public int KMP(String str, String subStr) {
        int str_len = str.length();
        int subStr_len = subStr.length();

        int[] next = getNextArr(subStr);

        int str_start = 0;
        int subStr_start = 0;

        while (str_start < str_len && subStr_start < subStr_len) {
            // Since if the strItself_start = next[0], the strItself_start == -1,
            // so we need check whether strItself_start == -1,
            // if that we just keep move forward.
            if (subStr_start == -1 || str.charAt(str_start) == subStr.charAt(subStr_start)) {

                str_start ++;
                subStr_start ++;

            } else {
                // Let next array guide us how to reset the strItself_start.
            	subStr_start = next[subStr_start];

            }
        }

        if (subStr_start >= subStr_len) {
            // The current str_start is point to,
            // the end of the matched part in the str,
            // and we know the matched length is strItself_len,
            // so we use str_start - strItself_len to get,
            // the matched start point in str.
            return str_start - subStr_len;
        } else return -1;
    }





// for input:  		System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsfdsfds"));
 //   public int[] getNextArr(String strItself) :

0 1 2 3 4 5 6 7 8 9 10 
d s f d s f d s f d s 
Prefix Index:-1 null Suffix_Index:0 null add next[1]=0
Prefix Index:-1 null Suffix_Index:1 null add next[2]=0
Prefix Index:-1 null Suffix_Index:2 null add next[3]=0
Prefix Index:0 d Suffix_Index:3 d add next[4]=1
Prefix Index:1 s Suffix_Index:4 s add next[5]=2
Prefix Index:2 f Suffix_Index:5 f add next[6]=3
Prefix Index:3 d Suffix_Index:6 d add next[7]=4
Prefix Index:4 s Suffix_Index:7 s add next[8]=5
Prefix Index:5 f Suffix_Index:8 f add next[9]=6
Prefix Index:6 d Suffix_Index:9 d add next[10]=7
-1 0 0 0 1 2 3 4 5 6 7



// for input:  	System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsffff"));
 //   public int[] getNextArr(String strItself) :

0 1 2 3 4 5 6 7 8 
d s f d s f f f f 
Prefix Index:-1 null Suffix_Index:0 null add next[1]=0
Prefix Index:-1 null Suffix_Index:1 null add next[2]=0
Prefix Index:-1 null Suffix_Index:2 null add next[3]=0
Prefix Index:0 d Suffix_Index:3 d add next[4]=1
Prefix Index:1 s Suffix_Index:4 s add next[5]=2
Prefix Index:2 f Suffix_Index:5 f add next[6]=3
Prefix Index:-1 null Suffix_Index:6 null add next[7]=0
Prefix Index:-1 null Suffix_Index:7 null add next[8]=0
-1 0 0 0 1 2 3 0 0



// for input:  			System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "gdsfdsffff"));
 //   public int[] getNextArr(String strItself) :

0 1 2 3 4 5 6 7 8 9 
g d s f d s f f f f 
Prefix Index:-1 null Suffix_Index:0 null add next[1]=0
Prefix Index:-1 null Suffix_Index:1 null add next[2]=0
Prefix Index:-1 null Suffix_Index:2 null add next[3]=0
Prefix Index:-1 null Suffix_Index:3 null add next[4]=0
Prefix Index:-1 null Suffix_Index:4 null add next[5]=0
Prefix Index:-1 null Suffix_Index:5 null add next[6]=0
Prefix Index:-1 null Suffix_Index:6 null add next[7]=0
Prefix Index:-1 null Suffix_Index:7 null add next[8]=0
Prefix Index:-1 null Suffix_Index:8 null add next[9]=0
-1 0 0 0 0 0 0 0 0 0





	
    
/*
 * KMP   --- Below method is very good.
 * 
 * Accepted.
 */
	
	    public int strStr3(String haystack, String needle) {
	        // Input validation.
	        if (haystack == null || needle == null) return -1;
	        if (haystack.length() < needle.length()) return -1;
//	        if (needle.length() == 0) return haystack;
	        if(needle.equals("")&&haystack.equals("")) return 0;
	        if(needle.length()==0) return -1;
	        
//	        if(needle.length()==0) return 0; // according to leetcode: Input: "" "" Expect: 0

	        // KMP.
	        int firstMatchedIndex = KMP(haystack, needle);

	        // Return result.
	        if (firstMatchedIndex < 0) return -1;
//	        else return haystack.substring(firstMatchedIndex, haystack.length());
	        else return firstMatchedIndex;
	    }

	    public int[] getNextArr(String pat) {
	        int pat_len = pat.length();

	        int[] next = new int[pat_len];
	        next[0] = -1;

	        int prefix_index = -1;
	        int suffix_index = 0;

	        while (suffix_index < pat_len) {
	            if (prefix_index == -1 || 
	                pat.charAt(prefix_index) == pat.charAt(suffix_index)) {

	                int numMatched_prefix_and_suffix = prefix_index + 1;

	                if (suffix_index + 1 >= pat_len) break;
	                next[suffix_index + 1] = numMatched_prefix_and_suffix;

	                prefix_index ++;
	                suffix_index ++;

	            } else {
	                // Let next array guide use how to reset the prefix_index.
	                prefix_index = next[prefix_index];

	            }
	        }

	        return next;
	    }

	    public int KMP(String str, String pat) {
	        int str_len = str.length();
	        int pat_len = pat.length();

	        int[] next = getNextArr(pat);

	        int str_start = 0;
	        int pat_start = 0;

	        while (str_start < str_len && pat_start < pat_len) {
	            // Since if the pat_start = next[0], the pat_start == -1,
	            // so we need check whether pat_start == -1,
	            // if that we just keep move forward.
	            if (pat_start == -1 || str.charAt(str_start) == pat.charAt(pat_start)) {

	                str_start ++;
	                pat_start ++;

	            } else {
	                // Let next array guide us how to reset the pat_start.
	                pat_start = next[pat_start];

	            }
	        }

	        if (pat_start >= pat_len) {
	            // The current str_start is point to,
	            // the end of the matched part in the str,
	            // and we know the matched length is pat_len,
	            // so we use str_start - pat_len to get,
	            // the matched start point in str.
	            return str_start - pat_len;
	        } else return -1;
	    }
 
 
	    
	    
	    
	    
	    
	/*
	 * KMP
	 * 
	 * Accepted.
	 */
	
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
 
	            		System.out.print(needle.charAt(k)+" ");

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
	
	
	
	/*
	 * Accepted.
	 * 
	 * 
	 */
    public int strStr(String source, String target) {
        
    	if(source==null||target==null) return -1;
    	
    	for(int i=0;i<source.length()-target.length()+1;i++){
    		int j=0;
    		for(j=0;j<target.length();j++){
    			if(source.charAt(i+j)!=target.charAt(j)){
    				break;
    			}
    		}	
    			if(j==target.length()){
    				return i;
    			}

    	}	
    	return -1;
    }
/*
 * 
 * Other solution:
 * http://zjalgorithm.blogspot.sg/2014/12/leetcode-in-java-implement-strstr.html
 * 
 */

}
