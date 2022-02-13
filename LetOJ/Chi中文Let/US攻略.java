





LeetCode-Solution-in-Good-Style
https://github.com/abshawn/LeetCode-Solution-in-Good-Style


力扣热题100 速通指南
https://zhuanlan.zhihu.com/p/458506664





https://zhuanlan.zhihu.com/p/349940945

Leetcode面试高频题分类刷题总结

TimothyL
TimothyL
​
电气工程博士
973 人赞同了该文章
收藏是点赞的三倍还多…也给个赞呗…

前文链接：

想看面试准备过程的在这：

TimothyL：一个大龄博士的刷题转码之路

前言：

这是本人在7个月刷了500道Leetcode题目并成功拿到几家北美Software Engineer Offer之后总结的Leetcode高频面试题目分类总结。这篇是高频题目的概述性总结，以后有时间打算单独给每个门类写一个详细的总结。希望对准备刷题面试的你有所帮助吧，谢谢！

注：本文一共200多道题，算上一些附加的衍生题差不多有250+，基本上很少有easy题目，大部分都是medium，少部分hard，按照大多数人30% Easy，60% Medium， 10% Hard的刷题标准，刷好下面全部的题目相当于300题，刷好足够应对大部分的算法面试了。如果你对算法与数据结构基础知识掌握的不够的情况下，先按照下面文章说提到的基础补好再开始刷对应门类的题目，不然很容易“一个人一包烟，一道题目刷一天”。

注：作者在北美各个大厂几乎全部面过，G家 A家 U家之类的大厂offer也都拿到过，可以确定刷好本文中的所有题以及掌握每道题对应知识点可以应对绝大多数的码农算法面试了。

如果题目/答案看不懂又不喜欢看discussion的话，现在有很多视频资源可以看。个人比较喜欢花花酱的讲解（花花酱的表世界的个人空间_哔哩哔哩_Bilibili）， 墙外的同学们也可以看关神的视频讲解（https://www.youtube.com/channel/UCY5Z0of98W-YSdmPgAe1DaA）。

不建议刷的题目类型：

非高频的hard题目，费时费力又很难在面试中遇到，性价比太低。
贪心法题目，每道题都不一样，解法没有通用性。
以下8个门类是面试中最常考的算法与数据结构知识点。

排序类（Sort）：

基础知识：快速排序（Quick Sort）， 归并排序（Merge Sort）的原理与代码实现。需要能讲明白代码中每一行的目的。快速排序时间复杂度平均状态下O（NlogN），空间复杂度O（1），归并排序最坏情况下时间复杂度O（NlogN），空间复杂度O（N）
入门题目：
Leetcode 148. Sort List
Leetcode 56. Merge Intervals
Leetcode 27. Remove elements
进阶题目：
Leetcode 179. Largest Number
Leetcode 75. Sort Colors
Leetcode 215. Kth Largest Element
Leetcode 4. Median of Two Sorted Arrays
注意：后两题是与快速排序非常相似的快速选择（Quick Select）算法，面试中很常考

链表类（Linked List）：

基础知识：链表如何实现，如何遍历链表。链表可以保证头部尾部插入删除操作都是O（1），查找任意元素位置O（N）
基础题目：
Leetcode 206. Reverse Linked List
Leetcode 876. Middle of the Linked List
注意：快慢指针和链表反转几乎是所有链表类问题的基础，尤其是反转链表，代码很短，建议直接背熟。

进阶题目:
Leetcode 160. Intersection of Two Linked Lists
Leetcode 141. Linked List Cycle (Linked List Cycle II)
Leetcode 92. Reverse Linked List II
Leetcode 328. Odd Even Linked List
堆（Heap or Priority Queue）、栈（Stack）、队列（Queue）、哈希表类（Hashmap、Hashset）：

基础知识：各个数据结构的基本原理，增删查改复杂度。
Queue题目：
Leetcode 225. Implement Stack using Queues
Leetcode 346. Moving Average from Data Stream
Leetcode 281. Zigzag Iterator
Leetcode 1429. First Unique Number
Leetcode 54. Spiral Matrix
Leetcode 362. Design Hit Counter
Stack题目：
Leetcode 155. Min Stack (follow up Leetcode 716 Max Stack)
Leetcode 232. Implement Queue using Stacks
Leetcode 150. Evaluate Reverse Polish Notation
Leetcode 224. Basic Calculator II (I, II, III, IV)
Leetcode 20. Valid Parentheses
Leetcode 1472. Design Browser History
Leetcode 1209. Remove All Adjacent Duplicates in String II
Leetcode 1249. Minimum Remove to Make Valid Parentheses
Leetcode 735. Asteroid Collision
Hashmap/ Hashset题目：
Leetcode 1. Two Sum
Leetcode 146. LRU Cache (Python中可以使用OrderedDict来代替)
Leetcode 128. Longest Consecutive Sequence
Leetcode 73. Set Matrix Zeroes
Leetcode 380. Insert Delete GetRandom O(1)
Leetcode 49. Group Anagrams
Leetcode 350. Intersection of Two Arrays II
Leetcode 299. Bulls and Cows
Leetcode 348 Design Tic-Tac-Toe
Heap／Priority Queue题目：
Leetcode 973. K Closest Points
Leetcode 347. Top k Largest Elements
Leetcode 23. Merge K Sorted Lists
Leetcode 264. Ugly Number II
Leetcode 1086. High Five
Leetcode 88. Merge Sorted Arrays
Leetcode 692. Top K Frequent Words
Leetcode 378. Kth Smallest Element in a Sorted Matrix
Leetcode 295. Find Median from Data Stream （标准解法是双heap，但是SortedDict会非常容易）
Leetcode 767. Reorganize String
Leetcode 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (这个题用单调双端队列、TreeMap、双heap都可以)
Leetcode 895. Maximum Frequency Stack
二分法（Binary Search）：

