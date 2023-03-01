package cn.cian.combination;

public class P377_CombinationSum4 {
    /**
     * 典型的背包问题了。
     * 先背包 在容量 == 》 组合数  忽略顺序
     * 先容量 在背包 == 》 排列数  顺序不同也算一个
     * */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if(i >= nums[j-1]){
                    dp[i] += dp[i - nums[j-1]];
                }
            }
        }
        return dp[target];
    }
}
