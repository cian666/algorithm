package cn.cian.leetcode;

import java.util.Arrays;

public class P253_Meeting02 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 1;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 0;
        for (int i = 0,j = 0; i < start.length && j < end.length; ) {
            if(start[i] < end[j]){
                max = Math.max(max,++i - j);
            }else {
                j++;
            }
        }
        return max;
    }
}