基础知识：二分法是用来解法基本模板，时间复杂度logN；常见的二分法题目可以分为两大类，显式与隐式，即是否能从字面上一眼看出二分法的特点：要查找的数据是否可以分为两部分，前半部分为X，后半部分为O
显式二分法：
Leetcode 34. Find First and Last Position of Element in Sorted Array
Leetcode 33. Search in Rotated Sorted Array
Leetcode 1095. Find in Mountain Array
Leetcode 162. Find Peak Element
Leetcode 278. First Bad Version
Leetcode 74. Search a 2D Matrix
Leetcode 240. Search a 2D Matrix II
隐式二分法：
Leetcode 69. Sqrt(x)
Leetcode 540. Single Element in a Sorted Array
Leetcode 644. Maximum Average Subarray II
Leetcode 528. Random Pick with Weight
Leetcode 1300. Sum of Mutated Array Closest to Target
Leetcode 1060. Missing Element in Sorted Array
Leetcode 1062. Longest Repeating Substring
Leetcode 1891. Cutting Ribbons
双指针（2 Pointer）：

基础知识：常见双指针算法分为三类，同向（即两个指针都相同一个方向移动），背向（两个指针从相同或者相邻的位置出发，背向移动直到其中一根指针到达边界为止），相向（两个指针从两边出发一起向中间移动直到两个指针相遇）
背向双指针：(基本上全是回文串的题)
Leetcode 409. Longest Palindrome
Leetcode 125. Valid Palindrome
Leetcode 5. Longest Palindromic Substring
相向双指针：(以two sum为基础的一系列题)
Leetcode 1. Two Sum (这里使用的是先排序的双指针算法，不同于hashmap做法)
Leetcode 167. Two Sum II - Input array is sorted
Leetcode 15. 3Sum
Leetcode 16. 3Sum Closest
Leetcode 18. 4Sum
Leetcode 454. 4Sum II
Leetcode 277. Find the Celebrity
Leetcode 11. Container With Most Water
同向双指针：（个人觉得最难的一类题，可以参考下这里 TimothyL：Leetcode 同向双指针/滑动窗口类代码模板）
Leetcode 283. Move Zeroes
Leetcode 26. Remove Duplicate Numbers in Array
Leetcode 395. Longest Substring with At Least K Repeating Characters
Leetcode 340. Longest Substring with At Most K Distinct Characters
Leetcode 424. Longest Repeating Character Replacement
Leetcode 76. Minimum Window Substring
Leetcode 3. Longest Substring Without Repeating Characters
Leetcode 1004 Max Consecutive Ones III
宽度优先搜索（BFS）：面试中最常考的

基础知识：
常见的BFS用来解决什么问题？(1) 简单图（有向无向皆可）的最短路径长度，注意是长度而不是具体的路径（2）拓扑排序 （3） 遍历一个图（或者树）
BFS基本模板（需要记录层数或者不需要记录层数）
多数情况下时间复杂度空间复杂度都是O（N+M），N为节点个数，M为边的个数
基于树的BFS：不需要专门一个set来记录访问过的节点
Leetcode 102 Binary Tree Level Order Traversal
Leetcode 103 Binary Tree Zigzag Level Order Traversal
Leetcode 297 Serialize and Deserialize Binary Tree （很好的BFS和双指针结合的题）
Leetcode 314 Binary Tree Vertical Order Traversal
基于图的BFS：（一般需要一个set来记录访问过的节点）
Leetcode 200. Number of Islands
Leetcode 133. Clone Graph
Leetcode 127. Word Ladder
Leetcode 490. The Maze
Leetcode 323. Connected Component in Undirected Graph
Leetcode 130. Surrounded Regions
Leetcode 752. Open the Lock
Leetcode 815. Bus Routes
Leetcode 1091. Shortest Path in Binary Matrix
Leetcode 542. 01 Matrix
Leetcode 1293. Shortest Path in a Grid with Obstacles Elimination
拓扑排序：（https://zh.wikipedia.org/wiki/%E6%8B%93%E6%92%B2%E6%8E%92%E5%BA%8F）
Leetcode 207 Course Schedule （I, II）
Leetcode 444 Sequence Reconstruction
Leetcode 269 Alien Dictionary
Leetcode 310 Minimum Height Trees
Leetcode 366 Find Leaves of Binary Tree
深度优先搜索（DFS）：面试中最常考的

