
public class DebugKMP {

	
	public static void main(String args[]){
		DebugKMP str=new DebugKMP();
		System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsffff"));
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

 /*


// for input:       System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsfdsfds"));
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



// for input:   System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "dsfdsffff"));
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



// for input:           System.out.println(str.strStr3("adffdsfdsfdsfdsfdsfdsfd", "gdsfdsffff"));
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

 */
	
}
