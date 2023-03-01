package cn.cian.leetcode;

public class LC6_Convert {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder("");
        }
        int cur = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            res[cur].append(s.charAt(i));
            if(cur == numRows-1){
                flag = -1;
            }
            if(cur == 0){
                flag = 1;
            }
            cur += flag;
        }
        StringBuilder ans = new StringBuilder("");
        for (StringBuilder re : res) {
            ans.append(re);
        }
        return ans.toString();
    }
}