基础知识：
常见的DFS用来解决什么问题？(1) 图中（有向无向皆可）的符合某种特征（比如最长）的路径以及长度（2）排列组合（3） 遍历一个图（或者树）（4）找出图或者树中符合题目要求的全部方案
DFS基本模板（需要记录路径，不需要返回值 and 不需要记录路径，但需要记录某些特征的返回值）
除了遍历之外多数情况下时间复杂度是指数级别，一般是O(方案数×找到每个方案的时间复杂度)
递归题目都可以用非递归迭代的方法写，但一般实现起来非常麻烦
基于树的DFS：需要记住递归写前序中序后序遍历二叉树的模板
Leetcode 543 Diameter of Binary Tree
Leetcode 226 Invert Binary Tree
Leetcode 101 Symmetric Tree
Leetcode 951 Flip Equivalent Binary Trees
Leetcode 124 Binary Tree Maximum Path Sum
Leetcode 236 Lowest Common Ancestor of a Binary Tree (相似题：235、1650)
Leetcode 105 Construct Binary Tree from Preorder and Inorder Traversal
Leetcode 104 Maximum Depth of Binary Tree
Leetcode 987 Vertical Order Traversal of a Binary Tree
Leetcode 1485 Clone Binary Tree With Random Pointer
Leetcode 572 Subtree of Another Tree
Leetcode 863 All Nodes Distance K in Binary Tree
Leetcode 1110 Delete Nodes And Return Forest
二叉搜索树（BST）：BST特征：中序遍历为单调递增的二叉树，换句话说，根节点的值比左子树任意节点值都大，比右子树任意节点值都小，增删查改均为O（h）复杂度，h为树的高度；注意不是所有的BST题目都需要递归，有的题目只需要while循环即可
Leetcode 230 Kth Smallest element in a BST
Leetcode 98 Validate Binary Search Tree
Leetcode 270 Cloest Binary Search Tree Value
Leetcode 235 Lowest Common Ancestor of a Binary Search Tree
Leetcode 669 Trim a Binary Search Tree
Leetcode 700 Search in a Binary Search Tree
Leetcode 108 Convert Sorted Array to Binary Search Tree
Leetcode 333 Largest BST Subtree (与98类似)
Leetcode 285 Inorder Successor in BST (I, II)
基于图的DFS: 和BFS一样一般需要一个set来记录访问过的节点，避免重复访问造成死循环; Word XXX 系列面试中非常常见，例如word break，word ladder，word pattern，word search。
Leetcode 341 Flatten Nested List Iterator (339 364)
Leetcode 394 Decode String
Leetcode 51 N-Queens (I II基本相同)
Leetcode 291 Word Pattern II (I为简单的Hashmap题)
Leetcode 126 Word Ladder II （I为BFS题目）
Leetcode 93 Restore IP Addresses
Leetcode 22 Generate Parentheses
Leetcode 586 Score of Parentheses
Leetcode 301 Remove Invalid Parentheses
Leetcode 37 Sodoku Solver
Leetcode 212 Word Search II （I, II）
Leetcode 1087 Brace Expansion
Leetcode 399 Evaluate Division
Leetcode 1274 Number of Ships in a Rectangle
Leetcode 1376 Time Needed to Inform All Employees
Leetcode 694 Number of Distinct Islands
Leetcode 131 Palindrome Partitioning
基于排列组合的DFS: 其实与图类DFS方法一致，但是排列组合的特征更明显
Leetcode 17 Letter Combinations of a Phone Number
Leetcode 39 Combination Sum（I, II, III相似， IV为动态规划题目）
Leetcode 78 Subsets （I, II 重点在于如何去重）
Leetcode 46 Permutation (I, II 重点在于如何去重)
Leetcode 77 Combinations (I, II 重点在于如何去重)
Leetcode 698 Partition to K Equal Sum Subsets
Leetcode 526 Beautiful Arrangement (similar to 46)
记忆化搜索（DFS + Memoization Search）：算是动态规划的一种，递归每次返回时同时记录下已访问过的节点特征，避免重复访问同一个节点，可以有效的把指数级别的DFS时间复杂度降为多项式级别; 注意这一类的DFS必须在最后有返回值，不可以用排列组合类型的DFS方法写; for循环的dp题目都可以用记忆化搜索的方式写，但是不是所有的记忆化搜索题目都可以用for循环的dp方式写。
Leetcode 139 Word Break II
Leetcode 72 Edit Distance
Leetcode 377 Combination Sum IV
Leetcode 1235 Maximum Profit in Job Scheduling
Leetcode 1335 Minimum Difficulty of a Job Schedule
Leetcode 1216 Valid Palindrome III
Leetcode 97 Interleaving String
Leetcode 472 Concatenated Words
Leetcode 403 Frog Jump
Leetcode 329 Longest Increasing Path in a Matrix
前缀和（Prefix Sum）

基础知识：前缀和本质上是在一个list当中，用O（N）的时间提前算好从第0个数字到第i个数字之和，在后续使用中可以在O（1）时间内计算出第i到第j个数字之和，一般很少单独作为一道题出现，而是很多题目中的用到的一个小技巧
常见题目：
Leetcode 53 Maximum Subarray
Leetcode 1423 Maximum Points You Can Obtain from Cards
Leetcode 1031 Maximum Sum of Two Non-Overlapping Subarrays
Leetcode 523 Continuous Subarray Sum
Leetcode 304 Range Sum Query 2D - Immutable
以上内容皆为面试中高频的知识点，以下知识点和题目在面试中属于中等频率（大概面10道题会遇到一次），时间不足的情况下，请以准备上面的知识点为主。

并查集（Union Find）：把两个或者多个集合合并为一个集合

基础知识：如果数据不是实时变化，本类问题可以用BFS或者DFS的方式遍历，如果数据实时变化（data stream）则并查集每次的时间复杂度可以视为O（1）；需要牢记合并与查找两个操作的模板
常见题目：
Leetcode 721 Accounts Merge
Leetcode 547 Number of Provinces
Leetcode 737 Sentence Similarity II
Leetcode 305 Number of Islands II
字典树（Trie）

基础知识：（https://zh.wikipedia.org/wiki/Trie）；多数情况下可以通过用一个set来记录所有单词的prefix来替代，时间复杂度不变，但空间复杂度略高
常见题目：
Leetcode 208 Implement Trie (Prefix Tree)
Leetcode 211 Design Add and Search Words Data Structure
Leetcode 1268 Search Suggestions System
Leetcode 212 Word Search II

单调栈与单调队列（Monotone Stack／Queue）

