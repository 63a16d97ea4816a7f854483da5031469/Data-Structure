# Record Technical Detail for JAVA

http://www.tutorialspoint.com/codingground.htm


http://www.runoob.com/java/java-generics.html



##difference between HashMap and Hashtable(not "T" it is "t"):

java.util.Hashtable
java.util.HashMap

<img src="./Screenshots/HashTable_HashMap.png">


#Difference Between Iterator And Enumeration 
http://javahungry.blogspot.com/2013/06/difference-between-iterator-and-enumeration-collections-java-interview-question-with-example.html

The most common interview question in Collections is What is the difference between iterator and enumeration.

Iterator

Iterator is the interface and found in the java.util package.
It has three methods

*hasNext()
*next()
*remove()

Enumeration

Enumeration is also an interface and found in the java.util package .
An enumeration is an object that generates elements one at a time. It is used for passing through a collection, usually of unknown size.
The traversing of elements can only be done once per creation.
It has following methods

*hasMoreElements()
*nextElement()

An iterator over a collection. Iterator takes the place of Enumeration in the Java collections framework.

Iterators differ from enumerations in two ways:

Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
Method names have been improved.


**Why not use for(int i=0; i< v.size();i++){}?**

For loops are expensive to the processor when the collection reaches large sizes, as many operations are done just to compute the first line:


int i = 0 is an assignment and creation (2 operations)
i get size, check value of i, and compare (3 operations)
i++ gets i then adds 1 to it [++i is only 2 operations] this one (3 operations)
*7/8 operations in total, each time the loop runs through

where an enumeration or iterator uses a while(){}
while(v.hasNext()) has next true or false (1 operation)
while(v.hasMoreElements()) has more true or false (1 operation)
*Only one operation per repeat of this loop





##Eclipse color theme plugin:
http://eclipsecolorthemes.org/?view=plugin

If you are on Eclipse 3.5 (Galileo), go to Help→Install New Software..., press Add Site and enter Eclipse Color Theme as the name and http://eclipse-color-theme.github.com/update as the URL. Then select the new entry from the select box labeled Work with, mark Eclipse Color Theme for installation and proceed.  

Usage  
After the installation, go to Window→Preferences→General→Appereance→Color Theme to change the color theme.

##ASCII table: 

http://mindprod.com/jgloss/ascii.html
ASCII and Latin-1 Character Table

	Char	Dec	Hex	Octal	HTML	Notes
	0	48	0x30	0060	0	digit 0
	1	49	0x31	0061	1	digit 1
	2	50	0x32	0062	2	digit 2
	3	51	0x33	0063	3	digit 3
	4	52	0x34	0064	4	digit 4
	5	53	0x35	0065	5	digit 5
	6	54	0x36	0066	6	digit 6
	7	55	0x37	0067	7	digit 7
	8	56	0x38	0070	8	digit 8
	9	57	0x39	0071	9	digit 9
	
	A	65	0x41	0101	A	upper case A
	B	66	0x42	0102	B	upper case B
	C	67	0x43	0103	C	upper case C
	D	68	0x44	0104	D	upper case D
	E	69	0x45	0105	E	upper case E
	F	70	0x46	0106	F	upper case F
	G	71	0x47	0107	G	upper case G
	H	72	0x48	0110	H	upper case H
	I	73	0x49	0111	I	upper case I
	J	74	0x4a	0112	J	upper case J
	K	75	0x4b	0113	K	upper case K
	L	76	0x4c	0114	L	upper case L
	M	77	0x4d	0115	M	upper case M
	N	78	0x4e	0116	N	upper case N
	O	79	0x4f	0117	O	upper case O
	P	80	0x50	0120	P	upper case P
	Q	81	0x51	0121	Q	upper case Q
	R	82	0x52	0122	R	upper case R
	S	83	0x53	0123	S	upper case S
	T	84	0x54	0124	T	upper case T
	U	85	0x55	0125	U	upper case U
	V	86	0x56	0126	V	upper case V
	W	87	0x57	0127	W	upper case W
	X	88	0x58	0130	X	upper case X
	Y	89	0x59	0131	Y	upper case Y
	Z	90	0x5a	0132	Z	upper case Z
	a	97	0x61	0141	a	lower case a
	b	98	0x62	0142	b	lower case b
	c	99	0x63	0143	c	lower case c
	d	100	0x64	0144	d	lower case d
	e	101	0x65	0145	e	lower case e
	f	102	0x66	0146	f	lower case f
	g	103	0x67	0147	g	lower case g
	h	104	0x68	0150	h	lower case h
	i	105	0x69	0151	i	lower case i
	j	106	0x6a	0152	j	lower case j
	k	107	0x6b	0153	k	lower case k
	l	108	0x6c	0154	l	lower case l
	m	109	0x6d	0155	m	lower case m
	n	110	0x6e	0156	n	lower case n
	o	111	0x6f	0157	o	lower case o
	p	112	0x70	0160	p	lower case p
	q	113	0x71	0161	q	lower case q
	r	114	0x72	0162	r	lower case r
	s	115	0x73	0163	s	lower case s
	t	116	0x74	0164	t	lower case t
	u	117	0x75	0165	u	lower case u
	v	118	0x76	0166	v	lower case v
	w	119	0x77	0167	w	lower case w
	x	120	0x78	0170	x	lower case x
	y	121	0x79	0171	y	lower case y
	z	122	0x7a	0172	z	lower case z

