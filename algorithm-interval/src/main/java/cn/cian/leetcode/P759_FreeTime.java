package cn.cian.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P759_FreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int OPEN = 0,ClOSE = 1;
        ArrayList<int[]> event = new ArrayList<>();
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                event.add(new int[]{interval.start,OPEN});
                event.add(new int[]{interval.end,ClOSE});
            }
        }
        Collections.sort(event, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o1[1] - o2[1]:o1[0] - o2[0];
            }
        });
        List<Interval> ans = new ArrayList();
        int pre = -1,num = 0;
        for (int[] ev : event) {
            if(num == 0 && pre >= 0){
                ans.add(new Interval(pre,ev[0]));
            }
            num += ev[1] == OPEN? 1:-1;
            pre = ev[0];
        }
        return ans;
    }
}
