
/*
 * 
https://leetcode.com/problems/word-ladder/


Easy

278

669

Add to List

Share
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

 

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


3 Apr. 2020 at 9:08 pm
 * 
 */

class Solution {
    public String defangIPaddr(String address) {
        if(address.length()==0) return address;
        
        return address.replace(".","[.]");
    }
}