基础知识：单调栈一般用于解决数组中找出每个数字的第一个大于／小于该数字的位置或者数字；单调队列只见过一道题需要使用；不论单调栈还是单调队列，单调的意思是保留在栈或者队列中的数字是单调递增或者单调递减的
常见题目：
Leetcode 85 Maximum Rectangle
Leetcode 84 Largest Rectangle in Histogram
Leetcode 907 Sum of Subarray Minimums (与84类似)
Leetcode 739 Daily Temperatures
Leetcode 901 Online Stock Span
Leetcode 503 Next Greater Element II
Leetcode 239 Sliding Window Maximum （唯一的单调队列题）



扫描线算法（Sweep Line）

基础知识：一个很巧妙的解决时间安排冲突的算法，本身比较容易些也很容易理解
常见题目：
Leetcode 253 Meeting Room II（Meeting Room I也可以使用）
Leetcode 218 The Skyline Problem
Leetcode 759 Employee Free Time

TreeMap

基础知识：基于红黑树（平衡二叉搜索树）的一种树状 hashmap，增删查改、找求大最小均为logN复杂度，Python当中可以使用SortedDict替代；SortedDict继承了普通的dict全部的方法，除此之外还可以peekitem(k)来找key里面第k大的元素，popitem(k)来删除掉第k大的元素，弥补了Python自带的heapq没法logN时间复杂度内删除某个元素的缺陷；最近又在刷一些hard题目时候突然发现TreeMap简直是个神技，很多用别的数据结构写起来非常麻烦的题目，TreeMap解决起来易如反掌。
常见题目：
Leetcode 729 My Calendar I
Leetcode 981 Time Based Key-Value Store
Leetcode 846 Hand of Straights
Leetcode 218 The Skyline Problem
Leetcode 480. Sliding Window Median (这个题用TreeMap超级方便)
Leetcode 318 Count of Smaller Numbers After Self (这个题线段树、二分索引树、TreeMap都可以)
动态规划（Dynamic Programming）

基础知识：这里指的是用for循环方式的动态规划，非Memoization Search方式。DP可以在多项式时间复杂度内解决DFS需要指数级别的问题。常见的题目包括找最大最小，找可行性，找总方案数等，一般结果是一个Integer或者Boolean。动态规划有很多分支，暂时还没想好怎么去写这部分，后面想好了再具体写吧。
常见题目：
Leetcode 674 Longest Continuous Increasing Subsequence (接龙型dp)
Leetcode 62 Unique Paths II
Leetcode 70 Climbing Stairs
Leetcode 64 Minimum Path Sum
Leetcode 368 Largest Divisible Subset (接龙型dp)
Leetcode 300 Longest Increasing Subsequence (接龙型dp)
Leetcode 354 Russian Doll Envelopes (接龙型dp， 300的2D版)
Leetcode 256 Paint House
Leetcode 121 Best Time to Buy and Sell Stock
Leetcode 55 Jump Game
Leetcode 45 Jump Game II
Leetcode 132 Palindrome Partitioning II
Leetcode 312 Burst Balloons (区间型dp)
Leetcode 1143 Longest Common Subsequence (前缀型dp)
Leetcode 1062 Longest Repeating Substring (dp方法与longest common substring一致)
Leetcode 718 Maximum Length of Repeated Subarray (和1062本质上一样)
Leetcode 174 Dungeon Game
Leetcode 115 Distinct Subsequences
Leetcode 72 Edit Distance
Leetcode 91 Decode Ways
Leetcode 639 Decode Ways II
Leetcode 712 Minimum ASCII Delete Sum for Two Strings
Leetcode 221 Maximal Square
Leetcode 1277 Count Square Submatrices with All Ones (可以使用221一样的解法)
Leetcode 198 House Robber
Leetcode 213 House Robber II
Leetcode 740 Delete and Earn
Leetcode 87 Scramble String
Leetcode 1140 Stone Game II
Leetcode 322 Coin Change
Leetcode 518 Coin Change II (01背包型)
Leetcode 1048 Longest String Chain
Leetcode 44 Wildcard Matching
Leetcode 10 Regular Expression Matching
Leetcode 32 Longest Valid Parentheses
Leetcode 1235 Maximum Profit in Job Scheduling (DP + binary search)
Leetcode 1043 Partition Array for Maximum Sum
Leetcode 926 Flip String to Monotone Increasing


------------------------------------------------------------------------------------------------------------------------


https://zhuanlan.zhihu.com/p/349591952


电气工程博士
342 人赞同了该文章
本文只讨论如何在Leetcode刷题，不讨论以下几个话题：为什么要转码，放弃原本行业转码值不值得，通过算法题的方式来面试筛选是否合理，当码农是否有35岁以后的失业风险等……

个人经历介绍：我是2020年5月开始正式刷题的，在此之前的工作学习经历与码农完全不相干，只是少量使用过Python做一些简单的数据处理工作，用Matlab写过一些实验，对数据结构与算法几乎零认知，连Hashmap是什么都不知道，更不用说什么堆栈队列深搜宽搜动态规划了……

刷题与面试结果：到2020年底差不多刷了500题，近半年在北美投了几十家IT公司，作为一个没有CS经历又投不了应届生岗位的转行狗没拿到几家面试，不过除了狗家外也拿到了几家Software Engineer offer，最终决定去了A家…

下面介绍下我是如何刷题的，希望对刷题路上的你有所帮助吧…

语言选择：个人觉得选择自己最熟悉的语言即可，没有必要为了刷题专门去学一门自己不熟悉的语言。实际面试中用Python和Java刷题的人是最多的～Python优势在于比较简洁，写起来快，在面试时候时间紧迫心态紧张的情况下会节省一些时间。劣势是没有TreeMap这种数据结构，真面到这样的题会被坑（我狗家就挂在了这个上面）。注意Matlab，R等不能算IT开发的编程语言，一般面试也不允许用。
2. 基本知识：个人还是建议在正经开始大规模刷题前先把面试中最常考的知识点学明白比较重要，不然直接去刷题怕是被打击的丧失自信了…面试常见的数据结构与算法就十几项，在文章下面都有列明。

