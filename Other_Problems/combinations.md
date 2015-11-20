##Combinations

http://stackoverflow.com/a/23718676

There is already plenty of good solutions here, but I would like to share how I solved this problem on my own and hope that this might be helpful for somebody who would also like to derive his own solution.

After some pondering about the problem I have come up with two following conclusions:

For the list L of size n there will be equal number of solutions starting with L1, L2 ... Ln elements of the list. Since in total there are n! permutations of the list of size n, we get n! / n = (n-1)! permutations in each group.
The list of 2 elements has only 2 permutations => [a,b] and [b,a].
Using these two simple ideas I have derived the following algorithm:

permute array
    if array is of size 2
       return first and second element as new array
       return second and first element as new array
    else
        for each element in array
            new subarray = array with excluded element
            return element + permute subarray
Here is how I implemented this in C#:

	public IEnumerable<List<T>> Permutate<T>(List<T> input)
	{
	    if (input.Count == 2) // this are permutations of array of size 2
	    {
	        yield return new List<T>(input);
	        yield return new List<T> {input[1], input[0]}; 
	    }
	    else
	    {
	        foreach(T elem in input) // going through array
	        {
	            var rlist = new List<T>(input); // creating subarray = array
	            rlist.Remove(elem); // removing element
	            foreach(List<T> retlist in Permutate(rlist))
	            {
	                retlist.Insert(0,elem); // inserting the element at pos 0
	                yield return retlist;
	            }
	
	        }
	    }
	}

## Generating all permutations of a given string

http://www.ericleschinski.com/c/java_permutations_recursion/

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
====> Modified: 	
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
 
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++){
	        	System.out.println(prefix +" || "+ str.charAt(i)+" || "+ str.substring(0, i)+ " || "+ str.substring(i+1, n));
	        	
	        	
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	

	        	System.out.println(prefix +" || "+ str.charAt(i)+" || "+ str.substring(0, i)+ " || "+ str.substring(i+1, n));

	  || a ||  || bc
	a || b ||  || c
	ab || c ||  || 
	abc
	a || c || b || 
	ac || b ||  || 
	acb
	 || b || a || c
	b || a ||  || c
	ba || c ||  || 
	bac
	b || c || a || 
	bc || a ||  || 
	bca
	 || c || ab || 
	c || a ||  || b
	ca || b ||  || 
	cab
	c || b || a || 
	cb || a ||  || 
	cba

	
	
	System.out.println(prefix +""+ str.charAt(i)+" || "+ str.substring(0, i)+ ""+ str.substring(i+1, n));
	        	

	a || bc
	ab || c
	abc || 
	abc
	ac || b
	acb || 
	acb
	b || ac
	ba || c
	bac || 
	bac
	bc || a
	bca || 
	bca
	c || ab
	ca || b
	cab || 
	cab
	cb || a
	cba || 
	cba

	
	
		
 	substring(a,b);     ===>  [a,b);            a=<x<b





    /**
     * Returns a new string that is a substring of this string. The
     * substring begins at the specified <code>beginIndex</code> and
     * extends to the character at index <code>endIndex - 1</code>.
     * Thus the length of the substring is <code>endIndex-beginIndex</code>.
     * <p>
     * Examples:
     * <blockquote><pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * </pre></blockquote>
     *
     * @param      beginIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @return     the specified substring.
     * @exception  IndexOutOfBoundsException  if the
     *             <code>beginIndex</code> is negative, or
     *             <code>endIndex</code> is larger than the length of
     *             this <code>String</code> object, or
     *             <code>beginIndex</code> is larger than
     *             <code>endIndex</code>.
 
    public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > value.length) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        int subLen = endIndex - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return ((beginIndex == 0) && (endIndex == value.length)) ? this
                : new String(value, beginIndex, subLen);
    }

	
	
	
##Using set to filter repeated strings.

http://stackoverflow.com/a/20614037

		public static Set<String> generatePerm(String input)
	{
	    Set<String> set = new HashSet<String>();
	    if (input == "")
	        return set;
	
	    Character a = input.charAt(0);
	
	    if (input.length() > 1)
	    {
	        input = input.substring(1);
	
	        Set<String> permSet = generatePerm(input);
	
	        for (String x : permSet)
	        {
	            for (int i = 0; i <= x.length(); i++)
	            {
	                set.add(x.substring(0, i) + a + x.substring(i));
	            }
	        }
	    }
	    else
	    {
	        set.add(a + "");
	    }
	    return set;
	}
	
## Without using recursion

http://stackoverflow.com/a/16753163

Let's use input abc as an example.
	
Start off with just the last element (c) in a set (["c"]), then add the second last element (b) to its front, end and every possible positions in the middle, making it ["bc", "cb"] and then in the same manner it will add the next element from the back (a) to each string in the set making it:
	
"a" + "bc" = ["abc", "bac", "bca"]  and  "a" + "cb" = ["acb" ,"cab", "cba"] 
Thus entire permutation:
	
["abc", "bac", "bca","acb" ,"cab", "cba"]
	
	Code:
	
	public class Test 
	{
	    static Set<String> permutations;
	    static Set<String> result = new HashSet<String>();
	
	    public static Set<String> permutation(String string) {
	        permutations = new HashSet<String>();
	
	        int n = string.length();
	        for (int i = n - 1; i >= 0; i--) 
	        {
	            shuffle(string.charAt(i));
	        }
	        return permutations;
	    }
	
	    private static void shuffle(char c) {
	        if (permutations.size() == 0) {
	            permutations.add(String.valueOf(c));
	        } else {
	            Iterator<String> it = permutations.iterator();
	            for (int i = 0; i < permutations.size(); i++) {
	
	                String temp1;
	                for (; it.hasNext();) {
	                    temp1 = it.next();
	                    for (int k = 0; k < temp1.length() + 1; k += 1) {
	                        StringBuilder sb = new StringBuilder(temp1);
	
	                        sb.insert(k, c);
	
	                        result.add(sb.toString());
	                    }
	                }
	            }
	            permutations = result;
	            //'result' has to be refreshed so that in next run it doesn't contain stale values.
	            result = new HashSet<String>();
	        }
	    }
	
	    public static void main(String[] args) {
	        Set<String> result = permutation("abc");
	
	        System.out.println("\nThere are total of " + result.size() + " permutations:");
	        Iterator<String> it = result.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }
	    }
	}