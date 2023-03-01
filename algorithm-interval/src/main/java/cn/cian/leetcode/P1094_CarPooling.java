package cn.cian.leetcode;

public class P1094_CarPooling {
    /**
     * 差分数组
     * */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timePeople = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            timePeople[trips[i][1]] += trips[i][0];
            timePeople[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for (int i : timePeople) {
            sum += i;
            if(sum > capacity)
                return false;
        }
        return true;
    }
}
