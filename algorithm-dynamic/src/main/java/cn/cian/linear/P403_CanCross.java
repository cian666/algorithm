package cn.cian.linear;

import org.junit.Test;

import java.util.Arrays;

public class P403_CanCross {
    @Test
    public void test(){
        int[] arr = {0,1,3,6,10,15,21,28};
        System.out.println(canCross(arr));
    }
    //动态规划
    public boolean canCross2(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
    //记忆化搜索。
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Boolean[][] memo = new Boolean[n][n];
        return dfs(stones,0,0,memo);
    }

    private boolean dfs(int[] stones, int cur, int preDis, Boolean[][] memo) {
        if(cur == stones.length-1){
            return true;
        }
        if(memo[cur][preDis] != null){
            return memo[cur][preDis];
        }
        for (int newDis = preDis; newDis <= preDis+1; newDis++) {
            if(newDis > 0 ){
                int j = Arrays.binarySearch(stones, cur + 1, stones.length, newDis + stones[cur]);
                if(j >= 0 && dfs(stones,j,newDis, memo)){
                    return memo[j][newDis] = true;
                }
            }
        }
        return memo[cur][preDis] = false;
    }
}
