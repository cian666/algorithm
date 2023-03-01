package cn.cian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P57_Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        while(i < len && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while (i < len){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][]);
    }
}