3. 面试中算法与数据结构的重要性，可以根据自己的时间来安排，如果时间紧迫可以只准备“高频”的部分。

高频：宽度优先搜索（BFS），深度优先搜索（DFS），二分法（Binary Search），双指针（2 Pointer），堆、栈、队列、哈希表（Heap，Stack，Queue，HashMap/HashSet），前缀和（Prefix Sum），链表（LinkedList），二叉树（Binary Tree），二叉搜索树（Binary Search Tree），快速排序与归并排序（Quick Sort/ Merge Sort）

中频：动态规划（DP），扫描线（Sweep Line），字典树（Trie），并查集（Union Find），单调栈与单调队列（Monotone Stack/ Queue），TreeMap等

低频：Dijkstra，树状数组，线段树，最小生成树等…

4. 如何刷题：每个人的基础、学习习惯都不一样，以下是我个人的习惯。(注意: 我基本上每周都会花20-40小时刷题，而且我本身有朝九晚五的全职工作的，所有的业余休息时间全部用来刷题了，几乎放弃了一切娱乐活动，真-东亚做题家的即视感。)

第一阶段：熟悉各个高频数据结构以及算法的原理、模版等，可以用来解决一些相关的Easy题目，这个大概花了1个月左右。

第二阶段：正式开始按照门类刷题，上面标记为“高”的各个知识点题目一共刷了200题左右，又刷了50道DP题目，按照Leetcode Frequency排序，只刷高频题，每道题如果5分钟内想不出怎么解就赶紧去看答案，看懂后要能做到不看答案自己正确实现出来才可以去做下一题…这是最耗时也是最痛苦的一个阶段，第一遍刷完250题花了大概三个月左右，第二遍花了一个月，第三遍花了半个月，总之后面越刷越快，几乎可以做到一天刷十几题…

第三阶段：针对面试的特殊准备，鉴于Leetcode上给了各个公司Tag下最近6个月的常见题目，我在面每家之前都会把该公司（如果Leetcode上有的话）出现过的最近6个月题目按照频率从高往低，至少把Top100 Most Frequent题目刷一遍，很多时候里面只有一半的题目是以前做过的。

第四阶段：由于狗家和某些Pre IPO公司出了名的算法题难，面试狗家前一个月专门又去学了一下在“中频”当中的算法与数据结构，以防遇到了不会做，然而人算不如天算，最后还是吃了Python没有TreeMap的亏挂掉了，不过总归学了知识以后用得上。

5. 题目难度选择：大概30%Easy，60%Medium，10%Hard，Hard题目除了高频题别死磕，面试中遇到没见过的Hard题目大多数人都会挂掉的，不要太担心，把时间尽量都用来高频题上。

6. 面试时候感受：面第一家公司时会很紧张，看到没见过的新题时会慌乱和紧张，脑子里一直在想完蛋了准备后事吧；后面再面别家时会越来越放松，即使当时手里并没有offer，但因为题刷到位了，不管是新题旧题都有自信做出来，而且要相信自己比面试官刷的多，他未必比你的算法强。

到目前为止各个公司面试时，一共被面了30题左右，整体以Medium为主，Hard在15%左右，只有2道题出了“高频”的范围，即使遇到Hard题目也是高频题或者两三个Medium题目组合出来的Hard题。面过的题目当中大概一半的题目是刷过的原题，另一半也大部分都是现有题目的改编或者高频知识点的重新组合题，完全没见过或者一眼看上去没思路的题目只有一两道。




各位加油！

更新于2020.02.16:

感谢各位的支持，稍微唠叨两句关于面试的准备，高频题是需要保证每一道都会做的，不要因为有些题很恶心或者差评特别多就跳过不做，不然面试遇到时候哭的就是自己了，我就是活生生的例子，比如Integer to English Words，Skyline，Integer to Roman之类的题目，现场做真的是一言难尽…

2021.2.18更新:

鉴于不少人都在问没有CS经历如何拿的到面试，我本身也不算成功案例，拿到的面试也没几家，一家之言仅供参考吧：

首先是厂家选择，个人感受是大厂相对于小厂对转行狗更友好，基本上不太喜欢问各种技术细节与简历，非技术类型的问题基本上都是行为类问题（BQ）。小厂可能生存压力更大，更希望招进来的人能迅速上手干活，所以更喜欢匹配度高的。

其次是简历丰富，首先是你以前做过的项目要重新包装，让项目看起来更像一个码农的活，再者是如果太过于缺少像码农的项目，那就只好去自学做一个项目，网上有太多这种免费/收费的手把手教你做项目的课程了，比如基于REACT的前端项目，基于Spring/ Django/ Spark之类的XXX项目。选择性的做一两个，手把手跟着学一遍，搞明白整体逻辑，保证别人问你的时候不会一脸懵逼就好。

第三是简历投递，个人理解的靠谱程度排序，相关岗位的负责人内推 > 相关岗位内部人员内推 > 自己去linkedIn联系HR > 找不认识或者不相关岗位的人内推 > 海投。疫情期间确实岗位少了很多，这一年半载的找工作难度要比以往大很多。

2020.3.10更新:

有人问我到底要准备到什么程度才可以去面试。其实没有统一的答案，个人觉得你把高频题都刷过2-3遍就已经可以开始投简历面试了，毕竟投简历到拿到面试慢的话可能要2-3个月，也可能第二天就拿到面试。

