package cn.cian.basic;

import java.util.Arrays;
import java.util.HashSet;

public class P3_NoRepeatString {
    //滑动窗口。
    public static int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
                ans = Math.max(ans,r - l);
                set.remove(s.charAt(l++));
            }
            set.add(c);
            r++;
        }
        return ans > set.size()? ans : set.size();
    }

    //动态规划思路
    public static int lengthOfLongestSubstring2(String s) {
        int[] map = new int[256];
        int pre = 0;
        int ans = 0;
        Arrays.fill(map,-1);
        for (int i = 0; i < s.length(); i++) {
            pre = Math.min(pre+1,i-map[s.charAt(i)]);
            ans = Math.max(pre,ans);
            map[s.charAt(i)] = i;
        }
        return ans;
    }
}
