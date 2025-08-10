package cn.cian.leetcode;

import java.util.Arrays;

public class LC03_LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.min(pre + 1,i-map[s.charAt(i)]);
            ans = Math.max(pre,ans);
            map[s.charAt(i)] = i;
        }
        return ans;
    }


    public static int lengthOfLongestSubstring0(String s) {
        return 0;
    }
}
