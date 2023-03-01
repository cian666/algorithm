package cn.cian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P56_Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1] - o1[1]:o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int left = intervals[i][0],right = intervals[i][1];
            i++;
            while(i < intervals.length && intervals[i][0] <= right){
                right = Math.max(right,intervals[i][1]);
                i++;
            }
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }
}
