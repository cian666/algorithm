package cn.cian.linear;

public class P198_Rob {

    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 1){
            return nums[0];
        }
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }
        return dp[N-1];
    }
}
