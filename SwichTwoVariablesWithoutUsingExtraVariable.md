# Switch a and b variable without using extra variable.

		public static void main(String args[]){
		int a = 3;
		int b = 2;
		a = a ^ b;
		b = a ^ b;  //----> b= a^b^b ===> b=a
		a = a ^ b;  //----> a= a^a^b ===> a=b
		System.out.println(a + " " + b);
	}
	
	
##java XOR

XOR     java:  a^b
	
	public static void main(String args[]){
		int a = 3;
		int b = 2;
 
		System.out.println(a^a + " " + a^b^a+" "+a^a^b);
	}
	
	
	public static void main(String[] args) {
		boolean[] all = { false, true };
		for (boolean a : all) {
			for (boolean b: all) {
				boolean c = a ^ b;
				System.out.println(a + " ^ " + b + " = " + c);
			}
		}
	}

	

##java XNOR
XNOR   binary number:   (each bit)^(each bit)^1 = one bit