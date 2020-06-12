/*
https://leetcode.com/problems/count-primes/
Description:

Count the number of prime numbers less than a non-negative number, n.



public class Solution {
    public int countPrimes(int n) {
        
    }
}

The first 168 prime numbers (all the prime numbers less than 1000) are:

2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 
137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 
277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433,
439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 
607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769,
773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 
967, 971, 977, 983, 991, 997 [2] (sequence A000040 in OEIS).


质数（Prime number），又称素数，指在大于1的自然数中，除了1和该数自身外，无法被其他自然数整除的数（也可定义为只有1与该数本身两个因数的数）。

Sieve of Eratosthenes
给出要筛数值的范围n，找出\sqrt{n}以内的素数p_{1},p_{2},\dots,p_{k}。先用2去筛，即把2留下，把2的倍数剔除掉；再用下一个素数，也就是3筛，把3留下，把3的倍数剔除掉；接下去用下一个素数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。


Sieve of Eratosthenes
Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
Initially, let p equal 2, the smallest prime number.
Starting from 2p, enumerate the multiples of p by counting to n in increments of p, and mark them in the list (these will be 2p, 3p, 4p, ... ; the p itself should not be marked).
Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.


  // 初始化素数数组
  char* num = (char*) malloc(sizeof(char) * n );
  for ( size_t i = 2; i < n; ++i ) {       
      num[i] = TRUE;                       
  }
  // 按照埃拉托斯特尼筛法，将为基数的倍数的所有数标记为非素数。
  size_t i = 2;
  while ( i * i  <= n ) {
       for (size_t c = 2, idx = 2*i; idx < n; ++c, idx = i * c) {
           num[idx] = FALSE;
       }
       do {
          ++i;
       } while ( i * i <= n && num[i] == FALSE);
  }
  return num;


 * 
 * 
 * 
 */
public class CountPrimes {

	public static void main(String args[]){
		
		CountPrimes s=new CountPrimes();
//		for(int i=2;i<1000;i++){
//			if(s.isPrime(i))
//			System.out.print(i+" ");
//
//			}
		System.out.println(s.countPrimes(100));
		
	}
	
	
	/*
	 * 
	 * Accepted.
	 */
	
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];

		for (int i = 2; i < n; i++)
			isPrime[i] = true;

		for (int i = 2; i * i <= n; i++) {

			if (isPrime[i]) {

				for (int j = i; i * j <= n; j++) {
					isPrime[i * j] = false;
				}

			}

		}

		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				count++;
		}

		return count;

	}

	
	
	
	public void getPrimeArr(int n){
		
		boolean[] isPrime=new boolean[n+1];
		

		for(int i=2;i<=n;i++){
			isPrime[i]=true;
		}

		for(int i=2;i*i<=n;i++){
		
			if(isPrime[i]){
				for(int j=i;i*j<=n;j++){
					isPrime[i*j]=false;
				}
			}
		}

		int countPrime=0;
		for(int i=2;i<=n;i++){
		if(isPrime[i]){
		System.out.println("The prime number is:"+i);
		countPrime++;
		}
		}


	}

	
	
/*
 * It is a very stupid way to get the prime.
 */



public boolean isPrime(int num){


	for(int i=2;i<num;i++){
		if(num%i==0) return false;

	}

	return true;

}



	
	
}