System.out.println((char)'1');  
System.out.println((byte)'1');  

Output:		
1  
49  


## Convert the Binary String to Integer

		String aa = "11";
		String bb="10";
		System.out.println(Integer.parseInt(aa,2)+Integer.parseInt(bb,2));

The definition of the function:

    /**
     * Parses the string argument as a signed integer in the radix
     * specified by the second argument. The characters in the string
     * must all be digits of the specified radix (as determined by
     * whether {@link java.lang.Character#digit(char, int)} returns a
     * nonnegative value), except that the first character may be an
     * ASCII minus sign {@code '-'} (<code>'&#92;u002D'</code>) to
     * indicate a negative value or an ASCII plus sign {@code '+'}
     * (<code>'&#92;u002B'</code>) to indicate a positive value. The
     * resulting integer value is returned.
     *
     * <p>An exception of type {@code NumberFormatException} is
     * thrown if any of the following situations occurs:
     * <ul>
     * <li>The first argument is {@code null} or is a string of
     * length zero.
     *
     * <li>The radix is either smaller than
     * {@link java.lang.Character#MIN_RADIX} or
     * larger than {@link java.lang.Character#MAX_RADIX}.
     *
     * <li>Any character of the string is not a digit of the specified
     * radix, except that the first character may be a minus sign
     * {@code '-'} (<code>'&#92;u002D'</code>) or plus sign
     * {@code '+'} (<code>'&#92;u002B'</code>) provided that the
     * string is longer than length 1.
     *
     * <li>The value represented by the string is not a value of type
     * {@code int}.
     * </ul>
     *
     * <p>Examples:
     * <blockquote><pre>
     * parseInt("0", 10) returns 0
     * parseInt("473", 10) returns 473
     * parseInt("+42", 10) returns 42
     * parseInt("-0", 10) returns 0
     * parseInt("-FF", 16) returns -255
     * parseInt("1100110", 2) returns 102
     * parseInt("2147483647", 10) returns 2147483647
     * parseInt("-2147483648", 10) returns -2147483648
     * parseInt("2147483648", 10) throws a NumberFormatException
     * parseInt("99", 8) throws a NumberFormatException
     * parseInt("Kona", 10) throws a NumberFormatException
     * parseInt("Kona", 27) returns 411787
     * </pre></blockquote>
     *
     * @param      s   the {@code String} containing the integer
     *                  representation to be parsed
     * @param      radix   the radix to be used while parsing {@code s}.
     * @return     the integer represented by the string argument in the
     *             specified radix.
     * @exception  NumberFormatException if the {@code String}
     *             does not contain a parsable {@code int}.
     */
    public static int parseInt(String s, int radix)
                throws NumberFormatException
    {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                                            " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                                            " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw NumberFormatException.forInputString(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw NumberFormatException.forInputString(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    throw NumberFormatException.forInputString(s);
                }
                if (result < multmin) {
                    throw NumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw NumberFormatException.forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
    }

## Math equation about finding the start point of circle 

http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/


There are two pointers:

A slow pointer that moves one node at a time.
A fast pointer that moves two nodes at a time.
If the two pointer meet, it proves that there is a loop. Once they have met, one of the nodes will point to the head and then have both proceed one node at a time. They will meet at the start of the loop.

![drawing](https://github.com/63a16d97ea4816a7f854483da5031469/Data-Structure/blob/master/Screenshots/LoopStartNode1.png)


![drawing](https://github.com/63a16d97ea4816a7f854483da5031469/Data-Structure/blob/master/Screenshots/LoopStartNode2.png)



## CompareTo return result
    public int compareTo(BigDecimal val) {} 
@return -1, 0, or 1 as this {@code BigDecimal} is numerically less than, equal to, or greater than {@code val}.

-1  ====>  less than  
0   ====>  equal to   
1   ====>  greater than  



## To do list for issues:

Binary Tree --->https://leetcode.com/problems/remove-duplicates-from-sorted-list/


## The right way to set initial max variable's value

If you want to find out the maximum number of an array, when you do the initialization, you need to do it in this way:

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 9, 0, 12, 23 };
		findMax(arr);

	}

	public static void findMax(int[] arr) {
		if (arr != null && arr.length > 0) {
			int maxNumber = arr[0];

			for (int tmpInt : arr) {
				if (maxNumber < tmpInt) {
					maxNumber = tmpInt;
				}

			}
			System.out.println(maxNumber);
		}
	}

##Java

http://www.tutorialspoint.com/java/java_basic_datatypes.htm  

There are two data types available in Java:

Primitive Data Types

Reference/Object Data Types

Primitive Data Types:
There are eight primitive data types supported by Java. Primitive data types are predefined by the language and named by a keyword. Let us now look into detail about the eight primitive data types.

##byte:
Byte data type is an 8-bit signed two's complement integer.

Minimum value is -128 (-2^7)

Maximum value is 127 (inclusive)(2^7 -1)

Default value is 0

Byte data type is used to save space in large arrays, mainly in place of integers, since a byte is four times smaller than an int.

Example: byte a = 100 , byte b = -50

##short:
Short data type is a 16-bit signed two's complement integer.

Minimum value is -32,768 (-2^15)

Maximum value is 32,767 (inclusive) (2^15 -1)

Short data type can also be used to save memory as byte data type. A short is 2 times smaller than an int

Default value is 0.

Example: short s = 10000, short r = -20000

##int:
Int data type is a 32-bit signed two's complement integer.

Minimum value is - 2,147,483,648.(-2^31)

Maximum value is 2,147,483,647(inclusive).(2^31 -1)

Int is generally used as the default data type for integral values unless there is a concern about memory.

The default value is 0.

Example: int a = 100000, int b = -200000

##long:
Long data type is a 64-bit signed two's complement integer.

Minimum value is -9,223,372,036,854,775,808.(-2^63)

Maximum value is 9,223,372,036,854,775,807 (inclusive). (2^63 -1)

This type is used when a wider range than int is needed.

Default value is 0L.

Example: long a = 100000L, long b = -200000L

##float:
Float data type is a single-precision 32-bit IEEE 754 floating point.

Float is mainly used to save memory in large arrays of floating point numbers.

Default value is 0.0f.

Float data type is never used for precise values such as currency.

Example: float f1 = 234.5f

##double:
double data type is a double-precision 64-bit IEEE 754 floating point.

This data type is generally used as the default data type for decimal values, generally the default choice.

Double data type should never be used for precise values such as currency.

Default value is 0.0d.

Example: double d1 = 123.4

##boolean:
boolean data type represents one bit of information.

There are only two possible values: true and false.

This data type is used for simple flags that track true/false conditions.

Default value is false.

Example: boolean one = true

##char:
char data type is a single 16-bit Unicode character.

Minimum value is '\u0000' (or 0).

Maximum value is '\uffff' (or 65,535 inclusive).

Char data type is used to store any character.

Example: char letterA ='A'