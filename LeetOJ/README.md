## Meaning of "constant space complexity"

What does it mean? No extra space or O(1) extra space? What if using recursion, does the stack count as constant space?

Constant space means that the amount of space that your algorithm uses is independent of the input parameters. Say you are given an array of size n. If the amount of space your algorithm uses scales with n, then it's not constant. If your algorithm always uses a fixed amount of space (5 variables, an array of fixed size: 100, 300, 5000, etc..), you are golden.

constant space just means the memory you use does not depends on the size of the input.  
When you use recursion, the stack also counted.