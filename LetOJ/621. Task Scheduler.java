
/*
 * 
https://leetcode.com/problems/task-scheduler/


621. Task Scheduler
Medium

2649

565

Add to List

Share
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

12 April 2020 at 10:30 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


 * 
 */



// 题目 leetcode 621 Task Scheduler

// 输入一个字符串，每个字符是一个指令，
// 然后再输入n，表示任何一个字符， 后面必须再经过n个其他字符才可以继续这个字符， 如果没有其他字符可以填上，就休息几个字符，直到最后可以填上
// 解题思路分析

// 这个题目的核心是， 这个长度是由出现最多的字符绝对的， 如果A是出现最多的字符， 那么任意两个A之间就要有n个字符， 无论是空格还是其他。 也就是说，
// 分成长度是n+1的段； 然后， 这里， 需要的是先来(max-1)段， 其中max是这个出现最多的字符的次数。 因为前面必须要这样设置， 但是到最后一段， 不需要长度是n+1了。
// 如果频率最大的字符只有一个， 那么最后一段就只放这一个字符就好； 如果有x个， 那么需要放这x个；
// 而且， 如果有x个， 在之前的段里面假设也是可以放完的。(当然，其实有可能会放不下，这个情况在后面作为特殊情况讨论)
// 所以， 这里最大的长度是(max-1) * (n+1) + maxcount
// 当然这里还有一个情况， 就是这个长度小于输入字符串的长度， 比如
// “ABCD”, n=1


自己复现的:

class Solution {
    //12.38am-看完题解开始-12.45am
    public int leastInterval(char[] tasks, int n) {
        int[] mapArr=new int[26];
        
        for(int i=0;i<tasks.length;i++){
            mapArr[(int)(tasks[i]-'A')]++;
        }
        
        int max=0;
        int maxCount=0;
        
        for(int i=0;i<mapArr.length;i++){
            if(mapArr[i]>max){
                max=mapArr[i];
                maxCount=1;
            }else if(mapArr[i]==max){
                maxCount++;
            }
        }
        
        int count=(max-1)*(n+1)+maxCount;
        
        return Math.max(count, tasks.length);
        
    }
}



public int leastInterval(char[] tasks, int n) {
    int[] table = new int[26];
    for(char task: tasks) {
        table[(int)(task-'A')]++;
    }
    int max = 0;
    int maxcount = 0;
    for(int i = 0; i < table.length; ++i) {
        if(table[i] > max) {
            max = table[i];
            maxcount = 1;
        }
        else if(table[i] == max) {
            maxcount++;
        }
    }
    
    int len = (max-1) * (n+1) + maxcount;
    return Math.max(len, tasks.length);
}



// 题解2 ：

class Solution {
    static class Node implements Comparable<Node> {
        char ch;
        int count;
        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
        public int compareTo(Node other) {
            return other.count - count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task: tasks) {
            int count = map.getOrDefault(task, 0);
            map.put(task, count+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        
        List<Character> list = new ArrayList<>();
        Set<Character> window = new HashSet<>();
        while (pq.size() > 0) {
            List<Node> temp = new ArrayList<>();
            boolean added = false;
            while(pq.size() > 0) {                            
                Node node = pq.poll();
                boolean conflict = window.contains(node.ch);
                if(!conflict) {
                        
                    list.add(node.ch);
                    window.add(node.ch);

                    if(list.size() > n) {
                        window.remove(list.get(list.size()-n-1));
                    }
                    
                    if(node.count > 1) {
                        Node nnode = new Node(node.ch, node.count-1);
                        pq.add(nnode);
                    }
                    added = true;
                    break;
                }
                else {
                    temp.add(node);
                }
            }
            if(!added) {
                
                list.add('*');
                
                if(list.size() > n) {
                    window.remove(list.get(list.size()-n-1));
                }
                
            }
            for(Node t: temp) {
                pq.add(t);
            }
        }
        return list.size();
    }
}



