刷题要刷到什么程度？高频题差不多要做到Medium题目10分钟、Hard题目15分钟写完代码，不要求一遍完全bug free，但不能有明显的错误。面试当中可能一道Medium题目面试官就给你留了20-25分钟左右来做，但这是包含了出题、澄清题目、想思路、和面试官讲明白思路、和面试官来回扯皮、写代码、跑测试样例、讲清楚时间空间复杂度的全部时间总和，这其中能留给你写代码的时间也就10分钟左右，所以熟练度非常重要！

为什么特别强调熟练度，因为面试当中可能会遇到各种不可控因素，比如面试官迟到10-15分钟，面试官自己也没想好题目怎么做才是最好的，面试官不允许你用自己熟悉的方法解题，面试官出题就花了10分钟，或者题目过长描述过于绕导致看明白问题花了很长时间，面试官上来和你闲聊花了太多时间等等，（以上问题我全都在面试中遇过）各种因素可能都会导致你做题的时间非常紧，这时候熟练度不高的话很大概率就要挂了……


------------------------------------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------------------------------------


基本类型


高频：

回溯算法

宽度优先搜索（BFS），深度优先搜索（DFS），二分法（Binary Search），双指针（2 Pointer），堆、栈、队列、哈希表（Heap，Stack，Queue，HashMap/HashSet），前缀和（Prefix Sum），链表（LinkedList），二叉树（Binary Tree），二叉搜索树（Binary Search Tree），快速排序与归并排序（Quick Sort/ Merge Sort）

中频：动态规划（DP），扫描线（Sweep Line），字典树（Trie），并查集（Union Find），单调栈与单调队列（Monotone Stack/ Queue），TreeMap等

低频：Dijkstra，树状数组，线段树，最小生成树等…





------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------




分类刷题:

import java.math.BigDecimal;

BigDecimal

@Test
public void whenBigDecimalCreated_thenValueMatches() {
    BigDecimal bdFromString = new BigDecimal("0.1");
    BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3','.','1','6','1','5'});
    BigDecimal bdlFromInt = new BigDecimal(42);
    BigDecimal bdFromLong = new BigDecimal(123412345678901L);
    BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
    BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);
        
    assertEquals("0.1",bdFromString.toString());
    assertEquals("3.1615",bdFromCharArray.toString());
    assertEquals("42",bdlFromInt.toString());
    assertEquals("123412345678901",bdFromLong.toString());
    assertEquals(bigInteger.toString(),bdFromBigInteger.toString());
}

@Test
public void whenComparingBigDecimals_thenExpectedResult() {
    BigDecimal bd1 = new BigDecimal("1.0");
    BigDecimal bd2 = new BigDecimal("1.00");
    BigDecimal bd3 = new BigDecimal("2.0");

    assertTrue(bd1.compareTo(bd3) < 0);
    assertTrue(bd3.compareTo(bd1) > 0);
    assertTrue(bd1.compareTo(bd2) == 0);
    assertTrue(bd1.compareTo(bd3) <= 0);
    assertTrue(bd1.compareTo(bd2) >= 0);
    assertTrue(bd1.compareTo(bd3) != 0);
}

On the other hand, the equals method considers two BigDecimal objects as equal only if they are equal in value and scale. Thus, BigDecimals 1.0 and 1.00 are not equal when compared by this method.

@Test
public void whenEqualsCalled_thenSizeAndScaleMatched() {
    BigDecimal bd1 = new BigDecimal("1.0");
    BigDecimal bd2 = new BigDecimal("1.00");
        
    assertFalse(bd1.equals(bd2));
}


@Test
public void whenPerformingArithmetic_thenExpectedResult() {
    BigDecimal bd1 = new BigDecimal("4.0");
    BigDecimal bd2 = new BigDecimal("2.0");

    BigDecimal sum = bd1.add(bd2);
    BigDecimal difference = bd1.subtract(bd2);
    BigDecimal quotient = bd1.divide(bd2);
    BigDecimal product = bd1.multiply(bd2);

    assertTrue(sum.compareTo(new BigDecimal("6.0")) == 0);
    assertTrue(difference.compareTo(new BigDecimal("2.0")) == 0);
    assertTrue(quotient.compareTo(new BigDecimal("2.0")) == 0);
    assertTrue(product.compareTo(new BigDecimal("8.0")) == 0);
}


        int myintbd=bd.intValue();
        long mylongbd=bd.longValue();
        double mydoublebd=bd.doubleValue();
        String mystringbd=bd.toString();

//************************************************************************************************

BigInteger

import java.math.BigInteger;

@Test
public void whenBigIntegerCreatedFromConstructor_thenExpectedResult() {
    BigInteger biFromString = new BigInteger("1234567890987654321");
    BigInteger biFromByteArray = new BigInteger(
       new byte[] { 64, 64, 64, 64, 64, 64 });
    BigInteger biFromSignMagnitude = new BigInteger(-1,
       new byte[] { 64, 64, 64, 64, 64, 64 });

    assertEquals("1234567890987654321", biFromString.toString());
    assertEquals("70644700037184", biFromByteArray.toString());
    assertEquals("-70644700037184", biFromSignMagnitude.toString());
}

@Test
public void givenBigIntegers_whenPerformingArithmetic_thenExpectedResult() {
    BigInteger i = new BigInteger("4");
    BigInteger j = new BigInteger("2");

    BigInteger sum = i.add(j);
    BigInteger difference = i.subtract(j);
    BigInteger quotient = i.divide(j);
    BigInteger product = i.multiply(j);

    assertEquals(new BigInteger("6"), sum);
    assertEquals(new BigInteger("2"), difference);
    assertEquals(new BigInteger("2"), quotient);
    assertEquals(new BigInteger("8"), product);
}


