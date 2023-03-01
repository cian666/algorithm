package cn.cian.linear;

public class P10_IsMatch {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int slen = s.length(),plen = p.length();
        // 1-i 与 1- j匹配。
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        for (int i = 2; i <= plen; i++) {
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char sc = s.charAt(i-1);
                char sp = p.charAt(j-1);
                if(sc == sp || sp == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if(sp == '*'){
                        if(dp[i][j-2]){
                            dp[i][j] = true;
                        }else if(sc == p.charAt(j-2) || p.charAt(j-2) =='.' ){
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
