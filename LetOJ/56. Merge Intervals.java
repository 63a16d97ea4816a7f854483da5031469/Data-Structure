
/*
 * 
https://leetcode.com/problems/merge-intervals/


56. Merge Intervals
Medium

3670

267

Add to List

Share
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

9 May 2020 at 5.12 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :


类似题目：
https://leetcode.com/problems/interval-list-intersections/
https://leetcode.com/problems/range-module/
https://leetcode.com/problems/insert-interval/
https://leetcode.com/problems/partition-labels/

 * 
 */










class Solution {
    //https://tfrain.gitbook.io/leetcode/56.-merge-intervals
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) return intervals;
        //按照起点的升序排列
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        List<int[]> result = new ArrayList<>();
        int [] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
        //因为已经排序，所以不会出现两数组本没有联系，有了第三个数组却有联系的情况
            if (interval[0] <= newInterval[1])
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}








// Runtime: 5 ms, faster than 94.36% of Java online submissions for Merge Intervals.
// Memory Usage: 42.4 MB, less than 47.83% of Java online submissions for Merge Intervals.


public class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
class Solution {
	//
	public int[][] merge(int[][] intervals) {
		int[][] result;
		List<Interval> list = new ArrayList<Interval> ();
		for (int i = 0; i<intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			list.add(new Interval(start, end));
		}
		if (list.size()<= 1) {
			result = new int[list.size()][2];
			for (int i = 0; i<list.size(); i++) {
				result[i][0] = list.get(i).start;
				result[i][1] = list.get(i).end;
			}
			return result;
		}
		list.sort((Interval interval1, Interval interval2) -> interval1.start - interval2.start);
		List<Interval> resultList = new ArrayList<>();
		int start = list.get(0).start;
		int end = list.get(0).end;
		for (int i = 1; i<list.size(); ++i) {
			Interval interval = list.get(i);
			if (end >= interval.start) {
				end = Math.max(end, interval.end);
			} else {
				Interval item = new Interval(start, end);
				resultList.add(item);
				start = interval.start;
				end = interval.end;
			}
		}
		resultList.add(new Interval(start, end));
		result = new int[resultList.size()][2];
		for (int i = 0; i<resultList.size(); i++) {
			result[i][0] = resultList.get(i).start;
			result[i][1] = resultList.get(i).end;
		}
		return result;
	}
}







http://www.noteanddata.com/leetcode-56-Merge-Intervals-facebook-interview-problem-java-solution-note.html

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
       if(intervals.size() <= 1) {
           return intervals;
       }
       intervals.sort((Interval interval1, Interval interval2)-> interval1.start - interval2.start);

       List<Interval> resultList = new ArrayList<>();
       int start = intervals.get(0).start;
       int end = intervals.get(0).end;
       for(int i = 1; i < intervals.size(); ++i) {
           Interval interval = intervals.get(i);
           if(end >= interval.start) {
               end = Math.max(end, interval.end);
           }
           else {
               Interval item = new Interval(start, end);
               resultList.add(item);

               start = interval.start;
               end = interval.end;
           }

       }
       resultList.add(new Interval(start, end));

       return resultList;
   }
}
