import java.util.Arrays;

/*
https://leetcode.com/problems/first-bad-version/


You are a product manager and currently leading a team to develop a new product. Unfortunately, 
the latest version of your product fails the quality check. Since each version is developed based on 
the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes 
all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement 
a function to find the first bad version. You should minimize the number of calls to the API.


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);  

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
    }
}
 * 
 * 
 */

public class FirstBadVersion {

	boolean[] bad = { false, true, true, true, true,true };
	int currOffset = 0;

	public static void main(String args[]) {
		FirstBadVersion fb = new FirstBadVersion();
		System.out.println(fb.firstBadVersion3(2147483647));
		
		System.out.println(Math.pow(2, 31)-1);
 
		
	}

	
	/*
	 * To avoid the overflow caused by n+1,
	 * I set the index begin from 0.
	 * 
	 * Accepted.
	 * 
	 */
	public int firstBadVersion3(int n) {
		int beginIndex = 0;
		// int endIndex=n; //add 1 to this number.
		int endIndex = n;
		int previousCurr = -1;
		
		
		int current = beginIndex + (endIndex - beginIndex) / 2;
		// int count=0;

		for (; beginIndex <= endIndex; current = beginIndex + (endIndex - beginIndex) / 2) {
			// count++;
			// if(count==10) break;
			System.out.println("before:" + beginIndex + " " + current + " " + endIndex + " offset "
					+ (endIndex - beginIndex) / 2 + " ??" + previousCurr);
			
			if (previousCurr == current){
				
				if(isBadVersion(previousCurr)){
					return previousCurr;
				}else if(isBadVersion(endIndex)){
				   	return endIndex;
				}
				
				break;
			}
			previousCurr = current;

			System.out.println(
					beginIndex + " " + current + " " + endIndex + " offset " + (endIndex - beginIndex) / 2+" isBadVersion:"+current+" "+isBadVersion(current));
			
			if (isBadVersion(current)) {
				endIndex = current;
			} else {
				beginIndex = current;
			}
		}
		return current;
	}
	
	
	//in order to test the 2147483647, I modified the below method:
	public boolean isBadVersion(int curr) {
		if(curr!=Math.pow(2, 31)-1) return false;
		else 
			return true;
//		return bad[curr];
	}
	
	
	
	/*
	 * 
	 * Status: Wrong Answer Submitted: 0 minutes ago Input: 4 versions 1 is the
	 * first bad version. Output: 2 Expected: 1

Input:
2147483647 versions
2147483647 is the first bad version.
Output:
1073741824
Expected:
2147483647

Integer maximum value: 2,147,483,647

Reason:  n=2147483647, it is the maximum value of Integer, in the below code, I used n+1===> this one will cause overflow.

		System.out.println(Math.pow(2, 31)-1);   // output:2.147483647E9

	 * 
	 * 
	 */
//
//	public int firstBadVersion2(int n) {
//		int beginIndex = 1;
//		// int endIndex=n; //add 1 to this number.
//		int endIndex = n + 1;
//		int previousCurr = -1;
//		
//		
//		int current = beginIndex + (endIndex - beginIndex) / 2;
//		// int count=0;
//
//		for (; beginIndex <= endIndex; current = beginIndex + (endIndex - beginIndex) / 2) {
//			// count++;
//			// if(count==10) break;
//			System.out.println("before:" + beginIndex + " " + current + " " + endIndex + " offset "
//					+ (endIndex - beginIndex) / 2 + " ??" + previousCurr);
//			
//			if (previousCurr == current){
//				
//				if(isBadVersion(previousCurr)){
//					return previousCurr;
//				}else if(isBadVersion(endIndex)){
//				   	return endIndex;
//				}
//				
//				break;
//			}
//			previousCurr = current;
//
//			System.out.println(
//					beginIndex + " " + current + " " + endIndex + " offset " + (endIndex - beginIndex) / 2+" isBadVersion:"+current+" "+isBadVersion(current));
//			
//			if (isBadVersion(current)) {
//				endIndex = current;
//			} else {
//				beginIndex = current;
//			}
//		}
//		return current;
//	}

	// public int firstBadVersion2(int n){
	//
	// int beginIndex=1;
	//// int endIndex=n; //add 1 to this number.
	// int endIndex=n+1;
	// int current=n/2;
	// int previousCurr=-1;
	//// int count=0;
	//
	// for(;beginIndex<=endIndex;current=beginIndex+(endIndex-beginIndex)/2){
	//// count++;
	//// if(count==10) break;
	// System.out.println(beginIndex+" "+current+" "+endIndex+" offset
	// "+(endIndex-beginIndex)/2 +" ??"+previousCurr);
	// if(previousCurr==current) break;
	//
	// previousCurr=current;
	//
	// System.out.println(beginIndex+" "+current+" "+endIndex+" offset
	// "+(endIndex-beginIndex)/2);
	// if(!isBadVersion(current)) {
	// endIndex=current+1;
	// }else{
	// beginIndex=current;
	// }
	//
	//
	// }
	//
	// return current;
	// }

	/*
	 * This one we need to use the Binary Search.
	 */

	/*
	 * 
	 * isBadVersion() always false;
	 * 
	 * 1 50 100offset 49 1 25 50offset 24 1 13 25offset 12 1 7 13offset 6 1 4
	 * 7offset 3 1 2 4offset 1 1 1 2offset 0 1 1 1offset 0 1 1 1offset 0
	 * 
	 * 
	 * 
	 * 
	 * 
	 * isBadVersion() always true;
	 * 
	 * 1 50 100offset 49 50 75 100offset 25 75 87 100offset 12 87 93 100offset 6
	 * 93 96 100offset 3 96 98 100offset 2 98 99 100offset 1 99 99 100offset 0
	 * 99 99 100offset 0
	 * 
	 * We can see it cannot reach the 100, we can add one extra number to
	 * endIndex by using below sentence: int endIndex=n+1;
	 * 
	 * Reason: As the beginIndex from 1 (in this case, we need to make sure it
	 * is begin from 1 rather than 0).
	 * 
	 * 
	 */

	/*
	 * 
	 * Status: Wrong Answer Submitted: 0 minutes ago Input: 4 versions 1 is the
	 * first bad version. Output: 2 Expected: 1
	 * 
	 */
//	public int firstBadVersion(int n) {
//
//		int beginIndex = 1;
//		// int endIndex=n; //add 1 to this number.
//		int endIndex = n + 1;
//		int current = n / 2;
//		int previousCurr = -1;
//		// int count=0;
//
//		for (; beginIndex <= endIndex; current = beginIndex + (endIndex - beginIndex) / 2) {
//			// count++;
//			// if(count==10) break;
//			// System.out.println(beginIndex+" "+current+" "+endIndex+" offset
//			// "+(endIndex-beginIndex)/2 +" ??"+previousCurr);
//			if (previousCurr == current)
//				break;
//
//			previousCurr = current;
//
//			// System.out.println(beginIndex+" "+current+" "+endIndex+" offset
//			// "+(endIndex-beginIndex)/2);
//			if (isBadVersion(current)) {
//				endIndex = current + 1;
//			} else {
//				beginIndex = current;
//			}
//
//		}
//
//		return current;
//	}

//	public boolean isBadVersion(int curr) {
//
//		return bad[curr];
//	}

}