@Test
public void givenBigIntegers_whentCompared_thenExpectedResult() {
    BigInteger i = new BigInteger("123456789012345678901234567890");
    BigInteger j = new BigInteger("123456789012345678901234567891");
    BigInteger k = new BigInteger("123456789012345678901234567892");

    assertTrue(i.compareTo(i) == 0);
    assertTrue(j.compareTo(i) > 0);
    assertTrue(j.compareTo(k) < 0);
}

@Test
public void givenBigIntegers_whenModularCalculation_thenExpectedResult() {
    BigInteger i = new BigInteger("31");
    BigInteger j = new BigInteger("24");
    BigInteger k = new BigInteger("16");

    BigInteger gcd = j.gcd(k);
    BigInteger multiplyAndmod = j.multiply(k).mod(i);
    BigInteger modInverse = j.modInverse(i);
    BigInteger modPow = j.modPow(k, i);

    assertEquals(new BigInteger("8"), gcd);
    assertEquals(new BigInteger("12"), multiplyAndmod);
    assertEquals(new BigInteger("22"), modInverse);
    assertEquals(new BigInteger("7"), modPow);
}

        int myintC=c.intValue();
        long mylongC=c.longValue();
        String myStringC=c.toString();
        double myDoubleC=c.doubleValue();



------------------------------------------------------------------------------------------------------------------------



高频：宽度优先搜索（BFS），深度优先搜索（DFS），二分法（Binary Search），双指针（2 Pointer），堆、栈、队列、哈希表（Heap，Stack，Queue，HashMap/HashSet），前缀和（Prefix Sum），链表（LinkedList），二叉树（Binary Tree），二叉搜索树（Binary Search Tree），快速排序与归并排序（Quick Sort/ Merge Sort）

中频：动态规划（DP），扫描线（Sweep Line），字典树（Trie），并查集（Union Find），单调栈与单调队列（Monotone Stack/ Queue），TreeMap等

低频：Dijkstra，树状数组，线段树，最小生成树等…



https://zhuanlan.zhihu.com/p/349940945


Line Sweep
设计
分治算法
Ordered Map
递归
动态规划
Random
链表
回溯算法
Rejection Sampling 队列
拓扑排序
Sliding Window
位运算
树状数组
图
双指针
贪心算法
堆
哈希表
二叉搜索树
栈
字典树
极小化极大
树
字符串
脑筋急转弯
几何
并查集
蓄水池抽样
排序
线段树
广度优先搜索
数学
记忆化
深度优先搜索
数组
二分查找



看图学习动态规划：

https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484350&idx=1&sn=fc88aa125f5a5269575b4c4d83774f41&chksm=fa0e6c3fcd79e5297257a05b8c75898b4059b1193956c702ff5ef3f2d8d46432bb7484bf6428&token=110841213&lang=zh_CN#rd


剑指offer的动画版本：

每一道都是算法面试的高频类型，并且提供详细的分析、精美的配图、易于理解的动画操作、保姆级别的注释、手把手的视频讲解。
在线阅读地址：
https://blog.algomooc.com/
Image
左侧菜单栏（如果手机端查看则是在左上角）已经按照顺序排好了，按照顺序一道一道刷就可以，认真学习的话，大概一周时间可以全部掌握。
同时，大部分的题目我也录制了视频，非常细致的进行讲解。
在线播放地址：https://space.bilibili.com/28610170


------------------------------------------------------------------------------------------------------------------------



如何正确的使用leetcode:
https://www.zhihu.com/question/26580300


去年找互联网的工作，刷了两遍LeetCode，只做了前200道。面试过程中碰到的算法题基本都被秒杀了。最后拿了9个offer。我是按Tag来刷的。链表，二叉树，回溯，深度宽度优先遍历，图，贪心，动规，数组，哈希表……每个tag由easy到hard，每道题先自己思考，不会的参考了一个开源的解答或者参考Discuss或者博客。开始的时候自己独立思考的时间比较长，后来没了耐心，不会的题目就马上看解答了。一般题目解法有多种，这时候最好尝试一下其他的做法，至少要知道思路。比如有关图的题目就会有DFS和BFS两种解法。Discuss里一般都会有高质量的解答。关键是每道题都要弄明白。一开始用IDE，跑出正确结果，再在线默写代码。后来写的多了，直接在线写代码了。这是一个自然的过程，做的多了就有“手感”了。总结一下，按tag由易到难，每道题弄清楚，知道其他的解法，这是核心！搞定了核心，其他的技巧都是锦上添花了。

作者：知乎用户
链接：https://www.zhihu.com/question/26580300/answer/144589637
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


作者：missmall
链接：https://www.zhihu.com/question/26580300/answer/167136412
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作为一个曾经把刷题网站上的题目刷过两遍并且最后拿到不错offer的人，我觉得我还是可以给题主提点建议的。

