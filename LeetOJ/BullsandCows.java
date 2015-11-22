/*
 * 
https://leetcode.com/problems/bulls-and-cows/

You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. 
Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both
 digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend 
 will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.


public class Solution {
    public String getHint(String secret, String guess) {
        
    }
}


 *
 *
 */


import java.util.*;
import java.util.Map.Entry;
public class BullsandCows {
	
	public static void main(String args[]){
		BullsandCows c=new BullsandCows();
		System.out.println(c.getHint("12","21"));
	}
	
	/*
	 * Accepted.
	 * 
	 */
    public String getHint(String secret, String guess) {
    	String result="";
    	int bull=0;
    	int cow=0;
    	String tmpSecret="";
    	String tmpGuess="";
    	
    	for(int i=0;i<secret.length();i++){
		if(secret.charAt(i)==guess.charAt(i)){
			bull++;
			secret=secret.subSequence(0, i)+"a"+secret.substring(i+1, secret.length());  
			guess=guess.substring(0,i)+"a"+guess.substring(i+1, guess.length());
		}
		
	}
  
    	
    	System.out.println(secret+" "+guess);
    	
//    	for(int i=0;i<secret.length();i++){
//    		if(secret.charAt(i)==guess.charAt(i)){
//    			bull++;
//    			secret=secret.subSequence(0, i)+secret.substring(i+1, secret.length());  //because you modified the secret and secret is the for() control variable.so the loop number is reduced.
//    			guess=guess.substring(0,i)+guess.substring(i+1, guess.length());
//    		}
//    		
//    	}
 
    	
    	
    	
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	for(int i=0;i<secret.length();i++){
    		if(secret.charAt(i)!='a'){
    		if(map.get(secret.charAt(i))==null){
    			map.put(secret.charAt(i), 1);
    		}else{
    			map.put(secret.charAt(i), map.get(secret.charAt(i))+1);
    		}
    		}
    	}
    	
//    	for(Entry<Character,Integer> entry:map.entrySet()){
//    		System.out.println(entry.getKey()+"="+entry.getValue());
//    	}
    	
    	
    	
    	for(int i=0;i<secret.length();i++){
    		if(secret.charAt(i)!='a'){
    		if(map.get(guess.charAt(i))!=null){
    			cow++;
    			map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
    			if(map.get(guess.charAt(i))==0) map.put(guess.charAt(i), null);
    		}
    	}
    	}
    	result=bull+"A"+cow+"B";
    	return result;
    }
}














