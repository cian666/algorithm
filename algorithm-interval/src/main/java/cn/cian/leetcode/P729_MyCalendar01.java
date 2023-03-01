package cn.cian.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P729_MyCalendar01 {

    List<int[]> booked;

    public P729_MyCalendar01() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }

}