1. 首先，我不建议题主在自己的本地编译器上先进行编译再上传结果。很多时候，特别是面试的时候，面试官一般都只会直接扔给你一张白纸，让你直接在白纸上写代码，如果题主一直用编译器进行编辑的话，突然被要求在白纸上写代码一定会觉得全身都废了、各种代码写不习惯。而且过度依赖编译器、特别是那些功能比较齐全的编译器的话，突然自己写代码一定会犯各种各样你想都想不到的错误，题主也不希望到时候面试官看到的是一个存在各种低级错误的代码吧。
2, 另外，建议楼主做完一道题目之后上参考网站上看看参考答案。很多参考答案相比较于我们自己的代码还是很棒很简洁的，看过之后会有一种豁然开朗的感觉。这里安利一个可以查答案的网址：LeetCode / LintCode 答案查询。我自己在刷题的时候经常用，学着参考答案对自己的代码进行修改，效果还是很赞的。现在回过头来看看自己以前的代码，颇有点不忍直视的感觉
3. 要想有效率的刷题就要对题目进行选择。就是说你不能每天看到什么题目就刷什么题目，而是要有计划的对题目进行先后排序。当时我刷题是在Lintcode上面进行的，就是先利用他的分类功能对题目进行类型分类，再根据难易进行排序，一段时间就专注在一种题目类型上，然后根据自己的水平，从容易或者中等难度开始刷起，一点点增加难度值。这样子的话更容易对一种类型的题目进行掌握，刷题不管速度还是效率都会有所提高。
4. 总结很重要。人是健忘的动物，如果你刷完题就把题目扔了，肯定没多久就忘的七七八八了，所以每做完一种类型的题目，甚至是做完一天的题目，就要参照标准答案对题目进行梳理整合总结，然后把这种总结记录下来，因为我用的Lintcode里面就有自带的笔记功能，所以我当时就会每天直接在lintcode里面记录自己的总结结果，然后以后每隔一段时间就回顾一下，强化一下记忆，这样你刷过的题目才能真正为你所有，不会边刷边忘，效率底下。
5. 最后就是一定要坚持刷，每天给自己强行安排指标，这样才能保证自己一直处在编程的状态下。这不但能养成编程刷题的习惯让刷题过程变的没那么痛苦，而且一直处在编程状态下本身就会让你的编程水平处在一个逐渐上升的过程中。




作者：程序员吴师兄
链接：https://www.zhihu.com/question/26580300/answer/555275635
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

刷 LeetCode 的大局观目前主流的刷题流派有两种，一种【龟系】，一种【兔系】。”龟系“刷法的精髓就是每个题目都做干净。不满足于一种解法，各种解法都写一写。这种流派适合不太急于准备算法面试的小伙伴，追求算法的干净优雅。“兔系“刷法的精髓是暴力，按照标签来刷，使用固定套路来刷。比如小吴之前分析的那道拍案叫绝的算法题，如果告诉你是标签是异或，你马上能 AC 。这都是套路。每个标签内部可以按照 Easy 、Medium、Hard 的顺序做，算法练习是一个系统工程，不要一开始就追求难题，先熟悉熟悉套路，循序渐进的去做，后面所谓的难题也就不在话下。建议小伙伴第一遍刷题可以使用【兔系】法。看懂题目万事开头难，看懂题目是做好一道算法题最开始也是最重要的一步。我将 LeetCode 上的题大致分为三种类型：考察数据结构，比如链表、栈、队列、哈希表、图、Trie、二叉树等考察基础算法，比如深度优先、广度优先、二分查找、递归等考察基本算法思想：递归、分治、回溯搜索、贪心、动态规划等一些算法题目会在标题或题目描述中给出明确的题目类型信息，比如二叉树的重建、链表的反转。而有一些题目中则在条件中给予暗示 ：设计一个 O(nlogn) 的算法（分治：在一颗搜索树中完成任务，对于数据排序）给定一个有序数组（二分法）无需考虑额外的空间（用空间换时间上的优化）数据规模大概是 10000（O(n^2)就可以）问题可以被递归解决（动态规划）无论怎样，当你拿到一道算法题的时候，希望你能先去弄明白这道题目要考察的是什么，是简单的数据结构还是复杂的算法思想。先去理清题目背后解法要用的技术，这样，这道算法题目才有做下去的可能。不要忽视暴力解法一般来说，BAT 等大厂的算法面试题基本上都是 Medium 级别及以下，并希望面试者能在 20 分钟以内给出一个「相对正确」的回答。为什么说是 相对正确 ？每一道算法题得解法都有很多种，并不是说你没有给出完美解或者最优解你就是错的。“正确” 本身是一个相对概念。在算法面试或者平时的算法练习时，如果没有头绪，可以尝试使用暴力解法。（不要忽视暴力解法。暴力解法通常是思考的起点。）当你使用了暴力解法之后，可以与面试官进行沟通优化，把这个过程看作是和面试官一起探讨一个问题的解决方案的过程，这也可以让面试官了解你的思考问题的方式。这也是一个“正确”的回答方式。先实现功能再去优化。Done is better than perfect 。

实际编写到这一步就是算法的落地了：将上面的思考结果思路转换为代码。在编写的过程中需要注意题目中的边界条件，比如数组是否为空，指针是否为 NULL；同时也要注意代码的规范性：变量名，模块化，复用性。做好总结一定要做好总结，特别是当没有解出题来，没有思路的时候，一定要通过结束阶段的总结来反思犯了什么错误。解出来了也一定要总结题目的特点，题目中哪些要素是解出该题的关键。不做总结的话，花掉的时间所得到的收获通常只有 50% 左右。在题目完成后，要特别注意总结此题最后是归纳到哪种类型中，它在这种类型中的独特之处是什么。经过总结，这样题目才会变成你在此问题域中的积累。做好总结，让每道题都有最大的收获。一个月之后自己的状态应该会有很大变化。最后，承认刷 LeetCode 很吃力很正常你我都是普通的程序员，不像那些玩 ACM，拳打 LeetCode，脚踩剑指 offer，我们得接受现实：刷题，就是很痛苦很打击的过程。但，一遍一遍的刷，多刷一题就多掌握一题，你总会比别人更强一点。大家一起加油：）为了避免知乎大佬觉得我吹逼，在这里贴一下自己的 GitHub 地址，目前 20 k star。12月初，将图解算法项目放到了GitHub上面去，短短两天登上了 trending 版第一的位置，点击这了解如何我是如何 21天，在Github上获取 6300 star 的。

https://zhuanlan.zhihu.com/p/53584215









------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------














------------------------------------------------------------------------------------------------------------------------











------------------------------------------------------------------------------------------------------------------------










