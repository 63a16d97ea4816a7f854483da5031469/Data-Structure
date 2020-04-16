
/*
 * 
https://leetcode.com/problems/queue-reconstruction-by-height/

406. Queue Reconstruction by Height
Medium

2242

268

Add to List

Share
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

12 April 2020 at 8:33: pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :

     Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

    int[][] res = result.toArray(new int[people.length][]);


      List<int[]> result = new ArrayList<>();
        for (int[] cur : people) {            
            result.add(cur[1], cur);
        }

result.add(cur[1], cur); 其实在插入


 * 
 */






class Solution {
    //9.13pm-9.45pm 题解
public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] cur : people) {            
            result.add(cur[1], cur);
        }
        int[][] res = result.toArray(new int[people.length][]);
        return res;
    }
}





class Solution {
    //9.13pm-9.45pm 题解
 
public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });
    
    for(int i=0;i<people.length;i++){
        for(int j=0;j<people[0].length;j++){
            System.out.print(people[i][j]+" ");
        }
        System.out.println();
    }
    
       
        List<int[]> result = new ArrayList<>();
        for (int[] cur : people) {
            for(int[] tmp:result){
                System.out.println(tmp[0]+","+tmp[1]);
            }
            System.out.println();
            
            result.add(cur[1], cur);
        }
        int[][] res = result.toArray(new int[people.length][]);
        return res;
    }
        
}


[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]

7 0 
7 1 
6 1 
5 0 
5 2 
4 4 

7,0

7,0
7,1

7,0
6,1
7,1

5,0
7,0
6,1
7,1

5,0
7,0
5,2
6,1
7,1

















