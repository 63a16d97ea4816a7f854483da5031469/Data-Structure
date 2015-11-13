package ok;


/*
 * To do something about the Fibonacci Nubmer
 * 
 * 13 November 2015 at 4:56:12 pm
 */

public class Fibonacci_Numbers {
	  public static void main(String args[]){
		  Fibonacci_Numbers fib=new Fibonacci_Numbers();
		    
		    int n=100;
		    for(int i=0;i<n;i++){
		    System.out.println(i+" "+fib.find_fib0(i));
		    }
		  }
	  
	  
		public long find_fib3(int n){
			  
			
			/*
			 * 
Starting Java 8, there is support for unsigned long (unsigned 64 bits). The way you can use it is:

Long l1 = Long.parseUnsignedLong("17916881237904312345");
To print it, you can not simply print l1, but you have to first:

String l1Str = Long.toUnsignedString(l1)
Then

System.out.println(l1Str);
			 * 
			 */
			
			  long v3=0;     //using long can reach: 91 7540113804746346429

			  if(n==0||n==1) return 1;

			  long v1=1;
			  long v2=1;

			  for(int i=1;i<n;i++){
			    v3=v1+v2;
			    v1=v2;
			    v2=v3;
			  }

			  return v3;
			 
			}
	  
	  
	  
	  
	  
		public long find_fib2(int n){
			  
			  long v3=0;     //using long can reach: 7540113804746346429

			  if(n==0||n==1) return 1;

			  long v1=1;
			  long v2=1;

			  for(int i=1;i<n;i++){
			    v3=v1+v2;
			    v1=v2;
			    v2=v3;
			  }

			  return v3;
			 
			}
	  

		public int find_fib(int n){
		  
		  int v3=0;   //using int only can reach: 45 1836311903 after that output becomes negative number

		  if(n==0||n==1) return 1;

		  int v1=1;
		  int v2=1;

		  for(int i=1;i<n;i++){
		    v3=v1+v2;
		    v1=v2;
		    v2=v3;
		  }

		  return v3;
		 
		}
		
		
		//using recursion:
	    public int find_fib0(int n){  // it is quite slow, when it show 43 701408733
	        
	        if(n==0||n==1) return 1;

	        return find_fib0(n-1)+find_fib0(n-2);  
	           
	        }

		
		
		
}
