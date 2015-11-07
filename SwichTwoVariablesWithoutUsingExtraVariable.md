# Switch a and b variable without using extra variable.

		public static void main(String args[]){
		int a = 3;
		int b = 2;
		a = a ^ b;
		b = a ^ b;  //----> b= a^b^b ===> b=a
		a = a ^ b;  //----> a= a^a^b ===> a=b
		System.out.println(a + " " + b);
	}



