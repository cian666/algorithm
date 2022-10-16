package cn.cian.greedy;

public class P376_WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);
                }else if(nums[i] < nums[j]){
                    dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
                }else {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                }
                max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
            }
        }
        return max;
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

}
