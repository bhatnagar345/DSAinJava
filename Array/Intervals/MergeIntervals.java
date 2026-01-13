package Array.Intervals;
//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//        Example 3:
//
//Input: intervals = [[4,7],[1,4]]
//Output: [[1,7]]
//Explanation: Intervals [1,4] and [4,7] are considered overlapping.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int n = intervals.length;
        Arrays.sort(intervals, (pair1, pair2) -> pair1[0] - pair2[0]);
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        List<int[]> res = new ArrayList<>();

        for (int i=1; i<n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
                continue;
            }
            res.add(new int[]{start1, end1});
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[]{start1, end1});

        for(int[] a : res)
        {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
