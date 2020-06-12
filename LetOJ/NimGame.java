package ok;
import java.util.Scanner;

/*
 * https://leetcode.com/problems/nim-game/
 * 
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

28 October 2015 at 12:30:06 pm

 * 
 * 
 */

class NimGame {

	public static void main(String args[]) {

		NimGame java = new NimGame();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// for(int n=0;n<100;n++)
		System.out.println(java.getF(n));
	}

	// according to the previous print out results to find out the feature.
	public boolean getF(int n) {
		if (n <= 0)
			return true;

		if (n % 4 == 0)
			return false;

		return true;
	}

	// by using array.
	/*
	 * 
	 * Submit result: Runtime Error Message: Line 18:
	 * java.lang.ArrayIndexOutOfBoundsException: 1000 Last executed input:
	 * 1348820612
	 * 
	 */

	// public boolean getF(int n){
	//
	// if(n>0){
	// int[] arr=new int[1000000];
	//
	// for(int i=0;i<arr.length;i++)
	// arr[i]=-1;
	//
	// arr[1]=1;
	// arr[2]=1;
	// arr[3]=1;
	//
	//
	//
	// for(int i=1;i<=n;i++){
	// if(arr[i]==-1){
	// if(arr[i-1]==1&&arr[i-2]==1&&arr[i-3]==1) arr[i]=0;
	// else arr[i]=1;
	// }
	//
	// }
	//
	// if(arr[n]==1) return true;
	// if(arr[n]==0) return false;
	//
	// }
	//
	// return true;
	// }
	//

	
	
	// by using recursion
	/*
	 * submit result:
	 * 
	 * 
	 * Status: Time Limit Exceeded Last executed input: 34
	 * 
	 */

	// public boolean getF(int n){
	// if(n==1||n==2||n==3) return true;
	//
	// boolean f1=getF(n-1);
	// boolean f2=getF(n-2);
	// boolean f3=getF(n-3);
	//
	// if(f1&&f2&&f3==true) return false;
	//
	// return true;
	//
	// }

}
