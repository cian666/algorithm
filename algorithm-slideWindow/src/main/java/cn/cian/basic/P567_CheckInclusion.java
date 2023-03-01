package cn.cian.basic;

public class P567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int[] need = new int[26];
        int needCount = s2.length();
        for (int i = 0; i < s2.length(); i++) {
            need[s2.charAt(i)]++;
        }
        int l = 0, r = 0;
        for ( ; r < s1.length() ; r++){
            if(need[s2.charAt(r) -'a'] -- > 0)
                needCount--;
        }
        for (; r < s1.length(); r++) {
            if(needCount == 0){
                return true;
            }
            if(need[s1.charAt(r) - 'a']-- >0){
                needCount--;
            }
            if(need[s1.charAt(l++) - 'a']++ >= 0){
                needCount++;
            }
        }
        return needCount == 0;
    }
}
