
/*
 * 
https://leetcode.com/problems/cheapest-flights-within-k-stops/


787. Cheapest Flights Within K Stops
Medium

1628

57

Add to List

Share
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.

15 June 2020 at 12:09 am


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





class Solution {
    //时间复杂度：O(K * m) //m 是 number of flights
       //空间复杂度：O(K * n) //可以优化到O(2n),每次维护两行即可
       public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
           int[][] dp = new int[K + 1][n];
           Arrays.fill(dp[0], Integer.MAX_VALUE);
           dp[0][src] = 0;
           for (int[] flight:flights) {
               if (flight[0] == src) {
                   dp[0][flight[1]] = flight[2];
               }
           }
           // System.out.println(Arrays.toString(dp[0]));
           for (int i = 1; i <= K; i++) {
               dp[i] = Arrays.copyOf(dp[i - 1], n);  // 一层一层，有更多的机场可打（不是MAX_VALUE)
               for (int[] flight:flights) {
                   if (dp[i - 1][flight[0]] != Integer.MAX_VALUE)
                       dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
               }
               // System.out.println(Arrays.toString(dp[i]));
           }
           if (dp[K][dst] == Integer.MAX_VALUE) return -1;
           return dp[K][dst];
   
       }
   }
   
   // 作者：LSF
   // 链接：https://www.acwing.com/solution/leetcode/content/634/
   // 来源：AcWing
   // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




//    算法2:BFS + memo

//    虽然加了memo应该和DP时间复杂度差不多，但是LC上面就是要花三倍时间
   
//    Java 代码
   
   
   
//    作者：LSF
//    链接：https://www.acwing.com/solution/leetcode/content/634/
//    来源：AcWing
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





// AC:
class Solution {
    //    算法2:BFS + memo
    
    // 虽然加了memo应该和DP时间复杂度差不多，但是LC上面就是要花三倍时间
    
    // Java 代码
    
        class Entry implements Comparable<Entry>{
            int place;
            int stop;
            int price;
            Entry (int place, int stop, int price) {
                this.place = place; this.stop = stop; this.price = price;
            }
            public int compareTo(Entry other) {
                return price - other.price;
            }
        }
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            PriorityQueue<Entry> pq = new PriorityQueue<>();
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            getFlight(flights, map);
            pq.add(new Entry(src, -1, 0));
            int[] cost = new int[n];
            while (!pq.isEmpty()) {
                Entry curr = pq.poll();
                // System.out.println(Arrays.toString(cost));
                cost[curr.place] = curr.price;
                if (curr.place == dst) {
                    return curr.price;
                } if (curr.stop == K) {
                    continue;
                }
                Map<Integer, Integer> next = map.get(curr.place);
                // System.out.println(next);
                if (next == null) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> entry:next.entrySet()) {
                    // if (cost[entry.getKey()] != 0) continue;
                    pq.add(new Entry(entry.getKey(), curr.stop + 1, curr.price + entry.getValue()));
                }
            }
            return -1;
        }
        private void getFlight(int[][] flights, Map<Integer, Map<Integer, Integer>> map) {
            for (int[] flight:flights) {
                map.computeIfAbsent(flight[0], k -> (new HashMap<>())).put(flight[1], flight[2]);
            }
        }
    
     
    }
    
    // 作者：LSF
    // 链接：https://www.acwing.com/solution/leetcode/content/634/
    // 来源：AcWing
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。











// AC:
class Solution {
    private class Entry implements Comparable<Entry>{
          int place;
          int stop;
          int price;
          Entry (int place, int stop, int price) {
              this.place = place; this.stop = stop; this.price = price;
          }
          public int compareTo(Entry other) {
              return price - other.price;
          }
  
      }
      public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
          PriorityQueue<Entry> pq = new PriorityQueue<>();
          Map<Integer, List<Map<Integer, Integer>>> map = new HashMap<>();
          getFlight(flights, map);
          pq.add(new Entry(src, -1, 0));
          int[] cost = new int[n];
          while (!pq.isEmpty()) {
              Entry curr = pq.poll();
            //   System.out.println("Curr: "+curr.place+" "+curr.stop+" "+curr.price);
            //   System.out.println(Arrays.toString(cost));
              cost[curr.place] = curr.price;
              if (curr.place == dst) {
                  return curr.price;
              } if (curr.stop == K) {
                  continue;
              }
              List<Map<Integer,Integer>> nextList = map.get(curr.place);
              // System.out.println(next);
              if (nextList==null||nextList.size()==0) {
                  continue;
              }
              for(Map<Integer,Integer> next:nextList)
              for (Map.Entry<Integer, Integer> entry:next.entrySet()) {
                //   System.out.println("Entry: "+entry.getKey()+" "+entry.getValue());
                  // if (cost[entry.getKey()] != 0) continue;
                  pq.add(new Entry(entry.getKey(), curr.stop + 1, curr.price + entry.getValue()));
              }
          }
          return -1;
      }
      private void getFlight(int[][] flights,  Map<Integer, List<Map<Integer, Integer>>> map) {
          for (int[] flight:flights) {
            //   System.out.println("[init] "+flight[0]+" "+flight[1]+" "+flight[2]);
             List<Map<Integer,Integer>> list= map.computeIfAbsent(flight[0], k -> (new ArrayList<Map<Integer,Integer>>()));
              HashMap tmp_map=new HashMap<>();
              tmp_map.put(flight[1], flight[2]);
              list.add(tmp_map);
          }
      }
}

// 作者：LSF
// 链接：https://www.acwing.com/solution/leetcode/content/634/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

