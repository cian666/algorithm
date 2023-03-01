package cn.cian.basic;

public class P76_MinWindow {
    public String minWindow(String s, String t) {
        if(s== null || t== null || t.length() > s.length())
            return "";
        int[] need = new int[256];
        int needCount = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int start = 0,end = s.length();
        /**
         * 最佳模板
         * 1.缩短条件范围
         * 2.当不满足条件时，缩短左边界。
         * 3.求最值。
         * */
        while(r < s.length()){
            if(need[s.charAt(r)]-- > 0){
                needCount--;
            }
            if(needCount == 0){
                while(l < r && need[s.charAt(l)] < 0){
                    need[s.charAt(l++)]++;
                }
                if(r - l < end - start){
                    start = l;
                    end = r;
                }
                need[s.charAt(l++)]++;
                needCount++;
            }
            r++;
        }
        return start == 0 && end == s.length()? "":s.substring(start,end+1);
    }
}
