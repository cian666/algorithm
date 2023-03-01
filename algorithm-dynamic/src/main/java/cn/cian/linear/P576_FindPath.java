package cn.cian.linear;


/**
 *
 * 记忆化搜索怎么转换为DP？
 *
 * */
public class P576_FindPath {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs(m,n,maxMove,startRow,startColumn,memo);
    }

    private int dfs(int m, int n, int move, int startRow, int startColumn, int[][][] memo) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n){
            return 1;
        }
        if(move == 0)
            return 0;
        if(memo[startRow][startColumn][move] != -1)
            return memo[startRow][startColumn][move];
        int ans = 0;
        int top = dfs(m, n, move-1, startRow+1,startColumn, memo);
        ans  = (ans + (top % mod))% mod;
        int bootom = dfs(m, n, move-1, startRow-1,startColumn, memo);
        ans  = (ans + (bootom % mod))% mod;
        int left = dfs(m, n, move-1, startRow,startColumn-1, memo);
        ans  = (ans + (left % mod))% mod;
        int right = dfs(m, n, move-1, startRow,startColumn+1, memo);
        ans  = (ans + (right % mod))% mod;
        memo[startRow][startColumn][move] = ans;
        return ans;
    }
}
