##KMP solution 2:
		
		    public int strStr3(String haystack, String needle) {
		        // Input validation.
		        if (haystack == null || needle == null) return -1;
		        if (haystack.length() < needle.length()) return -1;
	//	        if (needle.length() == 0) return haystack;
		        if(needle.length()==0) return -1;
	
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
	 
		